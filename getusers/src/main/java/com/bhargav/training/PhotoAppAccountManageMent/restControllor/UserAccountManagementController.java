package com.bhargav.training.PhotoAppAccountManageMent.restControllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserAccountManagementController {

    @Autowired
    CreteaUsersFeignClient creteaUsersFeignClient;


        @GetMapping
        public String getAccountManagement(){


            return creteaUsersFeignClient.createUser()+"bhargav";
        }
    }
