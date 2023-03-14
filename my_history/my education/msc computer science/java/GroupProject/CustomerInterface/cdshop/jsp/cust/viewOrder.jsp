<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.cdshop.customer.Customer" %>
<%@ page import="com.cdshop.customer.Address" %>
<%@ page import="com.cdshop.customer.CreditCard" %>
<%@ page import="com.cdshop.product.Order" %>
<%@ page import="com.cdshop.product.Product" %>
<%@ page import="com.cdshop.cart.CartItem" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<jsp:useBean id="customer" class="com.cdshop.customer.Customer" scope="session"/>
<% if (customer.getEmail() == null) {
    response.sendRedirect("Login.jsp");
    return;
}

Order or = null;
try {
    NumberFormat nf = new DecimalFormat();
    int ordernum = nf.parse(request.getParameter("order")).intValue();
    or = Order.findOrder(ordernum);
} catch (Exception ex) {
    response.sendRedirect("general_error.jsp");
    return;
}

if (!or.getCustomer().getEmail().equals(customer.getEmail())) {
    response.sendRedirect("noaccess.jsp");
    return;
}

%>
<head>
<title>Order <%= or.getOrderNumber() %></title>
</head>

<%@ include file="/jsp/includes/header.jsp" %>

<h2 align="center">Order <%= or.getOrderNumber() %></h2>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%">
  <tr>
    <th width="38%" height="23" align="left">Title</th>
    <th width="11%" height="23" align="left">Price</th>
    <th width="28%" height="23" align="center">Quantity</td>
    <th width="23%" height="23" align="left">Total</th>
  </tr>
    <%
    Iterator iter = or.getItems().iterator();
    while (iter.hasNext()) {
	CartItem item = (CartItem) iter.next();
	Product prod = item.getProduct();
%>
  <tr>
    <td width="38%" bgcolor="#00FFFF">
    <font style="font-size: 10.0pt; font-family: Times New Roman">
        <A HREF="product/Product.jsp?CD_ID=<%= prod.getCdId() %>">
        <%= prod.getTitle() %></A>
    </span><BR><BR></td>
    <td width="11%" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
    <font color=#990000>&pound;<%= prod.getPrice() %></font>
    </span></td>
    <td width="28%" bgcolor="#00FFFF">
    <p align="center"><font size="2">
    <%= item.getQuantity() %>
    </font></td>
    <td width="23%" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
    <font color=#990000>&pound;<%= item.getLineItemPriceString().substring(1) %></font>
    </span></td>
  </tr>
       <% } %>
  <TR><TD COLSPAN=4><HR></TD></TR>
  <TR><TD>&nbsp;</TD>
  <TD>&nbsp</TD>
  <TD ALIGN="center">
  <span style="font-size: 10.0pt; font-family: Times New Roman">
      SubTotal
  </span></TD>
    <TD>
  <span style="font-size: 10.0pt; font-family: Times New Roman">
   <font color=#990000>&pound;<%= or.getOrderSubtotalString().substring(1)%></font>
  </span></TD></TR>
  <TR><TD>&nbsp;</TD>
  <TD>&nbsp</TD>
  <TD ALIGN="center">
  <span style="font-size: 10.0pt; font-family: Times New Roman">
      Shipping
  </span></TD>
    <TD>
  <span style="font-size: 10.0pt; font-family: Times New Roman">
   <font color=#990000>&pound;<%= or.getOrderShippingString().substring(1)%></font>
  </span></TD></TR>
  <TR><TD>&nbsp;</TD>
  <TD>&nbsp</TD>
  <TD ALIGN="center">
  <span style="font-size: 10.0pt; font-family: Times New Roman">
      Tax
  </span></TD>
    <TD>
  <span style="font-size: 10.0pt; font-family: Times New Roman">
   <font color=#990000>&pound;<%= or.getOrderTaxString().substring(1)%></font>
  </span></TD></TR>
  <TR><TD>&nbsp;</TD>
  <TD>&nbsp</TD>
  <TD ALIGN="center">
  <span style="font-size: 10.0pt; font-family: Times New Roman">
      Total
  </span></TD>
    <TD>
  <span style="font-size: 10.0pt; font-family: Times New Roman">
   <font color=#990000>&pound;<%= or.getOrderTotalString().substring(1)%></font>
  </span></TD></TR>
</TABLE>
<P>
<B>Shipped to:</B><BR>
<%= or.getAddress().getFirstName() %>
<%= or.getAddress().getLastName() %><BR>
<%= or.getAddress().getStreet1() %><BR>
<%= or.getAddress().getStreet2() %><BR>
<%= or.getAddress().getCity() %>, 
<%= or.getAddress().getPostalCode() %><BR>
<%@ include file="/jsp/includes/footer.jsp" %>
