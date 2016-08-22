<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Post Form Spring MVC example</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('formSubmit', []);
	
	app.controller('FormSubmitController',[ '$scope', '$http', function($scope, $http) {
			
		$scope.list = [];
			$scope.headerText = 'AngularJS Post Form Spring MVC example: Submit below form';
			$scope.submit = function() {
				
				var formData = {
						"name" : $scope.name,
						"age" : $scope.age,
						"salary" : $scope.salary	
				};
				
				var response = $http.post('/employee/', formData);
				response.success(function(data, status, headers, config) {
					$scope.list.push(data);
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
				//Empty list data after process
				$scope.list = [];
				
			};
		}]);
</script>
</head>
<body>
	<form data-ng-submit="submit()" data-ng-controller="FormSubmitController">
		<h3>{{headerText}}</h3>
		<p>Name: <input type="text" data-ng-model="name"></p>
		<p>Age: <input type="text" data-ng-model="age"></p>
		<p>Salary: <input type="text" data-ng-model="salary"></p>
		<input type="submit" id="submit" value="Submit" /><br>	
		
		<h4>You submitted below data through post:</h4>
		 <pre>Form data ={{list}}</pre>
	</form>
</body>
</html>