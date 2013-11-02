(function() {

  coursePlannerApp.directive("dkToggleClick",
  function() {
    return {
      restrict: "A",
      link: function(scope, elem, attrs) {
        elem.bind("click", function() {
          scope[attrs.dkToggleClick] = !scope[attrs.dkToggleClick];
          scope.$apply();
        });
      }
    };
  });

})();