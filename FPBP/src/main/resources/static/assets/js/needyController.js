var app = angular.module("needyApp",[])
app.controller("needyController", function($scope,$http,$location){
	
	var category= $location.absUrl().split('?')[1];	
	$scope.url=category;
	
	$http.get('/AvailableCategories/Providers?category='+category).then(function(response) {       
			$scope.lists=response.data;
			
			});
	
	
	$scope.load=function(){
		
		$http.get('/AvailableCategories/Category').then(function(response) {       
			$scope.seekCategorylists=response.data;
			
			});
		}
	
  $scope.submitForm=function(){
		
		$scope.successMsg='called';
	
  }
	
}).factory("Seeker")
