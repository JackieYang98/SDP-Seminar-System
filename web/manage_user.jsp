<%-- 
    Document   : manage_user
    Created on : 19/09/2018, 5:15:19 PM
    Author     : jingl
--%>

<%@page import="java.util.List"%>
<%@page import="com.sdpseminarsystem.dao.factory.UserDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
    User current = (User) session.getAttribute("user");
    if(current == null){
        //Only for logged in users
%>
        <%@include file="WEB-INF/errors/not_logged_in.jsp" %>
<%
    }else if(current.getUserTypeFlag() != 'a'){
        //Only for Administrator User
%>
        <%@include file="WEB-INF/errors/unauthorized_action.jsp" %>
<%  
    }else {
        //Retrieve the list of all the users
        List<User> allUsers = UserDAOFactory.getInstance().findAll();
        //Set the attribute so it can be retrieved by the JSTL tag
        request.setAttribute("allUsers", allUsers);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/script.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            /*Hightlight the current page*/
            #manageuser{
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="manage-page">
        
            <form action="UserServlet" method="POST">
                <div class="container">
                    <h1>User List</h1>
                    <div id="events"></div>
                    <table id="user-list" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>UTS ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>User Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--For each user in the database, populate the table using JSTL lib-->
                            <c:forEach items="${allUsers}" var="Users">
                            <tr>
                                <td><c:out value="${Users.userId}"/></td>
                                <td><c:out value="${Users.userFirstName}"/></td>
                                <td><c:out value="${Users.userLastName}"/></td>
                                <td><c:out value="${Users.userEmail}"/></td>
                                <td><c:choose>
                                    <c:when test="${Users.userTypeFlag.toString() == 'a'}">
                                        <c:out value="Administrator"/>
                                    </c:when>
                                    <c:when test="${Users.userTypeFlag.toString() == 'o'}">
                                        <c:out value="Organiser"/>
                                    </c:when>
                                    <c:when test="${Users.userTypeFlag.toString() == 'h'}">
                                        <c:out value="Host"/>
                                    </c:when>
                                </c:choose></td>
                            </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                    <!--Add new user and role-->
                    <div class="center">
                    <button type="button" onclick="document.getElementById('addUser').style.display='block'; 
                        return false;">Add</button>
                    </div>
                    
                    <!--Change/Delete selected user role-->
                    <h1>User Role</h1>
                    <div class="add-role-input">
                        <select class="role-select" name="role">
                            <option value="admin">Administrator</option>
                            <option value="organiser" selected>Organiser</option>
                            <option value="host">Host</option>
                        </select>
                    </div>
                    <div class="center">
                    <input id="confirm-delete" type="hidden" name="submit">
                    <input id="row" type="hidden" value="" name="row">
                    <button id="confirm-button" name="update" type="submit" onclick="return updateDelete(this)" disabled="true">Confirm</button>
                    <button id="delete-button" name="delete" type="submit" onclick="return updateDelete(this)" disabled="true">Delete</button>
                    </div>
                </div>           
            </form>
            
            <!--Pop up for add new user-->
            <div class="center">
                <div id="addUser" class="modal">
                    <form name="addUserForm" class="modal-content animate" action="UserServlet" onsubmit="return validateAddUserForm()" method="POST">
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
                                        <option value="admin">Administrator</option>
                                        <option value="organiser" selected>Organiser</option>
                                        <option value="host">Host</option>
                                    </select>
                                </div>
                                <div class="add-submit"><input class="submitB" type="submit" name="addUser" value="Add"></div>
                                <input type="hidden" name="submit" value="create">
                                <div class="add-cancel" onclick="document.getElementById('addUser').style.display='none'"><input class="submitB" type="button" name="addUser" value="Cancel"></div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
        
        <script>
    /*
     * Load these functions on document load
     */
    $(document).ready(function() {
        //Initialize DataTable for user datas
        var table = $('#user-list').DataTable( {
            select:{
                items: 'row',
                style: 'single'
            }
        } );

        /*
         * On any row click, pass data into 'row' ID to pass onto Change role 
         * into userservlet
         */
        $('#user-list tbody').on( 'click', 'tr', function () {
            var data =  table.row( this ).data()[0];
            $('#row').val(data);
            //If any row is selected, enable button, else disable it
            if ( $(this).hasClass('selected') ){
                $('#confirm-button').prop('disabled', true);
                $('#delete-button').prop('disabled', true);
            }else{
                $('#confirm-button').prop('disabled', false);
                $('#delete-button').prop('disabled', false);
            }
        });
        
        //Allow pop up to be close by clicking outside the modal
        closeModal('addUser');
    });
    
    /*
     * Check whether which button was selected by admin, Confirm or Delete
     * 
     * @param String button the button that was clicked.
     */
    function updateDelete(button){
        //Show confirmation alert
        if(confirm("Confirm Action")){
            document.getElementById('confirm-delete').value = button.name;
            return true;
        } else{
            return false;
        }
    }
        </script>
    </body>
</html>     
<%  
}
%>