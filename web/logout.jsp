<%-- 
    Document   : logout
    Created on : 23/09/2018, 2:29:31 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="0.5; url=/SDP-Seminar-System/index.jsp" />
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <title>Logout</title>
    </head>
    <body>
        <%
            //Invalidate Session
            session.invalidate();
            request.setAttribute("logout", "logout");// Necessary for correct header
        %>
        <%@include file="WEB-INF/header.jsp" %>
        <h1>Logout</h1>
        <p>You have been logged out. Click <a href="/SDP-Seminar-System/index.jsp">here</a> to return to the main page, if you are not forwarded automatically.</p>
    </body>
</html>