package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Attendee;

/**
 * Servlet implementation class AttendeeServlet
 */
@WebServlet("/AttendeeServlet")
public class AttendeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendeeServlet() {
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
                            System.out.print(submitFlag);
				Attendee attendee = new Attendee();
				attendee.setAttendeeEmail(request.getParameter("attdEmail"));
				attendee.setAttendeePhone(request.getParameter("attdPhone"));
				attendee.setAttendeeFirstName(request.getParameter("attdFName"));
				attendee.setAttendeeLastName(request.getParameter("attdLName"));
				attendee.setAttendeeState(request.getParameter("status").charAt(0));
				DAOFactory.getInstanceOfAttendeeDAO().create(attendee, Integer.valueOf(request.getParameter("seminarId")));
			} else if (submitFlag == "update") {
				Attendee attendee = new Attendee();
				attendee.setAttendeeId(Integer.valueOf(request.getParameter("attdId")));
				attendee.setAttendeeEmail(request.getParameter("attdEmail"));
				attendee.setAttendeePhone(request.getParameter("attdPhone"));
				attendee.setAttendeeFirstName(request.getParameter("attdFName"));
				attendee.setAttendeeLastName(request.getParameter("attdLName"));
				attendee.setAttendeeState(request.getParameter("attdState").charAt(0));
				DAOFactory.getInstanceOfAttendeeDAO().update(attendee);
			} else if (submitFlag == "delete") {
				Attendee attendee = new Attendee();
				attendee.setAttendeeId(Integer.valueOf(request.getParameter("attdId")));
				DAOFactory.getInstanceOfAttendeeDAO().delete(attendee);
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mess", false);
		} finally {
			String basePath = request.getScheme() + "://" + request.getServerName() + ":"+request.getServerPort() 
				+ request.getContextPath() + "/";
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
