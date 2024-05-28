<%-- <html>
	<head>
		<title> Welcome Page</title>
	</head>
	<body>
		<div>Welcome ${name}</div>
		<hr>
		<div><a href="list-todos">Manage</a> your todos</div>
	</body>
</html> --%>

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<body>
	<div class="container">
		<h1>Welcome ${name}</h1>
		<a href="list-todos">Manage</a> your todos
	</div>
<%@ include file="common/footer.jspf"%>