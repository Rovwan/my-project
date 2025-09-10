package uz.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyConfig {
    private static EntityManagerFactory ormTest = Persistence.createEntityManagerFactory("ORM_TEST");
    public EntityManager entityManager(){
        return ormTest.createEntityManager();
    }

    private static MyConfig myConfig;
    public static MyConfig getMyConfig(){
        if (myConfig == null){
            myConfig = new MyConfig();
        }
        return myConfig;
    }

}
