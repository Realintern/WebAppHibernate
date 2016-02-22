package com.egsinterns.webapp.view;

import com.egsinterns.webapp.controler.CreateWebPageHTML;
import com.egsinterns.webapp.controler.ManipilMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by User on 2/21/2016.
 */
public class AppServlet extends HttpServlet{
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            CreateWebPageHTML.createWebPage(resp,req);
        }
        public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
            if(req.getParameter("first")!=null) {
                try {
                    ManipilMethods.insertIntoUsers(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if(req.getParameter("second")!=null){
                try {
                    ManipilMethods.showRegistratedInfoFromUsersTable(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(req.getParameter("back")!=null){
                CreateWebPageHTML.createWebPage(resp,req);
            }
        }
}
