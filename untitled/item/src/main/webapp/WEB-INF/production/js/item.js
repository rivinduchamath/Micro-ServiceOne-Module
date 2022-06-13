$(document).ready(function () {

    loadItems();
});

function loadItems() {

    $("#tableJson").empty();
    var ajaxConfig={
        url:"http://localhost:4000/items/getAll",
        method:"GET",
        async:'json'
    }
    var i =0;
    $.ajax(ajaxConfig).done(function (items,status,jQXHB) {
        for(var i =0;i< items.length;i++){
            var html = '<tr>' +
                '<td>' + items[i].itemId + '</td>' +
                '<td>' + items[i].itemName + '</td>' +
                '<td>' + items[i].itemPrice + '</td>' +
                '<td>' + items[i].itemQty + '</td>' +
                '<td>' + items[i].date + '</td>' +
                '<td>' + items[i].sellerId + '</td>' +
                '<td><i class="fas fa-trash"></i></td>' +
                '</tr>';
            $("#datatable tbody").append(html);
        }
    }).fail(function (jqXHB ,status,error) {
        console.log(error)
    })
}

$("#btnSubmit").click(function () {
    var item = {
        itemName: $("#itemName").val(),
        itemPrice: $("#itemPrice").val(),
        itemQty: $("#itemQty").val(),
        date: $("#date").val(),
        sellerId: $("#sellerId").val()
    };


    var ajaxConfig = {
        method: 'POST',
        url: 'http://localhost:4000/items/saveItem',
        async: true,
        contentType: 'application/json',
        data: JSON.stringify(item)
    };
    $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
        var html = "<tr>" +
            '<td>' + item.itemId + '</td>' +
            '<td>' + item.itemName + '</td>' +
            '<td>' + item.itemPrice + '</td>' +
            '<td>' + item.itemQty + '</td>' +
            '<td>' + item.date + '</td>' +
            '<td>' + item.sellerId + '</td>' +
            '<td><i class="fas fa-trash"></i></td>' +
            "</tr>";
        $("#datatable tbody").append(html);
        $("#itemName, #itemQty, #sellerId").val("");
        $("#itemName").focus();
    }).fail(function (jqXHR, status, error) {
        console.log(error);
    });

});

$("#datatable tbody").on('click', "tr td:last-child", function (eventData) {
    var row = $(this).parents("tr");
    eventData.stopPropagation();
    if (confirm("Are you sure whether you want delete this item?")) {
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost:4000/items/delete/' + row.find('td:first-child').text(),
            async: true
        }).done(function (response, status, jqXHR) {
            row.remove();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    }
});