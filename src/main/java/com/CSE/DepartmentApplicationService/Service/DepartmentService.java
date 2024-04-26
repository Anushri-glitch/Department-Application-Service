package com.CSE.DepartmentApplicationService.Service;

import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    IUserDao userDaoForDp;

    public List<User> getUserByType(String userType) {

        List<User> all = userDaoForDp.findAll();
        List<User> send = new ArrayList<>();
        for(User select : all){
            if(userType == "administrator" || userType == "instructor"){
                System.out.println("reached");
                if(select.getUserType().toString() == "user" && select.getApplied()){
                    send.add(select);
                }
            }
            else{
                return null;
            }
        }
        return send;
    }
}
