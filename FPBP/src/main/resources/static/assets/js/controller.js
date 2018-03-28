var app = angular.module("demoApp",[])
app.controller("demoCtrl", function($scope,$http,$location){
	
	$scope.seekHelpCategory=function(){
		$http.get('/AvailableCategories/SeekHelp').then(function(response) {       
					$scope.seekCategorylists=response.data;
					
	     });
		}

	$scope.wannaHelpCategory=function(){
		$http.get('/AvailableCategories/Donate').then(function(response) {       
					$scope.donorCategorylists=response.data;
					
	     });
		}
	
	
	
});


