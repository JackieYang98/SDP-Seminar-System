<%-- 
    Document   : index
    Created on : 19/09/2018, 4:05:49 PM
    Author     : jingl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpenSem Homepage</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://www.w3schools.com/lib/w3.js"></script>
        <script src="scripts/script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            #browse{
                text-decoration: underline;
            }
            td {
                border: 1px solid black;
                padding: 200px;
            } 
            table {
                border-spacing: 20px;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <br><br>
        <div align="center">
            <form action="index.jsp">
                Upcoming events: 
                <input type="text" name="Venue" value="Venue"/>
                <input type="date" name="Date" /> <!-- will not work on default IE because it's HTML5-->
                <input type="submit" name="Search" value="Search"/>
            </form>
        </div>
        <br>
        <div align="center">
            
            <table>
                <tr>
                    <td>EVENT 1</td>
                    <td>EVENT 2</td>
                    <td>EVENT 3</td>
                </tr>
                <tr>
                    <td>EVENT 4</td>
                    <td>EVENT 5</td>
                    <td>EVENT 6</td>
                </tr>
            </table>
        </div>
    </body>
    <script>
        //Function to get current date
        var currentDate = new Date().toISOString().split('T')[0];
        document.getElementsByName("Date")[0].setAttribute('min', currentDate);
        </script>
</html>
