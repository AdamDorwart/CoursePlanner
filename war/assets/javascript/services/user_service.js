(function () {
  coursePlannerApp.factory("UserService",
  [       "$http",
  function($http) {

    var user = null;

    return {
      get: function() {
        if(!user) {
          user = $http.get("/current_user");
        }

        return user;
      }
    };

  }]);
})();