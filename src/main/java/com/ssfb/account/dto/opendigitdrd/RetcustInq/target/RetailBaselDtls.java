package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RetailBaselDtls {
    @XmlElement(name = "retBaselID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String retBaselID;

    @XmlElement(name = "DebtHELOC", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String debtHELOC;

    @XmlElement(name = "CurrFICOScore", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String currFICOScore;

    @XmlElement(name = "TotalDSR", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String totalDSR;

    @XmlElement(name = "BusinessTotalScore", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String businessTotalScore;

    @XmlElement(name = "HasRelationship", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String hasRelationship;

    @XmlElement(name = "CombinedDSR", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String combinedDSR;

    @XmlElement(name = "BusinessDSR", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String businessDSR;

    @XmlElement(name = "CashAssetRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cashAssetRatio;

    @XmlElement(name = "DebtWorthRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String debtWorthRatio;

    @XmlElement(name = "InterestTaxRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String interestTaxRatio;

    @XmlElement(name = "GeneralQuickRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String generalQuickRatio;

    @XmlElement(name = "ScoredSICCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String scoredSICCode;

    @XmlElement(name = "OwnerYears", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ownerYears;

    @XmlElement(name = "NetWorth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String netWorth;

    @XmlElement(name = "DDABal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ddaBal;

    @XmlElement(name = "CombinedDebtRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String combinedDebtRatio;

    @XmlElement(name = "ProposedLeverage", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String proposedLeverage;

    @XmlElement(name = "GLBLCashCoverage", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String glblCashCoverage;

    @XmlElement(name = "CurrentRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String currentRatio;

    @XmlElement(name = "LiquidityRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String liquidityRatio;

    @XmlElement(name = "MinTangibleWorth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String minTangibleWorth;

    @XmlElement(name = "FICOScore", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ficoScore;

    @XmlElement(name = "FinInqCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String finInqCnt;

    @XmlElement(name = "FinTradeCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String finTradeCnt;

    @XmlElement(name = "InquiryCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String inquiryCnt;

    @XmlElement(name = "MinorDerogatoryCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String minorDerogatoryCnt;

    @XmlElement(name = "MajorDerogatoryCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String majorDerogatoryCnt;

    @XmlElement(name = "NeverPastDueCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String neverPastDueCnt;

    @XmlElement(name = "OpenTradeCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String openTradeCnt;

    @XmlElement(name = "HighestCreditLmt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String highestCreditLmt;

    @XmlElement(name = "TradeCntThirty", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tradeCntThirty;

    @XmlElement(name = "TradeCntSixty", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tradeCntSixty;

    @XmlElement(name = "TradeCntNinety", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tradeCntNinety;

    @XmlElement(name = "RevolveDebtPrcnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String revolveDebtPrcnt;

    @XmlElement(name = "SatisfactoryCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String satisfactoryCnt;

    @XmlElement(name = "InstLoanBal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String instLoanBal;

    @XmlElement(name = "InstLoanCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String instLoanCnt;

    @XmlElement(name = "MortgageBal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String mortgageBal;

    @XmlElement(name = "MortgageTradeCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String mortgageTradeCnt;

    @XmlElement(name = "OtherTradeBal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String otherTradeBal;

    @XmlElement(name = "OtherTradeCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String otherTradeCnt;

    @XmlElement(name = "RevolveBal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String revolveBal;

    @XmlElement(name = "RevolveTradeLmt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String revolveTradeLmt;

    @XmlElement(name = "RevolveTradeCnt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String revolveTradeCnt;

    @XmlElement(name = "CCLimit", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ccLimit;

    @XmlElement(name = "IsWorst", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isWorst;

    @XmlElement(name = "ExpenseIncomeRatio", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String expenseIncomeRatio;

    @XmlElement(name = "SgmntPoolID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String sgmntPoolID;

    @XmlElement(name = "PoolPD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String poolPD;

    @XmlElement(name = "PoolLGD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String poolLGD;

    @XmlElement(name = "PoolEAD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String poolEAD;

    @XmlElement(name = "PD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pd;

    @XmlElement(name = "LGD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String lgd;

    @XmlElement(name = "EAD", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ead;

    @XmlElement(name = "ModelName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String modelName;

    @XmlElement(name = "ModelVersion", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String modelVersion;

    @XmlElement(name = "ModelResult", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String modelResult;

    @XmlElement(name = "IsFailed", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isFailed;
}
