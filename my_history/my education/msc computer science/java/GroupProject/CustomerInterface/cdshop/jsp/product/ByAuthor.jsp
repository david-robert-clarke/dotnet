<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.bfg.product.Product" %>
<%@ page import="com.bfg.product.Author" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.bfg.cart.Cart" %>
<jsp:useBean id="cart" class="com.bfg.cart.Cart" scope="session"/>
<% Author author = null;
if (((request.getParameter("author") != null) &&  
     (author = Author.findAuthor(request.getParameter("author"))) != null)) {
%>
<head>
<title>Books By <%= author.getName() %></title>
</head>

<%@ include file="/jsp/includes/bfgheader.jsp" %>


    <h2 align="center">Books By <%= author.getName() %></h2>
<table border="0" cellpadding="5" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber4" height="253">
  <tr>
    <th width="38%" height="23" align="left">Title</th>
    <th width="23%" height="23" align="left">Author</th>
    <th width="11%" height="23" align="left">Price</th>
    <td width="28%" height="23" align="left">&nbsp;</td>
  </tr>
    <%
    Iterator iter = author.getBooks().iterator();
    while (iter.hasNext()) {
	Product prod = (Product) iter.next();
%>
  <tr>
    <td width="38%" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
       <A HREF="Product.jsp?ISBN=<%= prod.getISBN() %>">
        <%= prod.getTitle() %></A>
    </span></td>
    <td width="23%" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
       <%= prod.getAuthorString() %>
    </span></td>
    <td width="11%" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
    <%= prod.getPriceString() %>
    </span></td>
    <td width="28%" bgcolor="#00FFFF">
    <p align="center"><font size="2"><a href="Product.jsp?ISBN=<%= prod.getISBN()%>">
       [More Information] </A>
    [Buy It!]</font></td>
  </tr>
       <% }
} else {
%>
<head>
<title>Author Not Found</title>
</head>

<%@ include file="/jsp/includes/bfgheader.jsp" %>

<H1>The requested ISBN was not found.</H1>
If you believe you have reached this page in error, please contact
<A HREF="mailto: info@bfgbooks.com">info@bfgbooks.com</A>
<% } %>
<%@ include file="/jsp/includes/bfgfooter.jsp" %>

  





