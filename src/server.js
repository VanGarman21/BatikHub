const express = require('express');
const app = express();
const route = require('./routes');
const dotenv = require('dotenv');

dotenv.config();
const ports = process.env.PORT;

// Catch body from request
app.use(express.json());

app.use('/', route);

app.get('/', (req, res) => {
    res.send('Welcome to BatikHub');
});

app.listen(ports, () => {
    console.log(`BatikHub server listening at http://localhost:${ports}`)
});