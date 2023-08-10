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
            <p>Возраст: ${user.dateBirthday}</p>
            <p>Email: ${user.login}</p>

        </div>
    </div>
</div>
<form action="/user/account" method="get">
    <div class="container">
        <h3>Ваши покупки:</h3>
        <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
            <c:forEach items="${userPurchases}" var="purchase">
                <div class="col">
                    <div class="card mb-4 rounded-3 shadow-sm">
                        <div class="card-header py-3">
                            <h4 class="my-0 fw-normal">${purchase.subscription.subscriptionName}</h4>
                        </div>
                        <div class="card-body">
                            <h1 class="card-title pricing-card-title">${purchase.subscription.subscriptionPrice} BYN<small class="text-body-secondary fw-light"></small></h1>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>${purchase.subscription.subscriptionDaysNumber} days</li>
                                <li>${purchase.subscription.numberGuestVisitDays} guest visits</li>
                                <li>${purchase.subscription.numberSubscriptionStopDays} days pause</li>
                                <li>${purchase.subscription.description}</li>
                                <li>${purchase.paymentDate}</li>
                                <li>${purchase.paymentStatus}</li>
                            </ul>
                            <form action="/purchase/delete" method="post">
                                <input type="hidden" name="purchaseId" value="${purchase.purchaseId}">
                                <button type="submit" class="btn btn-danger">Удалить покупку</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</form>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bs-init.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.1/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/pages/blocks/footer.jsp" />
</body>
</html>
