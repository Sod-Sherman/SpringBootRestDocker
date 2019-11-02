$(document).ready(function () {

    $('#idListStudent').click(function (event) {
        event.preventDefault();

        $("#idResult").html("loading..");

        $.ajax({
            url: "/student/list",
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                console.log(data);
                $("#idResult").html("loaded: <br>");
                $.each(data, function (index, value) {
                    $("#idResult").append(JSON.stringify(value));
                    console.log(value);
                });
            },
            error: function (error) {
                console.log(error);

                $("#idResult").html("Error: <br>");
                if (error.status === 401)  // authorization
                    window.location.href = '/login';

                else {
                    $("#idResult").append(error);
                }
            }
        });

    });


});