<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<form:form action="/employee/search" commandName="searchPerson">
<table>
    <tr>
        <td>
            <input type="submit"
                value="<spring:message text="search"/>" />
        </td>
        <td>
            <form:input path="firstName"/>
        </td>
    </tr>
</table>
</form:form>

<a href = "<c:url value = "/employee/add"/>">add new employee</a>
<br/>
<c:if test="${action.equals('search')}">
    <a href = "<c:url value = "/allSkodaEmployees"/>">show all employees</a>
    <br/>
    <h2>Search results</h2>
</c:if>

<h3>Employees List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">Is Male</th>
		<th width="120">Birthday</th>
		<th width="120">Education</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td><a href="<c:url value='/employee/view/${person.id}' />" >${person.id}</a></td>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td>${person.isMale}</td>
			<td>${person.birthday}</td>
			<td>${person.education.grade}</td>
			<td><a href="<c:url value='/employee/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/employee/remove/${person.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>