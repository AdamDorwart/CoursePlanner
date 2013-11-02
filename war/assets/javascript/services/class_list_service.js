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

     /* var dummy_data = [
        {
          id: 0,
          course_id: "CAT1",
          name: "Culture, Art, and Technology 1",
          type: "ME"
        },

        {
          id: 1,
          course_id: "ANTH23",
          name: "Debating Multiculturalism",
          type: "GE"
        },

        {
          id: 2,
          course_id: "CSE11",
          name: "Intro to Java and OOP Design",
          type: "MR"
        },

        {
          id: 3,
          course_id: "CSE12",
          name: "Discrete Mathematics",
          type: "MR"
        }
      ];
      */
      // For now, use this dummy data
      //dummy_data.forEach(function(c) {
      //  mappedCourses[c.course_id] = c;
      //});

      //cb(mappedCourses);
      mappedCourses = {};

       $http.get("/course_info")
       .success(function(courseArray) {
         angular.forEach(courseArray, function(c) {
           mappedCourses[c.id] = c;
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