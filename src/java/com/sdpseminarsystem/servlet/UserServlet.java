package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/UserServlet")
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
            if (submitFlag.equals("create")) {
                User user = new User();
                user.setUserId(request.getParameter("userid"));
                user.setUserEmail(request.getParameter("email"));
                user.setUserFirstName(request.getParameter("fName"));
                user.setUserLastName(request.getParameter("lName"));
                user.setUserPassword(request.getParameter("password"));
                user.setUserTypeFlag(request.getParameter("role").charAt(0));
                DAOFactory.getInstanceOfUserDAO().create(user);
            } else if (submitFlag.equals("update")) {
                User user = new User();
                user.setUserId(request.getParameter("row"));
                user.setUserTypeFlag(request.getParameter("role").charAt(0));
                DAOFactory.getInstanceOfUserDAO().update(user);
            } else if (submitFlag.equals("delete")) {
                User user = new User();
                user.setUserId(request.getParameter("row"));
                DAOFactory.getInstanceOfUserDAO().delete(user);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            doGet(request, response);
        }
    }
}
