package com.bhargav.training.PhotoAppUsers.model;

import javax.validation.constraints.NotNull;

public class CreateUserModel {

    @NotNull
    public String email;

    @NotNull
    public String password;


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
}
