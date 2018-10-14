<%-- 
    Document   : detail_seminar
    Created on : 26/09/2018, 5:04:58 PM
    Author     : Jackie Yang
--%>

<%@page import="com.sdpseminarsystem.vo.Attendee"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.sdpseminarsystem.vo.Speaker"%>
<%@page import="com.sdpseminarsystem.vo.Seminar"%>
<%@page import="com.sdpseminarsystem.dao.factory.DAOFactory"%>
<%@page import="java.util.Locale" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String seminarId = request.getParameter("id");
    Seminar seminar = DAOFactory.getInstanceOfSeminarDAO().findById(Integer.parseInt(seminarId));
    List<Speaker> speaker = DAOFactory.getInstanceOfSpeakerDAO().findAllBySeminar(Integer.parseInt(seminarId));
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MM/dd/yyyy", Locale.UK);
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.UK);
    Integer attendeeNumber = DAOFactory.getInstanceOfAttendeeDAO().findAllBySeminar(Integer.parseInt(seminarId)).size();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <title>Seminar Details</title>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
            <!--Display the seminar details-->
            <h1> <%=seminar.getSeminarTitle()%> </h1>
            <div class="detail-seminar-grid">
                <div class="detail-seminar-venue"><b>Venue:</b> <%=seminar.getVenue().getVenueName() %></div>
                <div class="detail-seminar-location"><b>Location: </b><%=seminar.getVenue().getVenueLocation() %> </div>
                <div class="detail-seminar-capacity"><b>Capacity: </b><%=seminar.getVenue().getVenueCapacity() %></div>
                <div class="detail-seminar-number"><b>Registered: </b><%=attendeeNumber %> </div>
                <div class="detail-seminar-date"><b>Date:</b> <%=dateFormat.format(seminar.getSeminarStartTime()) %></div>
                <div class="detail-seminar-start"><b>Start:</b> <%=timeFormat.format(seminar.getSeminarStartTime())%></div>
                <div class="detail-seminar-end"><b>End:</b> <%=timeFormat.format(seminar.getSeminarEndTime())%></div>
                <div class="detail-seminar-host"><b>Host:</b> <%=seminar.getUserHost().getUserFirstName() %> <%=seminar.getUserHost().getUserLastName() %></div>
                <div class="detail-seminar-speaker"><b>Speaker: </b> <%=speaker.get(0).getSpeakerName() %> </div>
                <div class="detail-seminar-speaker-bio"><textarea name="detailSpeaker" readonly><%=speaker.get(0).getSpeakerBiography() %></textarea></div>
                <% if(!(speaker.get(1).getSpeakerName().equals(""))){%>
                <div class="detail-seminar-speakerO"><b>Speaker 2: </b> <%=speaker.get(1).getSpeakerName()%> </div>               
                <div class="detail-seminar-speakerO-bio"><textarea name="detailSpeaker" readonly><%=speaker.get(1 ).getSpeakerBiography() %></textarea></div>
                <% } %>
                <% if(!(speaker.get(2).getSpeakerName().equals(""))){%>
                <div class="detail-seminar-speakerT"><b>Speaker 3: </b> <%=speaker.get(2).getSpeakerName() %> </div>
                <div class="detail-seminar-speakerT-bio"><textarea name="detailSpeaker" readonly><%=speaker.get(2).getSpeakerBiography() %></textarea></div>
                <% } %>
                <div class="detail-seminar-desc"><b>Seminar Description</b> </div>
                <div class="detail-seminar-descV"><textarea name="detailSemDesc" readonly><%=seminar.getSeminarDescription()%> </textarea> </div>
                <div class="detail-seminar-register"><button type="button" onclick="document.getElementById('seminarRegister').style.display='block';">Register</button> </div>
            </div>
                
            <!--Register button click, display this register pop up-->
            <div id="seminarRegister" class="modal" >
                <form id="mainForm" class="modal-content animate" name="detailRegAttendeeForm" action="AttendeeServlet" onsubmit="document.getElementById('seminarConfirm').style.display='block';return false;" method="POST">
                    <div class="center">
                        <h1><%=seminar.getSeminarTitle()%></h1>
                        <table align="center">
                            <tr>
                                <th><b>Venue:</b></th>
                                <th><b>Location:</b></th>
                                <th><b>Date: </b></th>
                            </tr>
                            <tr>
                                <td><%=seminar.getVenue().getVenueName() %></td>
                                <td><%=seminar.getVenue().getVenueLocation() %></td>
                                <td><%=dateFormat.format(seminar.getSeminarStartTime()) %></td>
                            </tr>
                        </table>
                        <br>
                        <div class="register-grid">
                            <div class="register-Fname">First Name</div>
                            <div class="register-Lname">Last Name</div>    
                            <div class="register-Fname-input"><input id="firstNameInput" type="text" name="attdFName" placeholder="First Name" required ></div>
                            <div class="register-Lname-input"><input id="lastNameInput" type="text" name="attdLName" placeholder="Last Name" required></div>
                            <div class="register-email">Email</div>   
                            <div class="register-email-input"><input type="email" id="emailInput" name="attdEmail" placeholder="Email Address"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required></div>    
                            <div class="register-phone">Phone Number </div>
                            <div class="register-phone-input"><input type="text" id="phoneInput" name="attdPhone" placeholder="Phone Number" required></div>
                            <div class="register-status">Status</div>   
                            <div class="register-status-going"><input class="status" type="radio" name="status" value="Going" required/>Going </div>
                            <div class="register-status-interested"><input class="status" type="radio" name="status" value="Interested"/> Interested</div>
                            <input type="hidden" id="submit" name="submit" value="create">
                            <input type="hidden" id="seminarId" name="seminarId" value="<%=seminarId%>" >
                            <div class="register-registered"><label style="cursor: pointer" onclick="document.getElementById('seminarRegistered').style.display='block';document.getElementById('seminarRegister').style.display='none'"> Already registered? Click here</label></div>  
                            <div class="register-submit"><input type="submit" id="confirmButton" value="Confirm"></div>                           
                            <div class="register-cancel"><input type="button" onclick="document.getElementById('seminarRegister').style.display='none'" value="Close"></div>                            
                        </div>
                    </div>
                </form>
            </div>
           
            <!--When user click 'Already registered?' pop up-->
            <div id="seminarRegistered" class="modal">
                <div align="center">
                    <form name="detailRegisteredEmailForm" id="findUserForm" class="modal-content animate" action="AttendeeServlet" method="POST">
                        <h1>Enter your email</h1>
                        <br> <br>
                        <div class="registered-grid">
                            <div class="registered-email">Email: </div>
                            <div class="registered-email-input"><input type="email" id="email" name="regEmail" placeholder="Your email address"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required> </div>
                            <input id="flag" type="hidden" name="submit" value="verify">
                            <input id="seminarId" type="hidden" name="seminarId" value="<%=seminarId%>">
                            <div class="registered-submit"><input id="findUserButton" type="submit" class="registerButton" value="Confirm"> </div>
                            <div class="registered-cancel"><input type="button" class="registerButton" onclick="document.getElementById('seminarRegistered').style.display='none'" value="Cancel"></div>
                            <div id="registeredDiv" class="registered-error"></div>
                        </div>
                    </form>     
                </div>
            </div>
                            
            <!--Pop up to edit the detail of attendee-->
            <div id="seminarRegisterEdit" class="modal" >
                <form id="editForm" class="modal-content animate" action="AttendeeServlet" method="POST">
                    <div class="center">
                        <h1><%=seminar.getSeminarTitle()%> </h1>
                        <table align="center">
                            <tr>
                                <th><b>Venue:</b></th>
                                <th><b>Location:</b></th>
                                <th><b>Date: </b></th>
                            </tr>
                            <tr>
                                <td><%=seminar.getVenue().getVenueName() %></td>
                                <td><%=seminar.getVenue().getVenueLocation() %></td>
                                <td><%=dateFormat.format(seminar.getSeminarStartTime()) %></td>
                            </tr>
                        </table>
                        <br>
                        <div class="registerEdit-grid"></div>
                    </div>
                </form>
            </div>
            
            <!--Attendee Registering for seminar-->
            <div id="seminarConfirm" class="modal">
                <div class="modal-content animate" align="center">
                    <p><b>Your registration for the following seminar has been confirmed.</b></p>
                    <table align="center">
                        <tr>
                            <th><b>Venue:</b></th>
                            <th><b>Location:</b></th>
                            <th><b>Date: </b></th>
                        </tr>
                        <tr>
                            <td><%=seminar.getVenue().getVenueName() %></td>
                            <td><%=seminar.getVenue().getVenueLocation() %></td>
                            <td><%=dateFormat.format(seminar.getSeminarStartTime()) %></td>
                        </tr>
                    </table>
                        <div class="seminarConfirm"></div>                    
                </div> 
            </div>                  
                      
            <!--Confirm attendee has successfully edit personal details-->          
            <div id="seminarEditConfirm" class="modal">
                <div class="modal-content animate" align="center">
                    <p><b>Your edit for the following seminar has been confirmed.</b></p>
                    <table align="center">
                        <tr>
                            <th><b>Venue:</b></th>
                            <th><b>Location:</b></th>
                            <th><b>Date: </b></th>
                        </tr>
                        <tr>
                            <td><%=seminar.getVenue().getVenueName() %></td>
                            <td><%=seminar.getVenue().getVenueLocation() %></td>
                            <td><%=dateFormat.format(seminar.getSeminarStartTime()) %></td>
                        </tr>
                    </table>
                        <div class="editConfirm"></div>
                        
                </div> 
            </div>
                        
            <!--Confirm attendee has been removed from the seminar-->
            <div id="seminarRegisterDelete" class="modal">
                <div class="modal-content animate">
                    <h1>You have been removed from the seminar</h1>
                    <p><b>Seminar Name: </b> <%=seminar.getSeminarTitle()%></p>
                     <div class="deleteConfirm"></div>                    
                </div>        
            </div>
        </div>
    </body>
    <script>
    
    $(document).ready(function(){ 
        //Allow pop up to be close by clicking outside the modal
        closeModal('seminarRegister','seminarRegistered','seminarRegisterEdit'); 
    });
        
    /*
     * On Mainform submit, retrieve all attendee details, and launch AttendeeServlet
     * to create new attendee
     */
    $("#mainForm").submit(function(event){
        event.preventDefault();
        var submitFlag = $('#submit').val();
        var seminarId = $('#seminarId').val();
        var firstName = $('#firstNameInput').val();
        var lastName = $('#lastNameInput').val();
        var email = $('#emailInput').val();
        var phone = $('#phoneInput').val();
        var status = $('.status:checked').val();
        var data = 'submit='+submitFlag+'&seminarId='+seminarId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status;
        /*
         * Ajax to dynamically load data confirmation to attendee, after success
         * register.
         */
        $.ajax({
            url:"AttendeeServlet",
            type: "POST",
            data: data,
            success:function(data){
                if(data !== "null"){
                    $('.seminarConfirm').html(data);
                }else{
                    return false;
                }
            }
        });
    });
    
    /*
     * Form to check if attendee email has already been registerd with seminars
     */
    $("#findUserForm").submit(function(event){
        event.preventDefault();
        var submitFlag = $('#flag').val();
        var email = $('#email').val();
        var flag = $('#flag').val();
        var seminarId = $('#seminarId').val();
        var data = 'submit='+submitFlag+'&email='+email+'&flag='+flag+'&seminarId='+seminarId;
        
        /*
         * Ajax that return attendee data upon successful verification of attendee
         * existent in the seminar, it opens edit pop up
         */
        $.ajax({
            url:"AttendeeServlet",
            type: "POST",
            data: data,
            success:function(data){
                if(data != "null"){
                    $('.registerEdit-grid').html(data);
                    document.getElementById('seminarRegisterEdit').style.display='block'; 
                    document.getElementById('seminarRegistered').style.display='none'; 
                }else{
                    $("#registeredDiv").html('<span class="error" style="color: red">' + "Email is not registered with this seminar" + '</span>');  
                    return false;
                }
            }
        });
    });
 
    /*
     * Edit form allows attendee to edit/delete their details, and submit to another 
     * ajax so user can double check the details
     */
    $("#editForm").submit(function(event){
        event.preventDefault();
        var submitFlag = $('#hiddenFlag').val();
        var attendeeId = $('#attdId').val();
        //If attendee click on Confirm button to edit details
        if(submitFlag === "Confirm"){
            var seminarId = $('#seminarId').val();
            var firstName = $('#firstNameEdit').val();
            var lastName = $('#lastNameEdit').val();
            var targetEmail = $('#email').val();
            var email = $('#emailEdit').val();
            var phone = $('#phoneEdit').val();
            var status = $('.status:checked').val();
            var data = 'submit='+submitFlag+'&attdId='+attendeeId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status+'&seminarId='+seminarId+'&target='+targetEmail;
            /*
             * Ajax calls AttendeeServlet to update with new details
             */
            $.ajax({
                url:"AttendeeServlet",
                type: "POST",
                data: data,
                success:function(data){
                    if(data !== "null"){
                        $('.editConfirm').html(data);
                    }else{
                        return false;
                    }
                }
            });
            //Attendee click to delete data
        }else if(submitFlag === "Delete"){
            var firstName = $('#firstNameEdit').val();
            var lastName = $('#lastNameEdit').val();
            var email = $('#emailEdit').val();
            var phone = $('#phoneEdit').val();
            var status = $('.status:checked').val();
            var data = 'submit='+submitFlag+'&attdId='+attendeeId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status;
            /*
             * Ajax calls AttendeeServlet to delete the personal data
             */
            $.ajax({
                url:"AttendeeServlet",
                type: "POST",
                data: data,
                success:function(data){
                    if(data !== "null"){
                        $('.deleteConfirm').html(data);
                    }else{
                        return false;
                    }
                }
            });
            
        }    
    }); 
    </script>
</html>
