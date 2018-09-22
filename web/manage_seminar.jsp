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
        <script src="scripts/script.js"></script>
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
                        <div class="grid-ven-name-input">                     
                            <select name='venueName' id="selectDropdown">
                            <option value="Room 1">Room 1</option>
                            <option value="Room 2">Room 2</option>
                            <option value="Room 3">Room 3</option>
                            <option value="Room 4">Room 4..etc</option>
                            </select>
                        </div>
                        <div class="grid-ven-loc-input"><input type="text" name="venueLocation" placeholder="Venue Location (CBXX.YY.ZZZ)" required></div>
                        <div class="grid-sem-date">Seminar Date</div>
                        <div class="grid-start">Start Time</div>
                        <div class="grid-end">End Time</div>
                        <div class="grid-sem-date-input"><input type="date" name="seminarDate"  required style="width: 150px; height:40px;"></div>
                        <div class="grid-start-input"><input type="time" name="seminarStart" required style="width: 150px; height:40px;"></div>
                        <div class="grid-end-input"><input type="time" name="seminarEnd" required style="width: 150px; height:40px;"></div>
                        <div class="grid-speaker">Speaker 1</div>
                        <div class="grid-host">Host</div>
                        <div class="grid-cover-photo">Cover Photo</div>
                        <div class="grid-speaker-input"><input class="speakerNameText" type="text" name="speakerName" placeholder="Speaker Name" required></div>
                        <div class="grid-host-input">
                            <select name="seminarHost" id="selectDropdown">
                                <option value="Host 1">Host 1</option>
                                <option value="Host 2">Host 2</option>
                                <option value="Host 3">Host 3</option>
                                <option value="Host 4">Host 4..etc</option>
                            </select>
                        </div>
                        <div class="grid-image"><img src="image/building.jpg" alt="UTS Logo" style="width: 350px; height:250px;"></div>
                        <div class="grid-image-input"><input type="file" name="seminarImage"></div>
                        <div class="grid-bio">Speaker 1 Biography</div>
                        <div class="grid-bio-input"><textarea class="biotext" name="speakerBio" placeholder="About the speaker..." required></textarea></div>
                        <div class="grid-speaker2">Speaker 2</div>
                        <div class="grid-speaker2-input"><input type="text" name="speaker2Name" placeholder="Speaker 2 Name (Optional)" ></div>
                        <div class="grid-bio2">Speaker 2 Biography</div>
                        <div class="grid-bio2-input"><textarea class="biotext" name="speakerBio2" placeholder="About the second speaker... (Optional)"></textarea></div>
                        <div class="grid-speaker3">Speaker 3</div>
                        <div class="grid-speaker3-input"><input type="text" name="speaker3Name" placeholder="Speaker 3 Name (Optional)" ></div>
                        <div class="grid-bio3">Speaker 3 Biography</div>
                        <div class="grid-bio3-input"><textarea class="biotext" name="speakerBio3" placeholder="About the third speaker... (Optional)"></textarea></div>
                        <div class="grid-delete"><input class="deleteButton" type="button" name="seminarDelete" value="Delete Seminar" onclick="document.getElementById('deleteConfirm').style.display='block';return false;"></div>
                        <div class="grid-submit"><input class="submitButton" type="submit" name="seminarSubmitUpdate" value="Update Seminar"></div>                       
                    </div>
                </form>
        </div>
        <div id="deleteConfirm" class="modal">
                <form class="modal-content animate" method="POST">
                    <div class="container">
                        <h1>Seminar Deleted</h1>
                        <p> <b>Seminar Name:</b> Some name here </p>
                        <button type="button" onclick="document.getElementById('deleteConfirm').style.display='none'" title="Close Page">Return</button>
                    </div>
                </form>
        </div>
        <div id="attendee">
            <h1> Attendees </h1>
                <table class="attendee-list">
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
                        <td>Never</td>
                        <td>Gonna</td>
                        <td>Going</td>
                    </tr> 
                    <tr>
                        <td>bob@gmail.com</td>
                        <td>Give</td>
                        <td>You</td>
                        <td>Going</td>
                    </tr>            
                    <tr>
                        <td>bob@gmail.com</td>
                        <td>Up</td>
                        <td>Never</td>
                        <td>Going</td>
                    </tr>        
                    <tr>
                        <td>bob@gmail.com</td>
                        <td>Gonna</td>
                        <td>Let</td>
                        <td>Going</td>
                    </tr> 
                    <tr>
                        <td>bob@gmail.com</td>
                        <td>You</td>
                        <td>Down</td>
                        <td>Going</td>
                    </tr> 
                    </tbody>
                    
                </table>
            <button id="attendeeButtons" type="button" onclick="document.getElementById('Register').style.display='block';return false;" style="text-align: center;">Register</button>
            <button id="attendeeButtons" type="button" onclick="document.getElementById('editAttendee').style.display='block';return false;" style="text-align: center;">Edit</button>
            <button id="attendeeButtons" type="button" onclick="document.getElementById('deleteConfirmation').style.display='block';return false;" style="text-align: center;">Delete</button>
            <br>
            <button id="attendeeButtons" type="button" onclick="document.getElementById('printTags').style.display='block';return false;" style="text-align: center;">Print Tags</button>
            <button id="attendeeButtons" type="button" onclick="document.getElementById('emailAttendee').style.display='block';return false;" style="text-align: center;">Email</button>
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
            <div class="modal-content animate">
                <h1>Registration Complete</h1>
                <p> <b>First Name:</b> Some name here </p>
                <p> <b>Last Name:</b> Some name here </p>
                <button type="button" onclick="document.getElementById('Confirmation').style.display='none'" title="Close Page">Return</button>
            </div>        
        </div>
        <div id="editAttendee" class="modal">
            <form class="modal-content animate" action="#" method="POST">
                <h1>Edit Attendee</h1>
                <div class="register-grid">
                    <div class="register-Fname">First Name</div>
                    <div class="register-Lname">Last Name</div>    
                    <div class="register-Fname-input"><input type="text" name="editFirstName" placeholder="First Name" required></div>
                    <div class="register-Lname-input"><input type="text" name="editLastName" placeholder="Last Name" required></div>
                    <div class="register-email">Email</div>   
                    <div class="register-email-input"><input type="text" name="editEmail" placeholder="JohnDoe@email.com" required></div>    
                    <div class="register-status">Status</div>   
                    <div class="register-status-input">
                        <select>
                            <option value="Going">Going</option>
                            <option value="Interested">Interested</option>
                        </select>
                    </div>    
                    <div class="register-submit"><input id="editButton" type="submit" name="attendeeEdit" value="Confirm" onclick="document.getElementById('editConfirmation').style.display='block';document.getElementById('editAttendee').style.display='none';return false;"></div>
                    <div class="register-cancel"><button type="button" onclick="document.getElementById('editAttendee').style.display='none'"> Cancel</button></div>
                </div>
            </form>
        </div>
        <div id="editConfirmation" class="modal">
            <div class="modal-content animate">
                <h1>Attendee edited</h1>
                <p> <b>First Name:</b> Some name here </p>
                <p> <b>Last Name:</b> Some name here </p>
                <button type="button" onclick="document.getElementById('editConfirmation').style.display='none'" title="Close Page">Return</button>
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
    </script>
    </body>
</html>
