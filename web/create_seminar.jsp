<%-- 
    Document   : create_seminar
    Created on : 19/09/2018, 5:14:10 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="scripts/script.js"></script>
    <link rel="stylesheet" type="text/css" href="css/layout.css">
    <title>Create seminar</title>
    <style>
            #createseminar{
                text-decoration: underline;
            }
    </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
        <h1 style="padding-left:20px;">Create Seminar</h1>
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
                    <a class="clickMe">Toggle my text</a>
                    <div class="grid-speaker2">Speaker 2</div>
                    <div class="grid-speaker2-input"><input type="text" name="speaker2Name" placeholder="Speaker 2 Name (Optional)" ></div>
                    <div class="grid-bio2">Speaker 2 Biography</div>
                    <div class="grid-bio2-input"><textarea class="biotext" name="speakerBio2" placeholder="About the second speaker... (Optional)"></textarea></div>
                    <div class="grid-speaker3">Speaker 3</div>
                    <div class="grid-speaker3-input"><input type="text" name="speaker3Name" placeholder="Speaker 3 Name (Optional)" ></div>
                    <div class="grid-bio3">Speaker 3 Biography</div>
                    <div class="grid-bio3-input"><textarea class="biotext" name="speakerBio3" placeholder="About the third speaker... (Optional)"></textarea></div>
                    <div class="grid-submit"><input class="submitButton" type="submit" name="seminarSubmit" value="Create Seminar"></div>
                </div>
            </form>
        </div>
    </body>
    <script>
        $(function () {
    $(".textBox").hide();
    $('a.clickMe').click(function () {
        var thisElem = this;
        var isVisibe = $(thisElem).nextAll('div.grid-speaker2:first').is(":visible");
        $(".grid-speaker2").each(function(i,elem){
            console.error(thisElem,elem)
        	if(thisElem!==elem){
            	$(elem).hide();
            }
        });
       // if()
        $(thisElem).nextAll('div.grid-speaker2')[isVisibe ? "hide" : "show"]();
        $(thisElem).nextAll('.clickMe:first').nextAll("div.grid-speaker2").hide();
    });
});
    </script>
</html>
