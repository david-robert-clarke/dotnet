<%@ page import="com.cdshop.customer.Customer" %>
<jsp:useBean id="newcust" class="com.cdshop.customer.Customer" scope="request"/>
<jsp:setProperty name="newcust" property="*"/>

<% 
if (request.getParameter("SUBMITTED") != null) {
   
    try {   
	    if(newcust.validateCustomer()){    
	    newcust.createCustomer();
	    response.sendRedirect("NewSuccess.jsp");
	    }
    } catch (com.cdshop.exceptions.DuplicateEmailAddressException e) {
          newcust.addFieldError("email", 
			      "e-Mail address already in use. <BR>" +
			      "Please input again ");
    }
}
if (newcust.getEmail() == null) {
    newcust.setEmail("");
}
if (newcust.getPassword() == null) {
    newcust.setPassword("");
}
%>
<HEAD><TITLE>Create New Customer Account</TITLE></HEAD><BODY>

<FORM METHOD="POST" ACTION="NewCustomer.jsp">
<INPUT TYPE="HIDDEN" NAME="SUBMITTED" value="T">

<% if (newcust.getFieldError("email") != null) { %>
<FONT COLOR="#FF0000"><%= newcust.getFieldError("email")%></FONT><BR>
<% } %>

E-Mail Address: <INPUT NAME="email" TYPE="TEXT" SIZE=50
       VALUE="<%= newcust.getEmail() %>"><BR>
       
<% if (newcust.getFieldError("password") != null) { %>
<FONT COLOR="#FF0000"><%= newcust.getFieldError("password")%></FONT><BR>
<% } %>

Password: <INPUT NAME="password" TYPE="PASSWORD" SIZE=50
       VALUE="<%= newcust.getPassword() %>"><BR>
<INPUT TYPE="SUBMIT" value="Enter" >
</FORM>
</BODY>


