package com.eler.AuthenticationService.Services;

import com.eler.AuthenticationService.Models.TeacherAccount;
import com.eler.AuthenticationService.Repositories.TeacherAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {
    
    @Autowired
    TeacherAccountRepository teacherAccRepo;


    public void Authenticate(String email,String password){
        TeacherAccount teacher = teacherAccRepo.findByEmail(email);
        if(teacher != null){
            if(teacher.getPassword() == password){
                //LOGGED
            }else{
                //PASSWORD NOT MATCH
            }
        }else{
            //EMAIL NOT REGISTRED
        }
    }


    public void Register(String email,String password){
        TeacherAccount teacher = new TeacherAccount();
        teacher.setEmail(email);
        teacher.setPassword(password);
        
        teacherAccRepo.save(teacher);
    }
}
