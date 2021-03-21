package com.eler.AuthenticationService.Repositories;

import com.eler.AuthenticationService.Models.TeacherAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAccountRepository extends JpaRepository<TeacherAccount,Integer> {

    TeacherAccount findByEmail(String email);
}
