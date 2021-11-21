<jsp:useBean id="todo" scope="request" type="pl.sda.springzdjavapol92.model.Todo"/>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<%--    Dodaj wyświetlenie pozostałych pól klasy Todo--%>
    <h1> Ok, dodałeś nowe zadanie</h1>
    <p>Tytuł: ${todo.title}</p>
    <p>Osoba: ${todo.person}</p>
    <p>Data zakończenia: ${todo.deadline}</p>
    <p>Czy wykonano: ${todo.completed}</p>
    <p>Data i czas dodania: ${todo.created}</p>
    <a href="${pageContext.request.contextPath}/">Home</a>
    <a href="${pageContext.request.contextPath}/todo/add">Dodaj następne zadanie</a>
</body>
</html>