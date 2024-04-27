package com.CSE.DepartmentApplicationService.Service;

import com.CSE.DepartmentApplicationService.DTO.SignInInput;
import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Repository.ISignInDao;
import com.CSE.DepartmentApplicationService.Repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserDao userDao;

    @Autowired
    ISignInDao signInDao;

    public String signUp(User user) {


        if(!userDao.existsById(user.getUserId())){
            if(user.getApplied() == null){
                user.setApplied(false);
            }
            userDao.save(user);
            return user.getName() + " is created successfully";
        }
        else{
            return "Already Registered";
        }
    }

    public String signIn(SignInInput sign) {
        User oldUser = userDao.findByEmail(sign.getEmail());
        if(oldUser != null){
            signInDao.save(sign);
            return "SignIn Successfully";
        }
        else{
            return "User not found !!";
        }
    }
}
