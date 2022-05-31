package com.example.day19.service;


import com.example.day19.domain.User;
import com.example.day19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserInfoByUserId(String userId) {
        User user = userRepository.findUserByUserId(userId);
        return user;
    }

    @Override
    public List<User> findAllUserInfo() throws IllegalArgumentException, NullPointerException {
        List<User> users = Optional.ofNullable(userRepository.findAllUser()).orElse(new ArrayList<>());
        return users;
    }


}
