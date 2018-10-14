package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.*;

/**
 * Servlet implementation class ManageSeminarServlet.
 * <p>
 * Respond to requests for user's management of seminars.
 * 
 * @author Liam Heng
 * @see HttpServlet
 * @since 1.0
 */
public class ManageSeminarServlet extends HttpServlet {
    
    private static final long serialVersionUID = -2569131884527121645L;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //If the request is to delete seminar
            if (request.getParameter("submit").equals("Delete")) {
                deleteSeminar(request, response);
                //Request is to update the seminar
            } else if (request.getParameter("submit").equals("Update Seminar")) {
                updateSeminar(request, response);
            }
        } catch (ParseException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    /**
     * Processes requests for HTTP <code>GET</code> 
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //The first request to get the host of selected seminar, 
        //It is launched on manage seminar page load
        if (request.getParameter("venue") == null) {
            try {
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                List<User> allUsers = DAOFactory.getInstanceOfUserDAO().findAll();
                for (User user : allUsers) {
                    //If user is host and correct host of the seminar, select it
                    if (user.getUserTypeFlag().equals('h')
                            && user.getUserId().equals(request.getParameter("host")
                            .substring(0, 8))) {
                        out.write("<option selected>" + user.getUserId() + " " + 
                                user.getUserFirstName() + " " + 
                                user.getUserLastName() + "</option>");
                    //Just list other host normally
                    } else if (user.getUserTypeFlag().equals('h')) {
                        out.write("<option>" + user.getUserId() + " " + 
                                user.getUserFirstName() + " " + 
                                user.getUserLastName() + "</option>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //The second request to get venue of the selected seminar
        } else {
            try {
                List<Venue> allVenue = DAOFactory.getInstanceOfVenueDAO()
                    .findByUserHostId(Integer.parseInt(request.getParameter("host")
                    .substring(0, 8)));
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                for (Venue venue : allVenue) {
                    //Get the correct venue and select it in dropdown
                    if (venue.getVenueId().equals(Integer.parseInt(
                            request.getParameter("venue")))) {
                        out.write("<option value=" + venue.getVenueId() + 
                            " selected>" + venue.getVenueName() + " / " + 
                            venue.getVenueLocation() + " / " + " Capacity" + 
                            ": " + venue.getVenueCapacity() + "</option>");
                    //Print other venue out in dropdown normally
                    } else {
                        out.write("<option value=" + venue.getVenueId() + 
                                ">" + venue.getVenueName() + " / " + 
                                venue.getVenueLocation() + " / " + " Capacity" +
                                ": " + venue.getVenueCapacity()
                                + "</option>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Delete the seminar off the database
     * 
     * @param request   servlet request
     * @param response  servlet response
     * @throws SQLException 
     */
    private void deleteSeminar(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException {
        Seminar seminar = new Seminar();
        seminar.setSeminarId(Integer.parseInt(request.getParameter("seminarId")));
        DAOFactory.getInstanceOfSeminarDAO().delete(seminar);
    }
    
    /**
     * Update the seminar with new user input.
     * There are three tables to update: seminars, speakers, and venues.
     * 
     * @param request   servlet request
     * @param response  servlet response
     * @throws ParseException
     * @throws SQLException 
     */
    private void updateSeminar(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, SQLException {
        Seminar seminar = new Seminar();
        seminar.setSeminarId(Integer.parseInt(request.getParameter("seminarId")));
        seminar.setSeminarTitle(request.getParameter("seminarName"));
        seminar.setSeminarDescription(request.getParameter("seminarDescription"));
        
        //Update the venues table in database
        Venue venue = new Venue();
        venue.setVenueId(Integer.valueOf(request.getParameter("venueName")));
        seminar.setVenue(venue);
        
        //Update the start time and end time of the selected seminar
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String seminarDate = request.getParameter("seminarDate");
        String seminarStartTime = request.getParameter("seminarStart");
        String seminarEndTime = request.getParameter("seminarEnd");
        seminar.setSeminarStartTime(dateFormat.parse(seminarDate + " " + seminarStartTime));
        seminar.setSeminarEndTime(dateFormat.parse(seminarDate + " " + seminarEndTime));
        
        User organiser = new User();
        organiser.setUserId(request.getParameter("organiser"));
        seminar.setUserOrganiser(organiser);
        
        //Update the seminars table in database
        DAOFactory.getInstanceOfSeminarDAO().update(seminar);
        String speakerName = request.getParameter("speakerName");
        String speakerBio = request.getParameter("speakerBio");
        
        //Get first speaker input to update it
        Speaker speaker = new Speaker();
        List<Speaker> allSpeakers = DAOFactory.getInstanceOfSpeakerDAO()
                .findAllBySeminar(Integer.parseInt(request.getParameter("seminarId")));
        speaker.setSpeakerId(allSpeakers.get(0).getSpeakerId());
        speaker.setSpeakerName(speakerName);
        speaker.setSpeakerBiography(speakerBio);
        //Update speakers table in database
        DAOFactory.getInstanceOfSpeakerDAO().update(speaker);
        
        //Get second speaker input to update if there is any
        speakerName = request.getParameter("speakerTwoName");
        speakerBio = request.getParameter("speakerTwoBio");
        if (speakerName != null && speakerBio != null) {
            speaker = new Speaker();
            speaker.setSpeakerId(allSpeakers.get(1).getSpeakerId());
            speaker.setSpeakerName(speakerName);
            speaker.setSpeakerBiography(speakerBio);
            //Update speakers table in database
            DAOFactory.getInstanceOfSpeakerDAO().update(speaker);
        }
        
        //Get third speaker input to update if there is any
        speakerName = request.getParameter("speakerThreeName");
        speakerBio = request.getParameter("speakerThreeBio");
        if (speakerName != null && speakerBio != null) {
            speaker = new Speaker();
            speaker.setSpeakerId(allSpeakers.get(2).getSpeakerId());
            speaker.setSpeakerName(speakerName);
            speaker.setSpeakerBiography(speakerBio);
            //Update speakers table in database
            DAOFactory.getInstanceOfSpeakerDAO().update(speaker);
        }
    }
}
