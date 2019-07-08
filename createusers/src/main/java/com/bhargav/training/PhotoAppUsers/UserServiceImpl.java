package com.bhargav.training.PhotoAppUsers;

import com.bhargav.training.PhotoAppUsers.model.UsersDTO;
import com.bhargav.training.PhotoAppUsers.model.UsersEntity;
import com.bhargav.training.PhotoAppUsers.restcontrolloers.UserRepository;
import com.bhargav.training.PhotoAppUsers.restcontrolloers.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userService;

    final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public UsersDTO creeateUser(UsersDTO usersDTO) {
        usersDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(usersDTO.getPassWord()));
        usersDTO.setUserInfo(UUID.randomUUID().toString());
        userService.save(new ModelMapper().map(usersDTO, UsersEntity.class));

        return usersDTO;
    }

    public List<UsersEntity> getUser() {
        List<UsersEntity> list = new ArrayList<>();
        userService.findAll().forEach(list::add);
        return StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());

    }

    @Override
    public UsersDTO getUserDetailsByEmail(String email) {
        UsersEntity usersEntity = userService.findByEmail(email);
        return new ModelMapper().map(usersEntity, UsersDTO.class);

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersEntity usersEntity = userService.findByEmail(username);
        if (usersEntity == null) throw new UsernameNotFoundException("hi");
        return new User(usersEntity.getEmail(), usersEntity.getEncryptedPassword(), true, true, true, true, new ArrayList());
    }
}
