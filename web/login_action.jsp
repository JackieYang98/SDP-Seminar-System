<%-- 
    Document   : login_action
    Created on : 19/09/2018, 4:37:40 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sdpseminarsystem.dao.*"%>

<jsp:useBean id="userMan" class="com.sdpseminarsystem.servlet.LoginServlet" scope="application">
        <jsp:setProperty name="userMan" property="filePath" value="<%=%>"/>
    </jsp:useBean>
