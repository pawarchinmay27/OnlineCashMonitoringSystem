function fun(){
	
	var flag=true;//for all fields checked
	document.getElementById("usernameerror").className="error invisible";
	document.getElementById("countryerror").className="error invisible";
	document.getElementById("statuserror").className="error invisible";
	var username=document.getElementById("user").value;
	var password=document.getElementById("pass").value;
	var country=document.getElementById("country").value;
	var status=document.getElementById("status").value;
	var gen="female";
	if(document.getElementById("male").checked) {
		gen="male";
	} 

	
	//validation
	
	//username min 4 chars along with numbers and text only special character . and $ can be used
	//password min 8 letters shall have atleast one capital letter one number
	
	var errormsg="";
	var userregex=/^[a-zA-Z0-9\.\$]{4,100}$/;//\ for special char to be in data
	if(!userregex.test(username)){
			//errormsg+="please check user name";
		document.getElementById("usernameerror").className="error visible";
		flag=false;
	}
	var passregex=/[A-Z]/;
	if(password.length<8){
		errormsg+="Paasword length is minimum 8";
	}
	else if(!passregex.test(password)){
		errormsg+="please check password";
	}
	
	if(errormsg.length>0){
		//alert(errormsg);
	}
	
	
	if(country==-1){
		document.getElementById("countryerror").className="error visible";
		flag =false;
	}
	if(status==1){
		document.getElementById("statuserror").className="error visible";
	}
	return flag;//js functions can  return any value 
	
}




