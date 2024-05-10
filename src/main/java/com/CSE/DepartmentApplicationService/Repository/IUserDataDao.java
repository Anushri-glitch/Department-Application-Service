package com.CSE.DepartmentApplicationService.Repository;

import com.CSE.DepartmentApplicationService.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDataDao extends JpaRepository<UserData,String> {
    UserData findByEmail(String email);
}
