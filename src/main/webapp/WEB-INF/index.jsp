<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="main_container">
		<div class="goldcounter">
			<h4>Your Gold:</h4>
			<div class="goldnumber">
				<h5>
					<c:out value="${totalgold}"></c:out>
				</h5>
			</div>
		</div>
		<div class="places">
			<div class=" place farm">
				<h4>Farm</h4>
				<p>(earns 10-20 golds)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="clicked" value="farm">
					<button class=" butn btn btn-light">Find Gold!</button>
				</form>
			</div>
			<div class="place cave">
				<h4>Cave</h4>
				<p>(earns 5-10 golds)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="clicked" value="cave">
					<button class=" butn btn btn-light">Find Gold!</button>
				</form>
			</div>
			<div class="place house">
				<h4>House</h4>
				<p>(earns 2-5 golds)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="clicked" value="house">
					<button class=" butn btn btn-light">Find Gold!</button>
				</form>
			</div>
			<div class="place casino">
				<h4>Casino</h4>
				<p>(earns/takes 0-50 golds)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="clicked" value="casino">
					<button class=" butn btn btn-light">Find Gold!</button>
				</form>
			</div>
		</div>
		<p class="act_word">Activities:</p>
		<div class="activities">
			<p style="color : ${color}">${fn:replace(comment,"%*n", "<br />")}</p>
		</div>
		<a href="/reset" class="btn btn-danger float-right mt-3 mb-5 mr-3">Reset!</a>
	</div>
</body>
</html>