/**
 * @author root
 */
$(document).ready(function(){
	//js jquery code
	
	
	
		$("#datepicker").datepicker({
			changeYear:true
		});
	//ready takes function as a argument
	
	$(".calc_btn").click(function(){
		
		//this function clicked on click of that button takes function as arg functionality to be added here
		//# is for id selector
		//for class selctor use "."
				//now getting the elements
				
				var firstNo=	$("#first_no").val();
				var secondNo=$("#second_no").val();
				
				var isError=false;
				
				if(firstNo.trim().length===0){
							isError=true;
				//	$("#error_1").show();
				//try fade in animation
				$("#error_1").fadeIn(4000);
				}
				else{
								$("#error_1").fadeOut(4000);
					}
					if(secondNo.trim().length===0){
														isError=true;
														//$("#error_2").show();
														$("#error_2").slideDown(4000);
													}
				else{
							//$("#error_2").hide();
							$("#error_2").slideUp(4000);
					}
				
				var operator=$("#operator").val();
				
				if(isError===false){
					if(operator==="1"){
					//parseInt since it returns string value
					//$("#answer").val(parseInt(firstNo)+parseInt(secondNo));
					//to set html  content between the tag use inner html
					//set content betwwen the spans 
					//"The Answer Is <i> is the content here
					
					$("#answer").html("The Answer Is <i>"+(parseInt(firstNo)+parseInt(secondNo))+"</i>");
					
				}
				else{
							//$("#answer").val(parseInt(firstNo)-parseInt(secondNo));
							$("#answer").html("The Answer Is <i>"+(parseInt(firstNo)-parseInt(secondNo))+"</i>");
				
					}
				
				
		
				}
						
				
			
	});
	
	
	//change background color green on enter and yellow on leave
	$(".calc_btn").mouseenter(function (){
		
		$(".calc_btn").css("background-color","green");
		
		//.css() is a function takes property and property value
	});
	
	
	
	$(".calc_btn").mouseleave(function (){
		$(".calc_btn").css("background-color","yellow");
			
	});
	
});
