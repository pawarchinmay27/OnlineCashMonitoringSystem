<%@page import="com.abc.domain.RBIDomain"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>BANKS INFORMATION</title>
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="/Banking/css/w3.css">
<style type="text/css">
		tr td{
				
					text-align: center;
					cellpadding="5";	
			}
			tr th{
						text-align: center;	
				}
</style>
</head>
<body>
<ul class="w3-navbar w3-black" id="myTopnav">
  <li><a class="active" href="/Banking/rbihome.jsp">HOME</a></li>
  
  <li><a href="logout.jsp">LOGOUT</a></li>

</ul>
<%	
		RBIDomain rbidataset=(RBIDomain)request.getAttribute("banksforrbi");
%>
				<div>
						<table border="1px" class="table table-condensed table-striped" style="margin-top: 10px;">
						
									<tr style="text-align: center;">
														<th>ZONE</th>
														<th >BANK NAME</th>
														<th>CASH STATUS</th>
														<th>CROWD STATUS</th>
														<th>CASH DEPOSITED</th>
														<th>DATE WHEN LAST CASH DEPOSITED</th>
														<th>TIME LAST CASH DEPOSITED</th>
														<th>MAX CASH LIMIT</th>
														<th>REGION</th>
									</tr>
									
									
									
								<tr style="text-transform: uppercase;text-align: center;">
										<td ><%=rbidataset.getZone()%></td>
										<td ><%=rbidataset.getBank_name()%></td>
										<td ><%=rbidataset.getCash_stat()%></td>
										<td ><%= rbidataset.getCrowd_stat()%></td>
										<td ><%= rbidataset.getCashdepositedamount()%></td>
										<td ><%= rbidataset.getCashdepositeddate()%></td>
										<td ><%= rbidataset.getCashdepositedtime()%></td>										
										<td><%= rbidataset.getMax_cash_limit() %></td>
										<td ><%= rbidataset.getREGION()%></td>
										
										
								</tr>	
									
									
						</table>
			</div>			
</body>
</html>