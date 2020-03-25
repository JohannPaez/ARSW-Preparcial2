var apiClient = (function(){

    return {
        getAirportsByName: function(name, callback) {
            var promise = $.get({
                url: "/airports/"+ name
            });

            promise.then(function(data) {
                console.log("DATA ------------------------ " + data);
                callback(null, JSON.parse(data))
            }, function(error) {
                callback(error, null);
            });
        }
    }

})();