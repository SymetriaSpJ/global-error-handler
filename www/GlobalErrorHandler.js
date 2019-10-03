var exec = cordova.require('cordova/exec');

var GlobalErrorHandler = function() {};

GlobalErrorHandler.prototype.initializeCapturingErrors = function() {
    var errorCallback = function() {};
    var successCallback = function() {};

    exec(successCallback, errorCallback, 'GlobalErrorHandler', 'initializeCapturingErrors', []);
};

GlobalErrorHandler.prototype.startError = function() {
    var errorCallback = function() {};
    var successCallback = function() {};

    exec(successCallback, errorCallback, 'GlobalErrorHandler', 'startError', []);
};

GlobalErrorHandler.prototype.startSecondError = function() {
    var errorCallback = function() {};
    var successCallback = function() {};

    exec(successCallback, errorCallback, 'GlobalErrorHandler', 'startSecondError', []);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = GlobalErrorHandler;
}