var app=angular.module('app',[]);

app.controller('indexController',function ($scope,$http){

   $http({
      method:'GET',
      url:"/api/adres/list?page=2"
   }).then(function success(response){
      $scope.adresFormPage1=response.data;
   });

});