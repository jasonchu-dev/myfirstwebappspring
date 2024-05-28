<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<!-- when using bootstrap, recommended to use "container" -->
<!-- also centers container -->
<div class="container">
	<h1>Enter Todo Details</h1>
	<!-- form:... to map js elements to java variables -->
	<!-- modelAttribute to map a java class -->
	<!-- use post method (<form method="post">) in jsp to hide query params in url -->
	<form:form method="post" modelAttribute="todo">
		<!-- group all things related to one element -->
		<!-- mb-1, 2, 3 for margin spacing between submit fields -->
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<!-- required so text must be filled -->
			<form:input type="text" path="description" required="required" />
			<!-- relay message to browser from @Size in Todo.jsp -->
			<!-- highlight message as a text warning by using a css class -->
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" id="targetDate" path="targetDate"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<!-- without the next two lines, there would be an error, bc the page will say that there are two missing fields. So make a textbox for those but make them hidden -->
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
<!-- lookup bootstrap datepicker and this is how to implement -->
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>