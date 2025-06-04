const mysql = require('mysql2/promise');
require('dotenv').config();

const pool = mysql.createPool({ // DB 연결 시도
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  port: 3306,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_DATABASE
});

// pool.query("SELECT * FROM customers;")
module.exports = pool;