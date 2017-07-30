/*
* Licensed Materials - Property of IBM
* 5725-G92 (C) Copyright IBM Corp. 2006, 2013. All Rights Reserved.
* US Government Users Restricted Rights - Use, duplication or
* disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*/

function wlCommonInit(){


}

function REGISTER()
{
	
	var x=$("#uname").val();
	var y=$("#pwd").val();
	var z=$("#email").val();
	alert(x+""+y+""+z);
	
	

	   var X= {
				adapter:'MYSQL',
				procedure:'procedure3',
				parameters:[x,y,z]
			   };
		
	    var Y= {
				onSuccess:succ,
				onFailure:fail
			   };

		WL.Client.invokeProcedure(X,Y);
    

}
function succ()
{
	alert("WOW");
	
}
function fail()
{
	alert("SORRY");
}