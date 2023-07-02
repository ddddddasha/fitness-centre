<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
        .user-info {
            display: flex;
            align-items: center;
            margin-top: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 10px;
        }

        .user-photo {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            object-fit: cover;
            margin-right: 10px;
        }

        .user-info-text {
            margin-left: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="user-info">
        <img src="/img/user.jpg" alt="User Photo" class="user-photo">
        <div class="user-info-text">
            <h4>${user.firstName}, Добро пожаловать!</h4>
            <p>Имя: ${user.firstName}</p>
            <p>Фамилия: ${user.lastName}</p>
            <p>Возраст: ${user.age}</p>
            <p>Email: ${user.login}</p>

        </div>
    </div>
</div>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bs-init.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.1/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/pages/blocks/footer.jsp" />
</body>
</html>
