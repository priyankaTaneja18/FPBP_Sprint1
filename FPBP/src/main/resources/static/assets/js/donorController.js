var app = angular.module("donorApp",[])
app.controller("donorController", function($scope,$http,$location){
	
	$scope.load=function(){
		
		$http.get('/AvailableCategories/Category').then(function(response) {       
			$scope.donorCategorylists=response.data;
			
			});

		
		var category= $location.absUrl().split('?')[1];
		
		$scope.url=category;
		
		$scope.inside=true;
		
		var searchText= document.getElementById("searchText").value;
		if(searchText==""){

			$http.get('/AvailableCategories/Seeker?category='+category).then(function(response) {       
				$scope.lists=response.data;
				
				});
		}else{
			$http.get('/AvailableCategories/SearchSeeker?category='+category+'&search='+searchText).then(function(response) {       
				$scope.lists=response.data;
				
				});
		}
		
		
	}
	 
	/*$scope.setClickedRow = function(index){
		$scope.url=index;
		
		
	}*/
	
	
});
