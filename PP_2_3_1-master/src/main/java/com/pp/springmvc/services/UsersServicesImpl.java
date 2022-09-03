package com.pp.springmvc.services;

import com.pp.springmvc.dao.UserDao;
import com.pp.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicesImpl implements UsersServices{
    private final UserDao userDao;

    @Autowired
    public UsersServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    /*@Override
    public List<User> listUser() {
        return userDao.listUser();
    }*/
}
