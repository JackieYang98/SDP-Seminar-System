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
 * Servlet implementation class LoginServlet.
 * <p>
 * Respond to requests for logging in.
 * 
 * @author Leo Lee
 * @author Liam Heng
 * @see HttpServlet
 * @since 1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private static final long serialVersionUID = -2880945779610971202L;
    
    /**
     * Constructs a new {@code LoginServlet}.
     * 
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // set user for logging in
        User user = new User();
        user.setUserId(request.getParameter("username"));
        user.setUserPassword(request.getParameter("password"));
        // verify user
        try {
            if (DAOFactory.getInstanceOfUserDAO().verify(user)) {
                // success
                user = DAOFactory.getInstanceOfUserDAO().findById(user.getUserId());
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                // fail
                failLogin(response);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            failLogin(response);
        }
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void failLogin(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("invalid");
    }
}
