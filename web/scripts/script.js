/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){    
/*
 * Javascript to close modal when clicking
 * outside the box
 */
    // Get the modal
    var modal = document.getElementById('loginForm');
    
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
    
   
$(".user-list tbody tr").click(function(){
   $(this).addClass('selected').siblings().removeClass('selected');    
   var value=$(this).find('td:first').html();  
});
    
    
    
/*
* Responsive table code, 
* add scroll interface to table
*/    
    // Change the selector if needed
    var $table = $('table.user-list'),
        $bodyCells = $table.find('tbody tr:first').children(),
        colWidth;

    // Adjust the width of thead cells when window resizes
    $(window).resize(function() {
        // Get the tbody columns width array
        colWidth = $bodyCells.map(function() {
            return $(this).width();
        }).get();

        // Set the width of thead columns
        $table.find('thead tr').children().each(function(i, v) {
            $(v).width(colWidth[i]);
        });    
    }).resize(); // Trigger resize handler
});

function hide(speaker){
    var x = document.getElementById(speaker);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function validateAddUserForm(){
    var userID = document.forms["addUserForm"]["userid"].value;
    var fName = document.forms["addUserForm"]["fName"].value;
    var lName = document.forms["addUserForm"]["lName"].value;
    var email = document.forms["addUserForm"]["email"].value;
    var password = document.forms["addUserForm"]["password"].value;
    var role = document.forms["addUserForm"]["role"].value;
    
    if(!userID.match("^[0-9]{0,8}$")){
        alert("Please enter a valid ID");
        return false;
    }
    if(!fName.match("^[A-Za-z]+$")){
        alert("First name takes only alphabets");
        return false;
    }
    if(!lName.match("^[A-Za-z]+$")){
        alert("Last name takes only alphabets");
        return false;
    }
    if(!email.match("^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$")){
        alert("Please enter valid email address associated with ID");
        return false;
    }
    if(!password.match("(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$")){
        alert("Please enter valid password associated with ID");
        return false;
    }
    
}