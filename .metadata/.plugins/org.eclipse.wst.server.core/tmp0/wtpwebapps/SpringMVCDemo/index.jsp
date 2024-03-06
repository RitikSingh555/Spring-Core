<html>  
<body>  


	<h1> This is home page</h1>
	<h1> Called by home controller</h1>
	<h1>Url /home  </h1>
	
	<%
		String name=(String) request.getAttribute("name");
		
	
	%>
	
	<h1> Name is  <%= name%></h1>
	
</body>  
</html> 