/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdpseminarsystem.servlet;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Seminar;
import com.sdpseminarsystem.vo.User;
import com.sdpseminarsystem.vo.Venue;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.AbstractList;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jingl
 */
@WebServlet(name = "CreateSeminarServlet", urlPatterns = {"/CreateSeminarServlet"})
public class CreateSeminarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{ 
            
            String seminarName= request.getParameter("seminarName");
            String seminarDescription = request.getParameter("seminarDescription");
            String venueName= request.getParameter("venueName");
            String seminarDate = request.getParameter("seminarDate");
            String seminarStart = request.getParameter("seminarStart");
            String seminarEnd = request.getParameter("seminarEnd");
            String seminarHost = request.getParameter("seminarHost");
            String speakerOne = request.getParameter("speakerName");
            String speakerOneBio = request.getParameter("speakerBio");
            String image = request.getParameter("seminarImage");
            String organiser = request.getParameter("organiser");
            
            Seminar newSeminar = new Seminar();
            newSeminar.setSeminarId(DAOFactory.getInstanceOfSeminarDAO().findAll().size());
            newSeminar.setSeminarTitle(seminarName);
            newSeminar.setSeminarDescription(seminarDescription);
            Venue venue = new Venue();
            System.out.print(venueName + "HI");
            venue.setVenueId(Integer.parseInt(venueName));
            newSeminar.setVenue(venue);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date startDate = dateFormat.parse(seminarDate + " " + seminarStart);
            Date endDate = dateFormat.parse(seminarDate + " " + seminarEnd);
            newSeminar.setSeminarStartTime(startDate);
            newSeminar.setSeminarEndTime(endDate);
            
            System.out.print(seminarHost.substring(0,8));
            newSeminar.setUserHost(DAOFactory.getInstanceOfUserDAO().findById(seminarHost.substring(0,8)));
            
            newSeminar.setUserOrganiser(DAOFactory.getInstanceOfUserDAO().findById(organiser));
            System.out.print(newSeminar.getUserHost());
                        System.out.print(newSeminar.getSeminarId() + newSeminar.getSeminarTitle() + newSeminar.getSeminarEndTime() + newSeminar.getUserOrganiser() + newSeminar.getUserHost() + newSeminar.getVenue() + newSeminar.getSeminarStartTime() +
                    newSeminar.getSeminarLastMins());
            DAOFactory.getInstanceOfSeminarDAO().create(newSeminar);
            

            
            String speakerTwo = request.getParameter("speakerTwoName");
            String speakerTwoBio = request.getParameter("speakerTwoBio");
            if(speakerTwo != null && speakerTwoBio != null){
                
            }
            String speakerThree = request.getParameter("speakerThreeName");
            String speakerThreeBio = request.getParameter("speakerThreeBio");
            if(speakerThree != null && speakerThreeBio != null){
                
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("host") ==null){
            try{
                List<User> allUsers = DAOFactory.getInstanceOfUserDAO().findAll();
                response.getWriter().write("<option disabled selected value> -- Select a host -- </option>");
                for(User user: allUsers){
                    if(user.getUserTypeFlag().equals('h')){    
                        response.setContentType("text/html");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write("<option>"+user.getUserId() + " " + user.getUserFirstName() + "</option>");
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();;
            }
    } else {
            try{
                List<Venue> allVenue = DAOFactory.getInstanceOfVenueDAO().findByUserHostId(Integer.parseInt(request.getParameter("host").substring(0,8)));
                response.getWriter().write("<option disabled selected value> -- Select a venue -- </option>");
                for(Venue venue : allVenue){
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("<option value=" +venue.getVenueId() +">"+ venue.getVenueName() + " / " + venue.getVenueLocation() + " / " + " Capacity" + ": " + venue.getVenueCapacity() + "</option>");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
