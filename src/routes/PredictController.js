const route = require('express').Router();
const multer = require('multer');
const predictBatik = require('../utils/predict');
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();

// All path will automically start with /predict (because 'app.use()' from index.js)

const upload = multer({
    storage: multer.memoryStorage(),
    limits: {
        fileSize: 10 * 1024 * 1024,
    }
});

// Predict the posted image
route.post('/', upload.single('image'), async (req, res) => {
    const image = req.file;
    if(!image) {
        return res.status(400).json({ message: 'Invalid input!' });
    }

    try {
        const { confidenceScore, label } = await predictBatik(image.buffer);
        
        const batik = await prisma.batik.findFirst({
            where: {
                name: label
            }
        });

        const percentage = parseInt(confidenceScore);
        
        const now = new Date();
        const dateId = new Intl.DateTimeFormat('en-uk', {
            timeZone: 'Asia/Jakarta',
            year: 'numeric',
            month: '2-digit',
            day: '2-digit',
            hour: '2-digit',
            minute: '2-digit'
        });
        const [{ value: day },, { value: month },, { value: year },, { value: hour },, { value: minute }] = dateId.formatToParts(now);
        const date = `${day}-${month}-${year} | ${hour}:${minute}`;

        const img = batik.image;
        const desc = batik.description;

        return res.status(200).json({ 
            message: 'Image predicted succesfully! (this will not be posted to Cloud SQL database)',
            img,
            label,
            percentage,
            date,
            desc
        });
    } catch(error) {
        return res.status(500).json({ message: 'Internal server error!' });
    }
});

module.exports = route;