var express = require('express');
var router = express.Router();

var validJSON =
  	[
      {
        "uuid": "hs15sd684fw51384==",
        "name": "Super Phone",
        "type": "Phone",
        "description": "A short device description"
      }
    ] 

var invalidJSON = {
  	"errorCode": 3,
  	"errorMessage": "Invalid token",
}

router.get('/', function(req, res, next) {
  if (req.query.token == "x0iF/jCpvz/cPuh/DyKVLQ==") {
  	res.json(validJSON);
  } else {
  	res.json(invalidJSON);
  }
  res.end();
});


module.exports = router;
