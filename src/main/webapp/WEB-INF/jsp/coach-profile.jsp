<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navbar.jspf"%>
<%@ include file="common/header.jspf"%>


<div class="container-fluid">
	
	<div class="panel panel-dark">
		<div class="panel-heading">
			<h3>List of users</h3>
		</div>
		
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="30%">Name</th>
						<th width="30%">Surname</th>
						<th width="30%">Email</th>
						<th width="60%">Workout Program</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="users">
						<tr>
							<td>${user.name}</td>
							<td>${user.surname}</td>
							<td>${user.email}</td>
							<td>${user.workouts}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-update?id=${user.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-user?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
