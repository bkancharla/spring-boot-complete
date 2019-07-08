package com.bhargav.training.PhotoAppUsers.restcontrolloers;

import com.bhargav.training.PhotoAppUsers.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    UsersEntity findByEmail(String email);
}
