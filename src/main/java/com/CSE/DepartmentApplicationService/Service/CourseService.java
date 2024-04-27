package com.CSE.DepartmentApplicationService.Service;

import com.CSE.DepartmentApplicationService.Model.Courses;
import com.CSE.DepartmentApplicationService.Repository.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseDao courseDao;

    public List<Courses> getAllCourses() {
        return courseDao.findAll();
    }
}
