var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});


var validJSON = {
  	"errorCode": null,
  	"errorMessage": null,
  	"token": "x0iF/jCpvz/cPuh/DyKVLQ=="
  }

var invalidJSON = {
  	"errorCode": 1,
  	"errorMessage": "Invalid user name or password",
  	"token": null
  }

router.post('/authentication', function(req, res, next) {
  if (req.body.email == "abc@gmail.com" && req.body.password == "def") {
  	res.json(validJSON);
  } else {
  	res.json(invalidJSON);
  }
  res.end();
});
module.exports = router;
