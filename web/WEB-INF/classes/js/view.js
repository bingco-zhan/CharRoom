
var $online = $(".cr-list > .dropright").clone();
$(".cr-list").empty();

var $from = $(".cr-content > .cr-msg-from").clone();
var $to = $(".cr-content > .cr-msg-to").clone();
$(".cr-content").empty();

function loadOline(array) {

    $(".cr-list").empty();
    for (var x = 0; x < array.length; x++) {

        var remark = "Hello World Java.";
        if (array[x].remark) remark = array[x].remark;

        var img = "/CharRoom/img/log.jpg";
        if (array[x].pic) img = array[x].pic;

        var dom = $online.clone();
        dom.find("img").attr("src", img);
        dom.find("h6").text(array[x].nickname);
        dom.find("span").text(remark);
        dom.find(".signUp").attr("data-id", array[x].token);
        $(".cr-list").prepend(dom);
    }
}

var T = window.setInterval("queryOnline();", 2500);

function queryOnline() {
    sendMessage("<message><order><![CDATA[online]]></order><who></who><speak></speak></message>");
}

function lodPublic(json) {
    var user = eval("(" + json.from + ")");
    if (user.token == from) {

        var dom = $from.clone();
        console.log(dom);
        dom.find("h6").text(user.nickname);
        dom.find("p").text(json.speak);
        dom.find("img").attr("src", user.pic);
        $(".cr-content").prepend(dom);

    } else {

        var dom = $to.clone();
        console.log(dom);
        dom.find("h6").text(user.nickname);
        dom.find("p").text(json.speak);
        dom.find("img").attr("src", user.pic);
        $(".cr-content").prepend(dom);
    }
}

function loadPlanform(speak) {
    $(".cr-content").prepend("<p class='container'><p class='font-weight-bold ml-4 mr-4 bg-light text-center' " +
        "style='font-size: 14px; color: darkgrey'>"+ speak + "</p></div>");
}