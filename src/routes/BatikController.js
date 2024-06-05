const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /batik (because 'app.use()' from index.js)

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
        console.log(error);
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Get specified batik info from id
route.get('/id/:id', async (req, res) => {
    const batikId = req.params.id;
    try {
        const selectedBatik = await prisma.batik.findUnique({
            where: {
                id: batikId
            }
        });

        if (selectedBatik) {
            return res.json({
                message: 'Get selected batik success!',
                data: selectedBatik
            });
            console.log(`Batik yang dipilih: ${selectedBatik.name}`);
        } else {
            res.status(404).json({ message: 'Batik not found!' });
        }
    } catch(error) {
        console.log(error);
        res.status(500).json({ message: 'Internal server error!' });
    }
});

// Get specified batik info from name
route.post('/name', async (req, res) => {
    const { name } = req.body;

    try {
        const selectedBatik = await prisma.batik.findFirst({
            where: { name }
        });

        if(selectedBatik) {
            res.json({
                message: 'Get batik from name success!',
                data: selectedBatik
            });
        } else {
            res.status(404).json({ message: 'Batik not found! (Write correct and full batik name, ex: Batik Bali)' });
        }
    } catch(error) {
        console.log(error);
        res.status(500).json({ message: 'Internal server error!' });
    }
})

module.exports = route;