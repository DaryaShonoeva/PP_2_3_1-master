package com.pp.springmvc.dao;

import com.pp.springmvc.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUser(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, new Integer(id));
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, new Integer(id));
        entityManager.detach(user);
        return user;
    }

    /*@Override
    public List<User> listUser() {
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("from users",User.class);
        return namedQuery.getResultList();
    }*/
}
