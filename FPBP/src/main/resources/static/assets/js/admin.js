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
	 
});
