package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.accountbalance.source.AccountBalanceSourceResponse;
import com.ssfb.account.dto.accountbalance.source.Relparty;
import com.ssfb.account.dto.opendigitdrd.RetcustInq.source.RtCustInqRequest;
import com.ssfb.account.dto.opendigitdrd.RetcustInq.source.RtCustInqRequestBody;
import com.ssfb.account.dto.opendigitdrd.RetcustInq.source.RtCustInqResponse;
import com.ssfb.account.dto.opendigitdrd.source.*;
import com.ssfb.account.dto.opendigitdrd.target.*;
import com.ssfb.account.dto.opendigitdrd.tdrddetails.RelParty;
import com.ssfb.account.dto.opendigitdrd.tdrddetails.TDRDDetailsResponse;
import com.ssfb.account.entity.TDCreationSettlementAccount;
import com.ssfb.account.repository.TDCreationSettlementAccountRepository;
import com.ssfb.account.service.helper.RetCustInqHelper;
import com.ssfb.account.service.helper.TDRDDetailsHelper;
import com.ssfb.commonmodule.dto.fixml.CommonHeaders;
import com.ssfb.commonmodule.dto.fixml.MessageKey;
import com.ssfb.commonmodule.dto.fixml.RequestHeader;
import com.ssfb.commonmodule.dto.fixml.RequestMessageInfo;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.LogDetail;
import com.ssfb.logging.model.LogEnvelope;
import com.ssfb.logging.model.LogHeader;
import com.ssfb.logging.service.LoggingService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ssfb.account.dto.Constants.*;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.hibernate.boot.model.source.internal.hbm.Helper.getValue;

@Service
public class CreateDigiAccountTDService {
    private final RestTemplate restTemplate;

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    private final LoggingService logging = new LoggingService();

    @Autowired
    private RetCustInqHelper retCustInq;

    @Autowired
    private TDCreationSettlementAccountRepository repository;

    @Autowired
    private TDRDDetailsHelper tdrdDetails;

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private AccountConfig config;

    private AccountBalanceSourceResponse casaAccountInqResponse;

    private TDRDDetailsResponse tdrdDetailsResponse;

    private CreateDigiAccountTDService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public TDRDCreateResponse createDigiAccountTD(TDRDCreateRequest request, String correlationId, String requestId) throws Exception {

        RtCustInqResponse retcustinqResponse = null;
        String accountId = request.getData().getAccountId();
        String version = VERSION_V2;
        String token = null;

        TDRDCreateResponse response = new TDRDCreateResponse();
        FIXML targetResponse = new FIXML();
        Error error = new Error();

        try {

            if (request.getData().getAccountOpenDate() != null && !request.getData().getAccountOpenDate().isEmpty() &&
                    LocalDate.parse(request.getData().getAccountOpenDate()).isBefore(LocalDate.now().minusDays(7))) {

                response.setError(new Error("01", "Account Open Date cannot be earlier than 7 days from current date"));

                return response;
            }

            if (request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty()) {
                tdrdDetailsResponse = tdrdDetails.tdrdDetails(request.getData().getAccountId(), correlationId, requestId);
                if ("IBR".equalsIgnoreCase(requestId)) {
                    if (tdrdDetailsResponse.getData().getAccount() != null && tdrdDetailsResponse.getData().getAccount().get(0).getRelationship() != null &&
                            (tdrdDetailsResponse.getData().getAccount().get(0).getRelationship().equalsIgnoreCase("F") || tdrdDetailsResponse.getData().getAccount().get(0).getRelationship().equalsIgnoreCase("C"))) {

                        if (request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty()) {
                            String[] jointinfo = request.getData().getJointAcctHldrInfo().split("#");

                            String relationship = jointinfo.length > 0 ? jointinfo[0] : null;
                            String modeOfOperation = jointinfo.length > 0 ? jointinfo[1] : null;

                            if (!Objects.equals(tdrdDetailsResponse.getData().getAccount().get(0).getRelationship(), relationship) &&
                                    !Objects.equals(tdrdDetailsResponse.getData().getAccount().get(0).getModeOfOperation(), modeOfOperation)) {
                                response.setError(new Error("01", "Account cannot be opened under single name"));

                                return response;

                            }
                        }
                    }

                }
            }

            if (!"MOB".equalsIgnoreCase(requestId) && !"AIR".equalsIgnoreCase(requestId) && request.getData().getAccountId() != null && !request.getData().getAccountId().isEmpty() && request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty()) {
                casaAccountInqResponse = accountBalanceService.fetchAccountBalance(accountId, token, version, correlationId, requestId);
            }

            FIXML targetRequest = prepareTargetRequest(request, correlationId, requestId);

//            logging.log(new LogEnvelope(new LogHeader("Account", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
//                    new LogDetail(null, "API Request is : " + httpRequestUtils.writeXmlAsString(targetRequest))));

//        retcustinqResponse = prepapareRetcustInqResponse(request,requestId,correlationId);
//
//        if ((retcustinqResponse.getData()!=null  && retcustinqResponse.getData().getCustomerDetails()!=null && retcustinqResponse.getData().getCustomerDetails().get(0).getForm60()!=null && retcustinqResponse.getData().getCustomerDetails().get(0).getForm60().isEmpty())
//                || (retcustinqResponse.getData().getCustomerDetails().get(0).getPanNumber() ==null && retcustinqResponse.getData().getCustomerDetails().get(0).getPA().isEmpty()) ||
//                (retcustinqResponse.getData().getCustomerDetails().get(0).getIsMinor()!=null && !retcustinqResponse.getData().getCustomerDetails().get(0).getIsMinor().isEmpty() &&
//                        retcustinqResponse.getData().getCustomerDetails().get(0).getIsMinor().equalsIgnoreCase("Y"))){
//
//            response.setError(new Error("01","No PAN or Form60 found"));
//
//            return response;
//
//        }
            targetResponse = esbAPIRestCALL(restTemplate, targetRequest);

//            logging.log(new LogEnvelope(new LogHeader("Account", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
//                    new LogDetail(null, "API Response is : " + httpRequestUtils.writeXmlAsString(targetResponse))));

            response = prepareSourceResponse(targetResponse, requestId);

        } catch (Exception e) {
            try {
                // Extract the <FIXML> block using regex
                Pattern pattern = Pattern.compile("<FIXML[\\s\\S]*?</FIXML>");
                Matcher matcher = pattern.matcher(e.getMessage());

                if (!matcher.find()) {
                    throw new RuntimeException("FIXML block not found in error message");
                }

                String xmlString = matcher.group(0)
                        .replace("<EOL>", "");

                targetResponse = unmarshalXML(xmlString);
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }

        return response;
    }


    private RtCustInqResponse prepapareRetcustInqResponse(TDRDCreateRequest request, String requestId, String correlationId) throws Exception {
        RtCustInqResponse response = new RtCustInqResponse();
        RtCustInqRequest rtCustInqRequest = new RtCustInqRequest();
        RtCustInqRequestBody rtCustInqRequestBody = new RtCustInqRequestBody();

        rtCustInqRequestBody.setCustomerNo(request.getData().getCustomerId());

        rtCustInqRequest.setRtCustInqRequestBody(rtCustInqRequestBody);

        response = retCustInq.retCustInq(rtCustInqRequest, correlationId, requestId);

        return response;
    }


    private FIXML prepareTargetRequest(TDRDCreateRequest request, String correlationId, String requestId) {
        FIXML fixml = new FIXML();
        CommonHeaders headers = new CommonHeaders();
        Body body = new Body();

        headers.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setTdAcctAddRequest(prepareTDAcctAddRequest(request, correlationId, requestId));

        fixml.setHeader(headers);
        fixml.setBody(body);

        return fixml;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId("TDAcctAdd");
        messageKey.setServiceRequestVersion("10.2");
        if (requestId != null && requestId.length() >= 3) {
            messageKey.setChannelId(requestId.substring(0, 3));
        } else {
            messageKey.setChannelId(requestId);
        }

        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));

