package com.ashokit.zbest.practice.dao;

import org.springframework.stereotype.Component;

@Component("emp")
public class EmpDaoImpl implements EmpDao {

    public EmpDaoImpl(){
        System.out.println("EmpDaoImpl() Bean is created... :"+this.getClass().getName());
    }

    public String findUserNameById(int id){
        if(id==1)
            return "Raju";
        else if (id==2)
            return "Ram";
        else
            return "Invalid";
    }

}
