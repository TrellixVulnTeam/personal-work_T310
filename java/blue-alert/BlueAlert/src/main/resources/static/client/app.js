var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8080/blue-alert-websocket');
    stompClient = Stomp.over(socket);
    //stompClient.connect({username: $("#name").val()}, function (frame) {
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/register', function (greeting) {
            console.log(greeting);
            showGreeting(JSON.parse(greeting.body));
        });
        stompClient.subscribe('/user/topic/reply', function (message) {
            console.log("reply-to-user");
            console.log(message);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/register", {}, JSON.stringify({'data': $("#message").val()}));
}

function showGreeting(message) {
    console.log(message);
    $("#greetings").append("<tr><td>" + message.data + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});