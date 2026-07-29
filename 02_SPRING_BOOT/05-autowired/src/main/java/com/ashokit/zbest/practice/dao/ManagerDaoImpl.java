package com.ashokit.zbest.practice.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("manager")
//@Primary
public class ManagerDaoImpl implements EmpDao {

    public ManagerDaoImpl(){
        System.out.println("ManagerDaoImpl() no param constructor called... bean is created...");
    }

    public String findUserNameById(int id){
        if (id==1)
            return "Tarang";
        else if(id==2)
            return "Rajesh";
        else
            return "Invalid";
    }

}
