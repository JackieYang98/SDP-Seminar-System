package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.User;

/**
 * Servlet implementation class UserServlet.
 * <p>
 * Respond to requests for operating users.
 * 
 * @author Leo Lee
 * @see HttpServlet
 * @since 1.0
 */
public class UserServlet extends HttpServlet {
    
    private static final long serialVersionUID = -8837854028184582833L;
    
    /**
     * Constructs a new {@code UserServlet}.
     * 
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("manage_user.jsp").forward(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String submitFlag = request.getParameter("submit");
            // If the request is to create new user
            if (submitFlag.equals("create")) {
                User user = new User();
                user.setUserId(request.getParameter("userid"));
                user.setUserEmail(request.getParameter("email"));
                user.setUserFirstName(request.getParameter("fName"));
                user.setUserLastName(request.getParameter("lName"));
                user.setUserPassword(request.getParameter("password"));
                user.setUserTypeFlag(request.getParameter("role").charAt(0));
                // Create a new user in users table
                DAOFactory.getInstanceOfUserDAO().create(user);
                // If the request is to update the user's role
            } else if (submitFlag.equals("update")) {
                User user = new User();
                user.setUserId(request.getParameter("row"));
                user.setUserTypeFlag(request.getParameter("role").charAt(0));
                // Update user in the users table
                DAOFactory.getInstanceOfUserDAO().update(user);
                // If the request is to delete the user
            } else if (submitFlag.equals("delete")) {
                User user = new User();
                user.setUserId(request.getParameter("row"));
                // Delete user completely from the users table
                DAOFactory.getInstanceOfUserDAO().delete(user);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Refresh page to see newly updated table
            doGet(request, response);
        }
    }
}
