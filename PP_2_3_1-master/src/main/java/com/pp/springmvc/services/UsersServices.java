package com.pp.springmvc.services;

import com.pp.springmvc.models.User;

import java.util.List;

public interface UsersServices {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    //List<User> listUser();
}
