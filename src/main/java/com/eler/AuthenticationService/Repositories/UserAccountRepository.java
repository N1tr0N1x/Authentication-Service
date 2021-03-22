package com.eler.AuthenticationService.Repositories;

import com.eler.AuthenticationService.Models.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

    UserAccount findByEmail(String email);
}
