var app= angular.module("admin",[])
app.controller("adminController", function($scope,$http,$location){
	
	$scope.seekers=function(){
		$scope.donorMessage=false;
		$scope.seekerMessage=true;
	$http.get('/AdminView/Seeker').then(function(response) { 
		
			$scope.details=response.data;
			
			
			});
	 }
	 
	$scope.donors=function(){
		$scope.donorMessage=true;
		$scope.seekerMessage=false;
		$http.get('/AdminView/Donor').then(function(response) { 
				$scope.details=response.data;
				
				});
		 }
	
	 $scope.logout=function(){
		 localStorage.setItem("email","");
		 alert('Logout Successful!');
		  location.href = '/index.html';
	  }
	 
	 
	 $scope.deleteDonor=function(info){
		 var id= info.id;
		 var name = 'helpProvider';
			$scope.successMsg='called';
			$http({
					method:"POST",
					url:'/AdminView/Delete/?id='+id,
					data : {
	                    
	                    "tableName" : name,
	                 },
	                
			}).then(function(response){
				 alert("Row deleted Successfully")
				 if (response.data == true) {
					
							$http.get('/AdminView/Donor').then(function(response) { 
								
									$scope.details=response.data;
									
									});
				 	}
				 });	
	}
	 
	 $scope.deleteSeeker=function(info){
		 var id= info.sid;
			$scope.successMsg='called';
			$http({
					method:"POST",
					url:'/AdminView/Delete/?id='+id,
					data : {
	                    
	                    "tableName" : "helpSeeker",
	                 },
	                
			}).then(function(response){
				 alert("Row deleted Successfully")
				 if (response.data == true) {
					
							$http.get('/AdminView/Seeker').then(function(response) { 
								
									$scope.details=response.data;
									
									});
				 	}
				 });	
	}
	 
	 
	 
	 $scope.addSeeker=function(){
			$http({
					method:"POST",
					url:'/AvailableCategories/AddSeekerRequirement',
					data : {
	                    "orgName" : $scope.seeker.orgname,
	                    "address" : $scope.seeker.address,
	                    "contactNo" : $scope.seeker.contact_no,
	                    "website" : $scope.seeker.website,
	                    "email" : $scope.seeker.email,
	                    "requirement" : $scope.seeker.requirement,
	                    "quantity" : $scope.seeker.quantity,
	                    "category" : $scope.seeker.category
	                    
	                },
                 headers : {
                 	'Accept':'text/plain'
                    
                 }
					 
			}).then(function(response){
				alert(response.data);
				location.href = '/admin.html';
			});
			
			
	}
	 
	 
	 $scope.addProvider=function(){
		 alert($scope.provider.category)
		 
			$http({
					method:"POST",
					url:'/AvailableCategories/AddProvider',
					data : {
	                    "name" : $scope.provider.org_name,
	                    "address" : $scope.provider.address,
	                    "contactNo" : $scope.provider.contact_no,
	                    "email" : $scope.provider.email,
	                    "hoursOfOperation" : $scope.provider.hoursOfOperation,
	                    "website" : $scope.provider.website,
	                    "category" : $scope.provider.category
	                    
	                },
              headers : {
              	'Accept':'text/plain'
                 
              }
					 
			}).then(function(response){
				alert(response.data);
				location.href = '/admin.html';
			});
		 }
	
	 
});
