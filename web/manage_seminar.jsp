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
        <style>
            ul {
                list-style: none;
                padding: 0;
                margin: 0;
            }
            li{
                display: inline;
                border: solid;
                border-width: 1px 1px 0 1px;
                margin: 0 5px 0 0; 
                font-size: 40px
                    
            }
            li a {
                padding: 0 10px;
            }

        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
      <div id="tabs" class="center">
            <ul>
               <li> <a href="#edit"> Edit Seminar </a> </li>
               <li> <a href="#attendee"> View attendees list </a> </li>
            </ul>
            <div id="edit">
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
                        <button type="button" onclick="document.getElementById('deleteConfirm').style.display='none'" title="Close Modal">Return</button>
                    </div>
                </form>
        </div>
        <div id="attendee">
            <p> something attendees </p>
        </div>
    </div>
           <script>
        $("#tabs").tabs();
    </script>
    </body>
</html>
