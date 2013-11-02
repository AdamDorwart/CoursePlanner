(function() {

  coursePlannerApp.factory("DetailsPaneService",
  [       "$http",
  function($http) {

    var detailListeners = [];
    var currentDetailedCourse;

    var detailsCache = {};

    var get = function(course, cb) {
      if(!course) {
        cb(null);
        return;
      }

      var course_id = course.course_id;

      if(detailsCache[course_id]) {
        cb(detailsCache[course_id]);
        return;
      }

      $http.get("/course_detail?course_id="+course_id)
      .success(function(data) {
        detailsCache[course_id] = data;
        cb(data);
      })
      .error(function(data) {
        console.log("Error while reading course from server: ", data);
      });
    };

    var setDetailFromCourse = function(course) {

      get(course, function(courseDetail) {
        currentDetailedCourse = course;
        detailListeners.forEach(function(cb) {
          cb(course);
        });
      });

    };

    return {
      get: get,

      onDetailsChange: function(cb) {
        detailListeners.push(cb);
      },

      clear: function() {
        setDetailFromCourse(null);
      },

      setDetailFromCourse: setDetailFromCourse,

      getCurrentDetail: function() {
        return currentDetailedCourse;
      }
    };

  }]);

})();