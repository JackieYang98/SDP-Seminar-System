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
import java.io.PrintWriter;

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
                            Attendee attendee = findAttendee(request, "seminarId", "attdEmail");
                            if(attendee == null){
				attendee = new Attendee();
				attendee.setAttendeeEmail(request.getParameter("attdEmail"));
				attendee.setAttendeePhone(request.getParameter("attdPhone"));
				attendee.setAttendeeFirstName(request.getParameter("attdFName"));
				attendee.setAttendeeLastName(request.getParameter("attdLName"));
				attendee.setAttendeeState(request.getParameter("attdState").charAt(0));
				DAOFactory.getInstanceOfAttendeeDAO().create(attendee, Integer.valueOf(request.getParameter("seminarId")));
                                printConfirm(request, response, "seminarConfirm","seminarRegister");        
                            }else{
                                response.getWriter().print("<p style='color:red'>Email already registered! Please try again</p>");
                                response.getWriter().print("<button type='button' onclick=\"document.getElementById('seminarConfirm').style.display='none';"
                    + "\" title=\"Close Page\">Return</button>");
                            }
			}else if (submitFlag.equals("verify")){ 
                                Attendee attendee = findAttendee(request ,"seminarId", "email");
                                PrintWriter out = response.getWriter();
                                if(attendee != null){
                                    out.print("<div class='registerEdit-Fname'>First Name</div>");
                                    out.print("<div class='registerEdit-Lname'>Last Name</div>");  
                                    out.print("<div class='registerEdit-Fname-input'><input id='firstNameEdit' type='text' name='attdFName' placeholder='First Name' value='"+attendee.getAttendeeFirstName()+"' required ></div>");
                                    out.print("<div class='registerEdit-Lname-input'><input id='lastNameEdit' type='text' name='attdLName' placeholder='Last Name' value='"+attendee.getAttendeeLastName()+"' required></div>");
                                    out.print("<div class='registerEdit-email'>Email</div>");
                                    out.print("<div class='registerEdit-email-input'><input type='email' id='emailEdit' name='attdEmail' placeholder='Email Address' value='"+attendee.getAttendeeEmail()+"' pattern='.+@([\\w-]+\\.)+[\\w-]{2,4}$' required></div>");
                                    out.print("<div class='registerEdit-phone'>Phone Number </div>");
                                    out.print("<div class='registerEdit-phone-input'><input type='text' id='phoneEdit' name='attdPhone' value='"+attendee.getAttendeePhone()+"' placeholder='Phone Number' required></div>");
                                    out.print("<div class='registerEdit-status'>Status</div>");
                                    if(attendee.getAttendeeState().equals('G')){
                                        out.print("<div class='registerEdit-status-Going'><input type='radio' class='status' name='attdState' value='Going' required checked/>Going </div>");
                                        out.print("<div class='registerEdit-status-Interested'><input type='radio' class='status' name='attdState' value='Interested'/> Interested</div>");
                                    }else{
                                        out.print("<div class='registerEdit-status-Going'><input type='radio' class='status' name='attdState' value='Going' required/>Going </div>");
                                        out.print("<div class='registerEdit-status-Interested'><input type='radio' class='status' name='attdState' value='Interested' checked/> Interested</div>");
                                    }
                                    out.print("<input type='hidden' id='attdId' value='"+attendee.getAttendeeId()+"'>");
                                    out.print("<div class='registerEdit-submit'><input name='submit' type='submit' value='Confirm' onclick=\"document.getElementById('hiddenFlag').value='Confirm';document.getElementById('seminarEditConfirm').style.display='block';\"></div>");
                                    out.print("<input id='hiddenFlag' type='hidden' value='Delete'>");
                                    out.print("<input type='hidden' name='seminarId' value='<%=seminarId%>'>");
                                    out.print("<div class='registerEdit-delete'><input name='submit' type='submit' onclick=\"document.getElementById('seminarRegisterDelete').style.display='block'\" value='Delete'></button></div>");
                                }else{
                                    out.print("null");
                                }
                        }else if (submitFlag.equals("Confirm")) {
				Attendee attendee = new Attendee();
				attendee.setAttendeeId(Integer.parseInt(request.getParameter("attdId")));
				attendee.setAttendeeEmail(request.getParameter("attdEmail"));
				attendee.setAttendeePhone(request.getParameter("attdPhone"));
				attendee.setAttendeeFirstName(request.getParameter("attdFName"));
				attendee.setAttendeeLastName(request.getParameter("attdLName"));
				attendee.setAttendeeState(request.getParameter("attdState").charAt(0));
				DAOFactory.getInstanceOfAttendeeDAO().update(attendee);
                                printConfirm(request, response, "seminarEditConfirm", "seminarRegisterEdit");                 
			} else if (submitFlag.equals("Delete")) {
				Attendee attendee = new Attendee();
				attendee.setAttendeeId(Integer.valueOf(request.getParameter("attdId")));
				DAOFactory.getInstanceOfAttendeeDAO().delete(attendee);
                                printConfirm(request, response, "seminarRegisterDelete", "seminarRegisterEdit");
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mess", false);
		}
//                finally {
//			String basePath = request.getScheme() + "://" + request.getServerName() + ":"+request.getServerPort() 
//				+ request.getContextPath() + "/";
//			request.getRequestDispatcher(basePath).forward(request, response);
//		}
	}
        private void printConfirm(HttpServletRequest request, HttpServletResponse response, String openPopUp, String closePopUp) throws IOException{
            PrintWriter out = response.getWriter();
                out.print("<p> <b>First Name: </b>" + request.getParameter("attdFName") + "</p>"); 
                out.print("<p> <b>Last Name: </b>" + request.getParameter("attdLName") + "</p>");
                out.print("<p> <b>Email: </b>" + request.getParameter("attdEmail") + "</span></p>");
                out.print("<p> <b>Phone: </b>" + request.getParameter("attdPhone") + "</p>");
                out.print("<p> <b>Status: </b>" + request.getParameter("attdState") + "</p>");
                out.print("<button type='button' onclick=\"document.getElementById('" + openPopUp + "').style.display='none';"
                    + "document.getElementById('" + closePopUp + "').style.display='none';\" title=\"Close Page\">Return</button>");  
        }
        
        private Attendee findAttendee(HttpServletRequest request, String seminarId, String email) throws SQLException{
            Integer semId= Integer.parseInt(request.getParameter(seminarId));
            String em = request.getParameter(email);
            Attendee attendee = DAOFactory.getInstanceOfAttendeeDAO().findBySeminarAndEmail(semId, em);
            return attendee;
        }
}
