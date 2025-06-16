// 레포지토리 = DB에 접근하는 파일(Prisma)
const prisma = require('../utils/prisma/index')

class AuthRepository {  // 클래스(빵틀)

  async findByEmail(email){
    return await prisma.users.findFirst({
      where: { email }
    })
  }

  async createUser(email, password, nickname){
    return await prisma.users.create({
      data: {
        email,
        password, // 암호화된 비밀번호로 저장
        nickname
      }
    })
  }

  async login(email){
    // 2. 이메일에 해당하는 사용자 찾기
    return await prisma.users.findFirst({
        where: { email }
      })
  }
}

module.exports = new AuthRepository(); // 새 인스턴스(빵) 생성해 사용할 수 있게 내보냄