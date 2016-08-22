<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read by id</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.js"></script>
</head>
<body>
<div ng-app ng-controller="spotify_api"></div>
<script type='text/javascript'>
// open console
function spotify_api($http) {
    var url = "http://localhost:8080/com.springrestapi/employee/1";
    $http.jsonp(url).success(function(data) {
        console.log(data);
    });
}
</script>

</body>
</html>