<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Balance</title>
	<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
</head>
<body>

<%
		if(session.getAttribute("phno")==null){
					response.sendRedirect("login.jsp");
		}
%>


<%
		float customerbalance=(float)request.getAttribute("customerbalance");

%>
		<nav class=" nav navbar-DEFAULT">
					<div class="navbar-header">
													<a class="navbar-brand" href="#">Paytm</a>
					</div>


					<div class=" nav navbar-nav navbar-left">
								<li style="text-transform: uppercase;">	<a>	WELCOME <%=  session.getAttribute("uname") %></a></li>

					</div>


						<div class=" nav navbar-nav navbar-right">
								<li><a href="#first">HOME</a></li>
									<li><a href="#sec">ABOUT US</a></li>
									<li><a href="/Banking/LogoutCustomer">LOGOUT</a></li>


					</div>

					

		</nav>

							 
							 
							   <div class="alert alert-success">
									    <strong><%= customerbalance %></strong> IS Your Current Account Balance
								</div>
							
							<div class="alert alert-info">
    <strong> Exciting Recharge Offers!</strong>Find Your Nearest Recharge Stores <a href="#">WW.STORES.COM</a>
  </div>											 
							 
					
						
</body>
</html>