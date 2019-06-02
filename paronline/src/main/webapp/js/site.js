/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function removeUser(id) {
    var XHR = new XMLHttpRequest();
    var FD = new FormData();

    alert('id: ' + id);
    FD.append('id', id);
    
    alert('FD:' + FD);

    // Define what happens on successful data submission
    XHR.addEventListener('load', function (event) {
        alert('Usuario eliminado');
    });

    // Define what happens in case of error
    XHR.addEventListener('error', function (event) {
        alert('Error inesperado');
    });

    XHR.open('DELETE', 'http://localhost:8080/paronline/User');
    XHR.send(FD);
}


