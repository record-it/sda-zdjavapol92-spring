<%@page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@include file="../head.jspf"%>
<html>
<body>
<h2>Dodaj osobę</h2>
<form method="post">
    <label for="firstName">Imię</label><br>
    <input type="text" name="firstName" id="firstName"/><br>
    <label for="lastName">Nazwisko</label><br>
    <input type="text" name="lastName" id="lastName"><br>
    <label for="salary">Pensja</label><br>
    <input type="number" name="salary" id="salary"><br>
    <button type="submit">Zapisz</button><button type="reset">Wyczyść</button>
</form>
</body>
</html>