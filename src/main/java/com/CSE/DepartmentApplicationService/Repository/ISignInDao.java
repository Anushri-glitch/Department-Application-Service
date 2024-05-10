package com.CSE.DepartmentApplicationService.Repository;

import com.CSE.DepartmentApplicationService.DTO.SignInInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignInDao extends JpaRepository<SignInInput, String> {
}
