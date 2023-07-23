<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/pages/blocks/header.jsp" />
<div class="mt-xxl-5"></div>
<main class="form-signin text-center">
  <form method="post" action="/login" style="max-width: 400px; margin: 0 auto;">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="login">
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating mt-3">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="mt-3">
      <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    </div>

  </form>
</main>
<jsp:include page="/pages/blocks/footer.jsp" />
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
