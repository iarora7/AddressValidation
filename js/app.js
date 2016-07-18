var myApp = angular.module("myApp", []);

myApp.controller('mainCtrl', function($scope, $http) {

    $scope.submitAdd = function() {

        $http({
            method : "POST",
            url : "http://localhost:8090/myaddress",
            params: {
                name: $scope.name,
                house: $scope.house,
                city: $scope.city,
                state: $scope.state }
        }).then(function mySucces(response) {
            // var address = response.data.name + " @ " + response.data.house + ", " + response.data.city + ", " + response.data.state;
            $scope.addressUpdate = "Thank you for registering!";
        }, function myError(response) {
            $scope.addressUpdate = response.statusText;
            console.log(response);
        });

    };

    $scope.getAdd = function() {
        console.log("Search for name: " + $scope.searchName);
        $http({
            method : "GET",
            url : "http://localhost:8090/myaddress",
            params: {name: $scope.searchName}
        }).then(function mySucces(response) {
            var address = response.data.name + " @ " + response.data.house + ", " + response.data.city + ", " + response.data.state;
            $scope.addressReturned = address;
        }, function myError(response) {
            $scope.addressReturned = response.statusText;
            console.log(response);
        });

    };

});

myApp.controller('addressValidate', function($scope, $http) {



    $scope.validateAdd = function() {

        var house = $scope.house1;
        var city = $scope.city1;
        var state = $scope.state1;
        var postal = $scope.postal1;

        var urlpart = ('<AddressValidateRequest USERID="087ADP003802"><Address ID="0"><Address1></Address1> <Address2>' + house + '</Address2><City>' + city + '</City><State>' + state + '</State> <Zip5>' + postal + '</Zip5><Zip4></Zip4></Address></AddressValidateRequest>');

        // console.log("URL: " + "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + urlpart);
        $http({
            method : "GET",
            url : "http://production.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + urlpart

        }).then(function mySucces(response) {

            var x2js = new X2JS();
            var aftCnv = x2js.xml_str2json(response.data);
            console.log("XML to JSON: " + JSON.stringify(aftCnv));

            if(aftCnv.AddressValidateResponse.Address.Error){
                console.log("There is an error!!");
                $scope.addressValid = "Invalid address, Please check again!";

            } else {
                $scope.addressValid = "Validated!";
            }
        }, function myError(response) {
            $scope.addressValid = response.statusText;
            console.log(response);
        });
    };
});