<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>angexample</title>
<!-- Load AngularJS -->
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script type="text/javascript">
            var app = angular.module("UserManagement", []);
         
            //Controller Part
            app.controller("UserManagementController", function($scope, $http) {
         
                //Initialize page with default data which is blank in this example
                $scope.employees = [];
                $scope.form = {
                    id : -1,
                    name : "",
                    age : 0,
                    salary : 0
                };
         
                //Now load the data from server
                _refreshPageData();
         
                //HTTP POST/PUT methods for add/edit employee
                $scope.submitEmployee = function() {
         
                    var method = "";
                    var url = "";
                    if ($scope.form.id == -1) {
                        //Id is absent so add employee - POST operation
                        method = "POST";
                        url = 'employees';
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = 'employees/' + $scope.form.id;
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete employee by Id
                $scope.removeEmployee = function(employee) {
                    $http({
                        method : 'DELETE',
                        url : 'employees/' + employee.id
                    }).then(_success, _error);
                };
 
                //In case of edit employee, populate form with employee data
                $scope.editEmployee = function(employee) {
                    $scope.form.firstName = employee.firstName;
                    $scope.form.lastName = employee.lastName;
                    $scope.form.email = employee.email;
                    $scope.form.id = employee.id;
                };
         
                /* Private Methods */
                //HTTP GET- get all employees collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/com.springrestapi/employeelist'
                    }).then(function successCallback(response) {
                        $scope.employeelist = response.data.emp;
                        alert("hi");
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {0
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                    $scope.form.firstName = "";
                    $scope.form.lastName = "";
                    $scope.form.email = "";
                    $scope.form.id = -1;
                };
            });
        </script>
        <style>
            .button {
                cursor: pointer;
                color: blue;
            }
            td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
            }
            table {
                width: 600px;
            }
        </style>


</head>
<body ng-app="UserManagement" ng-controller="UserManagementController">

<h1>
            AngularJS - Use $http to invoke RESTful APIs
        </h1>
 
        <table>
            <tr>
                <th>id</th>
                <th>name </th>
                <th>age</th>
                <th>salary</th>
            </tr>
 
            <tr ng-repeat="employee in employeelist">
                <td>{ employee.id }</td>
                <td>{ employee.name }</td>
                <td>{ employee.age }</td>
                 <td>{ employee.salary }</td>
                <td><a ng-click="editEmployee( employee )" class="button">Edit</a> | <a ng-click="removeEmployee( employee )" class="button">Remove</a></td>
            </tr>
 
        </table>

</body>
</html>