<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
	</head>
	<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="UserController as ctrl">
		
<%-- <c:if test="${!empty emp}">
		<h2>List user</h2>
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Age</th>
			<th>Name</th>
			<th>salary</th>
	   </tr>

		<c:forEach items="${emp}" var="emp">
			<tr>
				<td><c:out value="${emp.id}"/></td>
				<td><c:out value="${emp.age}"/></td>
				<td><c:out value="${emp.name}"/></td>
				<td><c:out value="${emp.salary}"/></td>
				<td align="center"><a href="edit.html?id=${user.id}">Edit</a> | <a href="delete.html?id=${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>  --%>


<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Id</th>
                              <th>Name</th>
                              <th>Age</th>
                              <th>Salary</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.emp">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.age"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.salary"></span></td>
                              <td>
                              <!-- <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button> -->
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/script/app.js' />"></script>
      <script src="<c:url value='/script/emp_service.js' />"></script>
      <script src="<c:url value='/script/user_controller.js' />"></script> 
	</body>
</html>