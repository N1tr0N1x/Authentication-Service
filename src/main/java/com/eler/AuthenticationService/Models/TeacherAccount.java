package com.eler.AuthenticationService.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TeacherAccounts")
public class TeacherAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TeacherAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public TeacherAccount() {
    }

    public TeacherAccount(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    
}
