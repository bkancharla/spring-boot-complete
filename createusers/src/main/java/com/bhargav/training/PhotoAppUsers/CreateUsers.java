package com.bhargav.training.PhotoAppUsers;

import com.bhargav.training.PhotoAppUsers.restcontrolloers.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
public class CreateUsers {

    public static void main(String[] args) {
        SpringApplication.run(CreateUsers.class, args);
    }

    @Bean
    BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
