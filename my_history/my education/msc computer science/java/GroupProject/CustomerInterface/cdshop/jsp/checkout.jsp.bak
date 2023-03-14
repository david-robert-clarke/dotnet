<%@ include file="/jsp/cust/AutoLogin.jsp" %>
<%@ page import="com.bfg.customer.Customer" %>
<%@ page import="com.bfg.customer.Address" %>
<%@ page import="com.bfg.customer.CreditCard" %>
<%@ page import="java.text.NumberFormat" %>
<jsp:useBean id="customer" class="com.bfg.customer.Customer" scope="session"/>
<jsp:useBean id="orderaddr" class="com.bfg.customer.Address" scope="session"/>
<jsp:useBean id="ordercredit" class="com.bfg.customer.CreditCard" scope="session"/>
<jsp:setProperty name="orderaddr" property="*"/>
<jsp:setProperty name="ordercredit" property="*"/>
<%
Address ccaddr = new Address();
NumberFormat nf = NumberFormat.getInstance();

boolean loggedInUser = (customer.getEmail() != null);
String selectedCCId = request.getParameter("selectedCCId");
String selectedAddrId = request.getParameter("selectedAddrId");
if (selectedCCId == null) {
    selectedCCId = "NEW";
}

if (selectedAddrId == null) {
    selectedAddrId = "NEW";
}

if (request.getParameter("SUBMITTED") != null) {
    ccaddr.setFirstName(request.getParameter("ccFirstName"));
    ccaddr.setLastName(request.getParameter("ccLastName"));
    ccaddr.setStreet1(request.getParameter("ccStreet1"));
    ccaddr.setStreet2(request.getParameter("ccStreet2"));
    ccaddr.setCity(request.getParameter("ccCity"));
    ccaddr.setState(request.getParameter("ccState"));
    ccaddr.setPostalCode(request.getParameter("ccPostalCode"));

    Integer ccId;
    if (!selectedCCId.equals("NEW")) {
	try {
	    Number num = nf.parse(selectedCCId);
	    Integer CCId = new Integer(num.intValue());
	    if (customer.getWallet().get(CCId) != null) {
		ordercredit = (CreditCard) customer.getWallet().get(CCId);
		ccaddr = ordercredit.getAddress();
		pageContext.setAttribute("ordercredit", ordercredit, 
					 PageContext.SESSION_SCOPE);
	}
	} catch (Exception e) {
	    response.sendRedirect("general_error.jsp");
	    return;
	}
    }

    if (!selectedAddrId.equals("NEW")) {
	try {
	    Number num = nf.parse(selectedAddrId);
	    Integer AddrId = new Integer(num.intValue());
	    if (customer.getAddressBook().get(AddrId) != null) {
		orderaddr = (Address) customer.getAddressBook().get(AddrId);
		pageContext.setAttribute("orderaddr", orderaddr, 
					 PageContext.SESSION_SCOPE);
	}
	} catch (Exception e) {
	    response.sendRedirect("general_error.jsp");
	    return;
	}
    }

    boolean goodAddress = orderaddr.validateAddress();
    boolean goodCCAddress = ccaddr.validateAddress();
    boolean goodCard = ordercredit.validateCreditCard();
    if (goodAddress && goodCCAddress && goodCard) {
	if ((request.getParameter("createShip") != null) &&
	    (request.getParameter("createShip").equals("yes"))) {
	    orderaddr.createAddress();
	    customer.addAddress(orderaddr);
	}
	if ((request.getParameter("createCC") != null) &&
	    (request.getParameter("createCC").equals("yes"))) {
	    ccaddr.createAddress();
	    ordercredit.setAddress(ccaddr);
	    ordercredit.setCustomer(customer);
	    ordercredit.createCreditCard();
	    customer.getWallet().put(new Integer(ordercredit.getCardID()),
				     ordercredit);
	}
	response.sendRedirect("finalConfirm.jsp");
	return;
    }
} else {
    orderaddr = new Address();
    pageContext.setAttribute("orderaddr", orderaddr, 
			     PageContext.SESSION_SCOPE);
    ordercredit = new CreditCard();
    pageContext.setAttribute("ordercredit", ordercredit, 
			     PageContext.SESSION_SCOPE);
    ccaddr = new Address();
    pageContext.setAttribute("ccaddr", ccaddr, 
			     PageContext.SESSION_SCOPE);
}

