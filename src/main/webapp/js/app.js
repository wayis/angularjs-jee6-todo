var todoApp = angular.module('todoApp', [
  'ngRoute',
  'todoControllers',
  'ui.bootstrap'
]);

todoApp
    .config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/todos', {
        templateUrl: 'views/todos.html',
        controller: 'TodosListCtrl'
      }).
      otherwise({
        redirectTo: '/todos'
      });
  }]);