const fs = require('fs');
const admin = require('firebase-admin');
const dotenv = require('dotenv');

dotenv.config();

const serviceAccountPath = process.env.SERVICE_ACCOUNT;
const serviceAccount = JSON.parse(fs.readFileSync(serviceAccountPath, 'utf-8'));
// console.log(serviceAccount);

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
});

const accessValidation = async (req, res, next) => {
    const headerToken = req.headers.authorization;

    if(!headerToken) {
        return res.status(401).json({ message: 'Unauthorized Access: Token Needed!' });
    }

    const token = headerToken.split(' ')[1];

    try {
        const decode = await admin.auth().verifyIdToken(token);
        req.user = decode;
        next();
    } catch(error) {
        return res.status(401).json({ message: 'Unauthorized Access: Invalid Token!' })
    }
}

module.exports = accessValidation;