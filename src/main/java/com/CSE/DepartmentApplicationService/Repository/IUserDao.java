package com.CSE.DepartmentApplicationService.Repository;

import com.CSE.DepartmentApplicationService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}