
var exec = require('cordova/exec');

exports.openBox = function(success, error) {
    exec(success, error, "YouxiBox", "openBox", []);
};



