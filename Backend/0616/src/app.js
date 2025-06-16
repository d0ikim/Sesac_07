import express from 'express'
import cookieParser from 'cookie-parser'
import dotenv from 'dotenv'
import {prisma} from '../src/utils/prisma/index.js'
import bcrypt from 'bcrypt'

dotenv.config();
const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.json())
app.use(cookieParser())

app.post("/sign-up", async (req,res)=>{
  const {email, password, name, age, gender, profileImage} = req.body;

  if (!email || !password || !name) {
    return res.status(400).json({
      message: "이메일, 비밀번호, 이름을 모두 입력해주세요."
    })
  }

  const isExistUser = await prisma.users.findFirst({
    where: {email}
  });

  if (isExistUser) {
    return res.status(409).json({
      message: "이미 존재하는 이메일입니다."
    });
  }

  const hashedPassword = await bcrypt.hash(password, 10);

  try {
    const newUser = await prisma.$transaction(async (tx)=>{
      // Users 테이블에 값 추가
      const user = await tx.users.create({
        data: {
          email,
          password
        }
      })

      // UserInfos 테이블에 값 추가
      const userInfo = await tx.userInfos.create({
        data: {
          userId: user.userId,
          name,
          age : age ? parseInt(age) : null,
          gender : gender ? gender.toUpperCase() : null,
          profileImage : null
        }
      })
      return {user, userInfo};
    })
  } catch(e){
    console.error(e);
    return res.status(500).json({ message: "서버 내부 오류" });
  }

})

app.listen(PORT, ()=>{
  console.log(`${PORT} 포트로 서버가 열렸어요!`)
})