angular.module('defysope', []).controller('createUsersCtrl', ['$scope', '$http',
				function($scope, $http) {
	
	
	$scope.displayAddForm = false;
	$scope.users = {};
	
	$scope.thisUser = {};
	
	
	$scope.loadUsers = function(){
		$http.get(_context + '/user').then(function(response){
			console.log(response.data.users);
			$scope.users = response.data.users;
			console.log($scope.users);
		});
	};
	
	$scope.loadUsers();
	
	$scope.addForm = function() {
		console.log("add form >>>>>");
		$scope.thisUser = {};
		$scope.displayAddForm = true;
	};
	
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
	$scope.saveUsers = function(thisUser) {
		$http.post(_context+'/save-user',thisUser).then(function(response) {

		});
	};
	
	$scope.getUser = function(userId) {
		console.log("userId >> "+userId);
		$http.get(_context+'/user/'+userId).then(function(response) {
			$scope.thisUser = response.data.users;
			$scope.displayAddForm = true;
		});
	};
	
	$scope.getUser();
	
}]);