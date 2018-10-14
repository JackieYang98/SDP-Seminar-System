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
 * Servlet implementation class AttendeeServlet.
 * <p>
 * Respond to requests for operating attendees.
 * 
 * @author Leo Lee
 * @author Liam Heng
 * @see HttpServlet
 * @since 1.0
 */
@WebServlet("/AttendeeServlet")
public class AttendeeServlet extends HttpServlet {
    
    private static final long serialVersionUID = 977375217579536799L;
    
    /**
     * Constructs a new {@code AttendeeServlet}.
     * 
     * @see HttpServlet#HttpServlet()
     */
    public AttendeeServlet() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String submitFlag = request.getParameter("submit");
            //If the request was to create attendee
            if (submitFlag.equals("create")) {
                Attendee attendee = findAttendee(request, "seminarId", "attdEmail");
                //If there is no attendee by that email
                if (attendee == null) {
                    attendee = new Attendee();
                    attendee.setAttendeeEmail(request.getParameter("attdEmail"));
                    attendee.setAttendeePhone(request.getParameter("attdPhone"));
                    attendee.setAttendeeFirstName(request.getParameter("attdFName"));
                    attendee.setAttendeeLastName(request.getParameter("attdLName"));
                    attendee.setAttendeeState(request.getParameter("attdState").charAt(0));
                    //Create a new attendee in attendees table in database
                    DAOFactory.getInstanceOfAttendeeDAO().create(attendee,
                            Integer.valueOf(request.getParameter("seminarId")));
                    //Return response to ajax to display in pop up.
                    printConfirm(request, response);
                } else {
                    //There are duplicate email in the database, refuse creation
                    response.getWriter().print("<p style='color:red'>"
                        + "Email already registered! Please try again</p>");
                    response.getWriter().print("<button type='button' "
                        + "onclick=\"document.getElementById('seminarConfirm').style.display='none';\""
                        + "title=\"Close Page\">Return</button>");
                }
            //Request is from 'Already Registered', it check if email exists
            } else if (submitFlag.equals("verify")) {
                Attendee attendee = findAttendee(request, "seminarId", "email");
                PrintWriter out = response.getWriter();
                //If the email exists, display all the informations in popup
                if (attendee != null) {
                    out.print("<div class='registerEdit-Fname'>First Name</div>");
                    out.print("<div class='registerEdit-Lname'>Last Name</div>");
                    out.print("<div class='registerEdit-Fname-input'><input id='firstNameEdit' "
                        + "type='text' name='attdFName' placeholder='First Name' value='"
                        + attendee.getAttendeeFirstName() + "' required ></div>");
                    out.print("<div class='registerEdit-Lname-input'><input id='lastNameEdit' "
                        + "type='text' name='attdLName' placeholder='Last Name' value='"
                        + attendee.getAttendeeLastName() + "' required></div>");
                    out.print("<div class='registerEdit-email'>Email</div>");
                    out.print("<div class='registerEdit-email-input'>"
                        + "<input type='email' id='emailEdit' name='attdEmail' "
                        + "placeholder='Email Address' value='" + attendee.getAttendeeEmail()
                        + "' pattern='.+@([\\w-]+\\.)+[\\w-]{2,4}$' required></div>");
                    out.print("<div class='registerEdit-phone'>Phone Number </div>");
                    out.print("<div class='registerEdit-phone-input'>"
                        + "<input type='text' id='phoneEdit' name='attdPhone' value='"
                        + attendee.getAttendeePhone() + "' placeholder='Phone Number' "
                        + "required></div>");
                    out.print("<div class='registerEdit-status'>Status</div>");
                    if (attendee.getAttendeeState().equals('G')) {
                        out.print("<div class='registerEdit-status-Going'>"
                            + "<input type='radio' class='status' "
                            + "name='attdState' value='Going' required checked/>Going </div>");
                        out.print("<div class='registerEdit-status-Interested'>"
                            + "<input type='radio' class='status' name='attdState' "
                            + "value='Interested'/> Interested</div>");
                    } else {
                        out.print("<div class='registerEdit-status-Going'>"
                            + "<input type='radio' class='status' "
                            + "name='attdState' value='Going' required/>Going </div>");
                        out.print("<div class='registerEdit-status-Interested'>"
                            + "<input type='radio' class='status' "
                            + "name='attdState' value='Interested' checked/> Interested</div>");
                    }
                    out.print("<input type='hidden' id='attdId' value='" 
                        + attendee.getAttendeeId() + "'>");
                    out.print("<input id='hiddenFlag' type='hidden' value='Delete'>");
                    out.print("<input type='hidden' name='seminarId' value='<%=seminarId%>'>");
                    out.print("<div class='registerEdit-submit'>"
                        + "<input name='submit' type='submit' "
                        + "onclick=\"document.getElementById('hiddenFlag').value='Confirm';"
                        + "document.getElementById('seminarEditConfirm').style.display='block';\""
                        + " value='Confirm'></div>");
                    out.print("<div class='registerEdit-cancel'>"
                        + "<input name='submit' type='button' "
                        + "onclick=\"document.getElementById('seminarRegisterEdit')"
                        + ".style.display='none'\" value='Cancel'></div>");
                    out.print("<div class='registerEdit-delete'>"
                        + "<input name='submit' type='submit' "
                        + "onclick=\"document.getElementById('seminarRegisterDelete')"
                        + ".style.display='block'\" value='Delete'></button></div>");
                } else {
                    //Return null to ajax to display error in popup
                    out.print("null");
                }
            //Request is to update attendee
            } else if (submitFlag.equals("Confirm")) {
                Attendee attendee = findAttendee(request, "seminarId", "attdEmail");
                //If there is no attendee by the new entered email, and the email 
                //is still the same (not email of any other registered attendee).
                if (attendee == null || attendee.getAttendeeEmail()
                        .equalsIgnoreCase(request.getParameter("target"))) {
                    attendee = new Attendee();
                    attendee.setAttendeeId(Integer.parseInt(request.getParameter("attdId")));
                    attendee.setAttendeeEmail(request.getParameter("attdEmail"));
                    attendee.setAttendeePhone(request.getParameter("attdPhone"));
                    attendee.setAttendeeFirstName(request.getParameter("attdFName"));
                    attendee.setAttendeeLastName(request.getParameter("attdLName"));
                    attendee.setAttendeeState(request.getParameter("attdState").charAt(0));
                    //Update atttendee table in database
                    DAOFactory.getInstanceOfAttendeeDAO().update(attendee);
                    //Print pop-up confirming successful update to browser
                    printConfirm(request, response);
                } else {
                    //Attendee tried to change email that have already been registered
                    //with that seminar, refuse update and print error to browser.
                    response.getWriter().print("<p style='color:red'>"
                        + "Email already registered! Please try again</p>");
                    response.getWriter().print("<button type='button' "
                        + "onclick=\"document.getElementById('seminarEditConfirm')"
                        + ".style.display='none';"
                        + "\" title=\"Close Page\">Return</button>");
                }
            //Request is to delete attendee
            } else if (submitFlag.equals("Delete")) {
                Attendee attendee = new Attendee();
                attendee.setAttendeeId(Integer.valueOf(request.getParameter("attdId")));
                //Delete attendee from table in database
                DAOFactory.getInstanceOfAttendeeDAO().delete(attendee);
                //Print pop-up comfirming successful delete
                printConfirm(request, response);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.setAttribute("mess", false);
        }
    }
    
    /**
     * Print pop-up confirming successful user action to browser
     * 
     * @param request   servlet request
     * @param response  servlet response
     * @throws IOException 
     */
    private void printConfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<p> <b>First Name: </b>" 
            + request.getParameter("attdFName") + "</p>");
        out.print("<p> <b>Last Name: </b>" 
            + request.getParameter("attdLName") + "</p>");
        out.print("<p> <b>Email: </b>" 
            + request.getParameter("attdEmail") + "</span></p>");
        out.print("<p> <b>Phone: </b>" 
            + request.getParameter("attdPhone") + "</p>");
        out.print("<p> <b>Status: </b>" 
            + request.getParameter("attdState") + "</p>");
        out.print("<button type='button' "
            + "onclick=\"location.reload();\" title=\"Close Page\">Return</button>");
    }
    
    /**
     * Find the attendee of associated with a seminar(seminarID) by email(email)
     * 
     * @param request   sevlet request
     * @param seminarId seminar which to search attendee
     * @param email     email to be searched
     * @return          Attendee that matches
     * @throws SQLException 
     */
    private Attendee findAttendee(HttpServletRequest request, 
            String seminarId, String email) throws SQLException {
        Integer semId = Integer.parseInt(request.getParameter(seminarId));
        String em = request.getParameter(email);
        Attendee attendee = DAOFactory.getInstanceOfAttendeeDAO()
                            .findBySeminarAndEmail(semId, em);
        return attendee;
    }
}
