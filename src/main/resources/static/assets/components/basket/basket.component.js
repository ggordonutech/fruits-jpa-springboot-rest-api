if(app){ //ensure app is defined
	app.component('basket',{
		templateUrl:'assets/components/basket/basket.component.html',
		controllerAs: '$ctrl',
		bindings:{
			ownerName:'<'
		},
		controller: [
			'$scope',
			function BasketController($scope){
				$scope.operationType = '';
				var lastBasketId = 2;
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
				
				$scope.showAdd=function(){
					$scope.operationType='Add';
				}
				
				$scope.doAction=function(){
					switch($scope.operationType){
					case 'Add': addBasket();
					}
				}
				
				function addBasket(){
					var ownerName = $scope.$ctrl.ownerName;
					console.log("Adding ",ownerName);
					$scope.baskets.push({
						id : ++lastBasketId,
						ownerName : ownerName
					});
					$scope.operationType='';
					window.alert("Basket added successfully");
					
					
				}
			}
		]
	});
}