defysope.controller('CompanyProfileCtrl', [ '$scope', '$http', function($scope, $http) {

	
	$scope.company = {};
	
	$scope.submitForm = function() {
		if ($scope.form1.$valid) {
			alert('our form is amazing');
		}

	};
	
} ]);