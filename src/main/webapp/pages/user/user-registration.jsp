<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>User Registration</title>
    <style>
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333333;
        }

        input[type="text"],
        input[type="number"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #dddddd;
            border-radius: 3px;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 8px 16px;
            background-color: #576fb0;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #4c65af;
        }
        /* Styles for modal window */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
        }

        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
    </style>
    <script>
        function openModal() {
            var modal = document.getElementById("errorModal");
            modal.style.display = "block";
        }

        function closeModal() {
            var modal = document.getElementById("errorModal");
            modal.style.display = "none";
        }

        window.onclick = function(event) {
            var modal = document.getElementById("errorModal");
            if (event.target === modal) {
                modal.style.display = "none";
            }
        };

        // Open modal window if any error message is present
        window.onload = function() {
            var errorMessages = document.getElementsByClassName("error-message");
            if (errorMessages.length > 0) {
                openModal();
            }
        };
    </script>
</head>

<body>
<c:if test="${not empty errorMessageEmail}">
    <div id="errorModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <div class="error-message">${errorMessageEmail}</div>
        </div>
    </div>
</c:if>

<c:if test="${not empty errorMessageEmailAlreadyExists}">
    <div id="errorModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <div class="error-message">${errorMessageEmailAlreadyExists}</div>
        </div>
    </div>
</c:if>

<div class="container">
    <h1>User Registration</h1>
    <form method="post" action="/user/create">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="age">Date of birth:</label>
            <input type="text" id="age" name="age" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" id="login" name="login" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <input type="submit" value="Register" class="btn btn-primary btn-lg">
    </form>
</div>

<script src="/js/bootstrap.min.js"></script>
<jsp:include page="/pages/blocks/footer.jsp" />
</body>
</html>