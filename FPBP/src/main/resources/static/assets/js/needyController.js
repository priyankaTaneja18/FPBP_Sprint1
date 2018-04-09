var app = angular.module("needyApp",[])
app.controller("needyController", function($scope,$http,$location){
	
	$scope.load=function(){
		
		$http.get('/AvailableCategories/Category').then(function(response) {       
			$scope.seekCategorylists=response.data;
			
			});
		}
	

	var category= $location.absUrl().split('?')[1];
	
	$scope.url=category;
	
	$http.get('/AvailableCategories/Seeker?category='+category).then(function(response) {       
			$scope.lists=response.data;
			
			});
	
});
