const batiks = [
    {
        name: 'Batik Bali',
        regional_origin: 'Bali',
        description: 'Batik Bali dikenal dengan warna-warna cerah dan motif yang rumit. Desainnya sering menggambarkan keindahan alam Bali, seperti bunga, burung, dan elemen alam lainnya, mencerminkan budaya dan tradisi Pulau Dewata.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20BALI.jpg'
    },
    
    {
        name: 'Batik Betawi',
        regional_origin: 'DKI Jakarta',
        description: 'Batik Betawi memiliki motif yang ceria dan penuh warna, seringkali menggambarkan kehidupan sehari-hari masyarakat Betawi. Motifnya mencerminkan keberagaman budaya dan sejarah Jakarta sebagai ibu kota Indonesia.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20BETAWI.jpg'
    },
    
    {
        name: 'Batik Ikat Celup',
        regional_origin: 'Indonesia',
        description: 'Batik Ikat Celup merupakan teknik pewarnaan kain dengan cara mengikat sebagian kain sebelum dicelupkan ke dalam pewarna. Hasilnya adalah pola yang unik dan beragam yang tidak bisa ditemukan pada jenis batik lainnya.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20IKAT%20CELUP.jpg'
    },
    
    {
        name: 'Batik Cenderawasih',
        regional_origin: 'Papua',
        description: 'Batik Cenderawasih menampilkan motif burung cenderawasih, burung khas Papua yang terkenal dengan bulu yang indah. Motif ini melambangkan keindahan alam Papua dan sering kali dikombinasikan dengan elemen-elemen alam lainnya.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20CENDRAWASIH.jpg'
    },
    
    {
        name: 'Batik Dayak',
        regional_origin: 'Nunukan, Kalimantan Utara',
        description: 'Batik Dayak terinspirasi dari seni ukir dan budaya suku Dayak di Kalimantan. Motifnya sering kali mencerminkan flora dan fauna hutan Kalimantan, serta kehidupan masyarakat Dayak yang kaya akan tradisi dan adat istiadat.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20DAYAK.jpg'
    },
    
    {
        name: 'Batik Geblek Renteng',
        regional_origin: 'Kulon Progo',
        description: 'Batik Geblek Renteng berasal dari Kulon Progo, Yogyakarta, dengan motif yang terinspirasi dari makanan tradisional Geblek. Pola geometris yang simetris ini mencerminkan kesederhanaan dan kearifan lokal masyarakat Kulon Progo.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20GEBLEK%20RENTENG.jpg'
    },
    
    {
        name: 'Batik Insang',
        regional_origin: 'Pontianak',
        description: 'Batik Insang memiliki motif yang terinspirasi dari bentuk insang ikan, yang menggambarkan kehidupan masyarakat pesisir Pontianak. Motif ini mencerminkan hubungan erat masyarakat dengan sungai dan laut di sekitar mereka.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20INSANG.jpg'
    },

    {
        name: 'Batik Kawung',
        regional_origin: 'Yogyakarta',
        description: 'Batik Kawung adalah salah satu motif batik klasik dari Yogyakarta. Pola bulatnya menyerupai buah kawung atau kolang-kaling, melambangkan kesucian dan kekuatan, serta sering dikaitkan dengan filosofi kebijaksanaan dan ketenangan.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20KAWUNG.jpg'
    },

    {
        name: 'Batik Lasem',
        regional_origin: 'Lasem, Rembang',
        description: 'Batik Lasem terkenal dengan perpaduan warna cerah dan motif yang terinspirasi dari budaya Tionghoa. Desainnya mencerminkan akulturasi budaya di daerah pesisir Lasem, serta kaya akan detail dan simbolisme yang mendalam.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20LASEM.jpg'
    },

    {
        name: 'Batik Megamendung',
        regional_origin: 'Cirebon, Jawa Barat',
        description: 'Batik Megamendung memiliki motif awan besar dan megah yang mencerminkan filosofi ketenangan dan kedamaian. Pola ini melambangkan harapan agar pemakainya selalu dalam keadaan tenang dan damai seperti awan di langit.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20MEGAMENDUNG.jpg'
    },

    {
        name: 'Batik Pala',
        regional_origin: 'Maluku',
        description: 'Batik Pala mengangkat motif buah pala, yang merupakan salah satu rempah utama dari Maluku. Motif ini mencerminkan kekayaan alam Maluku dan sejarah panjang perdagangan rempah yang telah berlangsung selama berabad-abad.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20PALA.jpg'
    },

    {
        name: 'Batik Parang',
        regional_origin: 'Yogyakarta',
        description: 'Batik Parang memiliki motif garis miring yang berulang, melambangkan keberanian dan semangat yang tak kenal menyerah. Motif ini sering digunakan oleh keluarga kerajaan sebagai simbol kekuatan dan kekuasaan.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20PARANG.jpg'
    },

    {
        name: 'Batik Poleng',
        regional_origin: 'Bali',
        description: 'Batik Poleng adalah motif khas Bali yang terdiri dari pola kotak-kotak hitam putih. Motif ini melambangkan keseimbangan antara baik dan buruk, serta sering digunakan dalam upacara keagamaan dan simbol-simbol adat Bali.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20POLENG.jpg'
    },
    
    {
        name: 'Batik Sekar Jagad',
        regional_origin: 'Yogyakarta dan Solo',
        description: 'Batik Sekar Jagad memiliki motif yang menggambarkan keindahan dan keragaman dunia. Nama "Sekar Jagad" sendiri berasal dari kata "Sekar" (bunga) dan "Jagad" (dunia), melambangkan kecantikan dan keberagaman budaya Indonesia.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20SEKAR%20JAGAD.jpg'
    },
    
    {
        name: 'Batik Tambal',
        regional_origin: 'Yogyakarta',
        description: 'Batik Tambal adalah motif yang terdiri dari potongan-potongan kain dengan pola yang berbeda-beda, melambangkan penyatuan elemen-elemen yang beragam. Motif ini memiliki makna filosofis tentang perbaikan dan pemulihan.',
        image: 'https://storage.googleapis.com/fotobatik/BATIKIMG/BATIK%20TAMBAL.jpg'
    },
]

module.exports = batiks;