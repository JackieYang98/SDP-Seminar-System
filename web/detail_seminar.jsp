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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String seminarId = request.getParameter("id");
    Seminar seminar = DAOFactory.getInstanceOfSeminarDAO().findById(Integer.parseInt(seminarId));
    List<Speaker> speaker = DAOFactory.getInstanceOfSpeakerDAO().findAllBySeminar(Integer.parseInt(seminarId));
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MM/dd/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <title>Seminar Details</title>
        <style>
            th, td{
                padding-left:30px;
                padding-right: 30px;
            }
            input[type=radio],input.radio {
              float: left;
              clear: none;
              margin: 2px 0 0 2px;
            }
            .register-registered{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
            <h1> <%=seminar.getSeminarTitle()%> </h1>
            <div class="detail-seminar-grid">
                <div class="detail-seminar-venue"><b>Venue:</b> <%=seminar.getVenue().getVenueName() %></div>
                <div class="detail-seminar-location"><b>Location:</b> <%=seminar.getVenue().getVenueLocation() %></div>
                <div class="detail-seminar-date"><b>Date:</b> <%=dateFormat.format(seminar.getSeminarStartTime()) %></div>
                <div class="detail-seminar-start"><b>Start:</b> <%=timeFormat.format(seminar.getSeminarStartTime())%></div>
                <div class="detail-seminar-end"><b>End:</b> <%=timeFormat.format(seminar.getSeminarEndTime())%></div>
                <div class="detail-seminar-host"><b>Host:</b> <%=seminar.getUserHost().getUserFirstName() %></div>
                <div class="detail-seminar-speaker"><b>Speaker: </b> <%=speaker.get(0).getSpeakerName() %> </div>
                <div class="detail-seminar-speakerV"><textarea name="detailSpeaker" readonly><%=speaker.get(0).getSpeakerBiography() %></textarea></div>
                <div class="detail-seminar-desc"><b>Seminar Description</b> </div>
                <div class="detail-seminar-descV"><textarea name="detailSemDesc" readonly><%=seminar.getSeminarDescription()%> </textarea> </div>
                <div class="detail-seminar-register"><button type="button" onclick="document.getElementById('seminarRegister').style.display='block';">Register</button> </div>
            </div>
            <div id="seminarRegister" class="modal" >
                <form id="mainForm" class="modal-content animate" name="detailRegAttendeeForm" action="AttendeeServlet" onsubmit="document.getElementById('seminarConfirm').style.display='block';" method="POST">
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
                            <div class="register-status-going"><input type="radio" name="status" value="Going" required/>Going </div>
                            <div class="register-status-interested"><input type="radio" name="status" value="Interested"/> Interested</div>
                            <input type="hidden" name="submit" value="create">
                            <input type="hidden" name="seminarId" value="<%=seminarId%>">
                            <div class="register-registered"><label onclick="document.getElementById('seminarRegistered').style.display='block';document.getElementById('seminarRegister').style.display='none'"> Already registered? Click here</label></div>  
                            <div class="register-submit"><input type="submit" id="confirmButton" onclick="confirmAttending();" value="Confirm"></div>
                            <!----> 
                            <div class="register-cancel"><input type="button" onclick="document.getElementById('seminarRegister').style.display='none'" value="Close"></div>                            
                        </div>
                    </div>
                </form>
            </div>
            <div id="seminarRegistered" class="modal">
                <div align="center">
                    <!----> 
                    <form name="detailRegisteredEmailForm" id="findUserForm" class="modal-content animate" action="AttendeeServlet" method="POST">
                        <h1>Enter your email</h1>
                        <br> <br>
                        
                        <div class="registered-grid">
                            <div class="registered-email">Email: </div>
                            <div class="registered-email-input"><input type="email" id="email" name="regEmail" placeholder="Your email address"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required> </div>
                            <input id="flag" type="hidden" name="submit" value="verify">
                            <input id="seminarId" type="hidden" name="seminarId" value="<%=seminarId%>">
                            <div class="registered-submit"><input id="findUserButton" type="submit" class="registerButton" value="Confirm"> </div>
                            <div id="registeredDiv" class="registered-error"></div>
                        </div>
                    </form>
                </div> 
             </div>
            <div id="seminarRegisterEdit" class="modal" >
                <form id="editForm" class="modal-content animate" action="AttendeeServlet" method="POST">
                    <!---->
                    <div class="center">
                        <h1>Seminar Name</h1>
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
                        <p> <b>First Name: </b><span id="firstNameText"></span></p>
                        <p> <b>Last Name: </b> <span id="lastNameText"></span></p>
                        <p> <b>Email: </b> <span id="emailText"></span></p>
                        <p> <b>Phone Number: </b> <span id="phoneText"></span></p>
                        <p> <b>Status: </b> <span id="statusText"></span> </p>
                        <p> <b>You will be redirected in 5 seconds... </b></p>
                </div> 
            </div>
                        
                        
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
            <div id="seminarRegisterDelete" class="modal">
                <div class="modal-content animate">
                    <h1>You have been removed from the seminar</h1>
                    <p><b>Seminar Name: </b> <%=seminar.getSeminarTitle()%></p>
                     <div class="deleteConfirm"></div>
                    
                    <!--<button type="button" onclick="document.getElementById('seminarRegisterDelete').style.display='none';document.getElementById('seminarRegisterEdit').style.display='none'" title="Close Page">Return</button>-->
                </div>        
            </div>
        </div>
    </body>
    <script>
//    $('#mainForm').submit(function (e){
//        var form = this;
//        e.preventDefault();
//        setTimeout(function(){
//            form.submit();
//        }, 2000);
//    });
    
    function confirmAttending(){       
        var firstNameText = document.getElementById('firstNameText');
        firstNameText.textContent = document.getElementById('firstNameInput').value;
        var lastNameText = document.getElementById('lastNameText');
        lastNameText.textContent = document.getElementById('lastNameInput').value;
        var emailText = document.getElementById('emailText');
        emailText.textContent = document.getElementById('emailInput').value; 
        var phoneText = document.getElementById('phoneText');
        phoneText.textContent = document.getElementById('phoneInput').value;
        var statusText = document.getElementById('statusText');
        statusText.textContent = $('input[name="status"]:checked','#mainForm').val();    
    }
    
    $("#findUserForm").submit(function(event){
        event.preventDefault();
        var submitFlag = $('#flag').val();
        var email = $('#email').val();
        var flag = $('#flag').val();
        var seminarId = $('#seminarId').val();
        var data = 'submit='+submitFlag+'&email='+email+'&flag='+flag+'&seminarId='+seminarId;
        
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
 
    $("#editForm").submit(function(event){
        event.preventDefault();
        var submitFlag = $('#hiddenFlag').val();
        var attendeeId = $('#attdId').val();
        if(submitFlag === "Confirm"){
            var firstName = $('#firstNameEdit').val();
            var lastName = $('#lastNameEdit').val();
            var email = $('#emailEdit').val();
            var phone = $('#phoneEdit').val();
            var status = $('.status:checked').val();
            var data = 'submit='+submitFlag+'&attdId='+attendeeId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status;
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
        }else if(submitFlag === "Delete"){
            var firstName = $('#firstNameEdit').val();
            var lastName = $('#lastNameEdit').val();
            var email = $('#emailEdit').val();
            var phone = $('#phoneEdit').val();
            var status = $('.status:checked').val();
            var data = 'submit='+submitFlag+'&attdId='+attendeeId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status;
            alert(data);
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
