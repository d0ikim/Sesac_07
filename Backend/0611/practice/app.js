const express = require("express");
const userRouter = require("./routers/users.router");
const postRouter = require("./routers/posts.router");
const cookieParser = require("cookie-parser");
const errorHandlingMiddleware = require('./middleware/error-handling-middleware')


const app = express();
const PORT = process.env.PORT || 3000;



app.use(express.json());
// app.use(cookieParser());

app.use("/", [userRouter, postRouter])  // 배열은 앞에서부터 순서대로 뒤짐! 많이조회될거같은거를 앞에둠

// 에러관리 미들웨어
app.use(errorHandlingMiddleware);

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});









