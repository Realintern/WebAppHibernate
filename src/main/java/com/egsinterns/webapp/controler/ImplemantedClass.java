package com.egsinterns.webapp.controler;

import com.egsinterns.webapp.controler.DataBaseMethods;
import com.egsinterns.webapp.controler.Hibernate;
import com.egsinterns.webapp.model.Users;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;


public class ImplemantedClass implements DataBaseMethods {
    public  void addUser(Users user) throws SQLException {
        Session session = null;
        try{
            session= Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }

    }

    public List<Users> getUsers() throws SQLException {
        List<Users> usersList=null;
        Session session=null;
        try{
            session=Hibernate.getSessionFactory().openSession();
            usersList=session.createCriteria(Users.class).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        return usersList;
    }
}
