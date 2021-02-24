<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navbar.jspf"%>
<%@ include file="common/header.jspf"%>

<div class="container">
			<form method="post">
				  <div class="form-group">
				    <label for="name">Email address:</label>
				    <input type="text" class="form-control" id="name" name="name">
				  </div>
				  <div class="form-group">
				    <label for="surname">Email address:</label>
				    <input type="text" class="form-control" id="surname" name="surname">
				  </div>
				  <div class="form-group">
				    <label for="age">Email address:</label>
				    <input type="number" class="form-control" id="age" name="age">
				  </div>
				  <div class="form-group">
				    <label for="email">Email address:</label>
				    <input type="email" class="form-control" id="email" name="email">
				  </div>
				  <div class="form-group">
				    <label for="country">Email address:</label>
				    <input type="text" class="form-control" id="country" name="country">
				  </div>
				  <div class="form-group">
				    <label for="gender">Password:</label>
				    <input type="text" class="form-control" id="gender" name="gender">
			 	 </div>
			 	 <div class="form-group">
				    <label for="username">Email address:</label>
				    <input type="text" class="form-control" id="username" name="username">
				  </div>
			  		<button type="submit" class="btn btn-default">Submit</button>
			</form>
</div>