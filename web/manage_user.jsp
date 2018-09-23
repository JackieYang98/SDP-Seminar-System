<%-- 
    Document   : manage_user
    Created on : 19/09/2018, 5:15:19 PM
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
    }else {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            #manageuser{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="manage-page">
        
            <form action="manage_user.jsp" method="POST">
                <div class="container">
                    <h1>User List</h1>
                    <table class="user-list">
                        <thead>
                            <tr>
                                <th>UTS ID</th>
                                <th>First</th>
                                <th>Last</th>
                                <th>Email</th>
                                <th>User Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>12491508</td>
                                <td>Peter</td>
                                <td>Parker</td>
                                <td>PeterParker@oscorp.com</td>
                                <td>Admin</td>
                            </tr>
                            <tr>
                                <td>12491508</td>
                                <td>Peter</td>
                                <td>Parker</td>
                                <td>PeterParker@oscorp.com</td>
                                <td>Organiser</td>
                            </tr>
                            <tr>
                                <td>12491508</td>
                                <td>Peter</td>
                                <td>Parker</td>
                                <td>PeterParker@oscorp.com</td>
                                <td>Host</td>
                            </tr>
                            <tr>
                                <td>12491508</td>
                                <td>Peter</td>
                                <td>Parker</td>
                                <td>PeterParker@oscorp.com</td>
                                <td>Admin</td>
                            </tr>
                            <tr>
                                <td>12491508</td>
                                <td>Peter</td>
                                <td>Parker</td>
                                <td>PeterParker@oscorp.com</td>
                                <td>Admin</td>
                            </tr>
                            
                        </tbody>
                    </table>
                    <div class="center">
                    <button type="button" onclick="document.getElementById('addUser').style.display='block'; 
                        return false;">Add</button>
                    </div>

                    <h1>User Role</h1>
                    <div class="add-role-input">
                        <select class="role-select">
                            <option value="radmin">Administrator</option>
                            <option value="rorganiser" selected>Organiser</option>
                            <option value="rhost">Host</option>
                        </select>
                    </div>
                    <div class="center">
                    <button type="submit">Confirm</button>
                    <button type="submit">Delete</button>
                    </div>
                </div>           
            </form>
            <div class="center">
                <div id="addUser" class="modal">
                    <form name="addUserForm" class="modal-content animate" action="#" onsubmit="return validateAddUserForm()" method="POST">
                        <h2>Add User</h2>
                        <div id="add-grid" class="container">
                            <div class="add-id">UTS ID</div>
                            <div class="add-id-input"><input type="text" name="userid" placeholder="UTS ID" required pattern="^[0-9]{0,8}$"></div>
                            <div class="add-fname">First Name</div>
                            <div class="add-lname">Last Name</div>
                            <div class="add-fname-input"><input type="text" name="fName" placeholder="First Name" required pattern="^[A-Za-z]+$"></div>  
                            <div class="add-lname-input"><input type="text" name="lName" placeholder="Last Name" required pattern="^[A-Za-z]+$"></div>
                            <div class="add-email">Email</div>
                            <div class="add-email-input"><input type="text" name="email" placeholder="Email" required pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$"></div>
                            <div class="add-password">Password</div>
                            <div class="add-password-input"><input type="password" name="password" placeholder="Password" required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"></div>
                            <div class="add-role">User Role</div>
                            <div class="add-role-input">
                                <select class="role-select" name="role">
                                    <option value="radmin">Administrator</option>
                                    <option value="rorganiser" selected>Organiser</option>
                                    <option value="rhost">Host</option>
                                </select>
                            </div>
                            <div class="add-submit"><input class="submitButton" type="submit" name="addUser" value="Add"></div>
                            <div class="add-cancel" onclick="document.getElementById('addUser').style.display='none'"><input class="submitButton" type="button" name="addUser" value="Cancel"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>     
<%  
}
%>