<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <title>Accident</title>
</head>
<body>
<div class="row justify-content-center">
    <c:if test="${not empty errorMessage}">
        <div class="col-12 text-center" style="color:red; font-weight: bold; margin: 30px 0;">
                ${errorMessage}
        </div>
    </c:if>
    <form name='login' action="<c:url value='/login'/>" method='POST'>
        <table>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="username">UserName:</label></th>
                <td class="col-1"></td>
                <td class="col-8"><input id="username" type='text' name='username'></td>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="password">Password:</label></th>
                <td class="col-1"></td>
                <td class="col-8"><input id="password" type='password' name='password'></td>
            </tr>
            <tr class="row justify-content-center">
                <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
            </tr>
        </table>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
