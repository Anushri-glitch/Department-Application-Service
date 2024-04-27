package com.CSE.DepartmentApplicationService.Controller;

import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Model.UserData;
import com.CSE.DepartmentApplicationService.Repository.IUserDao;
import com.CSE.DepartmentApplicationService.Service.DepartmentService;
import com.CSE.DepartmentApplicationService.Service.userDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartentController {

    @Autowired
    IUserDao userDao;

    @Autowired
    DepartmentService dpService;

    @Autowired
    userDataService dataService;

    //List Of All Users For TA's
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/AllUsers")
    public List<User> getUser(){
        return userDao.findAll();
    }

    //List Of Users For Administrator & Instructor
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/selected/userType/{userType}")
    public List<User> getUserByType(@PathVariable String userType){
        return dpService.getUserByType(userType);
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/check")
    public String getUserCheck(){
        return "Hello";
    }

    //AssignTask
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/assigntask")
    public String assignTask (@RequestBody String assignData){
        return dataService.assignTask(assignData);
    }

    //AssignTaskDone
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/assigntaskdone")
    public String assignTaskDone (@RequestBody String taskDone){
        return dataService.assignTaskDone(taskDone);
    }

    //Forward Or Rejected
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/forwardOrRejected")
    public String forwardOrRejected(@RequestBody String forwardData){
        return dataService.forwardOrRejected(forwardData);
    }

    //Commented By Instructor
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/commentedByInstructor")
    public String commented(@RequestBody String comment){
        return dataService.commented(comment);
    }

    //Selected Or Rejected
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/selectedOrRejected")
    public String selectReject (@RequestBody String selection){
        return dataService.selectReject(selection);
    }

    //Accept Or Reject Offer
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/acceptOrRejectOffer")
    public String acceptReject (@RequestBody String offer){
        return dataService.acceptReject(offer);
    }

    //Get All Applicants
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/getAllApplicant")
    public List<UserData> getAllApplicants(){
        return dataService.getAllApplicants();
    }
}
