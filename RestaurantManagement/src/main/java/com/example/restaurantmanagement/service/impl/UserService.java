package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.dto.ReqRes;
import com.example.restaurantmanagement.model.Users;
import com.example.restaurantmanagement.repository.RolesRepository;
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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ReqRes register(ReqRes registerRequest) {
        ReqRes response = new ReqRes();
        try {
            Users user = new Users();
            user.setRoles(rolesRepository.findByName("CUSTOMER"));
            user.setUsername(registerRequest.getUsername());
            user.setDeleted(false);
            user.setDateOfBirth(registerRequest.getDateOfBirth());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            Users savedUser = userRepository.save(user);

            if (savedUser.getUsername() == userRepository.findByUsername(registerRequest.getUsername()).get().getUsername()) {
                response.setUsers(savedUser);
                response.setMessage("User saved Successfully");
                response.setStatusCode(200);
            }

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;    }

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
        ReqRes reqRes = new ReqRes();

        try {
            List<Users> result = userRepository.findAll();
            if (!result.isEmpty()) {
                reqRes.setUsersList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }    }

    @Override
    public ReqRes getUsersById(Integer id) {
        ReqRes reqRes = new ReqRes();
        try {
            Users usersById = userRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setUsers(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;    }

    @Override
    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            userRepository.softDeleteById(userId);
            reqRes.setStatusCode(200);
            reqRes.setMessage("User deleted successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    @Override
    public ReqRes updateUser(Integer userId, Users updatedUser) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Users> userOptional = userRepository.findById(String.valueOf(userId));
            if (userOptional.isPresent()) {
                Users user = userOptional.get();
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setDateOfBirth(updatedUser.getDateOfBirth());
                user.setPhoneNumber(updatedUser.getPhoneNumber());
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                user.setRoles(updatedUser.getRoles());
                userRepository.save(user);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User updated successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return reqRes;
    }

    @Override
    public ReqRes getMyInfo(String username) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Users> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                reqRes.setUsers(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;
    }
}
