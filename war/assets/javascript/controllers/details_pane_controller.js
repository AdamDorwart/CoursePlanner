(function() {

  coursePlannerApp.controller("DetailsPaneController",
  [       "$scope", "DetailsPaneService",
  function($scope,   DetailsPaneService) {

    DetailsPaneService.onDetailsChange(function(course) {
      $scope.course = course;
    });

  }]);

})();