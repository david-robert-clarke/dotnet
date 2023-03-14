<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.cdshop.customer.Customer" %>
<%@ page import="com.cdshop.customer.Address" %>
<%@ page import="java.text.NumberFormat" %>
<jsp:useBean id="customer" class="com.cdshop.customer.Customer" scope="session"/>
<jsp:useBean id="newaddr" class="com.cdshop.customer.Address" scope="request"/>
<% if (customer.getEmail() == null) {
    response.sendRedirect("Login.jsp");
    return;
}
%>
<jsp:setProperty name="newaddr" property="*"/>

<% 
NumberFormat nf = NumberFormat.getInstance();
String operation = request.getParameter("operation");
if (operation == null) {
    operation = "create";
}

if (request.getParameter("SUBMITTED") != null) {
    if (newaddr.validateAddress()) {
	if (operation.equals("update")) {
	    String addrId = request.getParameter("addressId");
	    if (addrId != null) {
		Integer id = null;
		try {
		    Number num = nf.parse(request.getParameter("addressId"));
		    id = new Integer(num.intValue());
		} catch (Exception e) {
		    response.sendRedirect("general_error.jsp");
		    return;
		}
		Address addr = (Address) customer.getAddressBook().get(id);
		if (addr != null) {
		    newaddr.setAddressID(id.intValue());
		    newaddr.updateAddress();
		    customer.addAddress(newaddr);
		    response.sendRedirect("MyAccount.jsp");
		    return;
		} else {
		    response.sendRedirect("noaccess.jsp");
		    return;
		}
	    } else {
		response.sendRedirect("general_error.jsp");
	    } 
	}
	else {
	    newaddr.createAddress();
	    customer.addAddress(newaddr);
	    response.sendRedirect("MyAccount.jsp");
	    return;
	}
    }
} else {
    if (operation.equals("update")) {
	String addrId = request.getParameter("addressId");
	if (addrId != null) {
	    Integer id = null;
	    try {
		Number num = nf.parse(request.getParameter("addressId"));
		id = new Integer(num.intValue());
	    } catch (Exception e) {
		response.sendRedirect("general_error.jsp");
		return;
	    }
	    Address addr = (Address) customer.getAddressBook().get(id);
	    if (addr != null) {
		newaddr = addr;
	    }
	}
    }
}
	

if (newaddr.getLastName() == null) {
    newaddr.setLastName("");
}
if (newaddr.getFirstName() == null) {
    newaddr.setFirstName("");
}
if (newaddr.getStreet1() == null) {
    newaddr.setStreet1("");
}
if (newaddr.getStreet2() == null) {
    newaddr.setStreet2("");
}
if (newaddr.getCity() == null) {
    newaddr.setCity("");
}
if (newaddr.getPostalCode() == null) {
    newaddr.setPostalCode("");
}

%>
<% if (operation.equals("update")) { %>
<HEAD><TITLE>Edit Address</TITLE></HEAD><BODY>
<%     } else {%>
<HEAD><TITLE>Create New Address</TITLE></HEAD><BODY>
<% } %>
<%@ include file="/jsp/includes/header.jsp" %>
<% if (operation.equals("update")) { %>
<CENTER><H1>Edit Address</H1></CENTER>
<%     } else {%>
<CENTER><H1>Create New Address</H1></CENTER>
<% } %>
<FORM METHOD=POST ACTION="NewAddress.jsp">
<INPUT TYPE="HIDDEN" NAME="SUBMITTED" VALUE="T">
<INPUT TYPE="HIDDEN" NAME="operation" VALUE="<%= operation %>">
<INPUT TYPE="HIDDEN" NAME="addressId" VALUE="<%= request.getParameter("addressId") %>">

<% if (newaddr.getFieldError("firstName") != null) { %>
<FONT COLOR="#FF0000"><%= newaddr.getFieldError("firstName")%></FONT><BR>
<% } %>

<% if (newaddr.getFieldError("lastName") != null) { %>
<FONT COLOR="#FF0000"><%= newaddr.getFieldError("lastName")%></FONT><BR>
<% } %>

First Name: <INPUT NAME="firstName" TYPE="TEXT" SIZE=30
       VALUE="<%= newaddr.getFirstName() %>">
Last Name: <INPUT NAME="lastName" TYPE="TEXT" SIZE=40
       VALUE="<%= newaddr.getLastName() %>"><BR>

<% if (newaddr.getFieldError("street1") != null) { %>
<FONT COLOR="#FF0000"><%= newaddr.getFieldError("street1")%></FONT><BR>
<% } %>

Street Addr 1: <INPUT NAME="street1" TYPE="TEXT" SIZE=80
       VALUE="<%= newaddr.getStreet1() %>"><BR>
Street Addr 2: <INPUT NAME="street2" TYPE="TEXT" SIZE=80
       VALUE="<%= newaddr.getStreet2() %>"><BR>

<% if (newaddr.getFieldError("city") != null) { %>
<FONT COLOR="#FF0000"><%= newaddr.getFieldError("city")%></FONT><BR>
<% } %>


<% if (newaddr.getFieldError("postalCode") != null) { %>
<FONT COLOR="#FF0000"><%= newaddr.getFieldError("postalCode")%></FONT><BR>
<% } %>

City: <INPUT NAME="city" TYPE="TEXT" SIZE=50
       VALUE="<%= newaddr.getCity() %>">

Postal Code: <INPUT NAME="postalCode" TYPE="TEXT" SIZE=10
       VALUE="<%= newaddr.getPostalCode() %>"><BR>

<INPUT TYPE=SUBMIT>
</FORM>
<%@ include file="/jsp/includes/footer.jsp" %>
