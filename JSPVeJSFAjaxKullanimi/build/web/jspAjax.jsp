<%@page contentType="text/html;charset=ISO-8859-9" pageEncoding="ISO-8859-9" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP&#38;Ajax</title>
    </head>
    <body>
        <h1>JSP Ve JQuery Ýle Ajax Kullanýmý</h1>
        <br>
        <form name="ajaxForm" method="GET" action="Ajaxexample" id="ajaxForm">
            <table>
                <tr>
                    <td>Ýsminizi Giriniz:</td><td><input type="text" name="isim"/></td>
                </tr>
                <tr>
                    <td>Soyisminizi Giriniz:</td><td><input type="text" name="soyisim"/></td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" value="GÖNDER"/></td>
                </tr>
            </table>
            <div id="bilesenId"></div>
        </form>
    </body>
</html>

<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
<script type="text/javascript">
 
var form = $('#ajaxForm');
form.submit(function () {
 
$.ajax({
type: form.attr('method'),
url: form.attr('action'),
data: form.serialize(),
success: function (data) {
var result=data;
 document.getElementById("bilesenId").innerHTML = result;
}
});
 
return false;
});
</script>