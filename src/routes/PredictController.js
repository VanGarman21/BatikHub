const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /predict (because 'use' from index.js)
// Predict the item inputed
route.post('/', (req, res) => {
    res.send('Ini endpoint untuk post predict');
});

module.exports = route;