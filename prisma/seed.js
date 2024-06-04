const batiks = require('./batiks');
const { PrismaClient } = require('@prisma/client');
const prisma = new PrismaClient();

async function main() {
    for (let batik of batiks) {
        await prisma.batik.create({
            data: batik
        })
    }
}

main().catch(e => {
    console.log(e);
    process.exit(1);
}).finally(() => {
    prisma.$disconnect();
})