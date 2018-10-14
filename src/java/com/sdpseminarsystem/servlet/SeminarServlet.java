package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Seminar;
import com.sdpseminarsystem.vo.Speaker;
import com.sdpseminarsystem.vo.User;

/**
 * Servlet implementation class SeminarServlet.
 * <p>
 * Respond to requests for displaying seminar on home page.
 * 
 * @author Liam Heng
 * @see HttpServlet
 * @since 1.0
 */
public class SeminarServlet extends HttpServlet {
    
    private static final long serialVersionUID = -8657402591524263040L;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws SQLException     if any database related error occurs
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an Input or output error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get if there is any user log in
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        //If the request is a search for seminar request
        if (request.getParameter("searchDate") != null) {
            try {
                List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO().findAllSortByDate();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
                Date startDate = formatter.parse(request.getParameter("startDate"));
                //If only start date field is input
                if (request.getParameter("endDate").equals("")) {
                    for (Seminar seminar : seminars) {
                        Date seminarStartTime = seminar.getSeminarStartTime();
                        //Get all seminar(s) after start date input but not in the past.
                        if (seminarStartTime.after(startDate) 
                                && seminarStartTime.after(new Date())) {
                            printSeminarBox(response, seminar, user);
                        }
                    }
                    //Both start date and end date range is filled
                } else {
                    Date endDate = formatter.parse(request.getParameter("endDate"));
                    for (Seminar seminar : seminars) {
                        Date seminarStartTime = seminar.getSeminarStartTime();
                        //Get all seminar(s) within range but not in the past
                        if (seminarStartTime.after(startDate) 
                                && seminarStartTime.before(endDate) 
                                && seminarStartTime.after(new Date()) ) {
                            printSeminarBox(response, seminar, user);
                        }
                    }
                }
            } catch (SQLException e) {
                e.getErrorCode();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else {
            //If the request is just to display all seminar(s) in homepage
            try {
                //Seminar to display to all attendee 
                if (user == null) {
                    List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO()
                            .findAllSortByDate();
                    for (Seminar seminar : seminars) {
                        Date today = new Date();
                        //Do not display past seminar to normal attendee type
                        if (seminar.getSeminarStartTime().after(today))
                            printSeminarBox(response, seminar, user);
                    }
                    //If the user logged in is 'host' or 'organiser'
                } else if (user.getUserTypeFlag() == 'h' 
                        || user.getUserTypeFlag() == 'o') {
                    List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO()
                            .findByUser(user);
                    for (Seminar seminar : seminars) {
                        //Display all seminars even those in the past
                        printSeminarBox(response, seminar, user);
                    }
                    //If the logged in user is 'admin'
                } else if (user.getUserTypeFlag() == 'a') {
                    List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO()
                            .findAllSortByVenue();
                    for (Seminar seminar : seminars) {
                        //Display all seminars to admin but with no edit access
                        printSeminarBox(response, seminar, user);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                response.getWriter().close();
            }
        }
    }
    
    /**
     * Display the correct seminar(s) depending on type of request.
     * 
     * @param response  servlet response
     * @param seminar   seminar(s) to display in home page
     * @param user      user that makes the request
     * @throws IOException
     * @throws SQLException 
     */
    private void printSeminarBox(HttpServletResponse response, Seminar seminar, User user)
            throws IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<div class='mix'>");
        out.print("<div class='seminar-box'>");
        out.print("<div class='seminar-image'>");
        out.print("<a href='detail_seminar.jsp?id=" + seminar.getSeminarId() + "'>");
        
        //Change seminar image based on type of venue
        String venueName = seminar.getVenue().getVenueName();
        if (venueName.toLowerCase().contains("classroom")) {
            out.print("<img src='image/classroom.jpg'></a></div>");
        } else if (venueName.toLowerCase().contains("pod")) {
            out.print("<img src='image/pod.jpg'></a></div>");
        } else if (venueName.toLowerCase().contains("workshop")) {
            out.print("<img src='image/workshop.jpg'></a></div>");
        } else if (venueName.toLowerCase().contains("computer")) {
            out.print("<img src='image/computer.jpg'></a></div>");
        } else {
            out.print("<img src='image/lecture.jpg'></a></div>");
        }
        
        out.print("<div class='seminar-name'><b>" + seminar.getSeminarTitle() + "</b></div>");
        
        //Seminar Organiser part
        User organiser = seminar.getUserOrganiser();
        out.print("<div class='seminar-organiser-header'> Organiser: </div>");
        out.print("<div class='seminar-organiser'>" + organiser.getUserFirstName() 
                + "  " + organiser.getUserLastName() + "</div>");
        
        //Seminar Speaker part
        List<Speaker> speakers = DAOFactory.getInstanceOfSpeakerDAO()
                .findAllBySeminar(seminar.getSeminarId());
        out.print("<div class='seminar-speaker-header'> Speakers:</div>");
        out.print("<div class='seminar-speaker'>" + speakers.get(0).getSpeakerName() + "<br>"
                + speakers.get(1).getSpeakerName() + "<br>" + speakers.get(2).getSpeakerName() + "</div>");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE - MM/dd", Locale.UK);
        out.print("<div class='seminar-date'>" 
                + dateFormat.format(seminar.getSeminarStartTime()) + " " + "</div>");
        out.print("<div class='seminar-venue'>" 
                + venueName + " " + seminar.getVenue().getVenueLocation() + "</div>");
        
        //Whether enable manage seminar feature based on user type
        if (user == null || user.getUserTypeFlag().equals('a')) {
            out.print("<div class='seminar-button'><a href='detail_seminar.jsp?id=" 
                    + seminar.getSeminarId() + "' class='button'>Enter</div>");
        } else if (user.getUserTypeFlag() != null) {
            out.print("<div class='seminar-button'><a href='manage_seminar.jsp?id=" 
                    + seminar.getSeminarId() + "' class='button'>Edit</div>");
        }
        
        out.print("</div>");
        out.print("</div>");
    }
}
