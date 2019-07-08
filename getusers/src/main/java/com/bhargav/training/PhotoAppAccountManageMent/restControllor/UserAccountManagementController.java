package com.bhargav.training.PhotoAppAccountManageMent.restControllor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserAccountManagementController {


        @GetMapping
        public String getAccountManagement(){
            return "bhargav";
        }
    }
