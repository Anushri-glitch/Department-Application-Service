package com.CSE.DepartmentApplicationService.Controller;

import com.CSE.DepartmentApplicationService.DTO.SignInInput;
import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/createUser")
    public String signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @PostMapping(value = "/signIn")
    public String signIn(@RequestBody SignInInput sign){
        return userService.signIn(sign);
    }
}
