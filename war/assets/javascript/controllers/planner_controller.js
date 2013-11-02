(function() {

  coursePlannerApp.controller("PlannerController",
  [       "$scope", "ClassListService",
  function($scope,   ClassListService) {

    // Four years per whatever
    $scope.years = [ [], [], [], [] ];

    $scope.years.forEach(function(year) {
      // Three quarters per year
      year.push([]);
      year.push([]);
      year.push([]);
    });

    console.log($scope.years);


    $scope.dropped = function(dragElem, dropElem) {
      var drag = angular.element(dragElem);
      var drop = angular.element(dropElem);

      // Get the actual course object assoicated with the drag element
      ClassListService.courseForElem(drag, function(course) {
        if(!course) {
          console.log("Didn't get a course: ", drag);
          return;
        }

        if(drag.attr("data-remove-on-drag")) {
          $scope.removeFromSchedule(course);
        }


        // Get the year/quarter that this is

        var yearNum = drop.attr("data-year-number");
        var quarterNum = drop.attr("data-quarter-number");

        var year = $scope.years[yearNum];

        if(!year[quarterNum]) {
          year[quarterNum] = [];
        }

        // Don't allow courses that have already been scheduled to
        // be added twice.
        if(alreadyScheduledCourse(course))
          return;

        $scope.years[yearNum][quarterNum].push(course); // push(course);
        $scope.$digest();
        console.log($scope.years);
      });
    };

    function alreadyScheduledCourse(course) {
      // Check that this course isn't already in a quarter
      var wasFound = false;
      $scope.years.forEach(function(y) {
        y.forEach(function(quarter) {
          if(quarter) {
            quarter.forEach(function(c) {
              console.log(c);
              if(c.course_id == course.course_id)
              {
                wasFound = true;
              }
            });
          }
        });
      });

      return wasFound;
    }

    $scope.removeFromSchedule = function(course) {

      console.log('removing', course);

      // Find the position of the course
      $scope.years.forEach(function(year) {

        year.forEach(function(quarter) {

          // fake indexof to handle objects
          var index = -1;
          for(var i = 0, len = quarter.length; i < len; i++) {
              if (quarter[i].course_id === course.course_id) {
                  index = i;
                  break;
              }
          }

          console.log("found at ", index);

          if(index !== -1)
          {
            quarter.splice(index, 1);
          }

        });
      });
    };

  }]);

})();