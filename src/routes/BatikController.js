const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /batik (because 'use' from index.js)

// Get all batik from database
route.get('/', async (req, res) => {
    try {
        const allBatik = await prisma.batik.findMany();
        res.json({ 
            message: 'Get all batik success!', 
            data: allBatik 
        });
        console.log('Mendapat semua batik');

    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Get specified batik info from id
route.get('/id/:id_batik', async (req, res) => {
    const batikId = req.params.id_batik;

    try {
        const selectedBatik = await prisma.batik.findUnique({
            where: {
                id_batik: batikId
            }
        });

        if (selectedBatik) {
            res.json({
                message: 'Get selected batik success!',
                data: selectedBatik
            });
            console.log(`Batik yang dipilih: ${selectedBatik.nama_batik}`);
        } else {
            res.status(404).json({ message: 'Batik not found!' });
        }
    } catch(error) {
        res.status(500).json({ message: 'Internal server error!' });
    }
});

module.exports = route;