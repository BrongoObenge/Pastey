<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Paste" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../highlight/github.css">
<script src="../highlight/highlight.pack.js"></script>
<script>hljs.initHighlightingOnLoad();</script>


<% 
	ArrayList<Paste> pastes = (ArrayList<Paste>)request.getAttribute("paste");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% for(Paste p : pastes){ 			//Adding <pre><code> will highlight%>
			<form method="POST" action="p">
				<button type="submit" id="nav-button" href="ap">Upload to Pastebin</button>
				<textarea type="text" name="test" style="visibility: hidden;">test</textarea>
				<textarea type="text" name="title" style="display: none;"><%= p.getTitle() %></textarea>
				<textarea type="text" name="content"style="display: none;"><%= p.getText()%></textarea>
			</form>
			
			<h1><%= p.getTitle() %></h1>
			<h5>Added time: <%=p.getTime()%></h5>
			<br>
			<%=p.getText().replace("\n", "<br>") %>
			<br><br><br>
			<b>Raw:</b><br>
			<textarea rows="10" cols="50"><%=p.getText()%></textarea>
<% 	}%>

</body>
</html>