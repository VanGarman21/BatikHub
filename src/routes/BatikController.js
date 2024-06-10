const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /batik (because 'app.use()' from index.js)

// Get all batik from database
route.get('/', async (req, res) => {
    try {
        const batiks = await prisma.batik.findMany();
        return res.status(200).json({ 
            message: 'Get all batik success!', 
            data: batiks
        });

    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
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
            return res.status(200).json({
                message: 'Get selected batik success!',
                data: selectedBatik
            });
        } else {
            return res.status(404).json({ message: 'Batik not found!' });
        }
    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
    }
});

// Get specified batik info from name
route.post('/name', async (req, res) => {
    const { name } = req.body;

    try {
        // if( {name} = ''){
        //     return res.json({ message: "Type some batik name!" });
        // }
        
        const selectedBatik = await prisma.batik.findFirst({
            where: { name }
        });

        if(selectedBatik) {
            return res.status(200).json({
                message: 'Get batik from name success!',
                data: selectedBatik
            });
        } else {
            return res.status(404).json({ message: 'Batik not found! (Write correct and full batik name, ex: Batik Bali)' });
        }
    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
    }
})

module.exports = route;