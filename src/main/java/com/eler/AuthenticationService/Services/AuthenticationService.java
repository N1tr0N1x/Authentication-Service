package com.eler.AuthenticationService.Services;

import com.eler.AuthenticationService.Models.UserAccount;
import com.eler.AuthenticationService.Repositories.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    @Autowired
    UserAccountRepository UserAccRepo;


    public UserAccount Authenticate(String email,String password){
        UserAccount user = UserAccRepo.findByEmail(email);
        if(user != null){
            if(user.getPassword().equals(password)){
                //LOGGED
                return user;
            }else{
                //PASSWORD NOT MATCH
                return null;
            }
        }else{
            //EMAIL NOT REGISTRED
            return null;
        }
    }

    public UserAccount Register(String email,String password){
        UserAccount user = new UserAccount(email,password);
        
        UserAccRepo.save(user);
        return user;
    }

    public UserAccount getUserByEmail(String email){
        return UserAccRepo.findByEmail(email);
    }
}
