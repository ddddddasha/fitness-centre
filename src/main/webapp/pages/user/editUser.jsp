<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>Редактирование пользователя</title>
  <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1>Редактирование пользователя</h1>

  <form action="/user/edit" method="post">
    <input type="hidden" name="id" value="${user.id}">

    <div class="mb-3">
      <label for="firstName" class="form-label">Name:</label>
      <input type="text" id="firstName" name="firstName" class="form-control" value="${user.firstName}">
    </div>

    <div class="mb-3">
      <label for="lastName" class="form-label">Last name:</label>
      <input type="text" id="lastName" name="lastName" class="form-control" value="${user.lastName}">
    </div>

    <div class="mb-3">
      <label for="age" class="form-label">Age:</label>
      <input type="number" id="age" name="age" class="form-control" value="${user.age}">
    </div>

    <div class="mb-3">
      <label for="login" class="form-label">email:</label>
      <input type="text" id="login" name="login" class="form-control" value="${user.login}">
    </div>

    <button type="submit" class="btn btn-primary">Сохранить</button>
  </form>
</div>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
