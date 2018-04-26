var app = angular.module("demoApp",[])
app.controller("demoCtrl", function($scope,$http,$location){
	
	$scope.load=function(){
		$scope.email=localStorage.getItem("email");
		if($scope.email==""){
			document.getElementById("logout").style.visibility = "hidden";
		}else{
			document.getElementById("logout").style.visibility = "visible";
		}
	}
	$scope.Category=function(){
		$http.get('/AvailableCategories/Category').then(function(response) {       
					$scope.categorylists=response.data;
					
	     });
		}
	
	$scope.haveLoggedInBefore= function(){
	
		
		var mail= localStorage.getItem("email");
	
		  if(mail==""){
			  
			  $scope.value="loginModal";
		  }else{
			  $scope.value="";
			 
			  
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
				
				localStorage.setItem("email", $scope.UserModel.Email);
				
			}
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
				localStorage.setItem("email", $scope.UserModel.Email);
				
				location.href = '/index.html';
				
			}
		    
		});
		}
	}

  $scope.logout=function(){
	  localStorage.setItem("email","");
	 alert("You are successfully logged out");
	  location.href = '/index.html';
  }
	
});



