const express = require("express");
const userRouter = require("./routers/users.router");
const cookieParser = require("cookie-parser");
const errorHandlingMiddleware = require('./middleware/error-handling-middleware')


const app = express();
const PORT = process.env.PORT || 3000;



app.use(express.json());
// app.use(cookieParser());

app.use("/", [userRouter])

// 에러관리 미들웨어
app.use(errorHandlingMiddleware);

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});









