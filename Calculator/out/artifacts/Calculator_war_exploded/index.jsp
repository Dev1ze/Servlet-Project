<%--
  Created by IntelliJ IDEA.
  User: iron-
  Date: 20.12.2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <body>
    <h1>Servlet-калькулятор</h1>
    <form method="post" action="calculate">
      <label>Значение 1
        <input type="text" name="value1"><br/>
      </label>
      <label>Значение 2
        <input type="text" name="value2"><br/>
      </label>
      <label>Операция
        <input type="text" name="operation"><br/>
      </label>
      Ответ:<%
      %>
      <br/>
      <button type="submit">ПОСЧИТАТЬ</button>
    </form>
  </body>

</html>