if (orderaddr.getLastName() == null) {
    orderaddr.setLastName("");
}
if (orderaddr.getFirstName() == null) {
    orderaddr.setFirstName("");
}
if (orderaddr.getStreet1() == null) {
    orderaddr.setStreet1("");
}
if (orderaddr.getStreet2() == null) {
    orderaddr.setStreet2("");
}
if (orderaddr.getCity() == null) {
    orderaddr.setCity("");
}

if (orderaddr.getState() == null) {
    orderaddr.setState("");
}

if (orderaddr.getPostalCode() == null) {
    orderaddr.setPostalCode("");
}

if (ccaddr.getLastName() == null) {
    ccaddr.setLastName("");
}

if (ccaddr.getFirstName() == null) {
    ccaddr.setFirstName("");
}

if (ccaddr.getStreet1() == null) {
    ccaddr.setStreet1("");
}

if (ccaddr.getStreet2() == null) {
    ccaddr.setStreet2("");
}

if (ccaddr.getCity() == null) {
    ccaddr.setCity("");
}

if (ccaddr.getState() == null) {
    ccaddr.setState("");
}

if (ccaddr.getPostalCode() == null) {
    ccaddr.setPostalCode("");
}

if (ordercredit.getCardOwner() == null) {
    ordercredit.setCardOwner("");
}

if (ordercredit.getCardType() == null) {
    ordercredit.setCardType("");
}

if (ordercredit.getCardNumber() == null) {
    ordercredit.setCardNumber("");
}

%>
<HEAD><TITLE>Enter Purchase Information</TITLE></HEAD><BODY>
<%@ include file="/jsp/includes/bfgheader.jsp" %>
<CENTER><H1>Enter Purchase Information</H1></CENTER>
<FORM METHOD=POST ACTION="checkout.jsp">
<INPUT TYPE="HIDDEN" NAME="SUBMITTED" VALUE="T">
<H2>Credit Card</H2>
<% if (loggedInUser) { 
    if (customer.getWallet().size() > 0) {
%>
Select Card From Wallet: <SELECT NAME="selectedCCId">
<OPTION VALUE="NEW">New Card
<% 
Iterator it = customer.getWallet().keySet().iterator();
while (it.hasNext()) {
    CreditCard cc = (CreditCard) customer.getWallet().get((Integer)it.next());
%>
    <OPTION VALUE="<%= cc.getCardID() %>"><%= cc.getCardType() %>: <%= cc.getObscuredNumber() %>
<% } %>
</SELECT><P> -- or -- <P>
<% } else { %>
<INPUT TYPE="HIDDEN" NAME="selectedCCId" VALUE="NEW">
<% }
} 

if (ordercredit.getFieldError("cardOwner") != null) { %>
<FONT COLOR="#FF0000"><%= ordercredit.getFieldError("cardOwner")%></FONT><BR>
<% } %>

Name on Card: <INPUT NAME="cardOwner" TYPE="TEXT" SIZE=50
       VALUE="<%= ordercredit.getCardOwner() %>"><BR>

<% if (ordercredit.getFieldError("cardType") != null) { %>
<FONT COLOR="#FF0000"><%= ordercredit.getFieldError("cardType")%></FONT><BR>
<% } %>

Card Type: <SELECT NAME="cardType">
<OPTION VALUE="">---SELECT---
<OPTION VALUE="VISA"
    <%= (ordercredit.getCardType().equals("VISA"))?" SELECTED":"" %>>Visa
<OPTION VALUE="MC"
    <%= (ordercredit.getCardType().equals("MC"))?" SELECTED":"" %>>MasterCard
<OPTION VALUE="AMEX"
    <%= (ordercredit.getCardType().equals("AMEX"))?" SELECTED":"" %>>American Express
<OPTION VALUE="DISC"
    <%= (ordercredit.getCardType().equals("DISC"))?" SELECTED":"" %>>Discover
</SELECT><BR>

