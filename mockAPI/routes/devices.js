var express = require('express');
var router = express.Router();

var validJSON =
  	[
      {
        "uuid": "hs15sd684fw51384==",
        "name": "Super Phone",
        "type": "Phone",
        "description": "A short device description"
      },
      {
        "uuid": "h1esd8684fw513ser58==",
        "name": "BatPhone",
        "type": "Phone",
        "description": "Not the phone you need, but the phone you deserve."
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


router.post('/', function(req, res, next) {
  if (req.query.token == "x0iF/jCpvz/cPuh/DyKVLQ==") {
    req.body.uuid = "ak5dan561ais8lda9da8=="
    res.json(req.body);
  } else {
    res.json(invalidJSON);
  }
  res.end();
});

module.exports = router;
