package com.SpringBootProject.Employee_Management_System.controller;

import com.SpringBootProject.Employee_Management_System.dto.RegisterRequest;
import com.SpringBootProject.Employee_Management_System.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private String register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

}

