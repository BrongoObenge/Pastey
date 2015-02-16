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

<% for(Paste p : pastes){ %>
			<h1><%= p.getTitle() %></h1>
			<br>
			<h5>Added time: <%=p.getTime()%></h5>
			<br><br>
			<%=p.getText() %>
<% 	}%>

</body>
</html>