package com.CSE.DepartmentApplicationService.Repository;

import com.CSE.DepartmentApplicationService.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseDao extends JpaRepository<Courses,String> {
}
