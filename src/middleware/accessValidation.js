const { PrismaClient } = require('@prisma/client');
const jwt = require('jsonwebtoken');
const dotenv = require('dotenv');

const prisma = new PrismaClient();
dotenv.config();

const accessValidation = (req, res, next) => {
    const { authorization } = req.headers;

    if(!authorization) {
        res.status(401).json({ message: 'Token needed!' });
    }

    const token = authorization.split(' ')[1];
    const secret = process.env.JWT_SECRET;

    try {
        const decode = jwt.verify(token, secret);
        req.user = decode;
    } catch(error) {
        return res.status(401).json({ message: 'Unauthorized!' })
    }

    next();
}

module.exports = accessValidation;