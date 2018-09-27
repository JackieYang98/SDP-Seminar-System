package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String submitFlag = request.getParameter("submit");
			if(submitFlag.equals("create")) {
                            User user = new User();    
                            user.setUserId(request.getParameter("userid"));
                            user.setUserEmail(request.getParameter("email"));
                            user.setUserFirstName(request.getParameter("fName"));
                            user.setUserLastName(request.getParameter("lName"));
                            user.setUserPassword(request.getParameter("password"));
                            user.setUserTypeFlag(request.getParameter("role").charAt(0));
                            DAOFactory.getInstanceOfUserDAO().create(user);
			}
			else if (submitFlag.equals("update")) {
                            String selectedUser = request.getParameter("row");
                            User user = new User();
                            user.setUserTypeFlag(request.getParameter("role").charAt(0));
                            user.setUserId(selectedUser);
                            System.out.print(user.getUserId() + user.getUserTypeFlag());
                            DAOFactory.getInstanceOfUserDAO().update(user);
			}
			else if (submitFlag.equals("delete")) {
                            User selectedUser = new User();
                            selectedUser.setUserId(request.getParameter("row"));
                            System.out.print(request.getParameter("row"));
                            DAOFactory.getInstanceOfUserDAO().delete(selectedUser);
			}
			else {
				throw new SQLException();
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mess", false);
		} finally {
//			String basePath = request.getScheme() + "://" + request.getServerName() + ":"+request.getServerPort() 
//				+ request.getContextPath() + "/";
			request.getRequestDispatcher("manage_user.jsp").forward(request, response);
		}
	}
}
