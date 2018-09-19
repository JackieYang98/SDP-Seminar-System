package com.sdpseminarsystem.servlet;



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

import com.sdpseminarsystem.dao.factory.UserDAOFactory;
import com.sdpseminarsystem.vo.User;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if(password.equals("sss")){
                    request.setAttribute("user", password);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}
//		User user = (User) request.getAttribute("User");
//		try {
//			if(UserDAOFactory.getInstance().verify(user))
//			{
//				RequestDispatcher dispatcher = request.getRequestDispatcher("login_succseeful.jsp");
//				dispatcher.forward(request, response);
//			}
//			else
//			{
//				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//				dispatcher.forward(request, response);
//			}
//		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//			//
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//response.setContentType("text/html");
////		PrintWriter out = response.getWriter();
////		
////		String p=request.getParameter("password");
////		if(p.equals("sss")){
////			String n=request.getParameter("username");
////		out.print("Welcome "+n);
////			
////		}
////		else{
////			out.print("Sorry username or password error!");
////			RequestDispatcher rd=request.getRequestDispatcher("login.html");
////			rd.include(request, response);
////		}
//// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
