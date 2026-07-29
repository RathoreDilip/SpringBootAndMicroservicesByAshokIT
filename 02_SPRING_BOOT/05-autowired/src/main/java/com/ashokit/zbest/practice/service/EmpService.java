package com.ashokit.zbest.practice.service;

import com.ashokit.zbest.practice.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmpService {

    // field level

//    @Autowired
//    @Qualifier("emp")
//    private EmpDao empDao;

    // constructor level - check using constructor parameter name

    private EmpDao empDao;

    public EmpService(EmpDao manager){
        System.out.println("EmpService() no param constructor called... bean is created...");
        this.empDao=manager;
    }

    public String getName(int id){
        return empDao.findUserNameById(id);
    }

}
