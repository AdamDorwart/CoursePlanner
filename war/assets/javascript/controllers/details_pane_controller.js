(function() {

  coursePlannerApp.controller("DetailsPaneController",
  [       "$scope", "DetailsPaneService",
  function($scope,   DetailsPaneService) {

    DetailsPaneService.onDetailsChange(function(course) {
      console.log("SET DETAIL TO: ", DetailsPaneService.getCurrentDetail());
      $scope.detail = DetailsPaneService.getCurrentDetail();
    });

  }]);

})();