package com.assignment.user.service;

import com.assignment.user.dao.UserDAO;

public class UserService {

    private EmailService emailService;
    private PasswordService passwordService;
    private UserDAO userDAO;

    public UserService(){
        System.out.println("UserService() no-arg constructor called...");
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void callAllService(){
        userDAO.userCall();
        passwordService.passwordGenerate();
        emailService.sendEmail();
    }

}
