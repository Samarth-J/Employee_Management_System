package com.SpringBootProject.Employee_Management_System.service;

import com.SpringBootProject.Employee_Management_System.dto.VerifyOtpRequest;
import com.SpringBootProject.Employee_Management_System.entity.User;
import com.SpringBootProject.Employee_Management_System.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpService {
    private UserRepository userRepository;

    public OtpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String VerifyOtp(VerifyOtpRequest verifyOtpRequest){
        Optional<User> optionalUser =userRepository.findByEmail(verifyOtpRequest.getEmail());
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            if(!user.getOtp().equals(verifyOtpRequest.getOtp())){
                return "invalid otp";
            }
            if (LocalDateTime.now().isAfter(user.getOtpexpiry())) {
                return "otp is expired";
            }
            else{
                user.setVerified(true);
                user.setOtp(null);
                user.setOtpexpiry(null);
                userRepository.save(user);
                return "otp verified successfully";
            }
        }
        else {
            return "user not found";
        }

    }
}
