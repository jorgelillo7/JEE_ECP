<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Eliminar temas</title>
</head>
<body>

	<c:set var="aVotoView" scope="request" value="${añadirVotoView}" />

	<form action="/JEE_ECP/jsp/añadirVoto" method="post">
		<p>
			Listado de Temas: <select name="temaAVotar">
				<c:forEach var="tema" items="${aVotoView.temas}">
					<option value="${tema.getId()}">${tema.toString()}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Nivel de Estudios: <select name="nivelEstudios">
				<c:forEach var="nivel" items="${aVotoView.listaEstudios}">
					<option value="${nivel}">${nivel}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Valoración: <select name="valoracion">
				<c:forEach var="i" begin="0" end="10">
					<option><c:out value="${i}" /></option>
				</c:forEach>
			</select>
		</p>
		
		<p>
			<input type="submit" value="Votar" />
		</p>
	</form>

	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>