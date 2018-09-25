<%-- 
    Document   : unauthorized_action
    Created on : 25/09/2018, 12:11:49 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" href="css/layout.css">
            <meta http-equiv="refresh" content="3; url=/SDP-Seminar-System/" />
            <title>Log-in Required</title>
        </head>
        <body>
            <%@include file="../header.jsp" %>
            <h1>Unauthorized Access</h1>
            <p>
                You do not have the clearance to visit this page. Please 
                <a href="/SDP-Seminar-System/index.jsp">log-in</a>. You will be redirected in 3 seconds...
            </p>
        </body>
</html>
