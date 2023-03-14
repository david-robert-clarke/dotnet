<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.cdshop.product.Product" %>
<%@ page import="com.cdshop.product.Order" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.cdshop.cart.CartItem" %>
<jsp:useBean id="orderaddr" class="com.cdshop.customer.Address" scope="session"/>
<jsp:useBean id="ordercredit" class="com.cdshop.customer.CreditCard" scope="session"/>
<jsp:useBean id="cart" class="com.cdshop.cart.Cart" scope="session"/>
<jsp:useBean id="customer" class="com.cdshop.customer.Customer" scope="session"/>
<%
Order order = new Order(customer, orderaddr, ordercredit, cart);
order.recordOrder();

cart.clear();
pageContext.setAttribute("orderaddr", null, PageContext.SESSION_SCOPE);
pageContext.setAttribute("ordercredit", null, PageContext.SESSION_SCOPE);

%>
<HEAD>
<TITLE>Order Receipt</TITLE>
</HEAD>
<BODY>

<%@ include file="/jsp/includes/header.jsp" %>
<CENTER><H1>Order Receipt</H1></CENTER>

Thank you for your order, your credit card has been charged
<font color=#990000>&pound;<%= order.getOrderTotalString().substring(1) %></font>.  Your order number is
<%= order.getOrderNumber() %>.  Please write down this order number in case you
need to refer to the order at a future date. You will also be receiving a copy of your
receipt via e-Mail.

<%@ include file="/jsp/includes/footer.jsp" %>
