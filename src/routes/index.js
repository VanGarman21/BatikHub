const route = require('express').Router();
const batikRoute = require('./BatikController');
const predictRoute = require('./PredictController');
const authRoute = require('./AuthController');

route.use('/auth', authRoute);
route.use('/batik', batikRoute);
route.use('/predict', predictRoute);

module.exports = route;