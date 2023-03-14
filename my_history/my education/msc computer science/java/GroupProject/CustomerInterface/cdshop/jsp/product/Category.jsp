<%@ include file="/jsp/cust/AutoLogin.jsp" %> 
<%@ page import="com.cdshop.product.Product" %>
<%@ page import="com.cdshop.product.Category" %>
<%@ page import="com.cdshop.cart.Cart" %>
<%@ page import="java.util.Iterator" %>  


<% Category cat = null;    

if (((request.getParameter("category") != null) &&  
     (cat = Category.findCategory(request.getParameter("category"))) != null)) {
%>
<head>
<title><%= cat.getName() %></title>
</head>

<%@ include file="/jsp/includes/header.jsp" %>
<jsp:useBean id="customer" class="com.cdshop.customer.Customer" scope="session"/>
<jsp:useBean id="cart" class="com.cdshop.cart.Cart" scope="session"/>
 
    <% 
if (cat.getFeaturedProduct() != null) {
    Product feat = cat.getFeaturedProduct();
  
%>

<table border="0" cellpadding="0" cellspacing="0" bordercolor="#111111" width="639">
      <tr>
        <td width="128">
        <img border="0" src="/cdshop/jsp/images/products/<%= feat.getCdId() %>.jpg" align="left" width="140" height="173"></td>
        <td valign="top" width="511">
        <h3 align="center">
        <span style="font-size: 10.0pt; font-family: Times New Roman">
	<%= feat.getTitle() %>
	</span></h3>
        <p align="center">
        <span style="font-size: 10.0pt; font-family: Times New Roman">
	By <%= feat.getArtist() %>
	</span></p>
        <p align="center"><font size="2" face="Times New Roman">Publication 
        date: </font>
        <span style="font-size: 10.0pt; font-family: Times New Roman">
	<%= feat.getPubDate() %>, <font color=#990000>&pound;<%= feat.getPrice() %></font>
	</span></td>
      </tr>
    </table>
    <p><span style="font-size: 10.0pt">
    <%= feat.getDescription() %>
    </span></p>  
    <p><font size="2">
    <a href="buyit.jsp">[Buy It!]</a></font></p>
    <p align="center">&nbsp;
     </td> 
                
  </tr>
</table>
    <% } %>

<FORM METHOD="POST" ACTION="buyit.jsp" TARGET="tempwindow">
<table border="0" cellpadding="0" cellspacing="0" 
style="border-collapse: collapse" bordercolor="#111111" 
width="100%" id="AutoNumber4" height="253">
  <tr>
    <th width="38%" height="23" align="left">Title</th>
    <th width="23%" height="23" align="left">Author</th>
    <th width="11%" height="23" align="left">Price</th>
    <th width="28%" height="23" align="center">Quantity</td>
  </tr>
    <%
    Iterator iter = cat.getProducts().iterator();       
    while (iter.hasNext()) {
	Product prod = (Product) iter.next(); 
%>
  <tr>
    <td width="38%" height="38" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
        <A HREF="Product.jsp?CD_ID=<%= prod.getCdId() %>">
        <%= prod.getTitle() %></A>
    </span></td>
    <td width="23%" height="38" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
       <%= prod.getArtist() %>
    </span></td>
    <td width="11%" height="38" bgcolor="#00FFFF">
    <span style="font-size: 10.0pt; font-family: Times New Roman">
    <font color=#990000>&pound;<%= prod.getPrice() %></font>
    </span></td>
    <td width="28%" height="38" bgcolor="#00FFFF">
    <p align="center"><font size="2">
    <INPUT NAME="CD_ID<%= prod.getCdId() %>" TYPE="TEXT" SIZE=2>
    <INPUT TYPE="SUBMIT" VALUE="Buy">
    </font></td>
  </tr>

       <% }
} else {
%>

<head>
<title>Category Not Found</title>
</head>

<%@ include file="/jsp/includes/header.jsp" %>

<H1>The requested Category was not found.</H1>
If you believe you have reached this page in error, please contact
<A HREF="mailto: info@G6C.com">info@G6C.com</A>
<% } %>
<%@ include file="/jsp/includes/footer.jsp" %>





