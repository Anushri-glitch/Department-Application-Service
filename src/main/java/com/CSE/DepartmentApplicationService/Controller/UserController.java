package com.CSE.DepartmentApplicationService.Controller;

import com.CSE.DepartmentApplicationService.DTO.SignInInput;
import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/signUp")
    public User signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/signIn")
    public User signIn(@RequestBody SignInInput sign){
        return userService.signIn(sign);
    }
}
