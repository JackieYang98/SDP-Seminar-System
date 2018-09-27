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
        <div class="center">
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
                <form class="modal-content animate" name="detailRegAttendeeForm" action="#"  onsubmit="document.getElementById('seminarConfirm').style.display='block';return false;"method="POST">
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
                            <div class="register-status-Going"><input type="radio" name="status" value="Going" required/>Going </div>
                            <div class="register-status-Interested"><input type="radio" name="status" value="Interested"/> Interested</div>
                            <div class="register-registered"><label onclick="document.getElementById('seminarRegistered').style.display='block';document.getElementById('seminarRegister').style.display='none'"> Already registered?</label></div>  
                            <div class="register-submit"><input id="registerButton" type="submit" name="attendeeRegister" value="Confirm"></div>
                            <div class="register-cancel"><button type="button" onclick="document.getElementById('seminarRegister').style.display='none'" title="Close Page">Close</button></div>
                        </div>
                    </div>
                </form>
            </div>
            <div id="seminarRegistered" class="modal">
                <div align="center">
                    <form class="modal-content animate" name="detailRegisteredEmailForm" action="#"  onsubmit="document.getElementById('seminarRegisterEdit').style.display='block'; document.getElementById('seminarRegistered').style.display='none';return false;"method="POST">
                        <h1>Enter your email</h1>
                        <br> <br>
                        <div class="registered-grid">
                            <div class="registered-email">Email: </div>
                            <div class="registered-email-input"><input type="email" name="regEmail" placeholder="JohnDoe@email.com"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required> </div>
                            <div class="registered-submit"><input id="registerButton" type="submit" name="seminarRegisteredSubmit" value="Confirm"> </div>
                        </div>
                    </form>
                </div> 
             </div>
            <div id="seminarRegisterEdit" class="modal" >
                <form class="modal-content animate" name="detailRegAttendeeEditForm" action="#"  onsubmit="document.getElementById('seminarEditConfirm').style.display='block';return false;"method="POST">
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
                        <div class="registerEdit-grid">
                            <div class="registerEdit-Fname">First Name</div>
                            <div class="registerEdit-Lname">Last Name</div>    
                            <div class="registerEdit-Fname-input"><input type="text" name="regFName" placeholder="First Name" required ></div>
                            <div class="registerEdit-Lname-input"><input type="text" name="regLName" placeholder="Last Name" required></div>
                            <div class="registerEdit-email">Email</div>   
                            <div class="registerEdit-email-input"><input type="email" id="emailInput" name="regEmail" placeholder="JohnDoe@email.com"  pattern=".+@([\w-]+\.)+[\w-]{2,4}$" required></div>    
                            <div class="registerEdit-status">Status</div>   
                            <div class="registerEdit-status-Going"><input type="radio" name="status" value="Going" required/>Going </div>
                            <div class="registerEdit-status-Interested"><input type="radio" name="status" value="Interested"/> Interested</div>
                            <div class="registerEdit-registered"><label onclick="document.getElementById('seminarRegistered').style.display='block';document.getElementById('seminarRegister').style.display='none'"> Already registered?</label></div>  
                            <div class="registerEdit-submit"><input id="registerButton" type="submit" name="seminarRegisterEditSubmit" value="Confirm"></div>
                            <div class="registerEdit-delete"><button type="button" onclick="document.getElementById('seminarRegisterDelete').style.display='block'">Delete</button></div>
                        </div>
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
                            <td>xxxxxxxxxxxx</td>
                            <td>yyyyyyyyyyyyyyyyyyyyyyy</td>
                            <td>zzzzzzzzzzzzzzz </td>
                        </tr>
                    </table>
                    <p> <b>First Name:</b> Some name here </p>
                    <p> <b>Last Name:</b> Some name here </p>
                    <p> <b>Email: </b> Some email here </p>
                    <p> <b>Status: </b> Some status here </p>
                    <button type="button" onclick="document.getElementById('seminarConfirm').style.display='none';document.getElementById('seminarRegister').style.display='none'" title="Close Page">Return</button>
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
                            <td>xxxxxxxxxxxx</td>
                            <td>yyyyyyyyyyyyyyyyyyyyyyy</td>
                            <td>zzzzzzzzzzzzzzz </td>
                        </tr>
                    </table>
                    <p> <b>First Name:</b> Some name here </p>
                    <p> <b>Last Name:</b> Some name here </p>
                    <p> <b>Email: </b> Some email here </p>
                    <p> <b>Status: </b> Some status here </p>
                    <button type="button" onclick="document.getElementById('seminarEditConfirm').style.display='none';document.getElementById('seminarRegisterEdit').style.display='none';" title="Close Page">Return</button>
                </div> 
            </div>
            <div id="seminarRegisterDelete" class="modal">
                <div class="modal-content animate">
                    <h1>You have been removed from the seminar</h1>
                    <p><b>Seminar Name: </b> Some name here</p>
                    <p> <b>First Name:</b> Some name here </p>
                    <p> <b>Last Name:</b> Some name here </p>
                    <p> <b>Email</b> Some email here </p>
                    <button type="button" onclick="document.getElementById('seminarRegisterDelete').style.display='none';document.getElementById('seminarRegisterEdit').style.display='none'" title="Close Page">Return</button>
                </div>        
            </div>
        </div>
    </body>
    <script>   
    </script>
</html>
