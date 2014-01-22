angular.module('todoApp')
	.factory('TodoServices', function($http) {
		'use strict';
		return {
			list: function(success, error) {
				$http.get('api/v1/todos').success(function(todos) {
					success(todos);
				}).error(error);
			}
		};
	});