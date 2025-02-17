package com.example.restaurantmanagement.dto;


import com.example.restaurantmanagement.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expiryTime;
    @Valid
    @NotEmpty
    private String name;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    private String phoneNumber;
    private String role;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private Users users;
    private List<Users> usersList;

}
