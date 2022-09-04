package com.pp.springmvc.dao;

import com.pp.springmvc.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        User user = entityManager.find(User.class, new Integer(id));
        entityManager.remove(user);
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, new Integer(id));
        entityManager.detach(user);
        return user;
    }

    @Override
    public List<User> listUser() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }
}
