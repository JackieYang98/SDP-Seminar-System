<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpenSem Homepage</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.mixitup/latest/jquery.mixitup.min.js"></script>
        <script src="https://www.w3schools.com/lib/w3.js"></script>
        <script src="scripts/script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <style>
            /*Hightlight the current page*/
            #browse{
                text-decoration: underline;
            }         
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
            <!--The form to search for seminar search-->
            <form id="searchForm" method="GET" action="SeminarServlet">
            <h1>Upcoming Events: </h1>
            <table class="search-table">
                <tr>
                    <td>From: <input type="date" id="startDateSearch" 
                                     required/> </td>
                    <td>To: <input type="date" id="endDateSearch"/> </td>
                    <td><input id="searchSubmit" type="submit" 
                               value="Search"/> </td>
                </tr>
                <tr>
                    <td>Search by name or venue:</td>
                    <td><input type="text" id="inputSearch" 
                               placeholder="Search by name or venue..."></td>
                    <td><input type="button" onclick="location.reload();" 
                               value="Reset"></td>
                </tr>
            </table>
            </form>
            <hr>
            
            <!--Empty div to store search result on return-->
            <div class="catalog"></div>
        </div>
    </body>
    <script>    
    $(document).ready(function(){
        //Call SeminarServlet and retrieve all seminars depends on user type
        $.ajax({
            url:"SeminarServlet",
            type: "GET",
            success:function(data){
            $(".catalog").html(data); 
            }
        });
        
        //On user input in search box, search for seminar with matched details
        $("#inputSearch").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $(".mix").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
    
    //Date form submission, to retrieve seminar within range of date.
    $("#searchForm").submit(function(event) {
        event.preventDefault();
        var startDate = $('#startDateSearch').val();
        var endDate = $('#endDateSearch').val();
        var flag = $('#searchSubmit').val();
        var data = 'searchDate='+flag+'&startDate='+
                startDate+'&endDate='+endDate;
        $.ajax({
            url:"SeminarServlet",
            type: "GET",
            data: data,
        success:function(data){
            $(".catalog").html(data); 
        }
        });
    });
    </script>
</html>