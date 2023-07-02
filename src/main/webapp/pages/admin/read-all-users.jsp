<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-pzjw8f+ua6a9PjOytaXn3P2woJ2wKfVqOjwiCk3wOC/DMAq/aTiNbNJq7E263X1V" crossorigin="anonymous">
    <style>
        body {
            padding: 20px;
            font-family: 'Montserrat', sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .table-title {
            text-align: center;
            margin-top: 20px;
        }
        .action-buttons {
            display: flex;
            justify-content: flex-end;
        }
        .action-buttons a {
            margin-left: 5px;
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="table-title">
    <h1>Список пользователей</h1>
</div>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">id</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Возраст</th>
        <th scope="col">Логин</th>
        <th scope="col">Роль</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.login}</td>
            <td>${user.role}</td>
            <td class="action-buttons">
                <a href="/user/edit?id=${user.id}" class="btn btn-primary">Редактировать</a>
                <a href="/deleteUser?id=${user.id}" class="btn btn-danger">Удалить</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"
        integrity="sha384-pzjw8f+ua6a9PjOytaXn3P2woJ2wKfVqOjwiCk3wOC/DMAq/aTiNbNJq7E263X1V"
        crossorigin="anonymous"></script>
<jsp:include page="/pages/blocks/footer.jsp" />
</body>
</html>