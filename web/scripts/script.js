/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){    

    //When user fill end time, check whether it is before start time of seminar
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

    //When user fill start time, check whether it is before end time of seminar
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
 
/**
 * Close modal when clicking outside the box
 * 
 * @param {String} id     Pop-up id for identification
 * @param {String} id2    Pop-up id for identification
 * @param {String} id3    Pop-up id for identification
 * @param {String} id4    Pop-up id for identification
 * @param {String} id5    Pop-up id for identification
 * @returns {undefined}
 */
 function closeModal(id,id2,id3,id4,id5){
    //Allow pop up to be close by clicking outside the modal
    //Get the modal
    var modal = document.getElementById(id);
    var modal2 = document.getElementById(id2);
    var modal3 = document.getElementById(id3);
    var modal4 = document.getElementById(id4);
    var modal5 = document.getElementById(id5);
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
        if (event.target == modal2) {
            modal2.style.display = "none";
        }
        if (event.target == modal3) {
            modal3.style.display = "none";
        }
        if (event.target == modal4) {
            modal4.style.display = "none";
        }
        if (event.target == modal5) {
            modal5.style.display = "none";
        }
    };     
}

/**
 * Toggles speaker 2 and 3 field visibility when user click
 * 
 * @param {String} speaker  speaker ID field to toggle
 * @returns {undefined}
 */
function hide(speaker){
    var x = document.getElementById(speaker);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

/**
 * Calculate how many minute the given time is from midnight to compare 
 * whether end time is before start time
 * 
 * @param {String} tm   the time to calculate
 * @returns {Integer}   the time difference from midnight in minute
 */
function minFromMidnight(tm){
        var ampm= tm.substr(-2);
        var clk = tm.substr(0, 5);
        var m  = parseInt(clk.match(/\d+$/)[0], 10);
        var h  = parseInt(clk.match(/^\d+/)[0], 10);
        h += (ampm.match(/pm/i))? 12: 0;
        return h*60+m;
}
