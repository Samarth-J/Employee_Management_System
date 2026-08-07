package com.SpringBootProject.Employee_Management_System.controller;

import com.SpringBootProject.Employee_Management_System.dto.RegisterRequest;
import com.SpringBootProject.Employee_Management_System.dto.VerifyOtpRequest;
import com.SpringBootProject.Employee_Management_System.service.OtpService;
import com.SpringBootProject.Employee_Management_System.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private OtpService otpService;

    public UserController(UserService userService, OtpService otpService) {
        this.userService = userService;
        this.otpService = otpService;
    }

    @PostMapping("/register")
    private String register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    @PostMapping("/verify-otp")
    public String  VerifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest){
       return otpService.VerifyOtp(verifyOtpRequest);
    }
}

