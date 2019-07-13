package com.bhargav.training.PhotoAppAccountManageMent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class PhotoAppAccountManageMentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppAccountManageMentApplication.class, args);
	}

}
