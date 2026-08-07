package com.SpringBootProject.Employee_Management_System.service;

import com.SpringBootProject.Employee_Management_System.dto.RegisterRequest;
import com.SpringBootProject.Employee_Management_System.entity.User;
import com.SpringBootProject.Employee_Management_System.repository.UserRepository;
import com.SpringBootProject.Employee_Management_System.util.OtpGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public String register(RegisterRequest registerRequest){
       Optional<User> ou = userRepository.findByEmail(registerRequest.getEmail());
       if(ou.isPresent()){
           return "email_id already exists";
       }
       else {
           User user =new User();
           user.setName(registerRequest.getName());
           user.setEmail(registerRequest.getEmail());
           user.setPassword(registerRequest.getPassword());
           user.setRole("USER_ROLE");
           user.setVerified(false);
           String otp = OtpGenerator.generateOtp();
           user.setOtp(otp);
           user.setOtpexpiry(LocalDateTime.now().plusMinutes(5));
           userRepository.save(user);

           emailService.sendOtp(registerRequest.getEmail(),otp);
           return "please check your email for otp";
       }
    }
}
