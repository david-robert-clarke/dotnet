<%@ page import="com.cdshop.product.Product" %>
<%@ page import="com.cdshop.cart.Cart" %>
<%@ page import="com.cdshop.cart.CartItem" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.text.NumberFormat" %>

<jsp:useBean id="cart" class="com.cdshop.cart.Cart" scope="session"/>
<%
Enumeration names = request.getParameterNames();
NumberFormat nf = NumberFormat.getInstance();
while (names.hasMoreElements()) {
    String name = (String) names.nextElement();
    if (name.startsWith("CD_ID")) {
	String CD_ID = name.substring(5);
	Product prod = Product.findProduct(CD_ID);
	if (prod != null) {
            CartItem item = cart.getItem(prod);
	    if (item != null) {
		if ((request.getParameter(name) != null) &&
		    (request.getParameter(name).length() > 0)) {
		    try {
			int quantity = nf.parse(request.getParameter(name)).intValue();
			out.print(quantity);
			if (quantity > 0) {
			    item.setQuantity(quantity);
			}
			if (quantity == 0) {
			    cart.removeItem(prod);
			}
		    } catch (NumberFormatException e) {
		    }
		}
	    }
	}
    }
}

%>
<SCRIPT>
if (window.opener && !window.opener.closed)
<%
    if (request.getParameter("checkout") != null) {
%>	
   window.opener.location = "/cdshop/jsp/checkout.jsp";
<% } else { %>
   window.opener.location.reload();
<% } %>
window.close();
</SCRIPT>
