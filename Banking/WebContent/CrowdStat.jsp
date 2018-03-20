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
<title>Insert title here</title>
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

<ul class="topnav" id="myTopnav">
  <li><a class="active" href="/Banking/bank_home.jsp">Home</a></li>
  
  
  <li><a href="/Banking/LogoutBank">LOGOUT</a></li>

</ul>

<div style="margin-top: 90px;">

</div>
<div class="form-group col-lg-8 wow fadeInLeft delay-06s">
			<form action="/Banking/banking?action=crowdcheck" method="post">
				<div class="control-group">
				
								<select name="crowdstat" class="form-control input-select" style="padding-left: 400px;margin-left: 250px;">
													<option>HIGH</option>
													<option>MEDIUM</option>
													<option>LOW</option>
								</select>
								
				</div><br><br>							
										<%
				

 								ResultSet rs	=Selectoptions.getRows(session.getAttribute("manager_name")+"");
				%>
	
				
										<select name="REGION" class="form-control input-select" style="padding-left: 370px;margin-left: 250px;">
																				<%
									while(rs.next()){
							%>
				
				
										<option value="<%= rs.getString("REGION") %>" style="text-transform: uppercase;"><%= rs.getString("REGION") %></option>	
							<%
									}
							%>
				</select><br><br>
									
				<center>		<input type="submit"  style="margin-left: 450px;" class="btn btn-primary input-btn pull-center"></center>
				</form><br>
	</div>							
</div>
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