const express = require("express");
const router = express.Router();
const jwt = require('jsonwebtoken')
const authenticateToken = require('../middleware/authenticate-middleware')

const SECRET_KEY = "sesac"

router.get('/login', (req, res, next) => {
  const user = {
    id: 1,
    username:"홍길동",
    role:"user"
  }

  const token = jwt.sign(user, SECRET_KEY, {
    expiresIn : '5h'
  })
  console.log(token)
  return res.json({
    token
  })
})

router.get("/user",authenticateToken, (req,res,next)=>{
  // 토큰 검증을 하면 되겠죠?
  // next(new Error("Forbidden"))
  console.log(req.user);
})



module.exports = router;