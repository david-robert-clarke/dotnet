<%@ page import="org.apache.turbine.util.TurbineConfig" %>
<%@ page import="org.apache.turbine.services.db.TurbineDB" %>
<%@ page import="org.apache.turbine.util.db.pool.DBConnection" %>
<%@ page import="java.sql.*" %>
<HTML>
<HEAD>
<TITLE>A JDBC SmokeTest</TITLE>
</HEAD>
<BODY>
This is a smoketest

<%
DBConnection dbConn = TurbineDB.getConnection();
PreparedStatement pstmt = dbConn.prepareStatement("select * from Customer");
ResultSet rs = pstmt.executeQuery();
if (rs.next()) {
    out.print("Got a result set!");
} else {
    out.print("No result set found!!");
}
rs.close();
pstmt.close();
TurbineDB.releaseConnection(dbConn);
%>
</BODY>
</HTML>
