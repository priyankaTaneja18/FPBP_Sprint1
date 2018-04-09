var app = angular.module("demoApp",[])
app.controller("demoCtrl", function($scope,$http,$location){
	
	$scope.Category=function(){
		$http.get('/AvailableCategories/Category').then(function(response) {       
					$scope.categorylists=response.data;
					
	     });
		}

	
	
	
});


