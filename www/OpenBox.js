var exec = require('cordova/exec');

//exports.openBox = function(success, error) {
//    exec(success, error, "YouxiBox", "openBox", []);
//};
 
    function YouxiBox(){};
    YouxiBox.prototype.openBox = function(key,success, error){
        exec(success, error, "YouxiBox", "openBox", [key]);
    };
    var YouxiBox = new YouxiBox();
    module.exports = YouxiBox;



