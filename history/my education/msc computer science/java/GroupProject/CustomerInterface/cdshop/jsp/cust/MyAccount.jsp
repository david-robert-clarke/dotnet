<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.cdshop.customer.Customer" %>
<%@ page import="com.cdshop.customer.Address" %>
<%@ page import="com.cdshop.customer.CreditCard" %>
<%@ page import="com.cdshop.product.Order" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Vector" %>

<jsp:useBean id="customer" class="com.cdshop.customer.Customer" scope="session"/>
<% if (customer.getEmail() == null) {
    response.sendRedirect("Login.jsp");
    return;
}
%>
<head>
<title>Account Maintainence</title>
</head>

<%@ include file="/jsp/includes/header.jsp" %>

<h2 align="center">Account Maintainence</h2>
<center><h2>Address Book</h2></center>
<A HREF="NewAddress.jsp">Create New Address</A>
<% if (customer.getAddressBook().size() > 0) { %>
<TABLE WIDTH="100%">
  <TR><TH>Name</TH><TH>City</TH><TH>Edit</TH><TH>Delete</TH></TR>
<% 
Iterator it = customer.getAddressBook().keySet().iterator();
while (it.hasNext()) {
    Address addr = (Address) customer.getAddressBook().get(it.next());
%>
	<TR><TD><%= addr.getFirstName() %> <%= addr.getLastName() %></TD>
	    <TD><%= addr.getCity() %></TD>
	    <TD><A HREF="NewAddress.jsp?operation=update&addressId=<%= addr.getAddressID() %>">X</A></TD>
	    <TD><A HREF="DeleteAddress.jsp?addressId=<%= addr.getAddressID() %>" TARGET="tempwindow">X</A></TD></TR>
<% } %>
</TABLE>
<% } %>

<center><h2>Credit Cards</h2></center>
<A HREF="NewCreditCard.jsp">Add New Card</A>
<% if (customer.getWallet().size() > 0) { %>
<TABLE WIDTH="100%">
  <TR><TH>Cardholder</TH><TH>Card Number</TH><TH>Edit</TH><TH>Delete</TH></TR>
<% 
Iterator it = customer.getWallet().keySet().iterator();
while (it.hasNext()) {
    CreditCard cc = (CreditCard) customer.getWallet().get(it.next());
%>
	<TR><TD><%= cc.getCardOwner() %> </TD>
	    <TD><%= cc.getObscuredNumber() %></TD>
	    <TD><A HREF="NewCreditCard.jsp?operation=update&cardId=<%= cc.getCardID() %>">X</A></TD>
	    <TD><A HREF="DeleteAddress.jsp?cardId=<%= cc.getCardID() %>" TARGET="tempwindow">X</A></TD></TR>
<% } %>
</TABLE>
<% } %>

<center><h2>Order History</h2></center>
<% Vector history = customer.getOrderHistory();

if (history.size() > 0) { %>
<TABLE WIDTH="100%">
  <TR><TH ALIGN="LEFT">Order</TH><TH ALIGN="LEFT">Date</TH>
    <TH ALIGN="LEFT">Amount</TH></TR>
<% 
Iterator it = history.iterator();
while (it.hasNext()) {
    Order or = (Order) it.next();
%>
	<TR><TD><A HREF="viewOrder.jsp?order=<%= or.getOrderNumber() %>">
	     <%= or.getOrderNumber() %> </A></TD>
	    <TD><%= or.getOrderDate() %></TD>
	    <TD><font color=#990000>&pound;<%= or.getOrderTotalString().substring(1) %></font></TD></TR>
<% } %>
</TABLE>
<% } %>

<%@ include file="/jsp/includes/footer.jsp" %>


