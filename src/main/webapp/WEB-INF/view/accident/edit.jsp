<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="accident" type="ru.job4j.accident.model.Accident"--%>
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
    <form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
        <table class="table">
            <tr class="row justify-content-center">
                <th><a href="<c:url value='/'/>">Главная</a></th>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="name">Название:</label></th>
                <td class="col-1"></td>
                <td class="col-8"><input id="name" type='text' name='name' value="${accident.name}">
                </td>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="address">Адрес:</label></th>
                <td class="col-1"></td>
                <td class="col-8"><input id="address" type='text' name='address'
                                         value="${accident.address}"></td>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="text">Описание:</label></th>
                <td class="col-1"></td>
                <td class="col-8"><input id="text" type='text' name='text' value="${accident.text}">
                </td>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="type">Тип:</label></th>
                <td class="col-1"></td>
                <td class="col-8">
                    <select id="type" name="type.id">
                        <c:forEach var="type" items="${types}">
                            <option
                                    <c:if test="${accident.type.id==type.id}"> selected </c:if>
                                    value="${type.id}">
                                    ${type.name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="row justify-content-center">
                <th scope="row" class="col-3"><label for="rule">Статьи:</label></th>
                <td class="col-1"></td>
                <td class="col-8">
                    <select id="rule" name="rIds" multiple>
                        <c:forEach var="rule" items="${rules}">
                            <option
                                    <c:if test="${accident.rules.contains(rule)}">selected</c:if>
                                    value="${rule.id}">${rule.name}</option>
                        </c:forEach>
                    </select>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="Сохранить"/></td>
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
