<%@page import="javax.servlet.http.Cookie" %>
 
<%
	//Set the Dummy Cookie
	Cookie dummyCookie = new Cookie("isCookieEnabled", "check");
	response.addCookie(dummyCookie);
	
	//Get the Always Remember Cookie (if any)
	String userNM="";
	Cookie[] receivedCookies = request.getCookies();
	if(receivedCookies!=null)
	{
		for(Cookie rcvdCookie : receivedCookies) {
			String name = rcvdCookie.getName();
			if(name.equals("alwaysRemember")) {
				userNM = rcvdCookie.getValue();
				break;
			}//End of if
		}//End of for
	}//End of outer if
%>

<html>
<body topmargin="2%" leftmargin="18%">
	<table border="3">
		<tr><td> <img src="./imgs/loginold.jpg"> </td></tr>
		<tr align="center">
		<td>
			</BR>
			<h3>
				<font color="grey">Sign in to continue to StudentsApp.</font>
				<font color="Maroon">Cookies must be enabled.</font>
				</BR></BR>
			
				<form action="./login" method="post">
				<font size="5" color="grey">
					User Name : <input type="number" name="regno" value="<%= userNM %>"  required="required"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Password : <input type="password" name="pass" required="required"/>
					</BR></BR>
					Remember Me : <input type="checkbox" name="remember" value="yes" />
					<BR/><BR/>
					<input type="submit" value="Sign In"></input>
				</font>
				</form>
			</h3>
		</td>
		</tr>
	</table>
</body>
</html>