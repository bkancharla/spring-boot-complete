package com.bhargav.training.PhotoAppUsers.restcontrolloers;

import com.bhargav.training.PhotoAppUsers.UserServiceImpl;
import com.bhargav.training.PhotoAppUsers.model.Users;
import com.bhargav.training.PhotoAppUsers.model.UsersDTO;
import com.bhargav.training.PhotoAppUsers.model.UsersEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final Environment environment;
    final UserServiceImpl userServiceImple;

    @Autowired
    public UserController(Environment environment, UserServiceImpl userServiceImple) {
        this.environment = environment;
        this.userServiceImple = userServiceImple;
    }

    @GetMapping
    public List<UsersEntity> getUser() {
        return userServiceImple.getUser();
    }

    @PostMapping
    public UsersDTO createUser(@Valid @RequestBody Users users) {

        UsersDTO usersDTO = new ModelMapper().map(users, UsersDTO.class);
        // userServiceImple.creeateUser(usersDTO);

        return userServiceImple.creeateUser(usersDTO);
    }
}
