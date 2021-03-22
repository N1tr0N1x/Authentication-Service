package com.eler.AuthenticationService.Services;

import com.eler.AuthenticationService.Models.TeacherAccount;
import com.eler.AuthenticationService.Repositories.TeacherAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    @Autowired
    TeacherAccountRepository teacherAccRepo;


    public TeacherAccount Authenticate(String email,String password){
        TeacherAccount teacher = teacherAccRepo.findByEmail(email);
        if(teacher != null){
            if(teacher.getPassword().equals(password)){
                //LOGGED
                return teacher;
            }else{
                //PASSWORD NOT MATCH
                return null;
            }
        }else{
            //EMAIL NOT REGISTRED
            return null;
        }
    }

    public TeacherAccount Register(String email,String password){
        TeacherAccount teacher = new TeacherAccount(email,password);
        
        teacherAccRepo.save(teacher);

        return teacher;
    }
}
