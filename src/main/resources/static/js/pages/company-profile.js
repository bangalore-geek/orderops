defysope.controller('CompanyProfileCtrl', [ '$scope', '$http', function($scope, $http) {


	$scope.company = {};

	$scope.save = function() {
		console.log('save called')
		$http.get("/save-user").then(function(res) {
			console.log(res);
		})

	};

} ]);