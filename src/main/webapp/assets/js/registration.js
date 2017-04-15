/**
 * Created by daivietquochoang on 14/04/2017.
 */
$(document).ready(function(){
    $("#btnRegistration").click(function(){
        var username = $('#username').val();
        var pasword = $('#password').val();
        console.log("you have just clicked on button Register"+username+pasword);
        $.ajax({
            type:"POST",
            url:"/registration",
            success: function(){
                console.log("send and receive data successful");
            },
            error: function(e){
                console.log("error: ",e);
            }

        });
    });
});