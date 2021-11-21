<%@page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jspf"%>
<body>
<%@include file="nav.jspf"%>
<div class="container m-6">
<h2>Lista zadań</h2>
<table class="table">
    <thead>
    <tr>
        <th>Treść zadania</th>
        <th>Osoba odpowiedzialna</th>
        <th>Termin wykonania</th>
        <th>Czy wykonano</th>
        <th>Data utworzenia</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="todos" scope="request" type="java.util.List<pl.sda.springzdjavapol92.model.Todo>"/>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>
                    ${todo.title}
            </td>
            <td>
                    ${todo.person}
            </td>
            <td>
                    ${todo.deadline}
            </td>
            <td>
                <c:if test="${todo.completed}">
                    <input class = "form-check-input" type="checkbox" checked disabled>
                </c:if>
                <c:if test="${!todo.completed}">
                    <form action="/todo/completed" method="post">
                        <input type="hidden" name="id" value="${todo.id}">
                        <input class="form-check-input" type="checkbox" name="completed" required>
                        <button class="btn btn-danger" type="submit">Zapisz wykonanie</button>
                    </form>
                </c:if>
            </td>
            <td>
                    ${todo.created}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>