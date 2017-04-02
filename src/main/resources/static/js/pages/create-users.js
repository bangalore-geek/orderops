angular.module('defysope', []).controller('createUsersCtrl', ['$scope', '$http',
				function($scope, $http) {
	
	
	$scope.displayAddForm = false;
	$scope.users = {};
	$scope.roles = {};
	$scope.thisUser = {};
	
	$scope.loadUsers = function(){
		$http.get(_context + '/user').then(function(response){
			$scope.users = response.data.users;
		});
	};
	$scope.loadUsers();
	
	$scope.loadRoles = function(){
		$http.get(_context + '/roles').then(function(response){
			$scope.roles = response.data.roles;
		});
	};
	$scope.loadRoles();
	
	$scope.addForm = function() {
		$scope.thisUser = {};
		$scope.displayAddForm = true;
	};
	
	$scope.closeForm = function() {
		$scope.displayAddForm = false;
	};
	
	$scope.saveUsers = function(thisUser) {
		$http.post(_context+'/save-user',thisUser).then(function(response) {
			$scope.displayAddForm = false;
			$scope.loadUsers();
		});
	};
	
	$scope.getUser = function(userId) {
		$http.get(_context+'/user/'+userId).then(function(response) {
			$scope.thisUser = response.data.users;
			$scope.displayAddForm = true;
		});
	};
}]);