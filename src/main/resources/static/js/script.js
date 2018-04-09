

$(document).ready(function() {
    $('.delete-book').on('click', function() {
        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'remove';
        /*]]>*/

        var id=$(this).attr('id');

        bootbox.confirm({
            message: "Are you sure you would like to delete this book?",
            buttons: {
                cancel: {
                    label: '<i class="fas fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fas fa-check"></i> Confirm'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.post(path, {'id':id}, function(res){console.log(res); location.reload();
                    });
                }
            }
        });
    });


   /* var bookIdList = [];

    $('.checkboxBook').click(function() {
        var id=$(this).attr('id');
        if(this.checked) {
            bookIdList.push(id);
            console.log(id);
        } else {
            bookIdList.splice(bookIdList.indexOf(id), 1);
        }
    });  */

    $('#deleteSelected').click(function() {
        var idList = $('.checkboxBook');
        var bookIdList = [];
        for (var i = 0; i < idList.length; i++) {
            if(idList[i].checked == true) {
                bookIdList.push(idList[i]['id'])
            }
        }

        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'removeList';
        /*]]>*/

        bootbox.confirm({
            message: "Are you sure you would like to delete all selected books?",
            buttons: {
                cancel: {
                    label: '<i class="fas fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fas fa-check"></i> Confirm'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.ajax({
                        type: 'POST',
                        url: path,
                        data: JSON.stringify(bookIdList),
                        contentType: "application/json",
                        success: function(res) {console.log(res); location.reload()},
                        error: function(res) {console.log(res); location.reload();}
                    });
                }
            }
        });

    });
});