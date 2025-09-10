package uz.app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import uz.app.controller.MyConfig;
import uz.app.entity.User;

import java.util.List;


public class UserDao {
    MyConfig myConfig =MyConfig.getMyConfig();
    public void saveUser(User user){
        EntityManager entityManager = myConfig.entityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public List<User> getAllUser(){
        EntityManager entityManager = myConfig.entityManager();
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}
