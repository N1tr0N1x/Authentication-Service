package com.eler.AuthenticationService.Controllers;

import com.eler.AuthenticationService.Models.UserAccount;
import com.eler.AuthenticationService.Services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthenticationService auth;

    @PostMapping("/register")
    @ResponseBody
    public UserAccount Register(@RequestBody UserAccount user){
        return auth.Register(user);
    }

    @PostMapping("/login")
    public UserAccount Login(@RequestBody UserAccount user) {
        return auth.Authenticate(user);
    }

    @RequestMapping("/getUser/{email}")
    public UserAccount getUserByEmail(@PathVariable("email") String email) {
        return auth.getUserByEmail(email);
    }

    @RequestMapping("/getCurrentUser")
    public UserAccount getCurrentUser() {
        return auth.getCurrentUser();
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable("id") int id) {
        auth.delete(id);
    }

}
