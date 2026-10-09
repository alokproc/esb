package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDtls {

    @JsonProperty("DocumentType")
    private String documentType;

    @JsonProperty("DocumentID")
    private String documentId;

    @JsonProperty("IsDocumentRcvd")
    private String isDocumentRcvd;

    @JsonProperty("DocumentUploadedOn")
    private String documentUploadedOn;
}
