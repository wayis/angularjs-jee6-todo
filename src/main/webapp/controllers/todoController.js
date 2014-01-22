angular.module('todoApp').controller('TodosListCtrl', ['$scope', '$http', 'TodoServices', function ($scope, $http, TodoServices) {
    $scope.todos = [];

    TodoServices.list(function(todos) {
        $scope.todos = todos;

    });

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
}]);