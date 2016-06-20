var hello = angular.module("helloApp", []);
hello.controller("HelloController", function($scope) {
	$scope.name = "Walter";
	console.log("controller 들어옴");
});