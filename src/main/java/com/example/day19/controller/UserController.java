package com.example.day19.controller;

import com.example.day19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        return new ResponseEntity<Object>(userService.findUserInfoByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/api/user")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<Object>(userService.findAllUserInfo(), HttpStatus.OK);
    }

}
