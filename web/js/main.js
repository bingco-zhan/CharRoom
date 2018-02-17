
var serverPath = location.hostname + ":" + location.port + "/" + $(".serverPath").attr("data");

var webSocket;

if ("webSocket" in window) {
    webSocket = new WebSocket("ws://" + serverPath + "/char?cr=" + getCookie(document.cookie, "cr"));
} else {
    alert("该浏览器不支持WebSocket!");
}

var from;

webSocket.onopen = function (event) {

}

webSocket.onmessage = function (event) {
    var json = eval("(" + event.data + ")");
    switch (json.order) {
        case "online":
            loadOline(json.list);
            break;

        case "public":
        case "private":
            lodPublic(json);
            break;

        case "token":
            from = json.speak;
            break;

        default:
            loadPlanform(json.speak);

    }
}

webSocket.onclose = function (event) {
    alert("你已下线...")
}

webSocket.onerror = function (event) {

}

function btmSend(to) {
    if (from) {
        var message = $(".cr-textarea").val();
        sendMessage("<message><order><![CDATA[public]]></order><from><![CDATA[" + from + "]]></from><to><![CDATA[" +
            to + "]]></to><speak><![CDATA[" + message.trim() + "]]></speak></message>");
        $(".cr-textarea").val("");
    } else {
        alert("请登陆!");
    }
}

function signUpBy(dom) {
    var id = $(dom).attr("data-id");
    console.log(dom);
    sendMessage("<message><order><![CDATA[sign out]]></order><from><![CDATA[" + from + "]]></from><to><![CDATA[" +
        id + "]]></to><speak></speak></message>");
}

window.onbeforeunload = function () {
    webSocket.close();
}

function sendMessage(message) {
    webSocket.send(message);
}

function getCookie(cookies, value) {
    var c = cookies.split(", ");
    for(var x = 0; x < c.length; x++) {
        var e = c[x].split("=");
        if (e[0] == value) return e[1];
    }
    return null;
}