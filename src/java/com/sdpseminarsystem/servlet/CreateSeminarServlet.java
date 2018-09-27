/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdpseminarsystem.servlet;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Seminar;
import com.sdpseminarsystem.vo.Venue;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        String seminarName= request.getParameter("seminarName");
        String seminarDescription = request.getParameter("seminarDescription");
        String venueName= request.getParameter("venueName");
        String venueDescription = request.getParameter("venueLocation");
        String seminarDate = request.getParameter("seminarDate");
        String seminarStart = request.getParameter("seminarStart");
        String seminarEnd = request.getParameter("seminarEnd");
        String seminarHost = request.getParameter("seminarHost");
        String speakerOne = request.getParameter("speakerName");
        String speakerOneBio = request.getParameter("speakerBio");
        String image = request.getParameter("seminarImage");

        Seminar newSeminar = new Seminar();
        Venue venue = new Venue();
//        DAOFactory.getInstanceOfVenueDAO().findById(0);
        newSeminar.setSeminarTitle(seminarName);
        newSeminar.setSeminarDescription(seminarDescription);
        newSeminar.setVenue(venue);
//        DAOFactory.getInstanceOfSeminarDAO().create(newSeminar);
        try {
            String speakerTwo = request.getParameter("venueLocation");
            String speakerTwoBio = request.getParameter("speakerBio");
            String speakerThree = request.getParameter("venueLocation");
            String speakerThreeBio = request.getParameter("speakerBio");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.print(seminarName + " " + seminarDescription + " " + venueName + " " + venueDescription + " " +
                seminarDate + " " + seminarStart + " " + seminarEnd + " " +
                seminarHost + " " + image + " " +speakerOne + " " +speakerOneBio);
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
        processRequest(request, response);
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
