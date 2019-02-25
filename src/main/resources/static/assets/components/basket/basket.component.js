if(app){ //ensure app is defined
	app.component('basket',{
		templateUrl:'assets/components/basket/basket.component.html',
		controller: [
			'$scope',
			function BasketController($scope){
				$scope.baskets = [
					{
						id:1,
						ownerName:"Hermione Granger"
					},
					{
						id:2,
						ownerName:"Tom Riddle"
					}
				];
			}
		]
	});
}