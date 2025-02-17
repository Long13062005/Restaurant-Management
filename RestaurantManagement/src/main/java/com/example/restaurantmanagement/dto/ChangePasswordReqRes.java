package com.example.restaurantmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangePasswordReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
