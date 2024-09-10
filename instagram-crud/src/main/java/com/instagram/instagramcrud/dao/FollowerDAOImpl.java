package com.instagram.instagramcrud.dao;

import com.instagram.instagramcrud.entity.Follower;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FollowerDAOImpl implements FollowerDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public FollowerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Follower> findAll() {

        // create a query
        TypedQuery<Follower> theQuery = entityManager.createQuery("from Follower", Follower.class);

        // execute query and get result list
        List<Follower> followers = theQuery.getResultList();

        // return the results
        return followers;
    }

    @Override
    public Follower findById(Long id) {

        // get follower
        Follower theFollower = entityManager.find(Follower.class, id);

        // return follower
        return theFollower;
    }

    @Override
    public Follower save(Follower theFollower) {

        // save follower
        Follower dbFollower = entityManager.merge(theFollower);

        // return the dbFollower
        return dbFollower;
    }

    @Override
    public void deleteById(Long id) {

        // find follower by id
        Follower theFollower = entityManager.find(Follower.class, id);

        // remove follower
        entityManager.remove(theFollower);
    }
}
