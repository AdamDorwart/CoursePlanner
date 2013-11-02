(function() {

  coursePlannerApp.factory("DetailsPaneService",
  [       "$http",
  function($http) {

    var detailListeners = [];
    var currentDetailedCourse;

    var get = function(course) {
      var course_id = course.course_id;
      return $http.get("/course_details?course_id="+course_id)
      .error(function(data) {
        console.log("Error while reading course from server: ", data);
      });
    };

    return {
      get: get,

      onDetailsChange: function(cb) {
        detailListeners.push(cb);
      },

      setDetailFromCourse: function(course) {

        get(course)
        .success(function(courseDetail) {
          currentDetailedCourse = course;
          detailListeners.forEach(function(cb) {
            cb(course);
          });
        });

      },

      getCurrentDetail: function() {
        return currentDetailedCourse;
      }
    };

  }]);

})();