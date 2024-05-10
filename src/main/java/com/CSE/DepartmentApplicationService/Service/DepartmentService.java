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
        //return all;
        List<User> send = new ArrayList<>();
        for(User itr: all){
            System.out.println(userType + "Hello");
            if(userType.equalsIgnoreCase("administrator") || userType.equalsIgnoreCase("instructor")){
                System.out.println("reached");
                System.out.println(itr.getUserType().toString());
                System.out.println(itr.getApplied());
                if(itr.getUserType().toString().equalsIgnoreCase("user") && itr.getApplied()){
                    send.add(itr);
                }
            }
            return send;
        }
        System.out.println(send);
        return send;
    }
}
