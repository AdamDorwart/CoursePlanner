(function() {

  var coursePlannerApp =
    angular.module("CoursePlannerApp", ["lvl.directives.dragdrop"]);
  window.coursePlannerApp = coursePlannerApp;

  coursePlannerApp.
    filter('htmlToPlaintext', function() {
      return function(text) {
        return String(text).replace(/<(?:.|\n)*?>/gm, '');
      };
    }
  );

})();