<%-- 
    Document   : header
    Created on : 19/09/2018, 4:13:49 PM
    Author     : jingl
--%>

<%@page import="com.sdpseminarsystem.vo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") == null) { %>
        <div class="navbar">
            <a href="https://www.uts.edu.au/">
                <h1><img id="logo" src="image/uts.png" alt="UTS Logo"></h1>
            </a>
            <div class="userfeatures">
                <a id="browse" href="/SDP-Seminar-System/index.jsp">Browse</a>
                <a id="login" href="#" onclick="document.getElementById('loginForm').style.display='block';return false;" style="width:auto" >Login</a>            
            </div>
    </div>      
    <%
        }else{
        User user = (User) session.getAttribute("user");
        String type;
        if(user.getUserTypeFlag() == 'a'){
            type = "Admin";
        } else if (user.getUserTypeFlag() == 'h'){
            type = "Host";
        } else{
            type = "Organiser";
        }
    %>
    <div class="navbar">
            <a href="https://www.uts.edu.au/">
                <h1><img id="logo" src="image/uts.png" alt="UTS Logo"></h1>
            </a>
            <div class="userfeatures">
                <a id="browse" href="/SDP-Seminar-System/index.jsp">Browse</a>
                <%if(user.getUserTypeFlag()=='a'){%><a id="manageuser" href="/SDP-Seminar-System/manage_user.jsp">Manage User</a><%}%>
                <%if(user.getUserTypeFlag()!='a'){%>
                    <a id="createseminar" href="/SDP-Seminar-System/create_seminar.jsp">Create Seminar</a>
                <%}%>
                <a id="login" style="width:auto" ><%=user.getUserFirstName() + " " + user.getUserLastName()%> as <%=type%></a>
                <a id="logout" href="LogoutServlet"><img src="image/logout.png" style="width:25px;height: 25px;"></a>
            </div>
    </div> 
    <% } %>
    <div id="loginForm" class="modal">
        <form id="login-form" class="modal-content animate" action="login" method="POST">
            <div class="imgcontainer">
                <img src="image/uts_logo.png" alt="logo" class="avatar">
                <span onclick="document.getElementById('loginForm').style.display='none'" class="close" title="Close Modal">&times;</span>
            </div>
            <div class="container">
                <h1>Log in</h1>
                <label for="username"><b>Username</b></label>
                <input id="username" type="text" placeholder="Staff or student number" name="username" required                 
                       pattern="^[0-9]{0,8}$" autofocus>
                <label for="password"><b>Password</b></label>
                <input id="password" type="password" placeholder="UTS Password" name="password" required>
                <a href="https://email.itd.uts.edu.au/webapps/myaccount/passwordreset/">Forget your Password?<br></a>
                <button type="submit">Login</button>
                <div id="messageDiv"></div>
            </div>
        </form>
    </div>
            
    <script>
        $("#login-form").submit(function(event){
            event.preventDefault();
            var username = $('#username').val();
            var password = $('#password').val();
            var data = 'username=' +username+'&password='+password;
                $.ajax({
                    type: "POST",
                    url: "LoginServlet",
                    data: data,
                    success: function(data)
                    {
                        if(data !== "invalid"){
                            window.location = "index.jsp";
                        }else{
                            $("#messageDiv").html('<span class="error" style="color: red">' + "Invalid Username and/or Password" + '</span>');  
                        }
                    },
                    error:function(xhr, ajaxOptions, thrownError){
                        alert(xhr.status + " " + thrownError + " Please come back soon while the server reload.");  
                    }                         
                });
                return false;
            });
    </script>
            
    
    <!--oninvalid="this.setCustomValidity('Please enter your ID')"--> 

<!--pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$">-->

