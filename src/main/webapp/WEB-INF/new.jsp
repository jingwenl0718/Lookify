<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form:form class="form" method="POST" action="/songs/new" modelAttribute="newSong">
		<p>
			<form:label class="form-label" path="title">Title:</form:label>
			<form:input class="form-control" path="title" />
			<form:errors style="color:red" path="title" />
		</p>
		<p>
			<form:label class="form-label" path="artist">Artist:</form:label>
			<form:input class="form-control" path="artist" />
			<form:errors style="color:red" path="artist" />
		</p>
		<p>
			<form:label class="form-label" path="rating">Rating:</form:label>
			<form:input type="number" class="form-control" path="rating" />
			<form:errors style="color:red" path="rating" />
		</p>
		<div class="d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">Add Song</button>
		</div>
	</form:form>
</body>
</html>