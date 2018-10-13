<%-- 
    Document   : faq
    Created on : 13/10/2018, 4:41:55 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpenSem Help Page</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            /*Hightlight the current page*/
            #faq{
                text-decoration: underline;
            }         
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div style="text-align: left; width: 50%; margin: auto; padding-bottom: 50px;">
            <div class="center">
            <h1>Frequently Ask Questions!</h1>  
            </div>
            <hr>
            <p><b>Do I have to sign up to attend a seminar?</b></p>
            <p>No, you do not need to sign up to attend any seminar.</p>
            
            <p><b>How do I register to attend a seminar?</b></p>
            <p>To register to attend, Enter the seminar and click 'Register',
            only Name, email, and phone number are required to register.</p>
            
            <p><b>What is the difference between 'Going' and 'Interested' status?</b></p>
            <p>Going means attendee are confirm to attend a seminar, and organiser can
               better prepare for the attendee on the day. Interested means attendee can 
               be notified regarding the update on the seminar, so attendee can 
               change the status later on.</p>
            
            <p><b>How do I edit my detail and status?</b></p>
            <p>Go to the seminar page that you have registered, click on 'Register',
               You will see 'Already Registered? Click here', simply enter the 
               email you registered with to edit all your details, and 'confirm'</p>
            
            <p><b>How do I delete my registration from a seminar?</b></p>
            <p>Go to the seminar page that you have registered, click on 'Register',
               You will see 'Already Registered? Click here', simply enter the 
               email you registered with to edit all your details, including
               deleting your details.</p>
            
            <h2>Any more question, please contact us at:</h2>
            <h3>General enquiries:</h3>
            <p>Telephone: +61 2 9514 2000</p>
            <h3>Student Centre enquiries:</h3>
            <p>Telephone: 1300 ASK UTS (1300 275 887)</p>
        </div>
    </body>
</html>
