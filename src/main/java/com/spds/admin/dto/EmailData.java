package com.spds.admin.dto;

import java.util.Map;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailData {

    private String toEmail;

    private Map<String, String> body;// body of the email

    private String ccEmail;

    private String bccEmail;

    private String subject;

    private String contentType;

    private String veName;

}
