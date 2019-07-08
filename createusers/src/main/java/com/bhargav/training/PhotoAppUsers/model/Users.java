package com.bhargav.training.PhotoAppUsers.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Users {
    @NotNull(message = "first name can' be null")
    private String firstName;
    private String lastName;
    @NotNull
    @Email
    private String email;
    private String passWord;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
