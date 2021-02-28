$(document).ready(function () {
    $.ajax({
        url: "/addressbook"
    }).then(function (data) {
        if (data) {
            if (data !== "") {
                //AddressBook Exists
                $('#submitNewAddressBook').hide();
                const headers = ['BuddyInfo ID', 'Name', 'Phone Number', 'Address'];

                $('#table_div').append('<table id="table_container"><thead><tr></tr></thead></table>');

                $thead = $('#table_container > thead > tr:first');
                for (let i = 0, len = headers.length; i < len; i++) {
                    $thead.append('<th>' + headers[i] + '</th>');
                }
                $(function () {
                    $.each(data.buddyInfos, function (i, item) {
                        $('<tr>').append(
                            $('<td>').text(item.buddyInfoId),
                            $('<td>').text(item.name),
                            $('<td>').text(item.phoneNumber),
                            $('<td>').text(item.address)).appendTo('#table_container');
                    });
                });
            }
        } else {
            //AddressBook not found
            $('#buddyInfoHeader').hide();
            $('#createNewBuddyInfoForm').hide();
        }
    });
});
