import { PrismaClient } from '@prisma/client' // 데이터베이스 클라이언트 코드 가져옴

export const prisma = new PrismaClient({
  // PrismaClient 클래스는 실제로 DB에 접근하고 쿼리할 수 있게 해줌
  log : ['query', 'info', 'warn', 'error'],
  errorFormat: 'pretty'
})  // prisma라는 유저(?)객체를 만들어 내보냄