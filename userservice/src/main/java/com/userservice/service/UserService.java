package com.userservice.service;

import com.userservice.model.User;

import java.util.List;

public interface UserService {

    User saveuser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);

    //for Put
    User updateUser(Long id,User user);


    //for Patch
     User patchUser(Long id,User user);

     void deleteUser(Long id);

    List<User> getUsersByAdminId(Long adminId);

}
