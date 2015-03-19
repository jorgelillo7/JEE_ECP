<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home JEE_ECP</title>
</head>
<body>
	<h1>Home JEE_ECP JSP</h1>
	<p>
		<a href="/JEE_ECP/jsp/nuevoTema">Nuevo Tema</a>
	</p>

	<c:set var="eView" scope="request" value="${eliminarTemaView}" />
	<span style="color: green">${eView.successMsg}</span>
	<p>Eliminar Tema:</p>
	<form action="/JEE_ECP/jsp/eliminarTema" method="post">
		
		<span style="color: red">${eView.errorMsg}</span>
		<p>
			Password: <input name="password" type="text" value="" />
		</p>
		<p>
			<input type="submit" value="Eliminar" />
		</p>

	</form>
	
	<p>
	<a href="/JEE_ECP/jsp/añadirVoto">Añadir Voto</a>
	</p>


</body>
</html>