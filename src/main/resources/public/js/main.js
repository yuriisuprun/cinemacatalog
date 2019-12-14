var app = angular.module('cinemaDemo', []);
app.controller('cinemaCtrl', function($scope, $http) {
    $scope.cinemas = [];

  $http.get('http://localhost:8787/allCinema').success(function(data){
    $scope.cinemas = data;
  });
});