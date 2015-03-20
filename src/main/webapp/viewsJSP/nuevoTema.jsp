<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Nuevo Tema</title>
</head>
<body>
	<h1>Nuevo tema</h1>
	<c:set var="nuevoTemaView" scope="request" value="${nuevoTemaView}" />
	
	<form action="/JEE_ECP/jsp/nuevoTema" method="post">
		<p>
			Categoría: <input name="categoria" type="text" required />
		</p>
		<p>
			Pregunta: <input name="pregunta" type="text" required />
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
	
</body>
</html>