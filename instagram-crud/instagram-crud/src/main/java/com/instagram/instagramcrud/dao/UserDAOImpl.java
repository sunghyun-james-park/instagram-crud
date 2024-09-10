package com.instagram.instagramcrud.dao;

import com.instagram.instagramcrud.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        // create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public User findById(Long id) {

        // get user
        User theUser = entityManager.find(User.class, id);

        // return user
        return theUser;
    }

    @Override
    public User save(User theUser) {

        // save user
        User dbUser = entityManager.merge(theUser);

        // return the dbUser
        return dbUser;
    }

    @Override
    public void deleteById(Long id) {

        // find user by id
        User theUser = entityManager.find(User.class, id);

        // remove user
        entityManager.remove(theUser);

    }
}
