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
	<h1>Top ten Songs</h1>
	<c:forEach var="eachSong" items="${songList }" >
		<div>
			<c:out value="${eachSong.rating }"/>
			<a href="/songs/${eachSong.id }"><c:out value="${eachSong.title }"/></a>
			<c:out value="${eachSong.artist }"/>
		</div>
	</c:forEach>
</body>
</html>