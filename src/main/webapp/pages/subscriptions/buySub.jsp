<!-- subscription.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Подтверждение покупки</title>
</head>
<body>
<h1>Подтверждение покупки абонемента</h1>

<form action="/subscription/buy" method="post">
    <input type="hidden" name="id" value="${subscription.id}">

    <p>Название абонемента: ${subscription.subscriptionName}</p>
    <p>Цена: ${subscription.subscriptionPrice}</p>
    <p>Длительность: ${subscription.subscriptionDaysNumber} дней</p>

    <p>Дата покупки: ${purchase.time}</p>
    <p>Статус платежа: ${purchase.paymentStatus}</p>

    <button type="submit">Подтвердить покупку</button>
</form>

<a href="/subscriptions">Вернуться к списку абонементов</a>
</body>
</html>
