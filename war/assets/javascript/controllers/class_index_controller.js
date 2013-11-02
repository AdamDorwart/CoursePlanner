(function() {
  coursePlannerApp.controller("ClassIndexController",
  [       "$scope", "$filter", "ClassListService", "DetailsPaneService",
  function($scope,   $filter,   ClassListService,   DetailsPaneService) {

    $scope.typeCodeToName = {
      "ME": "Major Requirement",
      "GE": "General Education",
      "MR": "Major Elective"
    };


    ClassListService.get(function(classes) {
      $scope.classes = [];

      // Covert the object into an array of its values
      for(var key in classes)
      {
        if(classes.hasOwnProperty(key))
        {
          $scope.classes.push(classes[key]);
        }
      }
    });

    $scope.showGeClasses = true;
    $scope.showMrClasses = true;
    $scope.showMeClasses = true;

    var updateFilteredClasses = function() {
      $scope.geClasses = $filter('filter')($scope.classes, searchFilter("GE"));
      $scope.mrClasses = $filter('filter')($scope.classes, searchFilter("MR"));
      $scope.meClasses = $filter('filter')($scope.classes, searchFilter("ME"));
    };

    $scope.$watch("searchString", updateFilteredClasses);
    $scope.$watch("classes", updateFilteredClasses);

    function hasSubstr(needle, haystack) {
      if(!haystack) {
        return false;
      }
      return haystack.toLowerCase().indexOf(needle) !== -1;
    }

    function searchFilter(classType) {

      return function(classObj) {
        if(classType !== classObj.type)
          return false;

        var search = $scope.searchString;
        if(!search || search.trim() === "")
          return true;

        search = search.toLowerCase();

        if(
          hasSubstr(search, classObj.course_id) ||
          hasSubstr(search, classObj.name))
        {
          return true;
        }
        else
          return false;
      };

    }

    $scope.showDetails = function(course) {
      console.log("Setting detail: ", course);

      DetailsPaneService.setDetailFromCourse(course);
    };

    $scope.clearDetails = function() {
      DetailsPaneService.clear();
    };

  }]);
})();