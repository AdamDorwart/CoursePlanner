(function() {
  coursePlannerApp.service("ClassListService",
  [       "$http",
  function($http) {
    var mappedCourses;

    var get = function (cb) {
      if(mappedCourses) {
        cb(mappedCourses);
        return;
      }

      //cb(mappedCourses);
      mappedCourses = {};

       $http.get("/course_info")
       .success(function(courseArray) {
         angular.forEach(courseArray, function(c) {
           mappedCourses[c.course_id] = c;
         });

         cb(mappedCourses);
       })
       .error(function(data) {
         console.log("Error retrieving class list: ", data);
       });
    };

    var courseForElem = function(elem, cb) {
      get(function(courses) {

        var elemCourseId = angular.element(elem).attr("data-course-id");
        cb(courses[elemCourseId]);

      });
    };

    return {
      get: get,
      courseForElem: courseForElem
    };

  }]);
})();