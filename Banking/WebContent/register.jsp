<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/Banking/css/w3.css">
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="/Banking/css/style.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/animate.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<style type="text/css">
						.invisible{
							
											display: none;
						}
						.visible{
									display: inline;
						}
						.error{
									
									color:red;
									font-style:italic;
						}
</style>
</head>
<body>
<div class="form-group col-lg-8 wow fadeInLeft delay-06s" style="margin-top: 50px;text-align: center;margin-left: 200px;">
		<h1>CUSTOMER REGISTERATION SCREEN</h1>
						<form action="/Banking/CustomerRegister" onsubmit="return fun()" method="post" >
						
						
																					<div class="control-group">
																										<div class="controls">
																																		Enter Your Name<input name="username" class="form-control" required><br>
											
																										</div>
																					</div><br>
																	<span class="error invisible" id="usernameerror">Please Enter Proper Username</span><br />
			
																<div class="control-group">
																										<div class="controls">
																															Enter Your Password<input type="password" name="password" class="form-control" required><br>
											
																										</div>
																					</div><br>
														<span class="error invisible" id="countryerror">Please Enter Valid Password</span>
			
																<div class="control-group">
																										<div class="controls">
																																Enter Your Email<input name="email" class="form-control" type="email" required><br>
											
																										</div>
																					</div><br>
						
																<div class="control-group">
																										<div class="controls">
																																	Enter Your Mobile Number<input name="mobile_no"  type="number" pattern="[789][0-9]{9}" required  class="form-control" ><br>
								
																										</div>
																					</div><br>
				
				
										
										
										
						
							
			
			
										
										<input type="submit" class="btn btn-primary input-btn pull-center">
										
										
								
						</form>
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
<script type="text/javascript" src="/Banking/js/form_validate.js"></script>						
</body>
</html>