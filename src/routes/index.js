const route = require('express').Router();
const batikRoute = require('./BatikController');
const predictRoute = require('./PredictController');
const authRoute = require('./AuthController');

route.use('/batik', batikRoute);
route.use('/predict', predictRoute);
route.use('/auth', authRoute);

module.exports = route;