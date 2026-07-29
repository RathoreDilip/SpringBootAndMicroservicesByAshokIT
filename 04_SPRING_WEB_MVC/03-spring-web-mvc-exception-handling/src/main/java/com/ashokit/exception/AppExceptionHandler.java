package com.ashokit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class AppExceptionHandler {

    private Logger logger= LoggerFactory.getLogger(AppExceptionHandler.class);

    // user defined exception
    @ExceptionHandler(value = ProductNotFoundException.class)
    public String handleProductNotFoundException(ProductNotFoundException e, Model model){
        logger.error(e.getMessage());
        model.addAttribute("msg","No Product Found");
        return "errorPage";
    }

    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException(SQLException e,Model model){
        logger.error(e.getMessage());
        model.addAttribute("msg",e.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String handleNPE(NullPointerException e,Model model){
        logger.error(e.getMessage());
        model.addAttribute("msg",e.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e,Model model){
        logger.error(e.getMessage());
        model.addAttribute("msg",e.getMessage());
        return "errorPage";
    }

}
