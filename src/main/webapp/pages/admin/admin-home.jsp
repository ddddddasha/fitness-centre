<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.7.1/dist/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="/pages/blocks/header.jsp" />
<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
    <li class="nav-item"><a href="/index.jsp" class="nav-link px-2 text-secondary">Home</a></li>
    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Features</a></li>
    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">About</a></li>

    <li class="nav-item"><a href="/pages/admin/read-all-users.jsp" class="nav-link px-2 text-white">Users</a></li>

</ul>
<div class="content">
    Добро пожаловать!
</div>
<jsp:include page="/pages/blocks/footer.jsp"/>
</body>
</html>