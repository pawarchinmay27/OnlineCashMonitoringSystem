<%@page import="com.abc.custom.Selectoptions"%>
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
<title>Bank Home</title>
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
</style>

</head>
<body>

<%
		if(session.getAttribute("manager_name")==null){
			response.sendRedirect("bank_login.jsp");
		}
%>


 <script type="text/javascript">
var Msg ='<%=session.getAttribute("operation")%>';
    if (Msg == "cash_status") {
 function alertName(){
 alert("CASH STATUS SUCESSFULLY UPDATED");
 }
 
 }
    else if(Msg=="crowd_status"){
    	function alertName(){
    							 alert("CROWD STATUS SUCESSFULLY UPDATED");
    		 }   	
    }
    else if(Msg=="with_limit"){
    	
    	function alertName(){
			 alert("WITHDRAW LIMIT SUCESSFULLY UPDATED");
			}
    }

    else if(Msg=="no"){
				    	function alertName(){
							 alert("SOMETHING  WENT WRONG TRY AGAIN");
							}
				    }
    
 </script> 
<%
			session.setAttribute("operation",null);
%>

<ul class="topnav" id="myTopnav">
  <li><a class="active" href="CrowdStat.jsp">UPDATE CROWD STATUS</a></li>
  <li><a class="active" href="CashLimit.jsp">UPDATE CASH LIMIT</a></li>
  
  
  <li><a href="#">HOME</a></li>
  <li><a href="/Banking/LogoutBank">LOGOUT</a></li>

</ul>

				<h1 align="center" style="text-transform: uppercase;">HELLO <%=	session.getAttribute("bank_name") %> </h1>
				
<div class="form-group col-lg-8 wow fadeInLeft delay-06s" style="margin-top: 50px;text-align: center;margin-left: 200px;">
				
	<form action="/Banking/banking?action=statusupdate" method="post">
	
		<div class="control-group">
		
				<div class="controls">
											<select name="cashavail" class="form-control input-select">
															<option value="CASH AVILABLE">CASH AVILABLE</option>
															<option value="CASH UNAVILABLE">CASH UNAVAILABE</option>
			
											</select>
				</div>
		</div>
		<br><br>
		<div class="control-group">
				
				<div class="controls">
				
				<%
		
	 				ResultSet rs=Selectoptions.getRows(session.getAttribute("manager_name")+"");
	
				%>
	
				
										<select name="REGION" class="form-control input-select">
																				<%
									while(rs.next()){
							%>
				
				
										<option value="<%= rs.getString("REGION") %>" style="text-transform: uppercase;"><%= rs.getString("REGION") %></option>	
							<%
									}
																				
																				rs.close();
							%>
				</select>
	
							
										
				
				</div>
				
				
		</div>	<br><br>	
						<input type="submit" class="btn btn-primary input-btn pull-center">
						
				</div>	
									
		</form>
<br>

<script type="text/javascript"> window.onload = alertName; </script>
<script>
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
</script>
<script type="text/javascript" src="/Banking/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/Banking/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Banking/js/jquery-scrolltofixed.js"></script>
<script type="text/javascript" src="/Banking/js/jquery.nav.js"></script> 
<script type="text/javascript" src="/Banking/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="/Banking/js/jquery.isotope.js"></script>
<script src="/Banking/js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script> 
<script type="text/javascript" src="/Banking/js/wow.js"></script> 
 <script src="/Banking/contact/jqBootstrapValidation.js"></script>
<!-- <script src="contact/contact_me.js"></script> -->
<script type="text/javascript" src="/Banking/js/custom.js"></script>

<script type="text/javascript" src="/Banking/plugins/moment/moment.min.js"></script>
<script type="text/javascript" src="/Banking/plugins/datepicker/daterangepicker.js"></script>
</body>
</html>