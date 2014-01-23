angular.module('todoApp')
	.factory('TodoServices', function($http) {
		'use strict';
		return {
			list: function(success, error) {
				$http.get('api/v1/todos').success(function(todos) {
					success(todos);
				}).error(error);
			},
			create: function(name, success, error) {
                $http.post('api/v1/todos', name).success(function() {
                    success();
                }).error(error);
			},
			mark: function(id, done, success, error) {
                $http.put('api/v1/todos/' + id.$oid, done).success(function() {
                    success();
                }).error(error);
            }
		};
	});