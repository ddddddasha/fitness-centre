<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
    <h1 class="display-4 fw-normal text-body-emphasis">Pricing</h1>
    <p class="fs-5 text-body-secondary">Выберите для себя один из доступных абонементов. Мы гарантируем, что найдете оптимальное решение, соответствующее вашим требованиям. Купите абонемент прямо сейчас и присоединяйтесь к нашему сообществу активных людей, стремящихся к здоровому образу жизни</p>
</div>

<div class="row justify-content-center mb-3">
    <div class="col-auto">
        <c:if test="${sessionScope.role eq 'ADMIN'}">
            <a href="/pages/subscriptions/addSub.jsp" class="btn btn-primary">Добавить абонемент</a>
        </c:if>
    </div>
</div>

<div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
    <c:forEach items="${subscriptions}" var="subscription">
        <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                    <h4 class="my-0 fw-normal">${subscription.subscriptionName}</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">${subscription.subscriptionPrice} BYN<small class="text-body-secondary fw-light"></small></h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li>${subscription.subscriptionDaysNumber} days</li>
                        <li>${subscription.numberGuestVisitDays} guest visits</li>
                        <li>${subscription.numberSubscriptionStopDays} days pause</li>
                        <li>${subscription.description}</li>
                    </ul>
                    <c:if test="${sessionScope.role eq 'ADMIN'}">
                        <div class="d-flex justify-content-between">
                            <a href="/subscription/edit?id=${subscription.id}" class="btn btn-primary">Редактировать</a>
                            <form action="/subscription/delete" method="post">
                                <input type="hidden" name="id" value="${subscription.id}" />
                                <button type="submit" class="btn btn-danger me-1">Удалить</button>
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${sessionScope.role eq 'CLIENT'}">
                        <div class="d-flex justify-content-between">
                            <a href="/subscription/buy?id=${subscription.id}" class="btn btn-danger me-1">Buy</a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="/pages/blocks/footer.jsp" />
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
