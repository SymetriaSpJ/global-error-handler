var exec = cordova.require('cordova/exec');

var GlobalErrorHandler = function() {};

GlobalErrorHandler.prototype.initializeCapturingErrors = function(onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'GlobalErrorHandler', 'initializeCapturingErrors', []);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = GlobalErrorHandler;
}