$(document).ready(function () {
        $("#menu > li > div").click(function () {
 
            if (false == $(this).next().is(':visible')) {
                $('#menu ul').slideUp(300);
            }
            $(this).next().slideToggle(300);
        });
        $('#menu ul:eq(0)').show();
 
    });
	

$(document).ready(function() {
	$("#grid tr:even").addClass('classEven');
});


$(document).ready(function () {
	  $("span.tooltip_message").hover(function () {
	    $(this).append('<div class="message"><p>Search by Keyword in:<ul><li>Author First Name </li><li>Author Last Name <li>Title of the book </li></ul></p></div>');
	  },function () {
	    $("div.message").remove();
	  });/*
	  $("span.tooltip_img1").hover(function(){$(this).append('<div class="message"><ul><li>Title - Beginning Groovy, Grails and Griffon</li><li>Author: Vishal Layka</li><li>Publisher: Apress</li></ul></div>');
}, function(){$("div.message").remove();});*/
	});
