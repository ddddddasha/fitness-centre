<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24.06.2023
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление абонемента</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Добавление абонемента</h1>

    <form action="/subscription/create" method="POST" accept-charset="UTF-8" class="needs-validation" novalidate >

        <div class="mb-3">
            <label for="subscriptionCategory" class="form-label">Тип абонемента:</label>
            <select id="subscriptionCategory" name="subscriptionCategory" class="form-control" required>
                <option value="GYM">GYM</option>
                <option value="YOGA">YOGA</option>
                <option value="PILATES">PILATES</option>
                <option value="SPA">SPA</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="subscriptionName" class="form-label">Название абонемента:</label>
            <input type="text" id="subscriptionName" name="subscriptionName" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="subscriptionPrice" class="form-label">Цена абонемента (BYN):</label>
            <input type="number" id="subscriptionPrice" name="subscriptionPrice" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="subscriptionPeriod" class="form-label">Период абонемента (в днях):</label>
            <input type="number" id="subscriptionPeriod" name="subscriptionPeriod" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="numberOfGuestVisits" class="form-label">Количество гостевых визитов (в днях):</label>
            <input type="number" id="numberOfGuestVisits" name="numberOfGuestVisits" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="maxSubscriptionStop" class="form-label">Пауза абонемента (в днях):</label>
            <input type="number" id="maxSubscriptionStop" name="maxSubscriptionStop" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Описание абонемента:</label>
            <textarea id="description" name="description" class="form-control" rows="5" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Добавить абонемент</button>
    </form>
</div>

<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
