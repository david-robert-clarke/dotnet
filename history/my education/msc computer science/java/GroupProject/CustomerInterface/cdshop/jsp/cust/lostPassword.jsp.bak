<%@ page import="com.bfg.customer.Customer" %>

<% 
    String email = request.getParameter("email");
boolean not_found = false;
    if (email == null) {
	email = "";
    }
if (request.getParameter("SUBMITTED") != null) {
    Customer c = Customer.findCustomer(email);
    if (c != null) {
	c.sendPasswordReminder();
	response.sendRedirect("sendPassword.jsp");
    }
    not_found = true;
}
%>
<HEAD><TITLE>Lost Password Retrieval</TITLE></HEAD><BODY>
Please enter the e-Mail address you used to register your account.
<FORM METHOD=POST ACTION="lostPassword.jsp">
<INPUT TYPE="HIDDEN" NAME="SUBMITTED" VALUE="T">

<% if (not_found) { %>
<FONT COLOR="#FF0000">Address not found in customer records.</FONT><BR>
<% } %>

e-Mail Address: <INPUT NAME="email" TYPE="TEXT" SIZE=50
       VALUE="<%= email %>"><BR>
<INPUT TYPE=SUBMIT>
</FORM>
</BODY>


