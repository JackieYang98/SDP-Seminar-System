<%-- 
    Document   : header
    Created on : 19/09/2018, 4:13:49 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <% 
    if(request.getParameter("username")== null){ %>
        <div class="navbar">
            <a href="https://www.uts.edu.au/">
                <h1><img id="logo" src="image/uts.png" alt="UTS Logo"></h1>
            </a>
            <div class="userfeatures">
                <a id="browse" href="index.jsp">Browse</a>
                <a id="login" href="#" onclick="document.getElementById('loginForm').style.display='block';return false;" style="width:auto" >Login</a>            
            </div>
    </div>      
    <%}else{
        String n = request.getParameter("username");
//        session.setAttribute("user", user);   
    %>
    <div class="navbar">
            <a href="https://www.uts.edu.au/">
                <h1><img id="logo" src="image/uts.png" alt="UTS Logo"></h1>
            </a>
            <div class="userfeatures">
                <a id="browse" href="index.jsp">Browse</a>
                <a id="manageuser" href="manage_user.jsp">Manage User</a>
                <a id="createseminar" href="create_seminar.jsp">Create Seminar</a>
               
                <a id="login" href="index.jsp" onclick="<% session.invalidate(); %> " style="width:auto" >Login as <%=n%></a>
            </div>
    </div> 
    <% } %>
    <div id="loginForm" class="modal">
        <form class="modal-content animate" action="login" method="POST">
            <div class="imgcontainer">
                <img src="image/uts_logo.png" alt="logo" class="avatar">
                <span onclick="document.getElementById('loginForm').style.display='none'" class="close" title="Close Modal">&times;</span>
            </div>
            <div class="container">
                <h1>Log in</h1>
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Staff or student number" name="username" required                 
                       pattern="^[0-9]{0,8}$" autofocus>
                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="UTS Password" name="password" required>
              
                <a href="https://email.itd.uts.edu.au/webapps/myaccount/passwordreset/">Forget your Password?<br></a>
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
            
    
   <script>
    // Get the modal
    var modal = document.getElementById('loginForm');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }; 
    </script>

    
    <!--oninvalid="this.setCustomValidity('Please enter your ID')"--> 

<!--pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$">-->

