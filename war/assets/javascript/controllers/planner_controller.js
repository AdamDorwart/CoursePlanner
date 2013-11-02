(function() {

  coursePlannerApp.controller("PlannerController",
  [       "$scope", "ClassListService", "$http", "$timeout", "UserService",
  function($scope,   ClassListService,   $http,   $timeout,   UserService) {

    // Four years per whatever
    $scope.years = [ [], [], [], [] ];

    $scope.years.forEach(function(year) {
      // Three quarters per year
      year.push([]);
      year.push([]);
      year.push([]);
    });

    UserService.get(function(user) {
      if(user.courseJsonString)
      {
        var coursesJson = JSON.parse(user.courseJsonString);
        $scope.years = coursesJson;
      }


    });

    function update() {
      $http.post("/current_user", JSON.stringify({
        courseJsonString: JSON.stringify($scope.years)
      }));
    }

    $scope.dropped = function(dragElem, dropElem) {
      var drag = angular.element(dragElem);
      var drop = angular.element(dropElem);

      // Get the actual course object assoicated with the drag element
      ClassListService.courseForElem(drag, function(course) {
        if(!course) {
          console.log("Didn't get a course: ", drag);
          return;
        }

        // Removes a course which was already on the schedule before
        // readding it, as to allow for a course to be moved around
        // the page.
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

        update();
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

    $scope.moveUp = function(course) {

      $scope.years.forEach(function(year) {

        year.forEach(function(quarter) {

          var index = indexOfObject(quarter, function(c) {
            return c.course_id === course.course_id;
          });

          if(index !== -1) {
            quarter.splice(index, 1);
            quarter.splice(index-1, 0, course);
          }

        });

      });

      update();
    };

    $scope.moveDown = function(course) {

      $scope.years.forEach(function(year) {

        year.forEach(function(quarter) {

          var index = indexOfObject(quarter, function(c) {
            return c.course_id === course.course_id;
          });

          if(index !== -1) {
            quarter.splice(index, 1);
            quarter.splice(index+1, 0, course);
          }

        });

      });

      update();
    };

    $scope.removeFromSchedule = function(course) {

      console.log('removing', course);

      // Find the position of the course
      $scope.years.forEach(function(year) {

        year.forEach(function(quarter) {

          var index = indexOfObject(quarter, function(c) {
            return c.course_id === course.course_id;
          });

          console.log("found at ", index);

          if(index !== -1)
          {
            quarter.splice(index, 1);
          }

        });
      });

      update();
    };

    function indexOfObject(haystack, comparitor) {
      var index = -1;
      for(var i = 0, len = haystack.length; i < len; i++) {
          if (comparitor(haystack[i])) {
              index = i;
              break;
          }
      }

      return index;
    }

  }]);

})();