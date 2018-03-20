<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home</title>
<link rel="stylesheet" href="/Banking/css/w3.css">
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="/Banking/css/style.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/animate.css" rel="stylesheet" type="text/css">
<style type="text/css">
			#if:link, #if:visited {
    background-color:#E91E63;
    color: white;
    padding: 14px 25px;
    text-align: center;
    
    text-decoration: none;
    display: inline-block;
}


#if:hover, #if:active {
    background-color: white;
    color: black;
}

</style>
</head>
<body>	
<%
		if(session.getAttribute("phno")==null){
								response.sendRedirect("login.jsp");
		}
%>



		<nav class=" nav navbar-DEFAULT">
					<div class="navbar-header">
													<a class="navbar-brand" href="#">Paytm</a>
					</div>


					<div class=" nav navbar-nav navbar-left">
								<li style="text-transform: uppercase;">	<a>	WELCOME <%=  session.getAttribute("uname") %></a></li>

					</div>


						<div class=" nav navbar-nav navbar-right">
								<li><a href="/Banking/LogoutCustomer">LOGOUT</a></li>
									<li><a href="#sec">ABOUT US</a></li>


					</div>

					

		</nav>
			
						
  

<div class="form-group col-lg-8 wow fadeInLeft delay-06s" style="margin-top: 50px;text-align: center;margin-left: 200px;">
	
			
				
				
				
			<h1><a href="/Banking/CustomerBalance" id="if" style="width: 100%;border-radius: 30px;">CHECK BALANCE</a></h1>
			
			<h1><a href="transfer.jsp" id="if" style="width: 100%;border-radius: 30px;margin-top: 150px;">TRANSFER MONEY</a></h1>	
				
	
	
	
			
			
				
			

</div>
						
		
					
					
					
									
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