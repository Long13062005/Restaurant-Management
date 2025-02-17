package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.dto.ReqRes;
import com.example.restaurantmanagement.model.Users;

public interface IUserService {
    ReqRes register(ReqRes registerRequest);
    ReqRes login(ReqRes loginRequest);
    ReqRes refreshAccessToken(String refreshToken);
    ReqRes getAllUsers();
    ReqRes getUsersById(Integer id);
    ReqRes deleteUser(Integer userId);
    ReqRes updateUser(Integer userId, Users updatedUser);
    ReqRes getMyInfo(String username);
}
