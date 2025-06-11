const express = require('express');

const aRouter = require('./a');
const app = express();

const PORT = 3000;
app.set("view engine", "ejs");
app.set("views", "./views")

app.use("./views", express.static(__dirname + "/views"));
app.use("./public", express.static(__dirname + "/public"));

app.use("/a", aRouter); // use("경로" 오면, 변수로 보내라)

const goods = [
      {
      goodsId: 1,
      goodName: "상품 1",
      category: "drink",
      price: 1000
      }
    ];

app.get('/api/goods', (req,res) => {
  res.send(goods);
})

app.post('/api/goods', (req,res) => {
  res.send({
      goods: [
        {
        goodsId: 1,
        goodName: "상품 1",
        category: "drink",
        price: 1000
        },
        {
        goodsId: 2,
        goodName: "상품 2",
        category: "drink",
        price: 3000
        },
      ]
    }
  );
})

app.get('/api/goods/:id', (req,res)=> {
  res.send({
  goodsId: 1,
  goodName: "상품 1",
  category: "drink",
  price: 1000
  });
})

app.put("/api/goods/:id", (req, res) => {
  res.send({
    goods: [
      {
        goodsId: 1,
        goodName: "상품 1",
        category: "drink",
        price: 1000
      },
      {
        goodsId: 2,
        goodName: "상품 2",
        category: "drink",
        price: 5000
      },
    ]}
  );
})

app.delete("/api/goods/:id", (req, res) => {
  res.send({
    goods: [
      {
        goodsId: 1,
        goodName: "상품 1",
        category: "drink",
        price: 1000
      }
    ]
  });
})

app.listen(PORT, () => {
  console.log(`http://localhost:${PORT}`)
})