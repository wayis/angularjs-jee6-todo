var todoControllers = angular.module('todoControllers', []);

todoControllers.controller('TodosListCtrl', function ($scope, $http) {
    $scope.todos = [
        {'name': 'Task 1', 'done': true},
        {'name': 'Task 2', 'done': false},
        {'name': 'Task 3', 'done': false}
    ];

    $scope.total = function() {
        return $scope.todos.length;
    };

    $scope.completed = function() {
        return _.filter($scope.todos, function(todo) {
            return todo.done;
        }).length;
    };

    $scope.add= function() {
        $scope.todos.push({'name': this.text, 'done': false});
        this.text = "";
    };

    $scope.mark = function() {
        // TODO: Update this method when Java EE6 backend will be done !
    };

    $scope.cleanup = function() {
        $scope.todos = _.filter($scope.todos, function(todo) {
            return !todo.done;
        });

    };
});