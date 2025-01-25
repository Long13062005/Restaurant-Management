package com.example.restaurantmanagement.dto;


import com.example.restaurantmanagement.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String role;
    private String username;
    private String email;
    private String password;
    private Users users;
    private List<Users> usersList;

}
