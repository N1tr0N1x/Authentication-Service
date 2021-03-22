package com.eler.AuthenticationService.Controllers;

import com.eler.AuthenticationService.Models.TeacherAccount;
import com.eler.AuthenticationService.Services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthenticationService auth;

    @RequestMapping("/register/{email}/{password}")
    public TeacherAccount Register(@PathVariable("email") String email, @PathVariable("password") String password){
        return auth.Register(email,password);
    }

    @RequestMapping("/login/{email}/{password}")
    public TeacherAccount Login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return auth.Authenticate(email, password);
    }

}
