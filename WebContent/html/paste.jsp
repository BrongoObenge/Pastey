<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Paste" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	ArrayList<Paste> pastes = (ArrayList<Paste>)request.getAttribute("paste");	
	
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a id="nav-button" href="html/addpaste.jsp">Add new paste</a>
<h1>Paste</h1>
<table>
<% for(Paste p : pastes){ %>
		<tr>
		<form method="GET" action="p" type="submit">
			<button name="paste" value="<%= p.getId()%>"><%= p.getTitle() %></button>
		</form>
		</tr><br>
<% 	}%>

</table>
</form>
</body>
</html>