<% 
	/*
	 * Validate the Session ID
	 */
	if(session.isNew())
	{
		//Invalid Session; Generate Login Page
		request.setAttribute("errMsg", "In-Valid Session !!! Pls Login ...");
%>
		<jsp:forward page="loginErr" />
<%
	}else{
		//Valid Session; Generate Response
		String url = request.getParameter("page");
%>
		<%@include file="./Header.html" %>
		<html>
		<body background="./imgs/bg111.jpg">
			<jsp:include page="<%=url%>" />
		</body>
		</html>
		<%@include file="./Footer.html" %>
<%
	}
%>