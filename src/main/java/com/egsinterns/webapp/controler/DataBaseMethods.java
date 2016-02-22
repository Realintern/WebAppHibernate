package com.egsinterns.webapp.controler;

import com.egsinterns.webapp.model.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 2/21/2016.
 */
public interface DataBaseMethods {
    void addUser(Users users)throws SQLException;
    List<Users> getUsers()throws SQLException;
}
