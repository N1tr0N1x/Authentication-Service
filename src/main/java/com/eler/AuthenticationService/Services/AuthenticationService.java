package com.eler.AuthenticationService.Services;

import com.eler.AuthenticationService.Models.UserAccount;
import com.eler.AuthenticationService.Repositories.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    @Autowired
    UserAccountRepository UserAccRepo;

    @Autowired
    UserAccount user = new UserAccount();

    boolean logged = false;

    public UserAccount Authenticate(String email,String password){
        UserAccount _user = UserAccRepo.findByEmail(email);
        if(_user != null){
            if(_user.getPassword().equals(password)){
                //LOGGED
                if(user.getIdUser()==0){
                    //LOGGED AS ADMIN
                }
                logged = true;
                user = _user;
                return _user;
            }else{
                //PASSWORD NOT MATCH
                return null;
            }
        }else{
            //EMAIL NOT REGISTRED
            return null;
        }
    }

    public UserAccount Register(UserAccount user){
        UserAccRepo.save(user);
        return user;
    }

    public UserAccount getUserByEmail(String email){
        return UserAccRepo.findByEmail(email);
    }

    public UserAccount getCurrentUser() {
        if(logged) return user;
        else return null;
    }

    public void delete(int idUser) {
        UserAccRepo.deleteById(idUser);
    }
}