<% if (ordercredit.getFieldError("cardNumber") != null) { %>
<FONT COLOR="#FF0000"><%= ordercredit.getFieldError("cardNumber")%></FONT><BR>
<% } %>
<% if (ordercredit.getFieldError("expMonth") != null) { %>
<FONT COLOR="#FF0000"><%= ordercredit.getFieldError("expMonth")%></FONT><BR>
<% } %>

<% if (ordercredit.getFieldError("expYear") != null) { %>
<FONT COLOR="#FF0000"><%= ordercredit.getFieldError("expYear")%></FONT><BR>
<% } 
int expMonth = ordercredit.getExpMonth();
int expYear = ordercredit.getExpYear();
%>


Card Number: <INPUT NAME="cardNumber" TYPE="TEXT" SIZE=25
       VALUE="<%= (!selectedCCId.equals("NEW"))?ordercredit.getObscuredNumber():ordercredit.getCardNumber() %>"><BR>

Expires: <SELECT NAME="expMonth">
  <OPTION VALUE="">SELECT
  <OPTION VALUE="1" <%= (expMonth == 1)?" SELECTED":"" %>>Jan
  <OPTION VALUE="2" <%= (expMonth == 2)?" SELECTED":"" %>>Feb
  <OPTION VALUE="3" <%= (expMonth == 3)?" SELECTED":"" %>>Mar
  <OPTION VALUE="4" <%= (expMonth == 4)?" SELECTED":"" %>>Apr
  <OPTION VALUE="5" <%= (expMonth == 5)?" SELECTED":"" %>>May
  <OPTION VALUE="6" <%= (expMonth == 6)?" SELECTED":"" %>>Jun
  <OPTION VALUE="7" <%= (expMonth == 7)?" SELECTED":"" %>>Jul
  <OPTION VALUE="8" <%= (expMonth == 8)?" SELECTED":"" %>>Aug
  <OPTION VALUE="9" <%= (expMonth == 9)?" SELECTED":"" %>>Sep
  <OPTION VALUE="10" <%= (expMonth == 10)?" SELECTED":"" %>>Oct
  <OPTION VALUE="11" <%= (expMonth == 11)?" SELECTED":"" %>>Nov
  <OPTION VALUE="12" <%= (expMonth == 12)?" SELECTED":"" %>>Dec
</SELECT> /

<SELECT NAME="expYear">
  <OPTION VALUE="">SELECT
  <OPTION VALUE="2002" <%= (expYear == 2002)?" SELECTED":"" %>>02
  <OPTION VALUE="2003" <%= (expYear == 2003)?" SELECTED":"" %>>03
  <OPTION VALUE="2004" <%= (expYear == 2004)?" SELECTED":"" %>>04
  <OPTION VALUE="2005" <%= (expYear == 2005)?" SELECTED":"" %>>05
  <OPTION VALUE="2006" <%= (expYear == 2006)?" SELECTED":"" %>>06
  <OPTION VALUE="2007" <%= (expYear == 2007)?" SELECTED":"" %>>07
  <OPTION VALUE="2008" <%= (expYear == 2008)?" SELECTED":"" %>>08
  <OPTION VALUE="2009" <%= (expYear == 2009)?" SELECTED":"" %>>09
  <OPTION VALUE="2010" <%= (expYear == 2010)?" SELECTED":"" %>>10
  <OPTION VALUE="2011" <%= (expYear == 2011)?" SELECTED":"" %>>11
  <OPTION VALUE="2012" <%= (expYear == 2012)?" SELECTED":"" %>>12<P>
</SELECT><P>
<H3>Credit Card Billing Address</H3><P>

<% if (ccaddr.getFieldError("firstName") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("firstName")%></FONT><BR>
<% } %>

<% if (ccaddr.getFieldError("lastName") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("lastName")%></FONT><BR>
<% } %>

First Name: <INPUT NAME="ccFirstName" TYPE="TEXT" SIZE=30
       VALUE="<%= ccaddr.getFirstName() %>">
Last Name: <INPUT NAME="ccLastName" TYPE="TEXT" SIZE=40
       VALUE="<%= ccaddr.getLastName() %>"><BR>

<% if (ccaddr.getFieldError("street1") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("street1")%></FONT><BR>
<% } %>

