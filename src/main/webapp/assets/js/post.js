/**
 * Created by daivietquochoang on 16/04/2017.
 */
function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};
//this function get content of post by id, data receive: Post(id,content,username) and show in divPost
function showPostContent(idPost) {
    var myData = {}
    myData["idPost"] = idPost;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/showPostContent",
        data: JSON.stringify(myData),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("success"+JSON.stringify(data));
            if(JSON.stringify(data).indexOf("null")>-1){
                alert("error: no post");
            }
            else{
                console.log(data["id"]+"----"+data["content"]+"----"+data["username"]);
                $("#PostId").html("idPost= "+data["id"]);
                $("#PostUsername").html("username = "+data["username"]);
                $("#PostContent").html("content = "+data["content"]);
            }

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
//show all comment
function showComments() {
    /*var dataLength = Object.keys(data).length;
    var rs="";
    for(i=0;i<dataLength;i++){
        rs+="<p>";
        rs+="<b>idComment = "+data[i].idComment+"</b>";
        rs+="<b> username = "+data[i].username+"</b>";
        rs+="<br></br>"+data[i].content+"";
        rs+="</p>";
    }
    $("#divShowComments").html(rs);*/
    var myData = {}
    myData["idPost"] = getUrlParameter("idPost");

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/showComments",
        data: JSON.stringify(myData),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("success"+JSON.stringify(data));
            var dataLength = Object.keys(data).length;
            var rs="";
            for(i=0;i<dataLength;i++){
                if(data[i].idPost==getUrlParameter("idPost")){
                    rs+="<p>";
                    rs+="<b>idComment = "+data[i].idComment+"</b>";
                    rs+="<b> username = "+data[i].username+"</b>";
                    rs+="<br></br>"+data[i].content+"";
                    rs+="</p>";
                }

            }
            $("#divShowComments").html(rs);


        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}
$(document).ready(function(){
    var idPost = getUrlParameter("idPost");
    console.log(idPost);
    showPostContent(getUrlParameter("idPost"));
    showComments();



    $("#btnComment").click(function () {
        var content = $('#txtaContent').val();
        if(content==""){
            alert("comment not null");
        }
        else{
            var myData = {}
            myData["idPost"] = getUrlParameter("idPost");
            myData["content"] = content;
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/addComment",
                data: JSON.stringify(myData),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function (data) {

                    document.getElementById("txtaContent").value = "";
                    showComments();

                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });


        }

    });

});