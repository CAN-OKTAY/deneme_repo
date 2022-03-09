
app.controller('indexController',function ($scope,$http){

    $http({
        method:'GET',
        dataType:"json",
        url:"api/users/list?page=1"
    }).then(function success(response){
        $scope.adresDataJson=response.data;
    });

});