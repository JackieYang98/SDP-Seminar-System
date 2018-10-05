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
            #browse{
                text-decoration: underline;
            }
            button {
                width:70px;
            }
            input{
                height: 30px;
                width: 200px;
            }
            table{
                margin-left: auto;
                margin-right: auto;
            }
            tr, td{
                padding-left:10px;
                padding-right: 10px;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="seminar-container" align="center">
            <table>
                <tr>
                    <td><h1>Upcoming Events: </h1></td>
                    <td><input type="text" id="dateSearch" name="Date" placeholder="Pick a date... (Date Month Year)"/> </td>
                    <td><input type="text" id="inputSearch" placeholder="Search a venue..."></td>
                </tr>
            </table>
            <hr>
           
            <div class="mix">  <!-- mix class name cannot be changed as it breaks it. Probably due to something in the mixitup js script -->
                <div class="seminar-box">
                    <div class="seminar-image"><a href='detail_seminar.jsp' >
                    <img src="image/building.jpg">
                    </a></div>
                    <div class="seminar-name">How to save a life</div>
                    <div class="seminar-date">16 June</div>
                    <div class="seminar-venue">Location1</div>
                    <div class="seminar-button">Apply</div>
                </div>
            </div> 
            <div class="mix"> 
                <div class="seminar-box">
                    <div class="seminar-image"><a href='detail_seminar.jsp' >
                    <img src="image/building.jpg">
                    </a></div>
                    <div class="seminar-name">How to save a life</div>
                    <div class="seminar-date">15 June</div>
                    <div class="seminar-venue">Location2</div>
                    <div class="seminar-button">Apply</div>
                </div>
            </div> 
        </div>
    </body>
    <script>
        //Function to get current date
        var currentDate = new Date().toISOString().split('T')[0];
        document.getElementsByName("Date")[0].setAttribute('min', currentDate);
        $(function() {
            $(".seminar-container").mixItUp();
            var inputText;
            var $matching = $();
            // Delay function
            var delay = (function(){
              var timer = 0;
              return function(callback, ms){
                clearTimeout (timer);
                timer = setTimeout(callback, ms);
              };
            })();
            $("#inputSearch").keyup(function(){         //VENUE SEARCHER
              // Delay function invoked to make sure user stopped typing
                delay(function(){
                    inputText = $("#inputSearch").val().toLowerCase();
                    // Check to see if input field is empty
                    if ((inputText.length) > 0) {            
                        $( '.mix').each(function() {
                            $this = $("this");
                         // add item to be filtered out if input text matches items inside the eventVenue   
                            if($(this).children('div.seminar-box').children('div.seminar-venue').text().toLowerCase().match(inputText)) {
                                $matching = $matching.add(this);
                            }
                            else {
                          // removes any previously matched item
                            $matching = $matching.not(this);
                            }
                        });
                        $(".seminar-container").mixItUp('filter', $matching);
                    }
                    else {
                      // resets the filter to show all item if input is empty
                      $(".seminar-container").mixItUp('filter', 'all');
                    }
                }, 200 );
            });
            $("#dateSearch").keyup(function(){   //DATE SEARCHER
                delay(function(){
                    inputText = $("#dateSearch").val().toLowerCase();
                    if ((inputText.length) > 0) {            
                        $( '.mix').each(function() {
                            $this = $("this");
                            if($(this).children('div.seminar-box').children('div.seminar-date').text().toLowerCase().match(inputText)) {
                                $matching = $matching.add(this);
                            }
                            else {
                            $matching = $matching.not(this);
                            }
                        });
                        $(".seminar-container").mixItUp('filter', $matching);
                    }
                    else {
                      $(".seminar-container").mixItUp('filter', 'all');
                    }
                }, 200 );
            });
        });

//     $(document).ready(function(){
//        $.ajax({
//            url:"SeminarServlet",
//            type: "GET",
//        success:function(data){
//            $(".mix").html(data); 
//        }
//        });
//     }) ;
        

    </script>
</html>