<%-- 
    Document   : detail_seminar
    Created on : 26/09/2018, 5:04:58 PM
    Author     : Jackie Yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div>
            <h1> Seminar Name </h1>
            <div class="detail-seminar-grid">
                <div class="detail-seminar-venue"><b>Venue:</b> place</div>
                <div class="detail-seminar-location"><b>Location:</b> place</div>
                <div class="detail-seminar-date"><b>Date:</b> Date</div>
                <div class="detail-seminar-start"><b>Start:</b> Time</div>
                <div class="detail-seminar-end"><b>End:</b> Time</div>
                <div class="detail-seminar-host"><b>Host:</b> Hostname</div>
                <div class="detail-seminar-speaker"><b>Speaker Name </b></div>
                <div class="detail-seminar-speakerV"><textarea name="detailSpeaker" placeholder="Speaker Description" readonly></textarea></div>
                <div class="detail-seminar-desc"><b>Seminar Description</b> </div>
                <div class="detail-seminar-descV"><textarea name="detailSemDesc" placeholder="Seminar Description" readonly></textarea> </div>
                <div class="detail-seminar-register"><button type="button" onclick="document.getElementById('seminarRegister').style.display='block';return false;">Register</button> </div>
            </div>
            <div id="seminarRegister" class="modal" >
                <form class="modal-content animate" name="detailRegAttendeeForm" action="#"  onsubmit="document.getElementById('xxx').style.display='block';return false;"method="POST">
                    <div class="center">
                        <h1>Seminar Name</h1>
                        <table align="center">
                            <tr>
                                <th><b>Venue:</b></th>
                                <th><b>Location:</b></th>
                                <th><b>Date: </b></th>
                            </tr>
                            <tr>
                                <td>xxxxxxxxxxxx</td>
                                <td>yyyyyyyyyyyyyyyyyyyyyyy</td>
                                <td>zzzzzzzzzzzzzzz </td>
                            </tr>
                        </table>
                        <br>
                        <div class="register-grid">
                            <div class="register-Fname">First Name</div>
                            <div class="register-Lname">Last Name</div>    
                            <div class="register-Fname-input"><input type="text" name="regFName" placeholder="First Name" required ></div>
                            <div class="register-Lname-input"><input type="text" name="regLName" placeholder="Last Name" required></div>
                            <div class="register-email">Email</div>   
                            <div class="register-email-input"><input type="email" id="emailInput" name="regEmail" placeholder="JohnDoe@email.com"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required></div>    
                            <div class="register-status">Status</div>   
                            <div class="register-status-Going"><input type="radio" name="status" value="Going"/>Going
                            <div class="register-status-Interested"><input type="radio" name="status" value="Interested"/> Interested</div>
                            <div class="register-submit"><input id="registerButton" type="submit" name="attendeeRegister" value="Confirm"></div>
                            <div class="register-cancel"><button type="button" onclick="document.getElementById('seminarRegister').style.display='none'" title="Close Page">Close</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script>   
    </script>
</html>
