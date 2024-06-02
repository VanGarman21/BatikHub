const route = require('express').Router();
const batikRoute = require('./BatikController');
const predictRoute = require('./PredictController')

route.use('/batik', batikRoute);
route.use('/predict', predictRoute);

module.exports = route;