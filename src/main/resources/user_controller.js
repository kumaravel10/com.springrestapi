'use strict';
 
'use strict';
App.controller('UserController', ['$scope', 'DataService', function($scope, UserService) {
          var self = this;
          self.emp={id:null,name:'',age:'',salary:''};
          self.emp=[];
              
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
                               function(d) {
                                    self.emp = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
}]);