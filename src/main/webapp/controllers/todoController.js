angular.module('todoApp').controller('TodosListCtrl', ['$scope', '$http', 'TodoServices', function ($scope, $http, TodoServices) {
    $scope.todos = [];

    var refreshList = function() {
        TodoServices.list(function(todos) {
        $scope.todos = todos;
    })};
    refreshList();

    $scope.total = function() {
        return $scope.todos.length;
    };

    $scope.completed = function() {
        return _.filter($scope.todos, function(todo) {
            return todo.done;
        }).length;
    };

    $scope.add= function() {
        TodoServices.create(this.name, function() {
            refreshList();
            this.name = "";
        });
    };

    $scope.mark = function(todo) {
        TodoServices.mark(todo._id, todo.done, function() {
            refreshList();
        });
    };

    $scope.cleanup = function() {
        $scope.todos = _.filter($scope.todos, function(todo) {
            return !todo.done;
        });

    };
}]);