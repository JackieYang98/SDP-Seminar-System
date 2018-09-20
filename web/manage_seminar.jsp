<%-- 
    Document   : manage_seminar
    Created on : 19/09/2018, 5:18:07 PM
    Author     : jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script src="script.js"></script>
        <title>Manage Seminar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
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
                <form action="#createaction" method="POST">  
                    <div class="grid-container">
                        <div class="grid-sem-name">Seminar Name</div>
                        <div class="grid-sem-desc">Seminar Description</div>
                        <div class="grid-sem-name-input"><input type="text" name="seminarName" placeholder="Name" required style="width:530px; height:40px;"></div>  
                        <div class="grid-sem-desc-input"><textarea class="desctext" name="seminarDescription" placeholder="About the seminar..." required></textarea></div>
                        <div class="grid-ven-name">Venue Name</div>
                        <div class="grid-ven-loc">Venue Location</div>
                        <div class="grid-ven-name-input"><input type="text" name="venueName" placeholder="Venue Name" required></div>
                        <div class="grid-ven-loc-input"><input type="search" name="venueLocation" placeholder="Venue Address..." required ></div>
                        <div class="grid-sem-date">Seminar Date</div>
                        <div class="grid-start">Start Time</div>
                        <div class="grid-end">End Time</div>
                        <div class="grid-sem-date-input"><input type="date" name="seminarDate"  required style="width: 150px; height:40px;"></div>
                        <div class="grid-start-input"><input type="time" name="seminarStart" required style="width: 150px; height:40px;"></div>
                        <div class="grid-end-input"><input type="time" name="seminarEnd" required style="width: 150px; height:40px;"></div>
                        <div class="grid-speaker">Speaker</div>
                        <div class="grid-host">Host</div>
                        <div class="grid-cover-photo">Cover Photo</div>
                        <div class="grid-speaker-input"><input type="text" name="speakerName" placeholder="Speaker Name" required></div>
                        <div class="grid-host-input"><input type="text" name="seminarHost" placeholder="Host Name" required></div>
                        <div class="grid-image"><img src="image/building.jpg" alt="UTS Logo" style="width: 350px; height:250px;"></div>
                        <div class="grid-image-input"><input type="file" name="seminarImage"></div>
                        <div class="grid-bio">Speaker Biography</div>
                        <div class="grid-bio-input"><textarea class="biotext" name="speakerBio" placeholder="About the speaker..." required></textarea></div>
                        <div class="grid-delete"><input id="deleteButton" type="button" name="seminarDelete" value="Delete Seminar" onclick="document.getElementById('deleteConfirm').style.display='block';return false;"></div>
                        <div class="grid-submit"><input id="submitButton" type="submit" name="seminarSubmitUpdate" value="Update Seminar"></div>
                    </div>
                </form>
        </div>
        <div id="deleteConfirm" class="modal">
                <form class="modal-content animate" method="POST">
                    <div class="container">
                        <h1>Seminar Deleted</h1>
                        <p> <b>Seminar Name:</b> Some name here </p>
                        <button type="button" onclick="document.getElementById('deleteConfirm').style.display='none'" title="Close Modal">Return</button>
                    </div>
                </form>
        </div>
        <div id="attendee">
            <h1> Attendees </h1>
                <table class="user-list">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>bob@gmail.com</td>
                            <td>Rick</td>
                            <td>Rolled</td>
                            <td>Going</td>
                        </tr>                            
                    </tbody>
                </table>

                    <button id="attendeeButtons" type="button" onclick="document.getElementById('Register').style.display='block';return false;" style="text-align: center;">Register</button>
                    <button id="attendeeButtons" type="button" onclick="document.getElementById('Edit').style.display='block';return false;" style="text-align: center;">Edit</button>
                    <button id="attendeeButtons" type="button" onclick="document.getElementById('Delete').style.display='block';return false;" style="text-align: center;">Delete</button>
                    <br>
                    <button id="attendeeButtons" type="button" onclick="document.getElementById('PrintTags').style.display='block';return false;" style="text-align: center;">Print Tags</button>
                    <button id="attendeeButtons" type="button" onclick="document.getElementById('Email').style.display='block';return false;" style="text-align: center;">Email</button>
        </div>
        <div id="Register" class="modal">
            <form class="modal-content animate" action="#" method="POST">
                <h1>Add Attendee</h1>
                <div class="register-grid">
                    <div class="register-Fname">First Name</div>
                    <div class="register-Lname">Last Name</div>    
                    <div class="register-Fname-input"><input type="text" name="FirstName" placeholder="First Name" required></div>
                    <div class="register-Lname-input"><input type="text" name="LastName" placeholder="Last Name" required></div>
                    <div class="register-email">Email</div>   
                    <div class="register-email-input"><input type="text" name="email" placeholder="JohnDoe@email.com" required></div>    
                    <div class="register-status">Status</div>   
                    <div class="register-status-input">
                        <select>
                            <option value="Going">Going</option>
                            <option value="Interested">Interested</option>
                        </select>
                    </div>    
                    <div class="register-submit"><input id="registerButton" type="submit" name="attendeeRegister" value="Confirm" onclick="document.getElementById('Confirmation').style.display='block';document.getElementById('Register').style.display='none';return false;"></div>
                    <div class="register-cancel"><button type="button" onclick="document.getElementById('Register').style.display='none'"> Cancel</button></div>
                </div>
            </form>
        </div>
        <div id="Confirmation" class="modal">
            <div class="container">
                <h1>Registration Complete</h1>
                <p> <b>First Name:</b> Some name here </p>
                <p> <b>Last Name:</b> Some name here </p>
                <button type="button" onclick="document.getElementById('Confirmation').style.display='none'" title="Close Modal">Return</button>
            </div>        
        </div>
    </div>
    <script>
        $("#tabs").tabs();
    </script>
    </body>
</html>
