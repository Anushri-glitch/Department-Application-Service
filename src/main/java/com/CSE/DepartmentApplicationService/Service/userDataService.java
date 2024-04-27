package com.CSE.DepartmentApplicationService.Service;

import com.CSE.DepartmentApplicationService.Model.User;
import com.CSE.DepartmentApplicationService.Model.UserData;
import com.CSE.DepartmentApplicationService.Repository.IUserDao;
import com.CSE.DepartmentApplicationService.Repository.IUserDataDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userDataService {

    @Autowired
    IUserDataDao dataDao;

    @Autowired
    IUserDao userDao;

    public String fillForm(UserData data) {
        User oldUser = userDao.findByEmail(data.getEmail());

        if(oldUser != null && data.getEmail().equalsIgnoreCase(oldUser.getEmail())) {
            if(data.getPreviouslyTa() == null){
                data.setPreviouslyTa(" ");
            }
            if(data.getTaStartDate() == null){
                data.setTaStartDate(" ");
            }
            if(data.getTaEndDate() == null){
                data.setTaEndDate(" ");
            }
            if(data.getStatus1() == null){
                data.setStatus1(" ");
            }
            if(data.getStatus2() == null){
                data.setStatus2(" ");
            }
            if(data.getStatus3() == null){
                data.setStatus3(" ");
            }
            if(data.getAssignTaskDone() == null) {
                data.setAssignTaskDone(" ");
            }
            if(data.getCommentedByInstructor() == null){
                data.setCommentedByInstructor(" ");
            }
            if(data.getSelectedOrRejected() == null){
                data.setSelectedOrRejected(" ");
            }
            if(data.getAcceptOrRejectOffer() == null){
                data.setAcceptOrRejectOffer(" ");
            }
            dataDao.save(data);
            oldUser.setApplied(true);
            return "user data saved !";
        }
         return "user not found !";
    }

    public String assignTask(String assignData) {

        JSONObject newJson = new JSONObject(assignData);
        UserData newData = dataDao.findByEmail(newJson.getString("email"));

        if(newData != null){
            newData.setAssignTask(newJson.getString("assigntask"));
            dataDao.save(newData);
            return "data updated";
        }
        return "data not found !!";
    }

    public String assignTaskDone(String taskDone) {
        JSONObject task = new JSONObject(taskDone);
        UserData checkData = dataDao.findByEmail(task.getString("email"));

        if(checkData != null){
            checkData.setAssignTaskDone(task.getString("assigntaskdone"));
            dataDao.save(checkData);
            return "assignTaskDone updated !";
        }
        return "data not found !";
    }

    public String forwardOrRejected(String forwardData) {
        JSONObject forward = new JSONObject(forwardData);
        UserData eligible = dataDao.findByEmail(forward.getString("email"));

        if(eligible != null){
            if(forward.getBoolean("forwardOrRejected")){
                eligible.setAssignTaskDone("department staff");
                dataDao.save(eligible);
            } else {
                eligible.setAssignTaskDone("Rejected");
                dataDao.save(eligible);
            }
            return "forwardOrRejected Updated !";
        }
        return "Not Found !";
    }

    public String commented(String comment) {
        JSONObject commentOnTop = new JSONObject(comment);
        UserData isCommented = dataDao.findByEmail(commentOnTop.getString("email"));

        if(isCommented != null){
            isCommented.setCommentedByInstructor(commentOnTop.getString("commentedByInstructor"));
            dataDao.save(isCommented);
            return "comment Added !";
        }
        return "Not Found !";
    }

    public String selectReject(String selection) {
        JSONObject selects = new JSONObject(selection);
        UserData isSelected = dataDao.findByEmail(selects.getString("email"));

        if(isSelected != null){
            if(selects.getBoolean("selectedOrRejected")){
                isSelected.setSelectedOrRejected("selected");
            }
            else{
                isSelected.setSelectedOrRejected("Rejected");
            }
            dataDao.save(isSelected);
            return "Selection Changes Added !";
        }
        return "Not Found !";
    }

    public String acceptReject(String offer) {
        JSONObject offers = new JSONObject(offer);
        UserData offered = dataDao.findByEmail(offers.getString("email"));

        if(offered != null){
            if(offers.getBoolean("acceptOrRejectOffer")){
                offered.setAcceptOrRejectOffer("Accepted");
            }
            else{
                offered.setSelectedOrRejected("Declined");
            }
            dataDao.save(offered);
            return "Offer Changes Added !";
        }
        return "Not Found !";
    }

    public List<UserData> getAllApplicants() {
        return dataDao.findAll();
    }
}
