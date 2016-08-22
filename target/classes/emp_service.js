'use strict';
 
App.factory('DataService', ['$http', '$q', function($http, $q){
    return {
        
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8080/com.springrestapi/employeelist')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
    
    };
}]);
            
           