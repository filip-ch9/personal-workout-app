<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navbar.jspf"%>
<%@ include file="common/header.jspf"%>


<div class="container-fluid">
	<div class="panel panel-default">
			  <!-- Default panel contents -->
			  <div class="panel-heading"><h2>My Users</h2></div>

				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Surname</th>
				      <th scope="col">Email</th>
				      <th scope="col">Program Name</th>
				      <th scope="col">Start Date</th>
				      <th scope="col">End Date</th>
				      <th scope="col">Add/Remove</th>
				      <th><!-- Single button -->
							<div class="btn-group">
							  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Sort <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu">
							    <li><a href="#">Most Active</a></li>
							    <li><a href="#">Start Date</a></li>
							    <li><a href="#">End Date</a></li>
							    <li><a href="#">By Group</a></li>
							  </ul>
							</div>
						</th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach var="users" items="${user}">
					<c:forEach var="workoutPrograms" items="${workoutProgram}">
						<tr>
							<td>${user.name}</td>
							<td>${user.surname}</td>
							<td>${user.email}</td>
							<td>${workoutProgram.workoutId}</td>
							<td>${workoutProgram.startDate}</td>
							<td>${workoutProgram.endDate}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-update?id=${user.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-user?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<nav aria-label="...">
  		<ul class="pager">
    		<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Previous</a></li>
    		<li class="next"><a href="#">Next <span aria-hidden="true">&rarr;</span></a></li>
  		</ul>
	</nav>
<%@ include file="common/footer.jspf"%>
