<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>New User</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="../../../../../webapp/assets/css/style.css" />">
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" modelAttribute="user">
    <sf:errors path="*" element="div" cssClass="error"/>
    <sf:label path="firstName"
              cssErrorClass="error">First Name</sf:label>
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName"
              cssErrorClass="error">Last Name</sf:label>
    <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="email"
              cssErrorClass="error">Email</sf:label>
    Email: <sf:input path="email" type="email" cssErrorClass="error"/><br/>
    Phone: <sf:input path="phone"/><br/>
    Password: <sf:password path="password"/><br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>