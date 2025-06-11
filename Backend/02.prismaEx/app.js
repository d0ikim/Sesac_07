import express from 'express';
import userRouter from "./routers/user.router.js" // 1. user.router파일 가져오고
import postRouter from "./routers/post.router.js" // 1. post.router파일 가져오고

const PORT = 4000;
const app = express();
app.use(express.json());

app.use('/users', userRouter); // 2. user.router 등록시키기(POST)
app.use('/post', postRouter) // 2. post.router 등록시키기


app.listen(PORT, () => {
  console.log(`http://localhost:${PORT}`)
})