/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){    
    closeModal('loginForm');
    closeModal('seminarRegister');
    closeModal('seminarRegistered');
  
  
    $("#endTime").change(function(){
      var startTime = $('#startTime').val();
      var endTime = $('#endTime').val();
      var st = minFromMidnight(startTime);
      var et = minFromMidnight(endTime);
      if(st>et){
          alert("End time must be greater than start time");
          $('#endTime').val('');
      }
  });

    $('#startTime').change(function(){
      var startTime = $('#startTime').val();
      var endTime = $('#endTime').val();
      var st = minFromMidnight(startTime);
      var et = minFromMidnight(endTime);
      if(st>et){
          alert("End time must be greater than start time");
          $('#startTime').val('');
      }
    });
 });  
 
 /*
 * Javascript to close modal when clicking
 * outside the box
 */
 function closeModal(id){
     //Get the modal
    var modal = document.getElementById(id);
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}
   
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



function minFromMidnight(tm){
        var ampm= tm.substr(-2);
        var clk = tm.substr(0, 5);
        var m  = parseInt(clk.match(/\d+$/)[0], 10);
        var h  = parseInt(clk.match(/^\d+/)[0], 10);
        h += (ampm.match(/pm/i))? 12: 0;
        return h*60+m;
}
