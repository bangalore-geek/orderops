angular.module('defysope', []).controller('loginCtrl', ['$scope', '$http', function($scope, $http) {
	$scope.user = "ytrhrth";
	$scope.forgetPassword = function(){
		$http.post(_contextPath + '/forgetPassword').then(function(response){
			if(response.data.success){
				toastr.success('Congratulations! you signed up successfully');
			}else{
				toastr.error('Sorry! something goes wrong please try again after some time.');
			}
		});
	};
	}]);