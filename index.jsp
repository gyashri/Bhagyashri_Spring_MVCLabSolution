<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Debate Event Home Page</title>
</head>


<body>
	<div class='container'>
		<form action="search" class="form-inline">
			<input type="search" name="sName" placeholder="Name"
				class="form-control-sm ml-5 mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
		</form>
		
		<!-- Add a button -->
		<a href="add" class="btn btn-primary btn-sm mb-3"> Register </a>
		<a href="" class="btn btn-primary btn-sm mb-3"> List All </a>
		<h1>List of students</h1>
		<table class="table table-bordered table-striped">
			<tr>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Department</th>
				<th>Country</th>

			</tr>
			<c:forEach items="${students }" var="student">
				<tr>
					<td>${student.studentId }</td>
					<td>${student.studentName }</td>
					<td>${student.department }</td>
					<td>${student.country }</td>
					<td>
						<!--  Add "update" button/link --> 
						<a href="#" class="btn btn-info btn-sm"> Update </a> 
						<!-- Add "delete" button/link--> 
						<a href="delete?id=${student.studentId}" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete </a>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>