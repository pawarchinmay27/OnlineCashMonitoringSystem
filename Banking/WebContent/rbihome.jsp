<%@page import="java.sql.ResultSet"%>
<%@page import="com.abc.custom.Selectoptions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RBI HOME</title>
		<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
		<link rel="stylesheet" href="/Banking/css/w3.css">
		<link rel="shortcut icon" href="/favicon.ico">
		<link rel="apple-touch-icon" href="/apple-touch-icon.png">
		<link rel="stylesheet" href="/Banking/datepicker/css/jquery-ui.min.css" />
		<script src="/Banking/datepicker/js/jquery-3.1.0.min.js"></script>
		<script src="/Banking/datepicker/js/jquery-ui.min.js"></script><!-- load after parent elemnent app.js -->
		<script src="/Banking/datepicker/js/app.js"></script>
		





</head>

<body>

<%
		if(session.getAttribute("bankname")==null){
								response.sendRedirect("RBIlogin.jsp");
		}
%>




 <script type="text/javascript">
var Msg ='<%=session.getAttribute("getAlert")%>';
    if (Msg == "yes") {
 function alertName(){
 alert("DATA SUCESSFULLY UPDATED");
 } 
 }
    else if(Msg=="no"){
    	function alertName(){
    		 alert("SOMETHING WENT WRONG");
    		 }   		
    }   
 </script> 
 <% session.setAttribute("getAlert",null); %>

<ul class="w3-navbar w3-black" id="myTopnav">
  <li><a class="active" href="/Banking/index.jsp">HOME</a></li>
  
  <li><a href="logout.jsp">LOGOUT</a></li>

</ul>
		
				<h1 style="text-align: center;margin-left:-10px; " class="col-xs-12">WELCOME TO RBI CONTROL UNIT</h1> <br><br>
			<%ResultSet checkrs=Selectoptions.getBanks(); %>
		<div class="form-group">
				<form action="/Banking/RBIaction?action=CheckBank" method="post">
						<h1 style="text-align: center;margin-left: 20PX;margin-top: 30px;">SELECT BANK AND REGION</h1>
							<select name="bankc"  style="margin-top: 50px;text-align: center;text-transform: uppercase;" class="form-control" >
											<%
													while(checkrs.next()){
											%>
											
											
										<option value="<%= checkrs.getString("bank_name")%>"><%= checkrs.getString("bank_name")%></option>
											<%
													}
											%>
							</select><br>
							<%ResultSet checkrsregion=Selectoptions.getBanks(); %>
							<select name="REGION" style="margin-top: 50px;text-transform: uppercase;" class="form-control" >
									<%
											while(checkrsregion.next()){
									%>
											<option value="<%=checkrsregion.getString("REGION") %>"><%=checkrsregion.getString("REGION") %></option>
											
									<%
											}
									%>
							</select><br><br>
				
							<center><input type="submit" style="text-align: center;"  class="btn btn-primary input-btn pull-center"></center>
				</form>
				
		</div>
		<div class="form-group">					
				<center><h1>UPDATE THE ATM DETAILS </h1></center>
				<form action="/Banking/RBIaction?action=UpdateBank"  method="post">
				<% ResultSet rs=Selectoptions.getBanks(); %>
							<select name="bankc"  style="margin-top: 50px;text-align: center;text-transform: uppercase;" class="form-control" >
							
											<%
													while(rs.next()){
											%>
												<option value="<%=rs.getString("bank_name") %>" style="text-transform: uppercase;"><%=rs.getString("bank_name") %></option>
											
											<%
													}
											%>
							</select><br>
							<%ResultSet rsreg=Selectoptions.getBanks(); %>						
							<select name="bankr"  style="margin-top: 50px;text-align: center;" class="form-control" >
												
												<%
														while(rsreg.next()){
															
														
												%>
												<option value="<%=rsreg.getString("REGION") %>"><%=rsreg.getString("REGION") %></option>
												<% 
														}
												%>
							</select><br>
							Enter The Amount <input name="bank_depamt" type="number"  style="margin-top: 50px;" class="form-control"><br>
							
							<br><br>
							
								Enter  Time<input name="bank_time" type="time" style="margin-top: 50px;" class="form-control"><br><br>
						
						
								DATE CASH DEPOSITED <input type="text" name="bank_date"  id="datepicker" style="width: 100%;"/><br><br>
						<center>	<input type="submit"  class="btn btn-primary input-btn pull-center"></center>
							
										
							
						
							
				</form>

	</div>	
	<script type="text/javascript"> window.onload = alertName; </script>		
</body>
</html>