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

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({
                                            dateFormat: "yy-mm-dd"
                                          });
        } );
    </script>
</head>
<body>
<h1>
	Add a Person
</h1>

<c:url var="addAction" value="/employee/save" ></c:url>

<form:form action="${addAction}" commandName="person">
<table>
	<c:if test="${!empty person.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td>
	</tr>
	<tr>
        <td>
            <form:label path="isMale">
                <spring:message text="Is Male"/>
            </form:label>
        </td>
        <td>
            <form:checkbox path="isMale" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="birthday">
                <spring:message text="Birthday"/>
            </form:label>
        </td>
        <td>
            <form:input path="birthday" id="datepicker" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="education">
                <spring:message text="Education"/>
            </form:label>
        </td>
        <td>
            <form:input path="education"/>
        </td>
    </tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty person.firstName}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
			<input type="button" onclick="location.href='/allSkodaEmployees'" value="<spring:message text="Close"/>" />
		</td>
	</tr>
</table>
</form:form>
</body>