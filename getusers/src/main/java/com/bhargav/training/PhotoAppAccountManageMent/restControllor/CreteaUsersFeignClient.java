package com.bhargav.training.PhotoAppAccountManageMent.restControllor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

;


@FeignClient(name = "createusers")
public interface CreteaUsersFeignClient {
 @GetMapping(path = "/users/test")
    public String createUser();
}