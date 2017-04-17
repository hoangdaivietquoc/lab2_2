/**
 * Created by daivietquochoang on 15/04/2017.
 */
// posts save all post
var posts;
function showPost(data) {
    var dataLength = Object.keys(data).length;
    var result="";
    var rsSelectId = "";
    if(dataLength>0){
        // console.log(data[0].content);
        for(i=0;i<dataLength;i++){
            result+="idPost = "+data[i].id+" user = ";
            result+="<b>"+data[i].username+"</b>";
            result+="<p>"+data[i].content+"</p>";
            rsSelectId+="<option value='value1'>"+data[i].id+"</option>";

        }
        $("#seId").html(rsSelectId);
        $("#divShowFeedTest").html(result);
        $("#divCommand").show();
    }
}
// function showLike show Like status of posts
function showLike() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/showLike",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("showLike success"+JSON.stringify(data));
            var dataLength = Object.keys(data).length;
            if(dataLength>0){
                var rs="";
                for(i=0;i<dataLength;i++){
                    console.log("idPost = "+data[i]["idPost"]+"--- nbLike = "+data[i]["nbLike"]+"---- username = "+data[i]["lsUserLike"]);
                    rs+="<p>";
                    rs+="idPost = "+data[i]["idPost"]+"--- number of Like = "+data[i]["nbLike"]+"---- List User Like = "+data[i]["lsUserLike"];
                    rs+="</p>";
                }
                $("#divShowLike").html(rs);

            }
            else {
                $("#divShowLike").html("");
            }
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
$(document).ready(function(){

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/refreshFeed",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            posts=data;
            // console.log("success"+JSON.stringify(data));
            showPost(data);
            if($("#divShowFeedTest").html()==""){$("#divCommand").hide();}
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    showLike();

    $("#btnShare").click(function(){
        var myData = {}
        myData["content"] = $('#txtaContent').val();
        if($('#txtaContent').val()==""){
            alert("please add content");
        }
        else{
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/share",
                data: JSON.stringify(myData),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function (data) {
                    posts=data;
                    // console.log("success"+JSON.stringify(data));
                    document.getElementById("txtaContent").value = "";
                    showPost(data);
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });
        }

    });

    $("#btnGo").click(function(){
        var Command = $('#seLC').find(":selected").text();
        var idPost = $('#seId').find(":selected").text();
        console.log("Command = "+Command+"idPost = "+idPost);
        if(Command=="Like or unlike"){
            //Like or unlike a post
            var myData = {}
            myData["idPost"] = idPost;

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/changeLike",
                data: JSON.stringify(myData),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function (data) {
                    //console.log("changePost success"+JSON.stringify(data));
                    showLike();
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });


        }
        else if(Command=="Comment"){
            var url = window.location.href;
            var newUrl = url.replace(/feed/i,'post?idPost=');
            console.log(newUrl+"--"+idPost+"--"+Command);
            newUrl+=idPost;
            window.location = newUrl;
        }


    });
});