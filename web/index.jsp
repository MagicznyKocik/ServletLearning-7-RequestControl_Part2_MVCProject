<%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 20.02.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>e-Shop</title>
  </head>
  <body>
  <h1>What you want to buy?</h1>

  <form action="buy" method="post">
    <input name="firstItem" placeholder="first product">
    <input name="firstItemPrice" placeholder="price">
    <br/>
    <input name="secondItem" placeholder="second product">
    <input name="secondItemPrice" placeholder="price">
    <br/>
    <input name="thirdItem" placeholder="third product">
    <input name="thirdItemPrice" placeholder="price">
    <br/>
    <input type="submit" value="Buy">
  </form>
  </body>
</html>
