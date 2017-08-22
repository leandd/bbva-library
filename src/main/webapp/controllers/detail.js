'use strict';

angular.module('book')
    .controller('DetailCtrl', function ($scope, book, $routeParams) {
    	
   	
    	$scope.get = function(){
    		 book.get($routeParams.id, function(data) {
    			$scope.detail = data.data;
    		});
    	}
    	$scope.get();  	
    });
