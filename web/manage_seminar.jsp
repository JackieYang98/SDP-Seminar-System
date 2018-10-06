<%-- 
    Document   : manage_seminar
    Created on : 19/09/2018, 5:18:07 PM
    Author     : jackie
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sdpseminarsystem.vo.Attendee"%>
<%@page import="com.sdpseminarsystem.vo.Speaker"%>
<%@page import="java.util.List"%>
<%@page import="com.sdpseminarsystem.vo.Seminar"%>
<%@page import="com.sdpseminarsystem.dao.factory.DAOFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User current = (User) session.getAttribute("user");
    String seminarId = request.getParameter("id");
    Seminar seminar = DAOFactory.getInstanceOfSeminarDAO().findById(Integer.parseInt(seminarId));
    List<Speaker> speaker = DAOFactory.getInstanceOfSpeakerDAO().findAllBySeminar(Integer.parseInt(seminarId));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
    String seminarDate = dateFormat.format(seminar.getSeminarStartTime());
    String seminarStart = timeFormat.format(seminar.getSeminarStartTime());
    String seminarEnd = timeFormat.format(seminar.getSeminarEndTime());
    
    List<Attendee> attendees = DAOFactory.getInstanceOfAttendeeDAO().findAllBySeminar(Integer.parseInt(seminarId));
    request.setAttribute("attendees", attendees);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
        <script src="scripts/script.js"></script>
        <title>Manage Seminar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <style>
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
      <div id="tabs" class="center">
            <ul>
                <li> <a href="#attendee"> View attendees list </a> </li>
                <li> <a href="#edit"> Edit Seminar </a> </li>    
            </ul>
          <br>
            <div id="edit" >
                <form action="ManageSeminarServlet" method="POST">  
                    <div class="grid-container">
                    <div class="grid-sem-name">Seminar Name</div>
                    <div class="grid-sem-name-input"><input type="text" name="seminarName" placeholder="Name" required style="width:515px; height:40px;" value="<%=seminar.getSeminarTitle() %>"></div>  

                    <div class="grid-speaker">Speaker 1</div>
                    <div class="grid-speaker-input"><input class="speakerNameText" type="text" name="speakerName" placeholder="Speaker Name" value="<%=speaker.get(0).getSpeakerName() %>" required></div>
                    <div class="grid-bio">Speaker 1 Biography</div>
                    <div class="grid-bio-input"><textarea class="biotext" name="speakerBio" placeholder="About the speaker..." required><%=speaker.get(0).getSpeakerBiography() %></textarea></div>
                    
                    <div onclick='hide("speaker2")' class="grid-speaker2" style="cursor: pointer; text-decoration: underline; ">Speaker 2 (Click to Toggle)</div>
                    
                    <div id="speaker2" class="grid-speaker2-input" <% if((speaker.get(1).getSpeakerName().equals(""))){%>style="display: none;"<% } %>>
                        <div><input type="text" name="speakerTwoName" placeholder="Speaker 2 Name" value="<%=speaker.get(1).getSpeakerName() %>"></div>
                        <div>Speaker 2 Biography</div>
                        <div><textarea class="biotext" name="speakerTwoBio" placeholder="About the second speaker..."><%=speaker.get(1).getSpeakerBiography() %></textarea></div>
                            <div onclick='hide("speaker3")' class="grid-speaker3" style="cursor: pointer; text-decoration: underline;">Speaker 3 (Click to Toggle)</div>
                            <div id="speaker3" class="grid-speaker3-input" <% if((speaker.get(2).getSpeakerName().equals(""))){%>style="display: none;"<% } %>>
                                <div><input type="text" name="speakerThreeName" placeholder="Speaker 3 Name" value="<%=speaker.get(2).getSpeakerName() %>"></div>
                                <div>Speaker 3 Biography</div>
                                <div><textarea class="biotext" name="speakerThreeBio" placeholder="About the third speaker..."><%=speaker.get(2).getSpeakerBiography() %></textarea></div>
                            </div>
                    </div>
                            
                    <div class="grid-host">Host</div>
                    <div class="grid-host-input">
                        <select name="seminarHost" id="hostDropdown" required>
                            <option selected><%=seminar.getUserHost().getUserId() + " " + seminar.getUserHost().getUserFirstName() + " " + seminar.getUserHost().getUserLastName()%></option>
                        </select>
                    </div>
                    <div class="grid-ven-loc">Venue</div>
                    <div class="grid-ven-loc-input">                     
                        <select name='venueName'  id="venueDropdown" required>
                            <option value="<%=seminar.getVenue().getVenueId()%>"> <%=seminar.getVenue().getVenueName() + " / " +
                                seminar.getVenue().getVenueLocation() + " / " + " Capacity" + ": " + seminar.getVenue().getVenueCapacity()%>
                            </option>
                        </select>
                    </div>   
                    <div class="grid-sem-date">Seminar Date</div>
                    <div class="grid-start">Start Time</div>
                    <div class="grid-end">End Time</div>
                    <div class="grid-sem-date-input"><input type="date" name="seminarDate" required style="width: 150px; height:40px;" value="<%=seminarDate %>"></div>
                    <div class="grid-start-input"><input type="time" name="seminarStart" required style="width: 150px; height:40px;" value="<%=seminarStart %>"></div>
                    <div class="grid-end-input"><input type="time" name="seminarEnd" required style="width: 150px; height:40px;" value="<%=seminarEnd %>"></div>
                    

                    <div class="grid-sem-desc">Seminar Description</div>
                    <div class="grid-sem-desc-input"><textarea class="desctext" name="seminarDescription" placeholder="About the seminar..." required><%=seminar.getSeminarDescription() %></textarea></div>
                    <input type="hidden" value="<%=current.getUserId()%>" name="organiser">
                    <input type="hidden" value="<%=seminarId %>" name="seminarId">
                    <div class="grid-delete"><input class="deleteButton" type="button" value="Delete Seminar" onclick="document.getElementById('deleteSeminar').style.display='block';return false;"></div>
                    <div class="grid-submit"><input class="submitButton" type="submit" name="submit" value="Update Seminar"></div>                       
                    </div>
                </form>
        </div>
        <div id="deleteSeminar" class="modal">
                <form class="modal-content animate" action="ManageSeminarServlet" method="POST">
                    <div class="container">
                        <h1>Are you sure you want to delete this seminar?</h1>
                        <p> <b>Seminar Name: </b> <%=seminar.getSeminarTitle() %></p>
                        <input type="hidden" name="seminarId" value="<%=seminar.getSeminarId()%>">
                        <button type="submit" name="submit" value="Delete">Delete</button>
                        <button type="button" onclick="document.getElementById('deleteSeminar').style.display='none'">Cancel</button>
                    </div>
                </form>
        </div>
        <div id="attendee" style="text-align: center; width: 800px; margin:auto auto;">
            <h1> Attendees </h1>
                <table id="attendee-list" class="display" style="width:100%;">
                    <thead>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Status</th>
                        <th hidden>ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${attendees}" var="attendee">
                            <tr>
                                <td><c:out value="${attendee.attendeeEmail}"/></td>
                                <td><c:out value="${attendee.attendeeFirstName}"/></td>
                                <td><c:out value="${attendee.attendeeLastName}"/></td>
                                <td><c:out value="${attendee.attendeePhone}"/></td>
                                <td><c:choose>
                                    <c:when test="${attendee.attendeeState == 'G'}">
                                        <c:out value="Going"/>
                                    </c:when>
                                    <c:when test="${attendee.attendeeState == 'I'}">
                                        <c:out value="Interested"/>
                                    </c:when>
                                </c:choose></td>
                                <td hidden><c:out value="${attendee.attendeeId}"/></td>

                            </tr>  
                            </c:forEach>
                    </tbody>
                </table>
            <div style="text-align: center">
            <button type="button" onclick="document.getElementById('seminarRegister').style.display='block';" >Register</button>
            <button id="editB" type="button" onclick="document.getElementById('seminarRegisterEdit').style.display='block'; autoFillDetails();" disabled>Edit</button>
            <button id="deleteB" type="button" onclick="document.getElementById('deleteConfirmation').style.display='block'; confirmDelete();" disabled>Delete</button>
            <br>
            <button type="button" onclick="document.getElementById('printTags').style.display='block';return false;" >Print Tags</button>
            <button type="button" onclick="document.getElementById('emailAttendee').style.display='block';return false;">Email</button>
            </div>
        </div>
        <div id="seminarRegister" class="modal">
            <form id="addAttendee" class="modal-content animate" name="addAttendeeForm" action="AttendeeServlet"  onsubmit="document.getElementById('seminarConfirm').style.display='block';return false;"method="POST">
                <h1>Add Attendee</h1>
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
                    <div class="register-submit"><input type="submit" id="confirmButton" value="Confirm"></div>                           
                    <div class="register-cancel"><input type="button" onclick="document.getElementById('seminarRegister').style.display='none'" value="Close"></div>                            
                </div>
            </form>
        </div>
        <div id="seminarConfirm" class="modal">
            <div class="modal-content animate">
                <h1>Registration Complete</h1>
                    <div class="seminarConfirm"></div>
            </div>        
        </div>
        <div id="seminarRegisterEdit" class="modal">
            <form id="editAttendee" class="modal-content animate" action="AttendeeServlet" onsubmit="document.getElementById('seminarEditConfirm').style.display='block';return false;" method="POST">
                <h1>Edit Attendee</h1>
                <div class="registerEdit-grid">
                    <div class="registerEdit-Fname">First Name</div>
                    <div class="registerEdit-Lname">Last Name</div>    
                    <div class="registerEdit-Fname-input"><input id="firstNameText" type="text" name="editFirstName" placeholder="First Name" required></div>
                    <div class="registerEdit-Lname-input"><input id="lastNameText"  type="text" name="editLastName" placeholder="Last Name" required></div>
                    <div class="registerEdit-email">Email</div>   
                    <div class="registerEdit-email-input"><input type="email" id="emailText" name="regEmail" placeholder="Email"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required></div>    
                    <div class="registerEdit-phone">Phone Number </div>
                    <div class="registerEdit-phone-input"><input type="text" id="phoneText" name="attdPhone" placeholder="Phone Number" required></div>
                    <div class="registerEdit-status">Status</div>   
                    
                    <div class="registerEdit-status-Going"><input id="going" type="radio" class="state" name="attdState" value="Going" required>Going</div>
                    <div class="registerEdit-status-Interested"><input id="interested" type="radio" class="state" name="attdState" value="Interested" required>Interested</div>
                    <input type="hidden" id="attdId">                       
                    <div class="registerEdit-submit"><input id="editConfirmButton" type="submit" name="attendeeEdit" value="Confirm"> </div>
                    <div class="registerEdit-cancel"><input type="button" onclick="document.getElementById('seminarRegisterEdit').style.display='none'" value="Cancel"></div>
                </div>
            </form>
        </div>
        <div id="seminarEditConfirm" class="modal">
            <div class="modal-content animate">
                <h1>Attendee edited</h1>
                <div class="seminarEditConfirm"></div>
            </div>        
        </div>
        <div id="deleteConfirmation" class="modal">
            <form id="deleteAttendee" class="modal-content animate" action="AttendeeServlet" method="POST" onsubmit="document.getElementById('seminarRegisterDelete').style.display='block';">
                <h1>Delete Attendee</h1>
                <p> <b>First Name:</b> <span id="firstName"></span> </p>
                <p> <b>Last Name:</b> <span id="lastName"></span> </p>
                <p> <b>Email: </b> <span id="email"></span> </p>
                <p> <b>Phone: </b> <span id="phone"></span> </p>
                <p> <b>Status: </b> <span id="status"></span></p>
                <input type="submit" id="deleteConfirmButton" value="Delete">
                <input id="attendeeID" type="hidden">
                <input type="button" onclick="document.getElementById('deleteConfirmation').style.display='none'" value="Cancel">
            </form>        
        </div>
        <div id="seminarRegisterDelete" class="modal">
            <div class="modal-content animate">
                <h1>Attendee deleted</h1>
                <div class="seminarDeleteConfirm"></div>
            </div>        
        </div>
        <div id="printTags" class="modal">
            <div class="modal-content animate">
                <h1>Print Tags</h1>
                <button type="button" onclick="document.getElementById('printTags').style.display='none'" title="Close Page">Return</button>
            </div>        
        </div>  
        <div id="emailAttendee" class="modal">
            <div class="modal-content animate">
                <h1>Send Email</h1>
                <div class="email-grid">
                    <div class="email-To">To: </div>
                    <div class="email-To-input"><input type="text" name="To" required></div>    
                    <div class="email-CC">CC: </div>
                    <div class="email-CC-input"><input type="text" name="CC"></div>
                    <div class="email-Subject">Subject: </div>   
                    <div class="email-Subject-input"><input type="text" name="subject"></div>    
                    <div class="email-Message">Message</div>   
                    <div class="email-Message-input"><textarea name="emailMessage" style="width:830px; height:200px;"></textarea> </div>   
                    <div class="email-Cancel"><button type="button" onclick="document.getElementById('emailAttendee').style.display='none'" title="Close Page">Cancel</button></div>   
                    <div class="email-Send"><button type="button" onclick="document.getElementById('emailConfirmation').style.display='block';document.getElementById('emailAttendee').style.display='none'" title="Send Email">Send</button></div>         
                </div>
            </div>  
        </div>
        <div id="emailConfirmation" class="modal">
            <div class="modal-content animate">
                <h1>Email sent</h1>
                <button type="button" onclick="document.getElementById('emailConfirmation').style.display='none'" title="Close Page">Return</button>
            </div>        
        </div>
    </div>
    <script>
    $("#tabs").tabs();
    //Function to get current date
    var currentDate = new Date().toISOString().split('T')[0];
    document.getElementsByName("seminarDate")[0].setAttribute('min', currentDate);
        
    var id, email, firstName, lastName, phone, status;
    $(document).ready(function(){
        var table = $('#attendee-list').DataTable( {
            select:{
                items: 'row',
                style: 'single'
            }
        });
        
        $('#attendee-list tbody').on( 'click', 'tr', function () {
            email = table.row( this ).data()[0];
            firstName =  table.row( this ).data()[1];
            lastName = table.row( this ).data()[2];
            phone = table.row( this ).data()[3];
            status = table.row( this ).data()[4];
            id = table.row( this ).data()[5];
            $('#row').val(data);
            
            if ( $(this).hasClass('selected') ){
                $('#editB').prop('disabled', true);
                $('#deleteB').prop('disabled', true);
            }else{
                $('#editB').prop('disabled', false);
                $('#deleteB').prop('disabled', false);
            }
        });
         
        var selectedHost = $("#hostDropdown option:selected").val();
        var data = "host="+selectedHost;
        $.ajax({
            url:"ManageSeminarServlet",
            type: "GET",
            data: data,
            success:function(data){
                $("#hostDropdown").html(data); 
            }
        });
        
        var selectedVenue = $("#venueDropdown option:selected").val();
        data = data+"&venue="+selectedVenue;
        $.ajax({
            url:"ManageSeminarServlet",
            type: "GET",
            data: data,
            success:function(data){
                $("#venueDropdown").html(data);
            }
        });
        
        
    });
    
        $("#hostDropdown").change(function(){
        var selectedHost = $("#hostDropdown option:selected").val();
        var data = "host="+selectedHost;
            $.ajax({
                url:"CreateSeminarServlet",
                type: "GET",
                data: data,
                success:function(data){
                    $("#venueDropdown").html(data);
                }
            });
        }); 
        
    $("#addAttendee").submit(function(event){
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
    
    function autoFillDetails(){
        document.getElementById('attdId').value = id;
        document.getElementById('emailText').value = email;
        document.getElementById('firstNameText').value = firstName;
        document.getElementById('lastNameText').value = lastName;
        document.getElementById('phoneText').value = phone;
        if(status === "Going"){
            $("#going").prop('checked',true);
        }else if(status === "Interested"){
            $("#interested").prop('checked',true);
        }
    }
    
    
    $("#editAttendee").submit(function(event){
        event.preventDefault();
        var submitFlag= $('#editConfirmButton').val();
        var seminarId = $('#seminarId').val();
        var attendeeId = $('#attdId').val();
        var firstName = $('#firstNameText').val();
        var lastName = $('#lastNameText').val();
        var email = $('#emailText').val();
        var phone = $('#phoneText').val();
        var status = $('.state:checked').val();
        var data = 'submit='+submitFlag+'&seminarId='+seminarId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status+"&attdId="+attendeeId;
        $.ajax({
            url:"AttendeeServlet",
            type: "POST",
            data: data,
            success:function(data){
                if(data !== "null"){
                    $('.seminarEditConfirm').html(data);
                }else{
                    return false;
                }
            }
        });
    });
    
    function confirmDelete(){
        document.getElementById('email').textContent = email;
        document.getElementById('firstName').textContent = firstName;
        document.getElementById('lastName').textContent = lastName;
        document.getElementById('attendeeID').value = id;
        document.getElementById('phone').textContent = phone;
        document.getElementById('status').textContent = status;
    }
    
    $("#deleteAttendee").submit(function(event){
        event.preventDefault();
        var submitFlag= $('#deleteConfirmButton').val();       
        var attendeeId = $('#attendeeID').val();
        var firstName = document.getElementById('firstName').textContent;
        var lastName = document.getElementById('lastName').textContent;
        var email = document.getElementById('email').textContent;
        var phone = document.getElementById('phone').textContent;
        var status = document.getElementById('status').textContent;
        var data = 'submit='+submitFlag+"&attdId="+attendeeId+'&attdFName='+firstName+'&attdLName='+
                    lastName+'&attdEmail='+email+'&attdPhone='+phone+
                    '&attdState='+status;
        alert(data);
        $.ajax({
            url:"AttendeeServlet",
            type: "POST",
            data: data,
            success:function(data){
                if(data !== "null"){
                    $('.seminarDeleteConfirm').html(data);
                }else{
                    return false;
                }
            }
        });
    });
    </script>
    </body>
</html>
