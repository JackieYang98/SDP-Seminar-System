package com.sdpseminarsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.*;

/**
 * Servlet implementation class CreateSeminarServlet.
 * <p>
 * Respond to requests for creating a seminar.
 * 
 * @author Liam Heng
 * @author Leo Lee
 * @see HttpServlet
 * @since 1.0
 */
@WebServlet(name = "CreateSeminarServlet", urlPatterns = { "/CreateSeminarServlet" })
public class CreateSeminarServlet extends HttpServlet {
    
    private static final long serialVersionUID = 5178634766764973899L;
    
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
        if (request.getParameter("host") == null) {
            try {
                List<User> allUsers = DAOFactory.getInstanceOfUserDAO().findAll();
                response.getWriter().write("<option disabled selected value> -- Select a host -- </option>");
                for (User user : allUsers) {
                    if (user.getUserTypeFlag().equals('h')) {
                        response.setContentType("text/html");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write("<option>" + user.getUserId() + " " + user.getUserFirstName() + " "
                                + user.getUserLastName() + "</option>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Venue> allVenue = DAOFactory.getInstanceOfVenueDAO()
                        .findByUserHostId(Integer.parseInt(request.getParameter("host").substring(0, 8)));
                response.getWriter().write("<option disabled selected value> -- Select a venue -- </option>");
                for (Venue venue : allVenue) {
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter()
                            .write("<option value=" + venue.getVenueId() + ">" + venue.getVenueName() + " / "
                                    + venue.getVenueLocation() + " / " + " Capacity" + ": " + venue.getVenueCapacity()
                                    + "</option>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        try {
            createSeminar(request, response);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    private boolean createSeminar(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, SQLException {
        Seminar seminar = new Seminar();
        seminar.setSeminarTitle(request.getParameter("seminarName"));
        seminar.setSeminarDescription(request.getParameter("seminarDescription"));
        
        Venue venue = new Venue();
        venue.setVenueId(Integer.valueOf(request.getParameter("venueName")));
        seminar.setVenue(venue);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String seminarDate = request.getParameter("seminarDate");
        String seminarStartTime = request.getParameter("seminarStart");
        String seminarEndTime = request.getParameter("seminarEnd");
        seminar.setSeminarStartTime(dateFormat.parse(seminarDate + " " + seminarStartTime));
        seminar.setSeminarEndTime(dateFormat.parse(seminarDate + " " + seminarEndTime));
        
        User organiser = new User();
        organiser.setUserId(request.getParameter("organiser"));
        seminar.setUserOrganiser(organiser);
        
        int rowId = DAOFactory.getInstanceOfSeminarDAO().create(seminar);
        if (rowId > 0) {
            String speakerName = request.getParameter("speakerName");
            String speakerBio = request.getParameter("speakerBio");
            
            Speaker speaker = new Speaker();
            speaker.setSpeakerName(speakerName);
            speaker.setSpeakerBiography(speakerBio);
            DAOFactory.getInstanceOfSpeakerDAO().create(speaker, rowId);
            
            speakerName = request.getParameter("speakerTwoName");
            speakerBio = request.getParameter("speakerTwoBio");
            if (speakerName != null || speakerBio != null) {
                speaker = new Speaker();
                speaker.setSpeakerName(speakerName);
                speaker.setSpeakerBiography(speakerBio);
                DAOFactory.getInstanceOfSpeakerDAO().create(speaker, rowId);
            }
            
            speakerName = request.getParameter("speakerThreeName");
            speakerBio = request.getParameter("speakerThreeBio");
            if (speakerName != null || speakerBio != null) {
                speaker = new Speaker();
                speaker.setSpeakerName(speakerName);
                speaker.setSpeakerBiography(speakerBio);
                DAOFactory.getInstanceOfSpeakerDAO().create(speaker, rowId);
            }
            
            return true;
        } else {
            return false;
        }
    }
}
