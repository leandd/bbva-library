'use strict';

angular.module('book')
    .controller('ListCtrl', function ($scope, book, $routeParams) {

        $scope.load = function() {
            book.list(function (list) {
                $scope.list = list.data;
            });
        }

        $scope.save = function() {
            book.save($scope.form, function() {
                $scope.load();
            });
        }
        
        $scope.deleteBook = function(id){
   		 book.deleteBook(id, function() {
   			$scope.load();
   		});
   	}

        $scope.form = {};

        $scope.load();
    });
