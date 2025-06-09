// 얘는 ???하는 라우터 파일임
// : 'Posts' 테이블을 건드리는 파일임

import express from 'express'

const router = express.Router();

export default router
// 다 만든 후 메인인 app.js에 가서,
// 1. router파일 가져오고
// import userRouter from "./routers/post.router.js"
// 2. 라우터 등록시켜야함
// app.use('/', postRouter);