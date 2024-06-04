const batik = require('./batik');
const { PrismaClient } = require('@prisma/client');
const prisma = new PrismaClient();

async function main() {
    for (let batik of batik) {
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