package com.SpringBootProject.Employee_Management_System.service;

import com.SpringBootProject.Employee_Management_System.dto.RegisterRequest;
import com.SpringBootProject.Employee_Management_System.entity.User;
import com.SpringBootProject.Employee_Management_System.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
           userRepository.save(user);
           return "please enter the otp";
       }
    }
}
