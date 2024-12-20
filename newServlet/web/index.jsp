<%@ page import="ru.appline.logic.Model" %>
<%--
  Created by IntelliJ IDEA.
  User: iron-
  Date: 16.12.2024
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>

  <body>
    <h1>Домашняя страница по рабоде с пользователями</h1>
    Введите id пользователя (0 - для вывода всего списка пользователей)
    <br/>
    Доступно: <%
    Model model = Model.getInstance();
    out.print(model.getFromList().size());
    %>
    <form method="get" action="get">
      <label>ID:
        <input type="Text" name="id"><br/>
      </label>
      <button type="submit">ПОИСК</button>
    </form>
    <a href="addUser.html">Создать нового пользователя</a><br/>
  </body>

</html>
