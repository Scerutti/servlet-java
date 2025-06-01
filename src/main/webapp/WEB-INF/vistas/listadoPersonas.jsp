<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Listado de Personas</h1>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>DNI</th>
        <th>Edad</th>
        <th>Fecha de nacimiento</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="persona" items="${personas}">
        <tr>
            <td>${persona.nombre}</td>
            <td>${persona.apellido}</td>
            <td>${persona.dni}</td>
            <td>${persona.edad}</td>
            <td>${persona.fechaNacimiento}</td>
            <td>${persona.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="/menu">Volver al men&uacute;</a>
