<%-- 
    Document   : manage_user
    Created on : 19/09/2018, 5:15:19 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            #manageuser{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
        <h1 style="padding-left:20px;">Manage User</h1>
        <form action="#createaction" method="POST">
            <div id="manage-grid" class="grid-container">
                <div class="manage-browse"><button type="button" onclick="document.getElementById('userList').style.display='block';return false;" style="width:auto">BROWSE</button></div>
                <div class="manage-fname">First Name</div>
                <div class="manage-lname">Last Name</div>
                <div class="manage-fname-input"><input type="text" name="firstName" placeholder="First Name" required></div>  
                <div class="manage-lname-input"><input type="text" name="lastName" placeholder="Last Name" required></div>
                <div class="manage-email">Email</div>
                <div class="manage-email-input"><input type="email" name="email" placeholder="Email" required></div>
                <div class="manage-faculty">Faculty (Optional)</div>
                <div class="manage-faculty-input">
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
                <div class="manage-role">User Role</div>
                <div class="manage-role-input">
                    <select class="role-select">
                        <option value="radmin">Administrator</option>
                        <option value="rorganiser" selected>Organiser</option>
                        <option value="rhost">Host</option>
                    </select>
                </div>
                <div class="manage-submit"><input id="submitButton" type="submit" name="userConfirm" value="Confirm"></div>
                <div class="manage-delete"><input id="submitButton" type="submit" name="userDelete" value="Delete"></div>
            </div>
        </form>
        </div>
        
        <div id="userList" class="modal">
            <form class="modal-content animate" action="manage_user.html" method="POST">
            <div class="container">
                <h1>User List</h1>
                <table class="user-list">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>First</th>
                            <th>Last</th>
                            <th>Faculty</th>
                            <th>User Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>PeterParker@oscorp.com</td>
                            <td>Peter</td>
                            <td>Parker</td>
                            <td>FEIT</td>
                            <td>Admin</td>
                        </tr>
                    </tbody>
                </table>
                <button type="submit">Add</button>
                <button type="button" onclick="document.getElementById('userList').style.display='none'" title="Close Modal">Cancel</button>
            </div>
        </form>
    </div>
    </body>
</html>