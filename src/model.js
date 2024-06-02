const mysql = require('mysql');
// const uuid4 = require('uuid4');

// const connection = mysql.createConnection({
//     host: 'localhost',
//     user: 'root',
//     password: '',
//     database: 'mysql://root:@localhost:3306/batikhub_dev'
// });

const connection = 'mysql://root:@localhost:3306/batikhub_dev'

connection.connect((err) => {
    if (err) {
        console.error('Error connecting to MySQL:', err.stack);
        return;
    }
    console.log('Connected to MySQL as id ' + connection.threadId);
});

// const uuid = uuidv4();

// const sql = "INSERT INTO batik (id_batik, nama_batik, asal_daerah, deskripsi_batik, gambar_batik) VALUES (?, ?, ?, ?, ?)";
// connection.query(sql, ['58419c4b-316d-4a22-b675-595214660bc3', 'Batik Ceplok', 'Kabupaten Bantul, Daerah Istimewa Yogyakarta', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vel felis a lacus cursus cursus. Vestibulum tincidunt nec metus in fermentum. Nulla eget diam vestibulum, venenatis eros a, ultricies mauris. Curabitur sed odio id ipsum vehicula porttitor a ut nibh. Praesent rutrum, erat quis hendrerit aliquet, est arcu viverra justo, aliquam condimentum est est at enim. Ut nec pulvinar arcu. Ut nec fermentum leo. Maecenas tempus bibendum est id malesuada. Phasellus auctor sagittis felis vel egestas. Sed lacinia metus neque, at posuere arcu bibendum non.', 'https://drive.google.com/file/d/1cG4iip3LbY9lWuCtEiNv6u8nHKO-qC2p/view?usp=drive_link'], (error, results, fields) => {
//     if (error) {
//         console.error('Error inserting data:', error.stack);
//         return;
//     }
//     console.log('Data inserted!');
// });

connection.end();