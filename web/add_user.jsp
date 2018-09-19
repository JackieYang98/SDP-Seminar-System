<%-- 
    Document   : add_user
    Created on : 19/09/2018, 5:11:46 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <style>
            #adduser{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
        <h1 style="padding-left:20px;">Add User</h1>
        
        <form action="#createaction" method="POST">

            <div id="add-grid" class="grid-container">
                <div class="add-fname">First Name</div>
                <div class="add-lname">Last Name</div>
                <div class="add-fname-input"><input type="text" name="firstName" placeholder="First Name" required></div>  
                <div class="add-lname-input"><input type="text" name="lastName" placeholder="Last Name" required></div>
                <div class="add-email">Email</div>
                <div class="add-email-input"><input type="email" name="email" placeholder="Email" required></div>
                <div class="add-faculty">Faculty (Optional)</div>
                <div class="add-faculty-input">
                    <select>
                        <option value="feit">Faculty of Engineering and Information Technology</option>
                        <option value="fbs">Business School</option>
                        <option value="fass">Faculty of Arts and Social Sciences</option>
                        <option value="fdab">Faculty of Design, Architecture and Building</option>
                        <option value="fh">Faculty of Health</option>
                        <option value="fl">Faculty of Law</option>
                        <option value="fsci">Faculty of Science</option>
                        <option value="fgh">Graduate School of Health</option>
                        <option value="fti">Faculty of Transdisciplinary Innovation</option>
                    </select>
                </div>
                <div class="add-role">User Role</div>
                <div class="add-role-input">
                    <select class="role-select">
                        <option value="radmin">Administrator</option>
                        <option value="rorganiser" selected>Organiser</option>
                        <option value="rhost">Host</option>
                    </select>
                </div>
                <div class="add-submit"><input id="submitButton" type="submit" name="addUser" value="Register"></div>
            </div>
        </form>
        </div>
    </body>
</html>