        requestHeader.setMessageKey(messageKey);
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }


    private TDAcctAddRequest prepareTDAcctAddRequest(TDRDCreateRequest request, String correlationId, String requestId) {
        FIXML fixml = new FIXML();
        TDAcctAddRequest tdAcctAddRequest = new TDAcctAddRequest();
        AcctStmtFreq acctStmtFreq = new AcctStmtFreq();
        AcctType acctType = new AcctType();
        BankInfo bankInfo = new BankInfo();
        BankInfoResponse bankInfoResponse = new BankInfoResponse();
        CustId custId = new CustId();
        DebitAcctId debitAcctId = new DebitAcctId();
        DepositTerm depositTerm = new DepositTerm();
        Doc doc = new Doc();
        GenLedgerSubHead genLedgerSubHead = new GenLedgerSubHead();
        GuardianContactInfo guardianContactInfo = new GuardianContactInfo();
        GuardianInfo guardianInfo = new GuardianInfo();
        InitialDeposit initialDeposit = new InitialDeposit();
        IOPMTSYS iopmtsys = new IOPMTSYS();
        NomineeContactInfo nomineeContactInfo = new NomineeContactInfo();
        NomineePercent nomineePercent = new NomineePercent();
//        OperAcctId
        PhoneNum phoneNum = new PhoneNum();
        POPMTSYS popmtsys = new POPMTSYS();
        PostAddr postAddr = new PostAddr();
        RelPartyTarget relPartyTarget = new RelPartyTarget();
        RenewalAmt renewalAmt = new RenewalAmt();
        RenewalDtls renewalDtls = new RenewalDtls();
        RenewalSchm renewalSchm = new RenewalSchm();
        RenewalTerm renewalTerm = new RenewalTerm();
        RepayAcctId repayAcctId = new RepayAcctId();
        TDAcctAddCustomData tdAcctAddCustomData = new TDAcctAddCustomData();
        TDAcctAddRq tdAcctAddRq = new TDAcctAddRq();
        TDAcctGenInfo tdAcctGenInfo = new TDAcctGenInfo();
        TDAcctId tdAcctId = new TDAcctId();
        TOPMTSYS topmtsys = new TOPMTSYS();
        TrnDtls trnDtls = new TrnDtls();

        String accountId = request.getData().getAccountId();
        String jointAcctHldrInfo = request.getData().getJointAcctHldrInfo();
        String productType = request.getData().getProduct().getType();
        if (accountId != null && accountId.length() >= 3 && (accountId.charAt(2) == '1' || accountId.charAt(3) == '2') && jointAcctHldrInfo != null && !jointAcctHldrInfo.isEmpty()) {
            if (tdrdDetailsResponse.getData().getAccount() != null && tdrdDetailsResponse.getData().getAccount().get(0).getRelParty() != null) {
                String customerId = tdrdDetailsResponse.getData().getAccount().get(0).getRelParty().stream().filter(relParty -> relParty.getType().equalsIgnoreCase("M")).map(RelParty::getCustomerId).findFirst().orElse(null);
                custId.setCustId(customerId);
            }
        } else {
            custId.setCustId(request.getData().getCustomerId());
        }

        tdAcctAddRq.setCustId(custId);

        String depositFrequency = request.getData().getDepositFrequency();
        String depositYear = prepareDepositYear(depositFrequency);
        String depositMonth = prepareDepositMonth(depositFrequency);
        String depositDay = prepareDepositDay(depositFrequency);
        String calculateMonth = String.valueOf(0);
        if (depositMonth != null && !depositMonth.isEmpty() && depositYear != null && !depositYear.isEmpty()) {
            calculateMonth = String.valueOf(Integer.parseInt(depositMonth) + (Integer.parseInt(depositYear) * 12));
        }
        String schemecode = prepareschemecode(jointAcctHldrInfo, productType, calculateMonth, depositDay);
        acctType.setSchmCode(schemecode);
        acctType.setSchmType("TDA");

        tdAcctId.setAcctType(acctType);

        if (request.getData().getAmount().getCurrencyCode() != null) {
            tdAcctId.setAcctCurr(request.getData().getAmount().getCurrencyCode());
        } else tdAcctId.setAcctCurr("INR");

        if (request.getData().getBranchId() != null) {
            bankInfo.setBranchId(request.getData().getBranchId());
        } else bankInfo.setBranchId("10000");

        tdAcctId.setBankInfo(bankInfo);
        tdAcctAddRq.setTdAcctId(tdAcctId);

        tdAcctGenInfo.setAcctStmtMode("R");
        tdAcctGenInfo.setDespatchMode("N");

        tdAcctAddRq.setTdAcctGenInfo(tdAcctGenInfo);

        initialDeposit.setAmountValue(request.getData().getAmount().getAmount());
        initialDeposit.setCurrencyCode(request.getData().getAmount().getCurrencyCode());

        tdAcctAddRq.setInitialDeposit(initialDeposit);

        depositTerm.setMonths(calculateMonth);
        depositTerm.setDays(depositDay);

        tdAcctAddRq.setDepositTerm(depositTerm);

        tdAcctAddRq.setInitialDeposit(initialDeposit);

        repayAcctId.setAcctId(request.getData().getTransferAccount().getAccountId());

        tdAcctAddRq.setRepayAcctId(repayAcctId);

        if (request.getData().getMaturity().getDisbursementOption().equalsIgnoreCase("2")) {
            renewalDtls.setAutoCloseOnMaturityFlg("Y");
        } else if (request.getData().getMaturity().getDisbursementOption().equalsIgnoreCase("3")) {
            renewalDtls.setAutoCloseOnMaturityFlg("N");
        }

        if (request.getData().getMaturity().getDisbursementOption().equalsIgnoreCase("2")) {
            renewalDtls.setAutoRenewalflg("N");
        } else if (request.getData().getMaturity().getDisbursementOption().equalsIgnoreCase("3")) {
            renewalDtls.setAutoRenewalflg("U");
        }
        renewalTerm.setDays(depositDay);
        renewalTerm.setMonths(calculateMonth);
        renewalDtls.setRenewalOption("M");

        renewalDtls.setRenewalTerm(renewalTerm);
        tdAcctAddRq.setRenewalDtls(renewalDtls);

        if (accountId != null && !accountId.isEmpty() && !"SER".equalsIgnoreCase(requestId)) {
            trnDtls.setTrnType("T");
            trnDtls.setTrnSubType("CI");

            if ("MOB".equalsIgnoreCase(requestId) || "AIR".equalsIgnoreCase(requestId) && accountId == null || accountId.isEmpty()) {

                List<TDCreationSettlementAccount> list = repository.findByChannelName(requestId);

                if (!list.isEmpty()) {
                    debitAcctId.setAcctId(list.get(0).getAccountId());
                }
            } else debitAcctId.setAcctId(accountId);

            debitAcctId.setAcctCurr(request.getData().getAmount().getCurrencyCode());
            debitAcctId.setBankInfo(bankInfo);
            trnDtls.setDebitAcctId(debitAcctId);
            tdAcctAddRq.setTrnDtls(trnDtls);
        }




        if (request.getData().getParty() != null && request.getData().getParty().size() == 1) {
            List<NomineeInfoRec> nomineeInfoRecList = new ArrayList<>();

            Party party = request.getData().getParty().get(0);
            if (party.getType() != null && "NOMINEE".equalsIgnoreCase(party.getType()) && party.getName() != null && !party.getName().isEmpty()) {
                NomineeInfoRec nomineeInfoRec = new NomineeInfoRec();
                nomineeInfoRec.setRegNum("10000");
                String nomineename = request.getData().getParty().stream().filter(p -> "NOMINEE".equalsIgnoreCase(party.getType())).map(Party::getName).findFirst().orElse(null);
                nomineeInfoRec.setNomineeName(nomineename);
                String relType = prepareRelType(request, requestId);
                nomineeInfoRec.setRelType(relType);
                phoneNum.setTelephoneNum(request.getData().getParty().get(0).getMobileNumber());
                nomineeContactInfo.setPhoneNum(phoneNum);
                nomineeContactInfo.setEmailAddr(request.getData().getParty().get(0).getEmailId());
                PostAddr singlepartypostAddr = prepareSinglePartyPostAddr(request);
                nomineeContactInfo.setPostAddr(singlepartypostAddr);
                nomineeInfoRec.setNomineeContactInfo(nomineeContactInfo);
                String nomineeMinorFlagSingleParty = prepareSinglePartMinorFlag(request);
                if (nomineeMinorFlagSingleParty != null) {
                    nomineeInfoRec.setNomineeMinorFlg(nomineeMinorFlagSingleParty);
                }
                String nomineeBirthDateSingleParty = preparenomineeBirthDateSingleParty(request);
                nomineeInfoRec.setNomineeBirthDt(nomineeBirthDateSingleParty);
                nomineePercent.setValue("100");
                nomineeInfoRec.setNomineePercent(nomineePercent);
                GuardianInfo guardianInfoSingleParty = prepareguardianInfoSingleParty(request);
                nomineeInfoRec.setGuardianInfo(guardianInfoSingleParty);

                nomineeInfoRecList.add(nomineeInfoRec);
            }
            tdAcctAddRq.setNomineeInfoRec(nomineeInfoRecList);

        }



        if (request.getData().getParty() != null && request.getData().getParty().size() > 1) {
            List<Party> multiplepartylist = request.getData().getParty();
            List<NomineeInfoRec> nomineeInfoRecList = new ArrayList<>();
            int i = 0;
            for (Party partylist : multiplepartylist) {
                NomineeInfoRec nomineeInfoRec = new NomineeInfoRec();

                nomineeInfoRec.setRegNum("1000" + i);
                if (partylist.getName() != null) {
                    nomineeInfoRec.setNomineeName(partylist.getName());
                }
                String multiplePartyRelType = preparemultiplereltype(partylist, requestId);
                nomineeInfoRec.setRelType(multiplePartyRelType);
                phoneNum.setTelephoneNum(partylist.getMobileNumber());
                nomineeContactInfo.setPhoneNum(phoneNum);
                nomineeContactInfo.setEmailAddr(partylist.getEmailId());
                PostAddr multyPartyPostAddr = prepareMultiPartyPostalAddress(partylist);
                nomineeContactInfo.setPostAddr(multyPartyPostAddr);
                nomineeInfoRec.setNomineeContactInfo(nomineeContactInfo);
                if (partylist.getMinor() != null && !partylist.getMinor().isEmpty()) {
                    nomineeInfoRec.setNomineeMinorFlg(partylist.getMinor());
                } else if ((partylist.getAge() != null && !partylist.getAge().isEmpty()) && Integer.parseInt(partylist.getAge()) < 18) {
                    nomineeInfoRec.setNomineeMinorFlg("Y");
                }
                if (partylist.getDateOfBirth() != null && !partylist.getDateOfBirth().isEmpty()) {
                    nomineeInfoRec.setNomineeBirthDt(partylist.getDateOfBirth() + "T00:00:00.000");
                } else if ((partylist.getAge() != null && !partylist.getAge().isEmpty()) && Integer.parseInt(partylist.getAge()) < 18) {
                    nomineeInfoRec.setNomineeBirthDt("2015-01-01T00:00:00.000");
                }
                nomineePercent.setValue(partylist.getNomineePercent());
                nomineeInfoRec.setNomineePercent(nomineePercent);
                GuardianInfo multipartyGuardainInfo = prepareMultiPartyGuardianInfo(partylist);
                nomineeInfoRec.setGuardianInfo(multipartyGuardainInfo);

                nomineeInfoRecList.add(nomineeInfoRec);
                i++;
            }
            tdAcctAddRq.setNomineeInfoRec(nomineeInfoRecList);
        }

        List<RelPartyRec> relPartyRecList = new ArrayList<>();
        if (request.getData().getModeOfOperation() != null && !request.getData().getModeOfOperation().isEmpty() && !request.getData().getModeOfOperation().equals("1") && request.getData().getRelParty() != null) {
            List<com.ssfb.account.dto.opendigitdrd.source.RelParty> relPartyList = request.getData().getRelParty();

            for (com.ssfb.account.dto.opendigitdrd.source.RelParty relParty : relPartyList) {
                RelPartyRec relPartyRec = new RelPartyRec();
                CustId custId1 = new CustId();

                relPartyRec.setRelPartyType(relParty.getType());
                relPartyRec.setRelPartyCode(relParty.getCode());
                custId1.setCustId(relParty.getCustomerId());
                relPartyRec.setCustId(custId1);

                relPartyRecList.add(relPartyRec);
            }
            tdAcctAddRq.setRelPartyRec(relPartyRecList);
        }


        if ((!"MOB".equalsIgnoreCase(requestId) && !"AIR".equalsIgnoreCase(requestId)) && accountId != null && !accountId.isEmpty() && request.getData().getAccountId().substring(3, 4).equals("1") && (request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty())) {
            List<Relparty> relpartyList = casaAccountInqResponse.getData().getRelParty();
            for (Relparty relparty : relpartyList) {
                if (relparty != null && relparty.getRecordDeleteFlag() != null && !relparty.getRecordDeleteFlag().equalsIgnoreCase("Y")) {
                    RelPartyRec relPartyRec = new RelPartyRec();
                    CustId custId1 = new CustId();

                    relPartyRec.setRelPartyType(relparty.getType());
                    relPartyRec.setRelPartyCode(relparty.getCode());
                    custId1.setCustId(relparty.getCustomerId());
                    relPartyRec.setCustId(custId1);

                    relPartyRecList.add(relPartyRec);
                }
            }
        }
        tdAcctAddRq.setRelPartyRec(relPartyRecList);

        tdAcctAddRequest.setTdAcctAddRq(tdAcctAddRq);

        tdAcctAddCustomData.setChannelLevelCode(requestId.substring(0, 3));
        tdAcctAddCustomData.setRmCode(request.getData().getRmCode());
        tdAcctAddCustomData.setLcCode(request.getData().getLcCode());
        tdAcctAddCustomData.setLgCode(request.getData().getLgCode());
        if (request.getData().getBestRateAutoRen() != null && request.getData().getBestRateAutoRen().equalsIgnoreCase("Y")) {
            tdAcctAddCustomData.setAcctLabel("BESTRATE");
        }
        tdAcctAddCustomData.setXferInd("O");
        tdAcctAddCustomData.setDepFreq(request.getData().getDepositFrequency());
        tdAcctAddCustomData.setCritSolId(request.getData().getBranchId());
        tdAcctAddCustomData.setChnlId(requestId);
        if ("SER".equalsIgnoreCase(requestId) && request.getData().getAccountId() != null && request.getData().getAccountId().isBlank()) {
            tdAcctAddCustomData.setCreMode("");
        } else tdAcctAddCustomData.setCreMode("V");
        tdAcctAddCustomData.setIntCrAcct(request.getData().getInterestTransferAccount().getAccountId());
        if (request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty() && request.getData().getJointAcctHldrInfo().contains("#")) {
            tdAcctAddCustomData.setModeOfOperation(request.getData().getJointAcctHldrInfo().substring(request.getData().getJointAcctHldrInfo().indexOf("#") + 1));
        } else if (request.getData().getModeOfOperation() != null && !request.getData().getModeOfOperation().isEmpty()) {
            tdAcctAddCustomData.setModeOfOperation(request.getData().getModeOfOperation());
        } else tdAcctAddCustomData.setModeOfOperation("1");
        tdAcctAddCustomData.setPlanCode(request.getData().getPlanCode());
        tdAcctAddCustomData.setAcctOpnDate("");
        if (request.getData().getAccountOpenDate() != null && !request.getData().getAccountOpenDate().isEmpty()) {
            String accountOpenDate = LocalDate.parse(request.getData().getAccountOpenDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            tdAcctAddCustomData.setOpenEffDate(accountOpenDate);
        } else tdAcctAddCustomData.setOpenEffDate("");
        String type = request.getData().getProduct().getType();
        if (request.getData().getProduct() != null && request.getData().getProduct().getType() != null && type.equals("3034") || type.equals("3035") || type.equals("3036") || type.equals("3037") || type.equals("3038") || type.equals("3039") || type.equals("3040") || type.equals("3041") || type.equals("3042")
                || type.equals("3043") || type.equals("3044") || type.equals("3045") || type.equals("3046") || type.equals("3047") || type.equals("3048") ||
                type.equals("3049") || type.equals("3050")) {
            tdAcctAddCustomData.setScopeFlg(request.getData().getScopeFlag());
        }
        tdAcctAddCustomData.setLeadGenCode(request.getData().getLeadGenerator());

        if (request.getData().getJointAcctHldrInfo() != null && !request.getData().getJointAcctHldrInfo().isEmpty() && request.getData().getJointAcctHldrInfo().contains("#")) {
            tdAcctAddCustomData.setAcnRelC(request.getData().getJointAcctHldrInfo().substring(0, request.getData().getJointAcctHldrInfo().indexOf("#")));
        } else if (request.getData().getAccountRelationship() != null && !request.getData().getAccountRelationship().isEmpty()) {
            tdAcctAddCustomData.setAcnRelC(request.getData().getAccountRelationship());
        } else tdAcctAddCustomData.setAcnRelC("A");
        if (request.getData().getAgent() != null) {
            tdAcctAddCustomData.setFreeText10(request.getData().getAgent().getAgentID());
            tdAcctAddCustomData.setFreeText13(request.getData().getAgent().getAgentLatLong());
        }
        tdAcctAddCustomData.setApplicationRefId(request.getData().getComments());
        tdAcctAddCustomData.setFreeText1(request.getData().getPaymentId());
        tdAcctAddCustomData.setTdMisCentRd("1");
        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("0") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            tdAcctAddCustomData.setTotPmtEntd("1");
        }
        tdAcctAddCustomData.setPhoneNum(request.getData().getPhoneNumber());
        tdAcctAddCustomData.setEmailId(request.getData().getEmailId());
        if (request.getData().getNomineeType() != null && !request.getData().getNomineeType().isEmpty()) {
            tdAcctAddCustomData.setNomineeType(request.getData().getNomineeType());
        }
        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("0") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            topmtsys.setIsMultiRec("Y");
            topmtsys.setSrlNum("1");
            topmtsys.setAmtInd("P");
            topmtsys.setPercentage("100");
            topmtsys.setAddnlEntd("1");
            topmtsys.setRemitMode("N");
            topmtsys.setPaySysId("NEFT");
            topmtsys.setRemitterName("RName");
            topmtsys.setRemitterAddr1("BAddr1");
            topmtsys.setPurposeCode("000");
            topmtsys.setPurposeCode("000");
            topmtsys.setBenefName("BName");
            topmtsys.setBenefAddr1("BAddr1");
            topmtsys.setBenefAcct(request.getData().getBeneficiary().getAccountId());
            topmtsys.setCollChrg("N");
            topmtsys.setDebitAcct("10000590110007");
            topmtsys.setCrncyCode("INR");
            topmtsys.setDeptCode("01");
            topmtsys.setRemitCity("MUMBA");
            topmtsys.setRemitState("MH");
            topmtsys.setRemitCountry("IN");
            topmtsys.setRemitPinCode("400037");
            topmtsys.setBenefIfsc(request.getData().getBeneficiary().getIfscCode());
            topmtsys.setBenefCity("MUMBA");
            topmtsys.setBenefState("MH");
            topmtsys.setBenefPinCode("4000604");
            if (request.getData().getComments() != null && !request.getData().getComments().isEmpty()) {
                topmtsys.setSenderToRecvr(request.getData().getComments().contains(SPECIAL_CHARACTERS) ? request.getData().getComments().replaceAll(SPECIAL_CHARACTERS, "") : request.getData().getComments());
//                    topmtsys.setSenderToRecvr(request.getData().getComments().replaceAll(SPECIAL_CHARACTERS, ""));
            } else topmtsys.setSenderToRecvr("Transfer");
            if (request.getData().getBeneficiary() != null && request.getData().getBeneficiary().getAccountType() != null && !request.getData().getBeneficiary().getAccountType().isEmpty()) {
                topmtsys.setRecvrAcctType(request.getData().getBeneficiary().getAccountType());
            }
            tdAcctAddCustomData.setTopmtsys(topmtsys);
        }

        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("2") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            tdAcctAddCustomData.setPopmtEntd("1");
        }
        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("2") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            popmtsys.setIsMultiRec("Y");
            popmtsys.setSrlNum("1");
            popmtsys.setAmtInd("P");
            popmtsys.setPercentage("100");
            popmtsys.setAddnlEntd("1");
            popmtsys.setRemitMode("N");
            popmtsys.setPaySysId("NEFT");
            popmtsys.setRemitterName("RName");
            popmtsys.setPurposeCode("000");
            popmtsys.setPurposeCode("000");
            popmtsys.setBenefName("BName");
            popmtsys.setBenefAddr1("BAddr1");
            popmtsys.setBenefAcct(request.getData().getBeneficiary().getAccountId());
            popmtsys.setCollChrg("N");
            popmtsys.setDebitAcct("10000590110007");
            popmtsys.setCrncyCode("INR");
            popmtsys.setDeptCode("01");
            popmtsys.setRemitCity("MUMBA");
            popmtsys.setRemitState("MH");
            popmtsys.setRemitCountry("IN");
            popmtsys.setRemitPinCode("400037");
            popmtsys.setBenefIfsc(request.getData().getBeneficiary().getIfscCode());
            popmtsys.setBenefCity("MUMBA");
            popmtsys.setBenefState("MH");
            popmtsys.setBenefPinCode("4000604");
            if (request.getData().getComments() != null && !request.getData().getComments().isEmpty()) {
                popmtsys.setSenderToRecvr(request.getData().getComments().replaceAll(SPECIAL_CHARACTERS, ""));
            } else popmtsys.setSenderToRecvr("Transfer");
            if (request.getData().getBeneficiary() != null && request.getData().getBeneficiary().getAccountType() != null && !request.getData().getBeneficiary().getAccountType().isEmpty()) {
                popmtsys.setRecvrAcctType(request.getData().getBeneficiary().getAccountType());
            }
        }
        tdAcctAddCustomData.setPopmtsys(popmtsys);
        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("2") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            tdAcctAddCustomData.setIopmtEntd("1");
        }

        if (request.getData().getInterestDisbursementMode() != null && request.getData().getInterestDisbursementMode().equals("2") && request.getData().getBeneficiary() != null &&
                request.getData().getBeneficiary().getAccountId() != null && !request.getData().getBeneficiary().getAccountId().isEmpty()) {
            iopmtsys.setIsMultiRec("Y");
            iopmtsys.setSrlNum("1");
            iopmtsys.setAmtInd("P");
            iopmtsys.setPercentage("100");
            iopmtsys.setAddnlEntd("1");
            iopmtsys.setRemitMode("N");
            iopmtsys.setPaySysId("NEFT");
            iopmtsys.setRemitterName("RName");
            iopmtsys.setPurposeCode("000");
            iopmtsys.setPurposeCode("000");
            iopmtsys.setBenefName("BName");
            iopmtsys.setBenefAddr1("BAddr1");
            iopmtsys.setBenefAcct(request.getData().getBeneficiary().getAccountId());
            iopmtsys.setCollChrg("N");
            iopmtsys.setDebitAcct("10000590110007");
            iopmtsys.setCrncyCode("INR");
            iopmtsys.setDeptCode("01");
            iopmtsys.setRemitCity("MUMBA");
            iopmtsys.setRemitState("MH");
            iopmtsys.setRemitCountry("IN");
            iopmtsys.setRemitPinCode("400037");
            iopmtsys.setBenefIfsc(request.getData().getBeneficiary().getIfscCode());
            iopmtsys.setBenefCity("MUMBA");
            iopmtsys.setBenefState("MH");
            iopmtsys.setBenefPinCode("4000604");
            if (request.getData().getComments() != null && !request.getData().getComments().isEmpty()) {
                iopmtsys.setSenderToRecvr(request.getData().getComments().replaceAll(SPECIAL_CHARACTERS, ""));
            } else iopmtsys.setSenderToRecvr("Transfer");
            if (request.getData().getBeneficiary() != null && request.getData().getBeneficiary().getAccountType() != null && !request.getData().getBeneficiary().getAccountType().isEmpty()) {
                iopmtsys.setRecvrAcctType(request.getData().getBeneficiary().getAccountType());
            }
        }
        tdAcctAddCustomData.setIopmtsys(iopmtsys);


        if (request.getData().getModeOfOperation() != null && !request.getData().getModeOfOperation().isEmpty() && !request.getData().getModeOfOperation().equals("1") && request.getData().getRelParty() != null) {

            List<com.ssfb.account.dto.opendigitdrd.source.RelParty> relPartyList = request.getData().getRelParty();
            List<RelPartyTarget> relPartyTarget1 = new ArrayList<>();
            for (com.ssfb.account.dto.opendigitdrd.source.RelParty relParty : relPartyList) {
                RelPartyTarget relPartyTarget2 = new RelPartyTarget();
                relPartyTarget2.setIsMultiRec("Y");
                relPartyTarget2.setPassSheetFlg("N");
                relPartyTarget2.setLoanOdNoticeFlg("N");
                relPartyTarget2.setXcludeCombStmtFlg("N");
                relPartyTarget2.setSiFlg("N");
                relPartyTarget2.setDepositNoticeFlg("N");
                relPartyTarget2.setCifId(relParty.getCustomerId());

                relPartyTarget1.add(relPartyTarget2);
            }

            tdAcctAddCustomData.setRelPartyTarget(relPartyTarget1);
        }


        doc.setIsMultiRec("Y");
        doc.setFreeText1(request.getData().getUmrnNumber());

        tdAcctAddCustomData.setDoc(doc);

        tdAcctAddRequest.setTdAcctAddCustomData(tdAcctAddCustomData);

        return tdAcctAddRequest;


    }

    private FIXML unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (FIXML) unmarshaller.unmarshal(reader);
    }


    private FIXML esbAPIRestCALL(RestTemplate restTemplate, FIXML targetRequest) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        ResponseEntity<String> response = restTemplate.exchange(URIBuilder(), HttpMethod.POST, new HttpEntity<>(targetRequest, headers), String.class);

        return unmarshalXML(response.getBody());
    }


    private TDRDCreateResponse prepareSourceResponse(FIXML fixml, String requestId) {
        TDRDCreateResponse response = new TDRDCreateResponse();
        List<TDRDCreateResponseBody> tdrdCreateResponseBodyList = new ArrayList<>();

        if (fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS")) {
            TDRDCreateResponseBody responseBodyList = new TDRDCreateResponseBody();

            responseBodyList.setAccountId(fixml.getBody().getTdAcctAddResponse().getTdAcctAddRs().getTdAcctId().getAcctId());
            responseBodyList.setTransactionCode("00");
            responseBodyList.setPlanCode(fixml.getBody().getTdAcctAddResponse().getTdAcctAddCustomData().getPlanCode());
            responseBodyList.setPlanId(fixml.getBody().getTdAcctAddResponse().getTdAcctAddCustomData().getPlan_ID());

            tdrdCreateResponseBodyList.add(responseBodyList);

            response.setTDRDCreateResponseBody(tdrdCreateResponseBodyList);
//            response.setTDRDCreateResponseBody((List<TDRDCreateResponseBody>) responseBodyList);
        } else if (fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("DUP:SUCCESS") && "FIN".equalsIgnoreCase(requestId)) {
            response.setError(new Error("01", "Duplicate Deposit:" + fixml.getBody().getTdAcctAddResponse().getTdAcctAddRs().getTdAcctId()));
        }
        if (!fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS") && fixml.getBody().getError().getFiSystemException() != null && fixml.getBody().getError().getFiSystemException().getErrorDetail() != null) {
            response.setError(new Error(fixml.getBody().getError().getFiSystemException().getErrorDetail().getErrorCode(), fixml.getBody().getError().getFiSystemException().getErrorDetail().getErrorDesc()));
        } else if (!fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS") && fixml.getBody().getError().getFiBusinessException() != null && fixml.getBody().getError().getFiBusinessException().getErrorDetail() != null) {
            response.setError(new Error(fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorCode(), fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorDesc()));
        }

        return response;

    }


    private static String prepareDepositYear(String depositFrequency) {
        if (depositFrequency != null && depositFrequency.contains("Y")) {
            return depositFrequency.substring(0, depositFrequency.indexOf("Y"));
        }
        return "0";
    }

    private static String prepareDepositMonth(String depositFrequency) {
        if (depositFrequency != null && depositFrequency.contains("M") && depositFrequency.contains("Y")) {
            return depositFrequency.substring(depositFrequency.indexOf("Y") + 1, depositFrequency.indexOf("M"));
        } else if (depositFrequency != null && depositFrequency.contains("M")) {
            return depositFrequency.substring(0, depositFrequency.indexOf("M"));
        }
        return "0";
    }

    private static String prepareDepositDay(String depositFrequency) {
        if (depositFrequency != null && depositFrequency.contains("M") && depositFrequency.contains("D")) {
            return depositFrequency.substring(depositFrequency.indexOf("M") + 1, depositFrequency.indexOf("D"));
        } else if (depositFrequency != null && depositFrequency.contains("Y") && depositFrequency.contains("D")) {
            return depositFrequency.substring(depositFrequency.indexOf("Y") + 1, depositFrequency.indexOf("D"));
        } else if (depositFrequency != null && depositFrequency.contains("D")) {
            return depositFrequency.substring(0, depositFrequency.indexOf("D"));
        }
        return "0";
    }

    private static String prepareschemecode(String jointAcctHldrInfo, String productType, String calculateMonth, String depositDay) {
        if (jointAcctHldrInfo != null && "3003".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3001";
            }
        }
        if (jointAcctHldrInfo != null && "4003".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "4001";
            }
        }
        if (jointAcctHldrInfo != null && "3009".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3005";
            }
        }
        if (jointAcctHldrInfo != null && "3010".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3006";
            }
        }
        if (jointAcctHldrInfo != null && "3011".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3008";
            }
        }
        if (jointAcctHldrInfo != null && "3022".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3002";
            }
        }
        if (jointAcctHldrInfo != null && "3025".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3023";
            }
        }
        if (jointAcctHldrInfo != null && "3026".equals(productType)) {
            String beforehash = jointAcctHldrInfo.contains("#") ? jointAcctHldrInfo.substring(0, jointAcctHldrInfo.indexOf("#")) : jointAcctHldrInfo;
            if (beforehash.contains("C") || beforehash.contains("F")) {
                return "3024";
            }
        }
        if (calculateMonth != null && depositDay != null && ("12".equals(calculateMonth) && "0".equals(depositDay)) || ("0".equals(calculateMonth) && "365".equals(depositDay))
                || ("0".equals(calculateMonth) && "366".equals(depositDay)) && ("3001".equals(productType) || "3057".equals(productType))) {
            return "3053";
        }
        if (calculateMonth != null && depositDay != null && ("12".equals(calculateMonth) && "0".equals(depositDay)) || ("0".equals(calculateMonth) && "365".equals(depositDay))
                || ("0".equals(calculateMonth) && "366".equals(depositDay)) && ("3003".equals(productType) || "3058".equals(productType))) {
            return "3061";
        }
        return productType;
    }

    private static String prepareRelType(TDRDCreateRequest request, String requestId) {
        String postalAddressRelationShip = null;
        if (request.getData().getPostalAddress() != null) {
            String postalrel = request.getData().getPostalAddress().getRelationship();
            if (postalrel != null && !postalrel.trim().isEmpty()) {
                postalAddressRelationShip = postalrel;
            }
        }
        String partyRelationShip = null;
        if (request.getData().getParty() != null && request.getData().getParty().get(0).getRelationship() != null && !request.getData().getParty().get(0).getRelationship().trim().isEmpty()) {
            partyRelationShip = request.getData().getParty().get(0).getRelationship();
        }
        if (isBlank(postalAddressRelationShip) || isBlank(partyRelationShip) && ("MB".equalsIgnoreCase(requestId) || "IBR".equalsIgnoreCase(requestId))) {
            return "42";
        }
        if ("OTHER".equalsIgnoreCase(postalAddressRelationShip) || "OTHER".equalsIgnoreCase(partyRelationShip)) {
            return "42";
        }
        if ("Spouse".equalsIgnoreCase(postalAddressRelationShip) || "Spouse".equalsIgnoreCase(partyRelationShip)) {
            return "37";
        }
        if ("DAUGHTER IN LAW".equalsIgnoreCase(postalAddressRelationShip) || "DAUGHTER IN LAW".equalsIgnoreCase(partyRelationShip)) {
            return "87";
        }
        if ("HUSBAND".equalsIgnoreCase(postalAddressRelationShip) || "HUSBAND".equalsIgnoreCase(partyRelationShip)) {
            return "88";
        }
        if ("SISTER-IN-LAW".equalsIgnoreCase(postalAddressRelationShip) || "SISTER-IN-LAW".equalsIgnoreCase(partyRelationShip)) {
            return "89";
        }
        if ("WIFE".equalsIgnoreCase(postalAddressRelationShip) || "WIFE".equalsIgnoreCase(partyRelationShip)) {
            return "90";
        }
        if ("AUNTY".equalsIgnoreCase(postalAddressRelationShip) || "AUNTY".equalsIgnoreCase(partyRelationShip)) {
            return "91";
        }
        if ("BROTHER".equalsIgnoreCase(postalAddressRelationShip) || "BROTHER".equalsIgnoreCase(partyRelationShip)) {
            return "39";
        }
        if ("BROTHER-IN-LAW".equalsIgnoreCase(postalAddressRelationShip) || "BROTHER-IN-LAW".equalsIgnoreCase(partyRelationShip)) {
            return "92";
        }
        if ("NIECE".equalsIgnoreCase(postalAddressRelationShip) || "NIECE".equalsIgnoreCase(partyRelationShip)) {
            return "93";
        }
        if ("NEPHEW".equalsIgnoreCase(postalAddressRelationShip) || "NEPHEW".equalsIgnoreCase(partyRelationShip)) {
            return "94";
        }
        if ("COUSIN".equalsIgnoreCase(postalAddressRelationShip) || "COUSIN".equalsIgnoreCase(partyRelationShip)) {
            return "95";
        }
        if ("DISCIPLE".equalsIgnoreCase(postalAddressRelationShip) || "DISCIPLE".equalsIgnoreCase(partyRelationShip)) {
            return "96";
        }
        if ("SON".equalsIgnoreCase(postalAddressRelationShip) || "SON".equalsIgnoreCase(partyRelationShip)) {
            return "40";
        }
        if ("FAHTER".equalsIgnoreCase(postalAddressRelationShip) || "FAHTER".equalsIgnoreCase(partyRelationShip)) {
            return "36";
        }
        if ("FATHER-IN-LAW".equalsIgnoreCase(postalAddressRelationShip) || "FATHER-IN-LAW".equalsIgnoreCase(partyRelationShip)) {
            return "97";
        }
        if ("GARND MOTHER".equalsIgnoreCase(postalAddressRelationShip) || "GARND MOTHER".equalsIgnoreCase(partyRelationShip)) {
            return "98";
        }
        if ("GARANDSON".equalsIgnoreCase(postalAddressRelationShip) || "GARANDSON".equalsIgnoreCase(partyRelationShip)) {
            return "99";
        }
        if ("GRAND DAUGHTER".equalsIgnoreCase(postalAddressRelationShip) || "GRAND DAUGHTER".equalsIgnoreCase(partyRelationShip)) {
            return "100";
        }
        if ("GRAND FATHER".equalsIgnoreCase(postalAddressRelationShip) || "GRAND FATHER".equalsIgnoreCase(partyRelationShip)) {
            return "101";
        }
        if ("UNCLE".equalsIgnoreCase(postalAddressRelationShip) || "UNCLE".equalsIgnoreCase(partyRelationShip)) {
            return "102";
        }
        if ("MOTHER".equalsIgnoreCase(postalAddressRelationShip) || "MOTHER".equalsIgnoreCase(partyRelationShip)) {
            return "35";
        }
        if ("MOTHER IN LAW".equalsIgnoreCase(postalAddressRelationShip) || "MOTHER IN LAW".equalsIgnoreCase(partyRelationShip)) {
            return "103";
        }
        if ("SISTER".equalsIgnoreCase(postalAddressRelationShip) || "SISTER".equalsIgnoreCase(partyRelationShip)) {
            return "38";
        }
        return !isBlank(postalAddressRelationShip) ? postalAddressRelationShip : partyRelationShip;
    }

    private static String preparemultiplereltype(Party party, String requestId) {
        String partyRelationShip = null;
        if (party != null && party.getRelationship() != null && !party.getRelationship().trim().isEmpty()) {
            partyRelationShip = party.getRelationship();
        }
        if (("MB".equalsIgnoreCase(requestId) || "IBR".equalsIgnoreCase(requestId)) && partyRelationShip==null) return "42";
        if ("OTHER".equalsIgnoreCase(partyRelationShip)) return "42";
        if ("Spouse".equalsIgnoreCase(partyRelationShip)) return "37";
        if ("DAUGHTER IN LAW".equalsIgnoreCase(partyRelationShip) || "DAUGHTER-IN-LAW".equalsIgnoreCase(partyRelationShip))
            return "87";
        if ("HUSBAND".equalsIgnoreCase(partyRelationShip)) return "88";
        if ("SISTER-IN-LAW".equalsIgnoreCase(partyRelationShip)) return "89";
        if ("WIFE".equalsIgnoreCase(partyRelationShip)) return "90";
        if ("AUNTY".equalsIgnoreCase(partyRelationShip)) return "91";
        if ("BROTHER".equalsIgnoreCase(partyRelationShip)) return "39";
        if ("BROTHER-IN-LAW".equalsIgnoreCase(partyRelationShip)) return "92";
        if ("NIECE".equalsIgnoreCase(partyRelationShip)) return "93";
        if ("NEPHEW".equalsIgnoreCase(partyRelationShip)) return "94";
        if ("COUSIN".equalsIgnoreCase(partyRelationShip)) return "95";
        if ("DISCIPLE".equalsIgnoreCase(partyRelationShip)) return "96";
        if ("SON".equalsIgnoreCase(partyRelationShip)) return "40";
        if ("FAHTER".equalsIgnoreCase(partyRelationShip) || "FATHER".equalsIgnoreCase(partyRelationShip)) return "36";
        if ("FATHER-IN-LAW".equalsIgnoreCase(partyRelationShip)) return "97";
        if ("GARND MOTHER".equalsIgnoreCase(partyRelationShip) || "GRAND MOTHER".equalsIgnoreCase(partyRelationShip))
            return "98";
        if ("GARANDSON".equalsIgnoreCase(partyRelationShip) || "GRANDSON".equalsIgnoreCase(partyRelationShip))
            return "99";
        if ("GRAND DAUGHTER".equalsIgnoreCase(partyRelationShip)) return "100";
        if ("GRAND FATHER".equalsIgnoreCase(partyRelationShip)) return "101";
        if ("UNCLE".equalsIgnoreCase(partyRelationShip)) return "102";
        if ("MOTHER".equalsIgnoreCase(partyRelationShip)) return "35";
        if ("MOTHER IN LAW".equalsIgnoreCase(partyRelationShip)) return "103";
        if ("SISTER".equalsIgnoreCase(partyRelationShip)) return "38";
        return partyRelationShip;
    }

    private PostAddr prepareSinglePartyPostAddr(TDRDCreateRequest request) {

        PostAddr postAddr = new PostAddr();
        PostalAddress postalAddress = request.getData().getPostalAddress();

        PartyPostalAddress partyPostalAddress = null;
        if (request.getData().getParty() != null
                && !request.getData().getParty().isEmpty()) {
            partyPostalAddress = request.getData().getParty().get(0).getPartyPostalAddress();
        }
        postAddr.setAddr1(getValue(partyPostalAddress != null ? partyPostalAddress.getStreetName() : null,
                postalAddress != null ? postalAddress.getStreetName() : null));
        postAddr.setAddr2(getValue(partyPostalAddress != null ? partyPostalAddress.getBuildingNumber() : null,
                postalAddress != null ? postalAddress.getBuildingNumber() : null));
        postAddr.setAddr3(getValue((partyPostalAddress != null && partyPostalAddress.getAddressLine() != null && !partyPostalAddress.getAddressLine().isEmpty()) ? partyPostalAddress.getAddressLine() : null,
                postalAddress != null ? postalAddress.getDepartment() : null));
        postAddr.setCity(getValue((partyPostalAddress != null && partyPostalAddress.getCity() != null && !partyPostalAddress.getCity().isEmpty()) ? partyPostalAddress.getCity() : null,
                (postalAddress != null && postalAddress.getCity() != null && !postalAddress.getCity().isEmpty()) ? postalAddress.getCity() : "MUMBA"));
        postAddr.setStateProv(getValue((partyPostalAddress != null && partyPostalAddress.getState() != null && !partyPostalAddress.getState().isEmpty()) ? partyPostalAddress.getState() : null,
                (postalAddress != null && postalAddress.getState() != null && !postalAddress.getState().isEmpty()) ? postalAddress.getState() : "MH"));
        postAddr.setPostalCode(getValue((partyPostalAddress != null && partyPostalAddress.getPostalCode() != null && !partyPostalAddress.getPostalCode().isEmpty()) ? partyPostalAddress.getPostalCode() : null,
                (postalAddress != null && postalAddress.getPostalCode() != null && !postalAddress.getPostalCode().isEmpty()) ? postalAddress.getPostalCode() : "400001"));
        postAddr.setCountry(getValue((partyPostalAddress != null && partyPostalAddress.getCountry() != null && !partyPostalAddress.getCountry().isEmpty()) ? partyPostalAddress.getCountry() : null,
                (postalAddress != null && postalAddress.getCountry() != null && !postalAddress.getCountry().isEmpty()) ? postalAddress.getCountry() : "IN"));
        return postAddr;
    }


    private static String prepareSinglePartMinorFlag(TDRDCreateRequest request) {
        if (request.getData().getParty() != null && request.getData().getParty().get(0).getMinor() != null && !request.getData().getParty().get(0).getMinor().isEmpty()) {
            return request.getData().getParty().get(0).getMinor();
        } else if (request.getData().getPostalAddress() != null && request.getData().getPostalAddress().getMinor() != null && !request.getData().getPostalAddress().getMinor().isEmpty()) {
            return request.getData().getPostalAddress().getMinor();
        } else if ((request.getData().getPostalAddress() != null && request.getData().getPostalAddress().getAge() != null && !request.getData().getPostalAddress().getAge().isEmpty() && Integer.parseInt(request.getData().getPostalAddress().getAge()) < 18) ||
                request.getData().getParty() != null && request.getData().getParty().get(0).getAge() != null && Integer.parseInt(request.getData().getParty().get(0).getAge()) < 18) {
            return "Y";
        } else return null;
    }

    private static String preparenomineeBirthDateSingleParty(TDRDCreateRequest request) {
        if (request.getData().getParty() != null && request.getData().getParty().get(0).getDateOfBirth() != null && !request.getData().getParty().get(0).getDateOfBirth().isEmpty()) {
            return request.getData().getParty().get(0).getDateOfBirth() + "T00:00:00.000";
        } else if ((request.getData().getPostalAddress() != null && request.getData().getPostalAddress().getAge() != null && !request.getData().getPostalAddress().getAge().isEmpty() && Integer.parseInt(request.getData().getPostalAddress().getAge()) < 18) ||
                request.getData().getParty() != null && request.getData().getParty().get(0).getAge() != null && !request.getData().getParty().get(0).getAge().isEmpty() && Integer.parseInt(request.getData().getParty().get(0).getAge()) < 18) {
            return "2015-01-01T00:00:00.000";
        } else return null;

    }

    private GuardianInfo prepareguardianInfoSingleParty(TDRDCreateRequest request) {
        GuardianInfo guardianInfo = new GuardianInfo();
        PhoneNum phoneNum = new PhoneNum();
        GuardianContactInfo guardianContactInfo = new GuardianContactInfo();
        PostAddr guardianPostAddr = new PostAddr();
        if ((request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getName() != null && !request.getData().getParty().get(0).getGuardian().getName().isEmpty()) || request.getData().getPostalAddress().getGuardianName() != null && !request.getData().getPostalAddress().getGuardianName().isEmpty()) {
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getName() != null && !request.getData().getParty().get(0).getGuardian().getName().isEmpty()) {
                guardianInfo.setGuardianCode(request.getData().getParty().get(0).getGuardian().getCode());
                guardianInfo.setGuardianName(request.getData().getParty().get(0).getGuardian().getName());
            } else if (request.getData().getPostalAddress().getGuardianName() != null && !request.getData().getPostalAddress().getGuardianName().isEmpty()) {
                guardianInfo.setGuardianCode("OTHERS");
                guardianInfo.setGuardianName(request.getData().getPostalAddress().getGuardianName());
            }
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getMobileNumber() != null && !request.getData().getParty().get(0).getGuardian().getMobileNumber().isEmpty()) {
                phoneNum.setTelephoneNum(request.getData().getParty().get(0).getGuardian().getMobileNumber());
            }

            guardianContactInfo.setPhoneNum(phoneNum);
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getEmailId() != null && !request.getData().getParty().get(0).getGuardian().getEmailId().isEmpty()) {
                guardianContactInfo.setEmailAddr(request.getData().getParty().get(0).getGuardian().getEmailId());
            }
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getAddressLine1() != null && !request.getData().getParty().get(0).getGuardian().getAddressLine1().isEmpty()) {
                guardianPostAddr.setAddr1(request.getData().getParty().get(0).getGuardian().getAddressLine1());
            } else if (request.getData().getPostalAddress() != null && request.getData().getPostalAddress().getStreetName() != null && !request.getData().getPostalAddress().getStreetName().isEmpty()) {
                guardianPostAddr.setAddr1(request.getData().getPostalAddress().getStreetName());
            }
            guardianPostAddr.setAddr2(request.getData().getParty().get(0).getGuardian().getAddressLine2());
            guardianPostAddr.setAddr3(request.getData().getParty().get(0).getGuardian().getAddressLine3());
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getCity() != null && !request.getData().getParty().get(0).getGuardian().getCity().isEmpty()) {
                guardianPostAddr.setCity(request.getData().getParty().get(0).getGuardian().getCity());
            } else guardianPostAddr.setCity("MUMBA");
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getState() != null && !request.getData().getParty().get(0).getGuardian().getState().isEmpty()) {
                guardianPostAddr.setStateProv(request.getData().getParty().get(0).getGuardian().getState());
            } else guardianPostAddr.setStateProv("MH");
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getPostalCode() != null && !request.getData().getParty().get(0).getGuardian().getPostalCode().isEmpty()) {
                guardianPostAddr.setPostalCode(request.getData().getParty().get(0).getGuardian().getPostalCode());
            } else guardianPostAddr.setStateProv("400001");
            if (request.getData().getParty().get(0).getGuardian() != null && request.getData().getParty().get(0).getGuardian().getCountry() != null && !request.getData().getParty().get(0).getGuardian().getCountry().isEmpty()) {
                guardianPostAddr.setCountry(request.getData().getParty().get(0).getGuardian().getCountry());
            } else guardianPostAddr.setCountry("IN");
            guardianContactInfo.setPostAddr(guardianPostAddr);
            guardianInfo.setGuardianContactInfo(guardianContactInfo);
        }

        return guardianInfo;
    }

    private GuardianInfo prepareMultiPartyGuardianInfo(Party party) {
        GuardianInfo guardianInfo = new GuardianInfo();
        GuardianContactInfo guardianContactInfo = new GuardianContactInfo();
        Guardian multipartyguardianinfo = party.getGuardian();
        PostAddr postAddr = new PostAddr();
        PhoneNum phoneNum = new PhoneNum();
        if (multipartyguardianinfo!=null && multipartyguardianinfo.getName() != null && !multipartyguardianinfo.getName().isEmpty()) {
            guardianInfo.setGuardianCode(multipartyguardianinfo.getCode());
            if (multipartyguardianinfo.getName() != null && !multipartyguardianinfo.getName().isEmpty()) {
                guardianInfo.setGuardianCode(multipartyguardianinfo.getName());
            }
            phoneNum.setTelephoneNum(multipartyguardianinfo.getMobileNumber());
            guardianContactInfo.setPhoneNum(phoneNum);
            guardianContactInfo.setEmailAddr(multipartyguardianinfo.getEmailId());
            if (multipartyguardianinfo.getAddressLine1() != null && !multipartyguardianinfo.getAddressLine1().isEmpty()) {
                postAddr.setAddr1(multipartyguardianinfo.getAddressLine1());
            }
            postAddr.setAddr2(multipartyguardianinfo.getAddressLine2());
            postAddr.setAddr3(multipartyguardianinfo.getAddressLine3());
            if (multipartyguardianinfo.getCity() != null && !multipartyguardianinfo.getCity().isEmpty()) {
                postAddr.setCity(multipartyguardianinfo.getCity());
            }
            if (multipartyguardianinfo.getState() != null && !multipartyguardianinfo.getState().isEmpty()) {
                postAddr.setStateProv(multipartyguardianinfo.getState());
            }
            if (multipartyguardianinfo.getPostalCode() != null && !multipartyguardianinfo.getPostalCode().isEmpty()) {
                postAddr.setPostalCode(multipartyguardianinfo.getPostalCode());
            }
            if (multipartyguardianinfo.getCountry() != null && !multipartyguardianinfo.getCountry().isEmpty()) {
                postAddr.setCountry(multipartyguardianinfo.getCountry());
            }

            guardianContactInfo.setPostAddr(postAddr);

            guardianInfo.setGuardianContactInfo(guardianContactInfo);
        }

        return guardianInfo;
    }

    private PostAddr prepareMultiPartyPostalAddress(Party party){
        PostAddr multiPartyPostalAddress = new PostAddr();
        PartyPostalAddress partyPostalAddress = party.getPartyPostalAddress();
        if(party.getPartyPostalAddress()!=null) {
            multiPartyPostalAddress.setAddr1(partyPostalAddress.getStreetName());
            multiPartyPostalAddress.setAddr2(partyPostalAddress.getBuildingNumber());
            multiPartyPostalAddress.setAddr3(partyPostalAddress.getDepartment());
        }
            multiPartyPostalAddress.setCity((partyPostalAddress!=null && partyPostalAddress.getCity() !=null && !partyPostalAddress.getCity().isEmpty()) ? partyPostalAddress.getCity() : "MUMBA");
            multiPartyPostalAddress.setStateProv((partyPostalAddress!=null && partyPostalAddress.getState() !=null && !partyPostalAddress.getState().isEmpty()) ? partyPostalAddress.getState() : "MH");
            multiPartyPostalAddress.setPostalCode((partyPostalAddress!=null &&partyPostalAddress.getPostalCode() !=null && !partyPostalAddress.getPostalCode().isEmpty()) ? partyPostalAddress.getPostalCode() : "400001");
            multiPartyPostalAddress.setCountry((partyPostalAddress!=null &&partyPostalAddress.getCountry() !=null && !partyPostalAddress.getCountry().isEmpty()) ? partyPostalAddress.getCountry() : "IN");

        return multiPartyPostalAddress;
    }



    private URI URIBuilder(){
        return UriComponentsBuilder.newInstance().scheme(config.getProtocol()).host(config.getHostname()).port(config.getPort()).path(config.getPath()).build().toUri();
    }

}
