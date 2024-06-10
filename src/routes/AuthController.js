const route = require('express').Router();
const dotenv = require('dotenv');
const { PrismaClient } = require('@prisma/client');
const { body, validationResult } = require('express-validator');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const prisma = new PrismaClient();
dotenv.config();

// All path will automically start with /auth (because 'app.use()' from index.js)

// Generate token for session
const generateToken = (user) => {
    const { id, email } = user;
    const secret = process.env.JWT_SECRET;
    return jwt.sign({ id, email }, secret, {
        expiresIn: '1h'
    })
}

// Register route
route.post('/register', [
    body('name').notEmpty().withMessage('Name is required!'),
    body('email').isEmail().withMessage('Enter a valid email address!')
], async (req, res) => {

    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(400).json({ message: errors.array()[0].msg });
    }
    
    const { name, email, password } = req.body;

    try {
        const userExist = await prisma.user.findUnique({ where: {email} });

        if(userExist) {
            return res.status(409).json({ message: `Email ${email} already registered!` });
        }

        // Hash password
        const salt = await bcrypt.genSalt();
        const hashPassword = await bcrypt.hash(password, salt);

        const createUser = await prisma.user.create({
            data: {
                name,
                email,
                password: hashPassword
            }
        });
        // const token = generateToken(payload);
        return res.status(200).json({ 
            message: 'Register success!',
            data: createUser
        });
    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
    }
});

// Login route
route.post('/login', async (req, res) => {
    const { email, password } = req.body;

    try {
        const userExist = await prisma.user.findUnique({ where: {email} });
        if(!userExist) {
            return res.status(404).json({ message: 'User not found!' });
        }
        
        const validatePassword = await bcrypt.compare(password, userExist.password);
        if(validatePassword) {
            const token = generateToken(userExist);
            res.cookie('auth_token', token, { maxAge: '3600000' })
            return res.status(200).json({
                message: 'Login success!',
                data: userExist,
                token: token
            });
        } else {
            return res.status(401).json({ message: 'Invalid password!'});
        }
    } catch(error) {
        console.log(error);
        return res.status(500).json({ message: 'Internal server error!' });
    }
});

module.exports = route;