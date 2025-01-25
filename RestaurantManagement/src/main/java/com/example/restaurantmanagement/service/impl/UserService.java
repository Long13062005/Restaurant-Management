package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.dto.ReqRes;
import com.example.restaurantmanagement.model.Users;
import com.example.restaurantmanagement.repository.UserRepository;
import com.example.restaurantmanagement.service.IUserService;
import com.example.restaurantmanagement.utils.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;


    @Override
    public ReqRes register(ReqRes registerRequest) {
        return null;
    }

    @Override
    public ReqRes login(ReqRes loginRequest) {
        ReqRes response = new ReqRes();

        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));
            var user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
            String token = jwtTokenService.generateToken(user);
            String refreshToken = jwtTokenService.generateRefreshToken(new HashMap<>(), user);

            response.setStatusCode(200);
            response.setToken(token);
            response.setRole(user.getRoles().toString());
            response.setRefreshToken(refreshToken);
            response.setExpiryTime("30m");
            response.setMessage("Successfully Logged In");

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public ReqRes refreshAccessToken(String refreshToken) {
        ReqRes response = new ReqRes();
        try {
            String userEmail = jwtTokenService.extractUsername(refreshToken);
            Users user = userRepository.findByUsername(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

            if (user != null) {
                if (jwtTokenService.isTokenValid(refreshToken, user)) {
                    String accessToken = jwtTokenService.generateToken(user);
                    response.setStatusCode(200);
                    response.setToken(accessToken);
                    response.setRefreshToken(refreshToken);
                    response.setRole(user.getRoles().toString());
                    response.setExpiryTime("30M");
                    response.setMessage("Successfully Refreshed Token");
                }
            } else {
                throw new RuntimeException("Invalid User");
            }

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public ReqRes getAllUsers() {
        return null;
    }

    @Override
    public ReqRes getUsersById(Integer id) {
        return null;
    }

    @Override
    public ReqRes deleteUser(Integer userId) {
        return null;
    }

    @Override
    public ReqRes updateUser(Integer userId, Users updatedUser) {
        return null;
    }

    @Override
    public ReqRes getMyInfo(String email) {
        return null;
    }
}