Street Addr 1: <INPUT NAME="ccStreet1" TYPE="TEXT" SIZE=80
       VALUE="<%= ccaddr.getStreet1() %>"><BR>
Street Addr 2: <INPUT NAME="ccStreet2" TYPE="TEXT" SIZE=80
       VALUE="<%= ccaddr.getStreet2() %>"><BR>

<% if (ccaddr.getFieldError("city") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("city")%></FONT><BR>
<% } %>

<% if (ccaddr.getFieldError("state") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("state")%></FONT><BR>
<% } %>

<% if (ccaddr.getFieldError("postalCode") != null) { %>
<FONT COLOR="#FF0000"><%= ccaddr.getFieldError("postalCode")%></FONT><BR>
<% } %>

City: <INPUT NAME="ccCity" TYPE="TEXT" SIZE=50
       VALUE="<%= ccaddr.getCity() %>">
State: <INPUT NAME="ccState" TYPE="TEXT" SIZE=2
       VALUE="<%= ccaddr.getState() %>">
Postal Code: <INPUT NAME="ccPostalCode" TYPE="TEXT" SIZE=10
       VALUE="<%= ccaddr.getPostalCode() %>"><P>
<% if (loggedInUser) { %>
<INPUT TYPE="CHECKBOX" NAME="createCC" VALUE="yes"> Add to Wallet<P>
<% } %>

<H2>Shipping Address</H2>
<% if (loggedInUser) { 
    if (customer.getAddressBook().size() > 0) {
%>
Select Address from Address Book: <SELECT NAME="selectedAddrId">
<OPTION VALUE="NEW">New Address
<% 
Iterator it = customer.getAddressBook().keySet().iterator();
while (it.hasNext()) {
    Address ad = (Address) customer.getAddressBook().get((Integer)it.next());
%>
    <OPTION VALUE="<%= ad.getAddressID() %>"><%= ad.getFirstName() %>
	           <%= ad.getLastName() %> (<%= ad.getCity() %>,
	           <%= ad.getState() %>)
<% } %>
</SELECT><P> -- or -- <P>
<% } else { %>
<INPUT TYPE="HIDDEN" NAME="selectedAddrId" VALUE="NEW">
<% }
} 

if (orderaddr.getFieldError("firstName") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("firstName")%></FONT><BR>
<% } %>

<% if (orderaddr.getFieldError("lastName") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("lastName")%></FONT><BR>
<% } %>

First Name: <INPUT NAME="firstName" TYPE="TEXT" SIZE=30
       VALUE="<%= orderaddr.getFirstName() %>">
Last Name: <INPUT NAME="lastName" TYPE="TEXT" SIZE=40
       VALUE="<%= orderaddr.getLastName() %>"><BR>

<% if (orderaddr.getFieldError("street1") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("street1")%></FONT><BR>
<% } %>

Street Addr 1: <INPUT NAME="street1" TYPE="TEXT" SIZE=80
       VALUE="<%= orderaddr.getStreet1() %>"><BR>
Street Addr 2: <INPUT NAME="street2" TYPE="TEXT" SIZE=80
       VALUE="<%= orderaddr.getStreet2() %>"><BR>

<% if (orderaddr.getFieldError("city") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("city")%></FONT><BR>
<% } %>

<% if (orderaddr.getFieldError("state") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("state")%></FONT><BR>
<% } %>

<% if (orderaddr.getFieldError("postalCode") != null) { %>
<FONT COLOR="#FF0000"><%= orderaddr.getFieldError("postalCode")%></FONT><BR>
<% } %>

City: <INPUT NAME="city" TYPE="TEXT" SIZE=50
       VALUE="<%= orderaddr.getCity() %>">
State: <INPUT NAME="state" TYPE="TEXT" SIZE=2
       VALUE="<%= orderaddr.getState() %>">
Postal Code: <INPUT NAME="postalCode" TYPE="TEXT" SIZE=10
       VALUE="<%= orderaddr.getPostalCode() %>"><P>
<% if (loggedInUser) { %>
<INPUT TYPE="CHECKBOX" NAME="createShip" VALUE="yes"> Add to Address Book<P>
<% } %>
<INPUT TYPE=SUBMIT>
</FORM>
<%@ include file="/jsp/includes/bfgfooter.jsp" %>



