<%@page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<html>
<%@include file="head.jspf" %>
<body>
<%@include file="nav.jspf" %>
<div class="container m-6">

    <h2 class="lead-2">Dodaj zadanie do wykonania</h2>
    <form method="post">
        <div class="mb-3">
            <label for="title">Tytuł zadania</label>
            <input class="form-control" type="text" name="title" id="title"/>
        </div>
        <div class="mb-3">
            <label for="deadline">Termin wykonania</label>
            <input class="form-control" type="date" name="deadline" id="deadline">
        </div>
        <div class="mb-3">
            <label for="person">Osoba odpowiedzialna</label>
            <input class="form-control" type="text" name="person" id="person">
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" type="submit">Zapisz</button>
            <button class="btn btn-warning" type="reset">Wyczyść</button>
        </div>
    </form>

</div>
</body>
</html>