<%@page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Lista zadań</h2>
<table>
    <thead>
        <tr>
            <th>Treść zadania</th>
            <th>Osoba odpowiedzialna</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>
                    ${todo.title}
                </td>
                <td>
                    ${todo.person}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>