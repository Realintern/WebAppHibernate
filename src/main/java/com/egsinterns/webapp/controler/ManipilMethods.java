package com.egsinterns.webapp.controler;

import com.egsinterns.webapp.model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 2/21/2016.
 */
public class ManipilMethods {
    public static void insertIntoUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //geta anum bolor parametrer@
        Enumeration paramNames = req.getParameterNames();
        String param;//parametri anun@
        List<String> list = new ArrayList<String>();
        while (paramNames.hasMoreElements()) {
            param = (String) paramNames.nextElement();
            if (!req.getParameter(param).equalsIgnoreCase("")) {
                list.add(req.getParameter(param));
            }
        }
        list.remove(list.size() - 1);//verin element@ submit buttoni anunn e ,,nayeq do post metodi araijn if paynamn@
        if (list.size() != 3) {
            CreateWebPageHTML.createWebPageWarning(resp, req);
        } else {
            String fName = list.get(0);
            String lName = list.get(1);
            String eMail = list.get(2);
            Users user = new Users();
            user.setFirstName(fName);
            user.setLastName(lName);
            user.setEmail(eMail);
            ImplemantedClass insertMethod = new ImplemantedClass();
            insertMethod.addUser(user);
            CreateWebPageHTML.createWebPageSubmit(resp, req);
        }
        list.clear();
    }

    public static void showRegistratedInfoFromUsersTable(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html><head>");
        pw.println("<title>The registrated person's page</title></head><body>");
        pw.println("<h2>All Information Form Users's Table</h2>");
        ImplemantedClass getUsers = new ImplemantedClass();
        List<Users> list = getUsers.getUsers();
        Iterator<Users> iter = list.iterator();
        Users user;
        while (iter.hasNext()) {
            user = iter.next();
            pw.println("<strong>" + "FirstName: " + user.getFirstName() + "</strong>"+"<br />");
            pw.println("<strong>" + "LasttName: " + user.getLastName() + "</strong>"+"<br />");
            pw.println("<strong>" + "Email: " + user.getEmail() + "</strong>"+"<br />");
            pw.println("<br />");
        }
        pw.println("<form method=\"post\" action=\"" + req.getContextPath() +
                "/mailregisterapp\">");
        pw.println("<table border=\"0\"><tr><td valign=\"top\">");
        pw.println("<input type=\"submit\" name=\"back\" value=\"Back\"></td></tr>");
        pw.println("</table></form>");
        pw.println("</body></html>");

    }
}
