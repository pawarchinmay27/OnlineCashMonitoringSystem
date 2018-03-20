<%@page import="com.abc.domain.CashOrNoCashDomain"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchBank</title>
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="/Banking/css/w3.css">
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="/Banking/css/style.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/animate.css" rel="stylesheet" type="text/css">
<style>
body {margin:0;}
ul.topnav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
  display: inline-block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  transition: 0.3s;
  font-size: 17px;
}

ul.topnav li a:hover {background-color: #555;}

ul.topnav li.icon {display: none;}

@media screen and (max-width:680px) {
  ul.topnav li:not(:first-child) {display: none;}
  ul.topnav li.icon {
    float: right;
    display: inline-block;
  }
}

@media screen and (max-width:680px) {
  ul.topnav.responsive {position: relative;}
  ul.topnav.responsive li.icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  ul.topnav.responsive li {
    float: none;
    display: inline;
  }
  ul.topnav.responsive li a {
    display: block;
    text-align: left;
  }
}
tr th{
			text-align: center;
	}
</style>


</head>
<body>
		<nav class=" nav navbar-DEFAULT">
					<div class="navbar-header">
													<a class="navbar-brand" href="#">Paytm</a>
					</div>


					<div class=" nav navbar-nav navbar-left">

					</div>


						<div class=" nav navbar-nav navbar-right">
								<li><a href="/Banking/LogoutCustomer">LOGOUT</a></li>
									<li><a href="#sec">ABOUT US</a></li>
									<li><a href="#">QUICK PLAY</a></li>


					</div>

					

		</nav>
			
						

<%ArrayList<CashOrNoCashDomain> rs=(ArrayList)request.getAttribute("Bank_Status"); 

%>


<table border="1px" class="table  table-striped">
										<tr >
														<th>ZONE</th>
														<th>BANK NAME</th>
														<th>CASH STATUS</th>
														<th>CROWD STATUS</th>
														<th>MAX CASH LIMIT</th>
														<th>REGION</th>
										</tr>
						<%
									for(CashOrNoCashDomain cod:rs){
										
									
						
						%>
						<tr style="text-transform: uppercase;text-align: center;">
										<td ><%= cod.getZone() %></td>
										<td ><%= cod.getBank_name()  %></td>
										<td ><%= cod.getCash_stat() %></td>
										<td ><%= cod.getCrowd_stat() %></td>
										<td><%= cod.getMax_cash_limit()%></td>
										<td ><%= cod.getREGION() %></td>
										
						</tr>				
						<%
									}
						%>
						
						</table>
		
</body>
</html>