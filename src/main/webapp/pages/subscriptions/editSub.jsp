<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Редактирование абонемента</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Редактирование абонемента</h1>

    <form action="/subscription/edit" method="post">
        <input type="hidden" name="id" value="${subscription.id}">

        <div class="mb-3">
            <label for="subscriptionName" class="form-label">Название:</label>
            <input type="text" id="subscriptionName" name="subscriptionName" class="form-control" value="${subscription.subscriptionName}">
        </div>

        <div class="mb-3">
            <label for="subscriptionPrice" class="form-label">Цена:</label>
            <input type="number" id="subscriptionPrice" name="subscriptionPrice" class="form-control" value="${subscription.subscriptionPrice}">
        </div>

        <div class="mb-3">
            <label for="subscriptionPeriod" class="form-label">Период:</label>
            <input type="number" id="subscriptionPeriod" name="subscriptionPeriod" class="form-control" value="${subscription.subscriptionDaysNumber}">
        </div>

        <div class="mb-3">
            <label for="numberOfGuestVisits" class="form-label">Количество гостевых посещений:</label>
            <input type="number" id="numberOfGuestVisits" name="numberOfGuestVisits" class="form-control" value="${subscription.numberGuestVisitDays}">
        </div>

        <div class="mb-3">
            <label for="maxSubscriptionStop" class="form-label">Пауза:</label>
            <input type="number" id="maxSubscriptionStop" name="maxSubscriptionStop" class="form-control" value="${subscription.numberSubscriptionStopDays}">
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Описание:</label>
            <textarea id="description" name="description" class="form-control">${subscription.description}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</div>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
