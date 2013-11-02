(function() {
  var UserController = coursePlannerApp.controller("UserController",
  [       "$scope", "UserService",
  function($scope,   UserService) {

    UserService.get(function(user) {
      $scope.user = user;

      console.log("Got the user: ", user);
    });

  }]);
})();