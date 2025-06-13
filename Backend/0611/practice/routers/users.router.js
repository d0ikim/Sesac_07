const express = require("express");
const router = express.Router();
const jwt = require('jsonwebtoken')
const SECRET_KEY = "sesac"
const authenticateToken = require('../middleware/authenticate-middleware')
const prisma = require('../utils/prisma/index')
const bcrypt = require('bcrypt')

const { signUpValidator,loginValidator,handleValidationResult } = require('../middleware/validation-result-handler')


/** 회원가입 API
 * 1. 이메일, 비밀번호, 닉네임 입력이 정확하게 왔는지 검증
 * 2. 비밀번호 6글자 이상
 * 3. 이메일이 중복이 있는지 확인
 * 4. 데이터베이스에 저장
 */
router.post('/sign-up', signUpValidator, handleValidationResult, async (req, res, next) => {
  const { email, password, nickname } = req.body;

  try {
    const user = await prisma.users.findFirst({
      where: { email }
    })
    if (user) {
      return next(new Error("ExistEmail"));
    }

    // 비밀번호 암호화
    const saltRounds = 10;
    const salt = await bcrypt.genSalt(saltRounds);
    console.log(salt)
    const bcryptPassword = await bcrypt.hash(password, salt)

    // 4. 데이터 베이스에 저장
    await prisma.users.create({
      data: {
        email,
        password: bcryptPassword, // 암호화된 비밀번호로 저장
        nickname
      }
    })

    return res.status(201).json({
      message: '회원가입이 성공적으로 완료'
    });
  } catch (e) {
    console.log(e)
    return next(new Error("DataBaseError"));
  }
})


/** 로그인 API
 * 1. 이메일, 비밀번호 입력 여부 확인
 * 2. 이메일에 해당하는 사용자 찾기
 * 3. 사용자 존재 여부
 * 4. 비밀번호 일치 여부 확인
 * 5. JWT 토큰 발급
 * 6. 생성된 데이터를 전달
 */
router.post('/login',loginValidator, handleValidationResult, async (req, res, next) => {
    const { email, password } = req.body;
    // 2번까지 완료!
    const user = await prisma.users.findFirst({
      where: { email }
    })
    if (!user) {
      // 유저가 없는 경우
      return next(new Error("UserNotFound"));
    }
    // 사용자가 있음 확인
    const verifyPassword = await bcrypt.compare(password, user.password);
    // console.log(verifyPassword)

    if(!verifyPassword){
      return next(new Error("PasswordError"));
    }
    const token = jwt.sign({
      userId : user.userId
    }, SECRET_KEY, {
      expiresIn : "12h"
    })
    return res.status(200).send({
      token
    })

})


router.get("/user",authenticateToken, (req,res,next)=>{
  // 토큰 검증을 하면 되겠죠?
  // next(new Error("Forbidden"))
  console.log(req.user);
})

module.exports = router;