package com.lazyprogrammer.userservice.service;

import org.springframework.stereotype.Service;

import com.lazyprogrammer.userservice.dto.UserRequest;
import com.lazyprogrammer.userservice.dto.UserResponse;
import com.lazyprogrammer.userservice.model.User;
import com.lazyprogrammer.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest) {
        User user = User.builder().email(userRequest.getEmail()).username(userRequest.getUsername()).build();

        userRepository.save(user);
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            UserResponse response = new UserResponse();

            response.setId(id);
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());

            return response;
        }

        return null;
    }
}
