var today = new Date();
var hourNow = today.getHours();
var greetings;

if(hourNow>18){
    greetings ='Good Evening!';
} else if (hourNow>12){
    greetings='Good Afternoon!';
}else if(hourNow>0){
    greetings = 'Good Morning!';
}else {
    greetings = 'Welcome!'
}
document.write('<h3>' + greetings+'</h3>');

$(document).ready(function(){
    $(window).scroll(function() {
        if ($(document).scrollTop() > 50) {
            $("p").addClass("test");
        } else {
            $("p").removeClass("test");
        }
    });
});