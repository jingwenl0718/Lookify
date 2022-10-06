<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search Result</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="d-flex">
		<h3>Songs by artist <c:out value="${keyword }"/></h3>
		<form action="/search">
			<input type="text" name="keyword"/>
			<button type="submit">Search Artists</button>
		</form>		
		<a href="/dashboard">Dashboard</a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachSong" items="${songList }" >
				<tr>
					<td><a href="/songs/${eachSong.id }"><c:out value="${eachSong.title }"/></a></td>
					<td><c:out value="${eachSong.rating }"/></td>
					<td>
						<form action="/songs/delete/${eachSong.id }" method="POST">
							<input type="hidden" name="_method" value="delete"/>
							<button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>