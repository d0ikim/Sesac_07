// [역할] 유저(User)를 생성하는 POST API 라우터
// : 'Users' 테이블을 건드리는 파일임
// [연결] app.js에서 '/users' 경로에 등록되어 동작함
import express from 'express'
import { prisma } from "../utils/prisma/index.js" // 내보낸 prisma라는 유저(?)객체 가져옴

const router = express.Router();

// 새로운 유저 추가(POST)
router.post('/', async (req,res,next)=> {
  const {email, password, nickname} = req.body;
  try {
    // 기존에 DB에 이메일이 있는지 없는지 확인
    const existingUser = await prisma.users.findUnique({
      where: {email}
    })
    // 이메일이 있으면 중복 안내
    if(existingUser) {
      return res.send({
        message:"중복된 아이디가 있습니다."
      })
    }
    // 이메일 없으면 추가
    await prisma.users.create({
      data: {
        email,
        password,
        nickname
      }
    })
    return res.send({
      message:"회원가입 완료!"
    })
  } catch(e) {
    console.log(e)
  }
})

router.get('/', async (req,res,next)=> {
  const users = await prisma.users.findMany();  // prisma변수를 이용해 실제로 DB에 접근해 쿼리작업( users테이블에 있는 모든 유저 가져오기 )
  console.log(users);
  return res.send({
    users // DB에서 모든 유저 출력
  })
})

export default router
// 다 만든 후 메인인 app.js에 가서,
// 1. router파일 가져오고
// import userRouter from "./routers/user.router.js"
// 2. 라우터 경로 등록시켜야함
// app.use('/', userRouter);