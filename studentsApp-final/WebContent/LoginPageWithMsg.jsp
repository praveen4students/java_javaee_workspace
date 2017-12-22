<% 
	String msg = (String)request.getAttribute("errMsg");
	String msgColor = (String)request.getAttribute("color");
	
	if(msgColor==null || msgColor.equals("")){
		msgColor="red";
	}
%>
<html>
<body>
<h2><font color="<%= msgColor %>"> <%=msg%></font></h2>
</body>
</html>
 
<jsp:include page="/loginPage" />