<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h3>Title: <c:out value="${song.title }"/></h3>
	<h3>Artist: <c:out value="${song.artist }"/></h3>
	<h3>Rating: <c:out value="${song.rating }"/></h3>
	<form action="/songs/delete/${song.id}" method="POST"}>
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Delete</button>
	</form>
</body>
</html>