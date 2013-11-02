(function () {
  coursePlannerApp.factory("UserService",
  [       "$http",
  function($http) {

    var user = null;

    return {
      get: function(cb) {
        return $http.get("/current_user")
          .success(function(data) {
            if(data.loginUrl)
            {
              // Server sent a redirect string. Go to that.
              window.location = data.loginUrl;
            }
          }).success(cb);
        }
      };

  }]);
})();