var app = angular.module("needyApp",[])
app.controller("needyController", function($scope,$http,$location){
	
	$scope.load=function(){
		
		$http.get('/AvailableCategories/SeekHelp').then(function(response) {       
			$scope.seekCategorylists=response.data;
			
			});
		}
	

	var category= $location.absUrl().split('?')[1];
	
	$scope.url=category;
	
	$http.get('/AvailableCategories/'+category+'Seeker').then(function(response) {       
			$scope.lists=response.data;
			
			});
	
});
