<%@ page import="java.util.List" %>
<%@ page import="pl.adamLupinski.model.Item" %><%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 20.02.2019
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Summary</title>
</head>
<body>
<h1> Summary </h1>

<h2>Item list:</h2>

<ol>
    <%
        List<Item> cart = (List<Item>)request.getAttribute("cart");
        for (Item item: cart){
    %>

    <li>
        <%=
            String.format("%s:  Original Price: %.2f, Price after discount: %.2f", item.getProduct(), item.getOriginalPrice(), item.getDiscountPrice())
        %>
    </li>
    <%
        }
    %>
</ol>
    <h2> Total price: <%= request.getAttribute("originalSum")%> </h2>
    <h2> Total price after discount: <%= request.getAttribute("discountSum")%> </h2>
</body>
</html>
