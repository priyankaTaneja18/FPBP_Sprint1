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
  
  $scope.LoginForm = function () {  
		$scope.message='hi';
		$http({
			method:"POST",
			url:'/Users/login',
			data : {
				emailId: $scope.UserModel.Email,  
				password: $scope.UserModel.Password
			},
			headers : {
				'Accept':'text/plain'

			}

		}).then(function(response){
			$scope.message= response.data;
			if(response.data == "Login Successful")
			{
				/*if(response.data.equals(""))*/
				location.href = '/NeedHelpAddForm.html?'+category;
			}
			/*else{
      	alert(response.data);
      }*/
		});
	}
  
  $scope.RegisterForm = function () { 	
	  alert('hi');
		$http({
			method:"POST",
			url:'/Users/register',
			data : {
				emailId: $scope.UserModel.Email,  
				password: $scope.UserModel.Password
			},
			headers : {
				'Accept':'text/plain'
			}

		}).then(function(response){
			$scope.message= response.data;
			if(response.data == "Account created successfully")
			{
				alert(response.data)
				location.href = '/NeedHelpAddForm.html?'+category;
			}
		});
	}	
	
});