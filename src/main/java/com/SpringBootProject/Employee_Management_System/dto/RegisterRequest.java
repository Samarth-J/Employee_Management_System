package com.SpringBootProject.Employee_Management_System.dto;

import lombok.Data;

import javax.xml.transform.sax.SAXResult;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
