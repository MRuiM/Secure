package com.example.day19.service;

import com.example.day19.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findUserInfoByUserId(String userId);

    List<User> findAllUserInfo();
}
