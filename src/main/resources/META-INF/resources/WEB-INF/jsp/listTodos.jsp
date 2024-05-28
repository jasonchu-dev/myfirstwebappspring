<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<!-- when using bootstrap, recommended to use "container" -->
<!-- also centers container -->
<div class="container">
	<div>Welcome ${name}</div>
	<hr>
	<!-- hr is for line -->
	<h1>Your Todos</h1>
	<!-- define table and structure and organize table using "table" -->
	<table class="table">
		<!-- define row/column names -->
		<thead>
			<!-- name of headings in row like form (tr) -->
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<!-- iterate through todos list to print out items -->
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<!-- ...?=${todo.id} to tell controller what to do -->
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- add button -->
	<!-- <a href="add-todo">Add Todo</a> -->
	<!-- add class to make an actual button -->
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf"%>