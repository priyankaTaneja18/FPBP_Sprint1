var app = angular.module("needyApp",[])
app.controller("needyController", function($scope,$http,$location){
	
	var category= $location.absUrl().split('?')[1];	
	$scope.url=category;
	
	
	$scope.load=function(){
			
		var searchText= document.getElementById("searchText").value;
		if(searchText==""){
		$http.get('/AvailableCategories/Providers?category='+category).then(function(response) {       
			$scope.lists=response.data;
			
			});
		}else{
			$http.get('/AvailableCategories/SearchProviders?category='+category+'&search='+searchText).then(function(response) {       
				$scope.lists=response.data;
				
				});
		}
		
		$http.get('/AvailableCategories/Category').then(function(response) {       
			$scope.seekCategorylists=response.data;
			
			});
		
		$scope.email=localStorage.getItem("email");
		if($scope.email==""){
			document.getElementById("logout").style.visibility = "hidden";
		}else{
			document.getElementById("logout").style.visibility = "visible";
		}
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
				location.href = '/NeedHelp.html?'+category;
			});
			
	}
  
  $scope.LoginForm = function () {  
		$scope.message='hi';
		if(  $scope.UserModel.Email == "admin@gmail.com" && $scope.UserModel.Password =="admin@123")
		{
			location.href = '/admin.html';
		}
		else {
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
				location.href = '/NeedHelpAddForm.html?'+category;
				localStorage.setItem("email", $scope.UserModel.Email);
				$scope.email='Hi,'+localStorage.getItem("email");
			}
			/*else{
      	alert(response.data);
      }*/
		});
		}
	}
  
  $scope.RegisterForm = function () { 	
	  
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
				localStorage.setItem("email", $scope.UserModel.Email);
				$scope.email='Hi,'+localStorage.getItem("email");
			}
		});
	}	
  
  $scope.haveLoggedIn= function(){
	  if($scope.email==""){
		  $scope.value="helpModal";
	  }else{
		  $scope.value="";
		  location.href = '/NeedHelpAddForm.html?'+category;
	  }
  }
  
  $scope.logout=function(){
	  localStorage.setItem("email","");
	 alert("You are successfully logged out");
	  location.href = '/index.html';
  }
	
});