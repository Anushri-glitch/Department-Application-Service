package com.CSE.DepartmentApplicationService.Controller;

import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Repository.IUserDao;
import com.CSE.DepartmentApplicationService.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartentController {

    @Autowired
    IUserDao userDao;

    @Autowired
    DepartmentService dpService;

    //List Of All Users For TA's
    @GetMapping(value = "/AllUsers")
    public List<User> getUser(){
        return userDao.findAll();
    }

    //List Of Users For Administrator & Instructor
    @GetMapping(value = "/selected/type/{userType}")
    public List<User> getUserByType(@PathVariable String userType){
        return dpService.getUserByType(userType);
    }
}
