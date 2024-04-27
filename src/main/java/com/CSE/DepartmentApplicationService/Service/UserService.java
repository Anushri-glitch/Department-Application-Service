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

    public User signUp(User user) {
        userDao.save(user);
        return user;
    }

    public User signIn(SignInInput sign) {
        User oldUser = userDao.findByEmail(sign.getEmail());
        if(oldUser != null && oldUser.getPassword().equals(sign.getPassword())){
            return oldUser;
        }
        else{
            return null;
        }
    }
}
