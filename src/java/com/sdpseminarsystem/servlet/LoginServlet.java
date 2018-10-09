package com.sdpseminarsystem.servlet;



import com.sdpseminarsystem.dao.factory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdpseminarsystem.dao.factory.UserDAOFactory;
import com.sdpseminarsystem.vo.User;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = new User();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
           
            user.setUserId(username);
            user.setUserPassword(password);   
            
            try {
                    if(DAOFactory.getInstanceOfUserDAO().verify(user))
                    {     
                        User newUser = DAOFactory.getInstanceOfUserDAO().findById(username);
                        HttpSession session = request.getSession();
                        session.setAttribute("user", newUser);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
                    }
                    else
                    {
                        response.setContentType("text/plain");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write("invalid");
                    }
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
		} catch (SQLException e) {
                    e.printStackTrace();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
		}
	}
        
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
