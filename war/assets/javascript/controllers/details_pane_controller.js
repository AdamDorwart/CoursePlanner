(function() {

  coursePlannerApp.controller("DetailsPaneController",
  [       "$scope", "DetailsPaneService",
  function($scope,   DetailsPaneService) {

    DetailsPaneService.onDetailsChange(function(course) {

      CourseService.get(course, function(courseDetail) {
        $scope.courseDetail = courseDetail;
      });
    });

  }]);

})();