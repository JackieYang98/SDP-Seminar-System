<%-- 
    Document   : create_seminar
    Created on : 19/09/2018, 5:14:10 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User current = (User) session.getAttribute("user");
    if(current == null){
        //Only for logged in users
%>
        <%@include file="WEB-INF/errors/not_logged_in.jsp" %>
<%
    }else if(current.getUserTypeFlag() != 'h' && current.getUserTypeFlag() != 'o'){
        //Only for Organiser or Host User
%>
        <%@include file="WEB-INF/errors/unauthorized_action.jsp" %>
<%  
    }else {
%>
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
            <form action="CreateSeminarServlet" method="POST">
                <div class="grid-container">
                    <div class="grid-sem-name">Seminar Name</div>
                    <div class="grid-sem-desc">Seminar Description</div>
                    <div class="grid-sem-name-input"><input type="text" name="seminarName" placeholder="Name" required style="width:530px; height:40px;"></div>  
                    <div class="grid-sem-desc-input"><textarea class="desctext" name="seminarDescription" placeholder="About the seminar..." required></textarea></div>  
                    <div class="grid-host">Host</div>
                    <div class="grid-host-input">
                        <select name="seminarHost" id="hostDropdown"></select>
                    </div>
                    <div class="grid-ven-loc">Venue</div>
                    <div class="grid-ven-loc-input">                     
                        <select name='venueName'  id="venueDropdown" >
                            <option value="" disabled selected>-- Select a host to display venue --</option>
                        </select>
                    </div>                   
                    <div class="grid-sem-date">Seminar Date</div>
                    <div class="grid-start">Start Time</div>
                    <div class="grid-end">End Time</div>
                    <div class="grid-sem-date-input"><input type="date" name="seminarDate"  required style="width: 150px; height:40px;"></div>
                    <div class="grid-start-input"><input type="time" name="seminarStart" required style="width: 150px; height:40px;"></div>
                    <div class="grid-end-input"><input type="time" name="seminarEnd" required style="width: 150px; height:40px;"></div>
                    <div class="grid-speaker">Speaker 1</div>
                    
                    <div class="grid-cover-photo">Cover Photo</div>
                    <div class="grid-speaker-input"><input class="speakerNameText" type="text" name="speakerName" placeholder="Speaker Name" required></div>
                    
                    <div class="grid-image"><img id="image" src="image/building.jpg" alt="UTS Logo" style="width: 350px; height:250px;"></div>
                    <div class="grid-image-input"><input id="image-input" type="file" name="seminarImage"></div>
                    <div class="grid-bio">Speaker 1 Biography</div>
                    <div class="grid-bio-input"><textarea class="biotext" name="speakerBio" placeholder="About the speaker..." required></textarea></div>
                    <div onclick='hide("speaker2")' class="grid-speaker2" style="cursor: pointer; text-decoration: underline; ">Speaker 2 (Click to Toggle)</div>
                    <div id="speaker2" class="grid-speaker2-input" style="display: none;">
                        <div><input type="text" name="speakerTwoName" placeholder="Speaker 2 Name" ></div>
                        <div>Speaker 2 Biography</div>
                        <div><textarea class="biotext" name="speakerTwoBio" placeholder="About the second speaker..."></textarea></div>
                            <div onclick='hide("speaker3")' class="grid-speaker3" style="cursor: pointer; text-decoration: underline;">Speaker 3 (Click to Toggle)</div>
                            <div id="speaker3" class="grid-speaker3-input" style="display: none;">
                                <div><input type="text" name="speakerThreeName" placeholder="Speaker 3 Name" ></div>
                                <div>Speaker 3 Biography</div>
                                <div><textarea class="biotext" name="speakerThreeBio" placeholder="About the third speaker..."></textarea></div>
                            </div>
                    </div>
                    <input type="hidden" value="<%=current.getUserId()%>" name="organiser">
                    <div class="grid-submit"><input class="submitButton" type="submit" name="seminarSubmit" value="Create Seminar"></div>
                </div>
            </form>
        </div>
        <script>
    $('#image-input').onchange = function(e) {
    // Get the first file in the FileList object
    var imageFile = this.files[0];
    // get a local URL representation of the image blob
    var url = window.URL.createObjectURL(imageFile);
    // Now use your newly created URL!
    $('#image').src = url;
    }
            
    $(document).ready(function(){
    //Function to get current date
    var currentDate = new Date().toISOString().split('T')[0];
    document.getElementsByName("seminarDate")[0].setAttribute('min', currentDate);
    
        $.ajax({
            url:"CreateSeminarServlet",
            type: "GET",
        success:function(data){
            $("#hostDropdown").html(data); 
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
    
        </script>
    </body>
</html>
<%  
}
%>