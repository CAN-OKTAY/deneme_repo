
app.controller('userInfoController',function ($scope,$http){

    $http({
        method:'GET',
        dataType:"json",
        url:"api/users/getList?page=1"
    }).then(function success(response){
        $scope.adresDataJson=response.data;
    });

});