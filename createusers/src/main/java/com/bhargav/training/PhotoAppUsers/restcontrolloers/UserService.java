package com.bhargav.training.PhotoAppUsers.restcontrolloers;

import com.bhargav.training.PhotoAppUsers.model.UsersDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

     UsersDTO creeateUser(UsersDTO usersDTO);
     UsersDTO  getUserDetailsByEmail(String email);
}
