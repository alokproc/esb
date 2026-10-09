package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RtCustInqResponseBody {
    @JsonProperty("AccountDetails")
    private List<AccountDetails> accountDetails;
    @JsonProperty("DepositDetails")
    private List<DepositDetails> depositDetails;
    @JsonProperty("ProfileLoanDetails")
    private List<ProfileLoanDetails> profileLoanDetails;
    @JsonProperty("BR.NetLoanDetails")
    private List<BrNetLoanDetails> brNetLoanDetails;
    @JsonProperty("CustomerDetails")
    private List<CustomerDetails> CustomerDetails;
    @JsonProperty("CRMCustDataResponse")
    private List<CRMCustDataResponse> cRMCustDataResponse;
    @JsonProperty("GetCorporateCustomerDetails_CustomData")
    private GetCorporateCustomerDetailsCustomData getCorporateCustomerDetailsCustomData;
    @JsonProperty("TransactionCode")
    private String transactionCode;
}
