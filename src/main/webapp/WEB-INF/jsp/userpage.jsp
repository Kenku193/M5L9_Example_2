<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>M5L9_Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="./" method="post" class="form-horizontal">
        <fieldset>

            <!-- FORM NAME -->
            <legend>User Page</legend>
            <!-- TEXT INPUT -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="${user.login}"
                           type="text" placeholder="none" class="form-control input=md">
                </div>
            </div>

            <!-- PASSWORD INPUT -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="${user.password}"
                           type="text" placeholder="none" class="form-control input=md">
                </div>
            </div>
            <input type="hidden" value="${user.id}">

            <!-- BUTTON (DOUBLE) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="operation">Operation</label>
                <div id="operation" class="col-md-8">
                    <c:choose>
                        <c:when test="${requestScope.user!=null}">
                            <button name="updateUser" class="btn btn-success">Update user</button>
                            <button name="deleteUser" class="btn btn-danger">Delete user</button>
                        </c:when>
                        <c:otherwise>
                            <button name="createUser" class="btn btn-danger">Create user</button>
                            <button name="loginUser" class="btn btn-primary">Login user</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </fieldset>
    </form>

    <h2>List users</h2>
    <c:forEach var="user" items="${requestScope.users}">
    <div>
        <a href="/users/${user.id}/">Edit</a>: ${user}
    </div>
    </c:forEach>

<%--    <c:if test="${sessionScope.user}">--%>
<%--    <div>--%>
<%--        Session user: ${sessionScope.user}--%>
<%--    </div>--%>
<%--    </c:if>--%>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
