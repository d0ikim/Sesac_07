const express = require('express'); // 서버
const app = express();
const PORT = 3000;
app.use(express.json());

const dotenv = require('dotenv');
dotenv.config();  // .env 파일 읽어옴
const mysql = require('mysql2');  // DB

// 1. DB연결
const db = mysql.createConnection({ 
  host:process.env.DB_HOST,
  user:process.env.DB_USER,
  password:process.env.DB_PASSWORD,
  database:process.env.DB_DATABASE
}).promise();

// 2. 서버 요청 비동기작업 통해 쿼리문 날리기
app.post('/api/tables', async(req,res,next)=> {
  // 요청값 json
  // {
  //   "tableName":    "rawQueryTable"
  // }
  const { tableName } = req.body; // 구조분해할당으로 똑같은 변수명으로 req.body에 있는거 받아와서 쓰겠다

  // 테이블을 생성
  await db.query(`
    CREATE TABLE ${tableName} (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(20) NOT NULL,
        createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    )
    `);

    console.log(tableName);

  return res.json({message: '테이블 생성에 성공하였습니다.'})
})

app.get('/api/tables', async (req, res, next) => {
  return res.json();
  // 응답
  // {
  //   "tableList": [
  //     "rawQueryTable",
  //     "rawQueryTable1"
  //   ]
  // }
})

app.post('/api/tables/:tableName/items', async (req, res, next) => {
  // 요청값 json
  // {
  //   "name":"Hello"
  // }
  const { name } = req.body;

  // 데이터를 생성
  await db.query(`
    CREATE 
    `)
 
  return res.json({message: '테이블 생성에 성공하였습니다.'})
});

app.get('/api/tables/:tableName/items',  (req, res, next) => {
 res.send(
  {
    "itemList": [
      {
        "id": 1,
        "name": "Hello",
        "createdAt": "2024-01-01T04:17:57.000Z"
      },
      {
        "id": 2,
        "name": "Hello",
        "createdAt": "2024-01-01T04:17:57.000Z"
      },
      {
        "id": 3,
        "name": "Hello",
        "createdAt": "2024-01-01T04:17:58.000Z"
      }
    ]
  }
 )
})

app.listen(PORT, () => {
  console.log(`https://localhost:${PORT}`);
});