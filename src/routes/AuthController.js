const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');
const bcrypt = require('bcrypt');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /auth (because 'app.use()' from index.js)

// Register route
route.post('/register', async (req, res) => {
    const { name, email, password } = req.body;

    try {
        const isUserExist = await prisma.user.findUnique({ where: {email} });

        if(!isUserExist) {
            const salt = await bcrypt.genSalt();
            const hashPassword = await bcrypt.hash(password, salt);
    
            const createUser = await prisma.user.create({
                data: {
                    name,
                    email,
                    password: hashPassword
                }
            });
            return res.json({ 
                message: 'Register success!',
                data: createUser
            });
        } else {
            return res.status(409).json({ message: `Email ${email} already registered!` });
        }
    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
    }
});

// Login route
route.post('/login', async (req, res) => {
    return res.send('Ini endpoint untuk login');
})

module.exports = route;