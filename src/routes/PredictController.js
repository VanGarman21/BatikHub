const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /predict (because 'use' from index.js)

// Predict the item inputed
route.post('/', (req, res) => {
    try {
        res.send('Ini endpoint untuk post predict');
    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Get histories of predictions
route.get('/histories', (req, res) => {
    try {
        res.send('ini endpoint untuk riwayat prediksi');
    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Multiple route for Get or Delete predict histories from id

    // --- Get
route.route('/id/:id_predict').get((req, res) => {
    try {
        res.send('Ini endpoint untuk mendapatkan prediksi sesuai id');
    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
    // ---Delete
}).delete((req, res) => {
    try {
        res.send('Ini endpoint untuk hapus riwayat prediksi');
    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Delete history by id
// route.delete('/id/:id_predict', (req, res) => {});

module.exports = route;