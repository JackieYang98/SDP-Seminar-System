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
               <li> <a href="#edit"> Edit Seminar </a> </li>
               <li> <a href="#attendee"> View attendees list </a> </li>
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
                            </tr>  
                            </c:forEach>
                    </tbody>
                </table>
            <div style="text-align: center">
            <button type="button" onclick="document.getElementById('seminarRegister').style.display='block';return false;" >Register</button>
            <button type="button" onclick="document.getElementById('editAttendee').style.display='block';return false;" >Edit</button>
            <button type="button" onclick="document.getElementById('deleteConfirmation').style.display='block';return false;" >Delete</button>
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
        <div id="editAttendee" class="modal">
            <form class="modal-content animate" action="#" onSubmit="document.getElementById('editConfirmation').style.display='block';return false" method="POST">
                <h1>Edit Attendee</h1>
                <div class="addAttendee-grid">
                    <div class="addAttendee-Fname">First Name</div>
                    <div class="addAttendee-Lname">Last Name</div>    
                    <div class="addAttendee-Fname-input"><input type="text" name="editFirstName" placeholder="First Name" required></div>
                    <div class="addAttendee-Lname-input"><input type="text" name="editLastName" placeholder="Last Name" required></div>
                    <div class="addAttendee-email">Email</div>   
                    <div class="addAttendee-email-input"><input type="email" id="emailInput" name="regEmail" placeholder="JohnDoe@email.com"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required></div>    
                    <div class="addAttendee-status">Status</div>   
                    <div class="addAttendee-status-input">
                        <select>
                            <option value="Going">Going</option>
                            <option value="Interested">Interested</option>
                        </select>
                    </div>    
                    <div class="addAttendee-submit"><input id="editButton" type="submit" name="attendeeEdit" value="Confirm"> </div>
                    <div class="addAttendee-cancel"><button type="button" onclick="document.getElementById('editAttendee').style.display='none'"> Cancel</button></div>
                </div>
            </form>
        </div>
        <div id="editConfirmation" class="modal">
            <div class="modal-content animate">
                <h1>Attendee edited</h1>
                <p> <b>First Name:</b> </p>
                <p> <b>Last Name:</b> Some name here </p>
                <button type="button" onclick="document.getElementById('editConfirmation').style.display='none';document.getElementById('editAttendee').style.display='none'" title="Close Page">Return</button>
            </div>        
        </div>
        <div id="deleteConfirmation" class="modal">
            <div class="modal-content animate">
                <h1>Attendee Deleted</h1>
                <p> <b>First Name:</b> Some name here </p>
                <p> <b>Last Name:</b> Some name here </p>
                <p> <b>Email</b> Some email here </p>
                <button type="button" onclick="document.getElementById('deleteConfirmation').style.display='none'" title="Close Page">Return</button>
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
        
    $(document).ready(function(){
        var table = $('#attendee-list').DataTable( {
            select:{
                items: 'row',
                style: 'single'
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
        
        $('#attendee-list tbody').on( 'click', 'tr', function () {
           var data =  table.row( this ).data();
           $('#row').val(data);
           
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
            alert(data);
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
    </script>
    </body>
</html>
