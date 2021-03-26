package com.eler.AuthenticationService.Services;

import com.eler.AuthenticationService.Models.UserAccount;
import com.eler.AuthenticationService.Repositories.UserAccountRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    @Autowired
    UserAccountRepository UserAccRepo;

    @Autowired
    UserAccount user = new UserAccount();

    boolean logged = false;

    public UserAccount Authenticate(UserAccount user){
        UserAccount _user = UserAccRepo.findByEmail(user.getEmail());
        if(_user != null){
            if(_user.getPassword().equals(user.getPassword())){
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

    public UserAccount getUserById(int idUser) {
        return UserAccRepo.findByIdUser(idUser);
    }
}
