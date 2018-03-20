<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfering</title>
<link rel="stylesheet" href="/Banking/css/bootstrap.min.css">
<link rel="stylesheet" href="/Banking/css/w3.css">
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="/Banking/css/style.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="/Banking/css/animate.css" rel="stylesheet" type="text/css">

</head>
<body>
<%
		if(session.getAttribute("phno")==null){
								response.sendRedirect("login.jsp");
		}
%>
<script type="text/javascript">
var Msg ='<%=session.getAttribute("getAlert")%>';
    if (Msg == "yes") {
 function alertName(){
 alert("MONEY SUCESSFULLY TRANSFERED");
 }
 
 }
    else if(Msg=="no"){
    	function alertName(){
    		 alert("MONEY NOT TRANSFERED PLEASE TRY AGAIN");
    		 }   	
    }
 </script> 
 
<%
		session.setAttribute("getAlert",null);
%>


<ul class="w3-navbar w3-black" id="myTopnav">
  <li><a class="active" href="/Banking/home.jsp">HOME</a></li>
  
  <li><a href="/Banking/LogoutCustomer">LOGOUT</a></li>

</ul>
<div class="form-group col-lg-8 wow fadeInLeft delay-06s" style="margin-top: 50px;text-align: center;margin-left: 200px;">

	<form action="/Banking/MoneyTransfer"  method="post">
	<div class="control-group">
											
								<h1>TRANSFER MONEY TO ANY ACCOUNT IN SECONDS</h1>			
			<div class="controls">				
					Enter The Receiver Mobile number<input name="rno" type="tel" class="form-control" placeholder="Enter The Mobile Number"><br>
			</div>		
	</div>
	<div class="control-group">
	
	<div class="controls">				
			
					Enter Amount <input name="amt" type="number"  min="0.01" step="0.01"  value="00.00"  placeholder="Enter The Amout In INR" class="form-control" ><br>
	</div>	
					<input type="submit"  class="btn btn-primary input-btn pull-center">
	</div>
	
	</form>
</div>							

<div>

<div class="form-group wow fadeInLeft delay-06s" style="text-align: center;">

<div class="w3-container w3-green" style="margin-top: 450px;color: white;">
  <h2 style="color: white;">Currency Converter</h2>
</div>
			

  <table class="table table-bordered" style="margin-top: 0px;">
    			<th style="padding-left: 350px;">DOLLAR</th>
    			<th>INR</th>
    			<th>YEN</th>
    			<th>EURO</th>
    			<th>POUNDS</th>
    			
    <tbody style="color: black;">
      <tr style="padding-left: -100px;"> 
        <td>Enter Amount In USD<input id="inputDollar" type="number" placeholder="USD" oninput="CurrencyConverter(this.value)" onchange="temperatureConverter(this.value)"></td>
        <td id="INR"></td>
        <td id="YEN"></td>
         <td id="EURO"></td>
         <td id="POUNDS"></td>
      </tr>
    
    </tbody>
  </table>
  </div>
</div>													
	<script type="text/javascript"> window.onload = alertName; </script>		

<script>
function CurrencyConverter(valNum) {
  valNum = parseFloat(valNum);

  document.getElementById("INR").innerHTML=(valNum*57.58);
  document.getElementById("YEN").innerHTML=(valNum*112.46);
  document.getElementById("EURO").innerHTML=(valNum*0.96);
  document.getElementById("POUNDS").innerHTML=(valNum*0.96);
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