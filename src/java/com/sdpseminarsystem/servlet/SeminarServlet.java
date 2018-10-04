/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdpseminarsystem.servlet;

import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Seminar;
import com.sdpseminarsystem.vo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jingl
 */
public class SeminarServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null){
                List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO().findAll();
                for (Seminar seminar : seminars) {
                    printSeminarBox(response, seminar, user);
                }
            }else if(user != null && user.getUserTypeFlag() == 'o'){
                List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO().findByUser(user);
                for (Seminar seminar : seminars) {
                    printSeminarBox(response, seminar, user);
                }       
            }else if(user != null && user.getUserTypeFlag() == 'h'){
                List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO().findByUser(user);
                for (Seminar seminar : seminars) {
                    printSeminarBox(response, seminar, user);
                } 
            }else if(user != null && user.getUserTypeFlag() == 'a'){
                List<Seminar> seminars = DAOFactory.getInstanceOfSeminarDAO().findAll();
                for (Seminar seminar : seminars) {
                    printSeminarBox(response, seminar, user);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            response.getWriter().close();
        }
        
    }

    private void printSeminarBox(HttpServletResponse response, Seminar seminar, User user) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MM/dd");
                    PrintWriter out = response.getWriter();
                    out.print("<div class='seminar-box'>");
                    out.print("<div class='seminar-image'>");
                    out.print("<a href='detail_seminar.jsp?id="+seminar.getSeminarId()+"'>");
                    out.print("<img src='image/building.jpg'></a></div>");                   
                    out.print("<div class='seminar-name'>"+seminar.getSeminarTitle()+"</div>");
                    out.print("<div class='seminar-date'>"+dateFormat.format(seminar.getSeminarStartTime())+"</div>");            
                    out.print("<div class='seminar-venue'>"+seminar.getVenue().getVenueName() + " " + 
                            seminar.getVenue().getVenueLocation()+"</div>");
                    if(user == null){
                        out.print("<div class='seminar-button'><button type='button'>Apply</button></div>");
                    }else if (user.getUserTypeFlag() != null){
                        out.print("<div class='seminar-button'><button type='button'>Edit</button></div>");
                    }
                    out.print("</div>");
                    
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
