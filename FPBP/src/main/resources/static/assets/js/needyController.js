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
			$http({
					method:"POST",
					url:'/AvailableCategories/AddSeekerRequirement',
					data : {
	                    "orgName" : $scope.seeker.org_name,
	                    "address" : $scope.seeker.address,
	                    "contactNo" : $scope.seeker.contact_no,
	                    "website" : $scope.seeker.website,
	                    "email" : $scope.seeker.email,
	                    "requirement" : $scope.seeker.requirement,
	                    "quantity" : $scope.seeker.quantity,
	                    "category" : $scope.url
	                    
	                },
                    headers : {
                    	'Accept':'text/plain'
                       
                    }
					 
			}).then(function(response){
				alert(response.data);
				location.href = '/index.html';
			});
			
	}
  
	
});