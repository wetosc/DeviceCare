var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});


router.post('/authentication', function(req, res, next) {
  res.send('hi');
  res.end();
});
module.exports = router;
