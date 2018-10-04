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
                height: 40px;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/header.jsp" %>
        <div class="center">
            <h1>Upcoming Events</h1>
            <button class="filter" data-filter="all">All</button>
            <button class="filter" data-filter=".blue">Blue</button>
            <button class="filter" data-filter=".orange">Orange</button>
            <button class="filter" data-filter=".red">Red</button>
            <input type="date" name="Date" /> 
            <input type="text" id="inputSearch" placeholder="Search...">

            <hr>
           
            <div class="catalog">  
                
<!--                <div class="seminar-box">
            
                    <div class="seminar-image"><a href='detail_seminar.jsp' >
                    <img src="image/building.jpg">
                    </a></div>
    
                    <div class="seminar-name">How to save a life</div>
                    <div class="seminar-date">16 June</div>
                    <div class="seminar-venue">Location</div>
                    <div class="seminar-button">Apply</div>
                </div>
                
        
                 <div class="seminar-box">
             
                    <div class="seminar-image"><a href='detail_seminar.jsp' >
                    <img src="image/building.jpg">
                    </a></div>
           
                    <div class="seminar-name">How to save a life</div>
                    <div class="seminar-date">16 June</div>
                    <div class="seminar-venue">Location</div>
                    <div class="seminar-button">Apply</div>
                </div>
                
                
                 <div class="seminar-box">
                    
                    <div class="seminar-image"><a href='detail_seminar.jsp' >
                    <img src="image/building.jpg">
                    </a></div>
                  
                    <div class="seminar-name">How to save a life</div>
                    <div class="seminar-date">16 June</div>
                    <div class="seminar-venue">Location</div>
                    <div class="seminar-button">Apply</div>
                </div>-->
                
            </div>
        </div>
    </body>
    <script>
        //Function to get current date
        var currentDate = new Date().toISOString().split('T')[0];
        document.getElementsByName("Date")[0].setAttribute('min', currentDate);

        $(function() {
            $(".mixcontainer").mixItUp();
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
            $("#inputSearch").keyup(function(){
              // Delay function invoked to make sure user stopped typing
                delay(function(){
                    inputText = $("#inputSearch").val().toLowerCase();
                    // Check to see if input field is empty
                    if ((inputText.length) > 0) {            
                        $( '.mix').each(function() {
                            $this = $("this");
                         // add item to be filtered out if input text matches items inside the eventName   
                            if($(this).children('.eventName').text().toLowerCase().match(inputText)) {
                                $matching = $matching.add(this);
                            }
                            else {
                          // removes any previously matched item
                            $matching = $matching.not(this);
                            }
                        });
                        $(".mixcontainer").mixItUp('filter', $matching);
                    }
                    else {
                      // resets the filter to show all item if input is empty
                      $(".mixcontainer").mixItUp('filter', 'all');
                    }
                }, 200 );
            });
        });   
        
        
     $(document).ready(function(){
        $.ajax({
            url:"SeminarServlet",
            type: "GET",
        success:function(data){
            $(".catalog").html(data); 
        }
        });
     }) ;
        

    </script>
</html>
