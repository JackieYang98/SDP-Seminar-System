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
        <div class="mixcontainer" align="center">
            <h1>Upcoming Events</h1>
            <button class="filter" data-filter="all">All</button>
            <button class="filter" data-filter=".blue">Blue</button>
            <button class="filter" data-filter=".orange">Orange</button>
            <button class="filter" data-filter=".red">Red</button>
            <input type="date" name="Date" /> 
            <input type="text" id="inputSearch" placeholder="Search...">

            <hr>
            <a href="detail_seminar.jsp">
            <div class="mix red" onclick="">
              <p class="eventName">Red</p>
            </div></a>
            <a href="detail_seminar.jsp">
            <div class="mix">
            <p class="eventName">Reddit</p>
            </div></a>
            <a href="detail_seminar.jsp">
            <div class="mix orange">
              <p class="eventName">Orange</p>
            </div></a>
            <a href="detail_seminar.jsp">
            <div class="mix blue">
              <p class="eventName">Blue</p>
            </div></a>
            <a href="detail_seminar.jsp">
            <div class="mix">
              <p class="eventName">Blue Bottle</p>
            </div></a>
            
            <a href="detail_seminar.jsp">
            <div class="mix orange">  
                <p class="eventName" style="color: transparent; font-size:0.1px;"> Angel </p>
                <div class="mix-grid">
                    <div class="mix-name"> Angel </div>
                    <div class="mix-venue"> VENUE </div>
                    <div class="mix-date"> DATE </div>
                    <div class="mix-edit"> EDIT </div>

                </div>
            </div></a>
            
            <a href="create_seminar.jsp">
            <div class="mix red blue orange">
              <p class="eventName">+</p>
            </div></a>
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
    </script>
</html>
