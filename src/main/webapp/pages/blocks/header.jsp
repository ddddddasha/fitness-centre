<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/Navbar-With-Button-icons.css">

<header class="p-3 text-dark bg-dark">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
      </a>

      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li class="nav-item"><a href="/index.jsp" class="nav-link px-2 text-secondary">Home</a></li>
        <li class="nav-item"><a href="/" class="nav-link px-2 text-white">Pricing</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-white">About</a></li>
        <c:if test="${sessionScope.role eq 'ADMIN'}">
          <li class="nav-item"><a href="/pages/admin/read-all-users.jsp" class="nav-link px-2 text-white">Users</a></li>
        </c:if>
      </ul>

      <c:choose>
        <c:when test="${not empty sessionScope.role}">
          <!-- Если пользователь уже вошел в систему -->
          <div class="text-end">
            <span class="text-white me-2">Welcome!</span>
            <a href="/exit" class="btn btn-outline-light">Exit</a>
          </div>
        </c:when>
        <c:otherwise>
          <!-- Если пользователь не вошел в систему -->
          <div class="text-end">
            <button type="button" class="btn btn-outline-light me-2" onclick="window.location.href='/pages/user/user-sign-in.jsp'">Login</button>
            <a href="/pages/user/user-registration.jsp" class="btn btn-warning text-white">Sign-up</a>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</header>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bs-init.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.1/dist/js/bootstrap.bundle.min.js"></script>
