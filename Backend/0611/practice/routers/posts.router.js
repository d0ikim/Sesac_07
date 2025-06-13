// [역할] 게시글(Post)와 관련된 작업을 하는 API 라우터
// : 'Posts' 테이블을 건드리는 파일임
// [연결] app.js에서 '/posts' 경로에 등록되어 동작함
const express = require("express");
const router = express.Router();
const prisma = require('../utils/prisma/index') // 내보낸 prisma라는 유저(?)객체 가져옴
const authenticateToken = require('../middleware/authenticate-middleware')


// 1. 게시글 생성(로그인 된 사람만 가능)
router.post('/posts',authenticateToken, async (req, res, next) => {
  const { title, content } = req.body; // req.body에서 게시글의 제목, 내용, 작성자 ID를 받아옴
  const userId = req.user;
  const newPost = await prisma.post.create({
    data: {
      title,
      content,
      userId,
    },
  });
  console.log(newPost); // 잘 생성되었는지 확인
  return res.status(201).send({
    msg: "게시글이 등록되었습니다.",
    data: newPost
  }); // 생성된 게시글 정보 반환
});


// 2. 전체 게시글 조회(누구나 조회 가능/작성자 정보도 같이 보냄join)
router.get('/posts', async (req, res, next) => {
  const posts = await prisma.post.findMany({
    include : { // join 연산
      User: {
        select: {
          userId: true,
          nickname: true
        }
      }
    },
    orderBy : {
      createdAt : "desc"
    }
  });
  console.log(posts); // 잘 가져왔는지 확인
  return res.send({
    data: posts
  }); // DB에서 모든 게시글 출력
});


// 3. 특정 게시글 조회(누구나 조회 가능)
router.get('/posts/:postId', async (req, res, next) => {
  const {postId} = req.params;
  const post = await prisma.post.findUnique({
    where : { postId : +postId },
      include : { // join 연산
        User: {
          select: {
            userId: true,
            nickname: true
          }
        }
    },
  })
  return res.status(200).json({data: post});
});


// 4. 게시글 수정(작성자만 가능)
router.put('/posts/:postId', async (req, res, next) => {
  const { postId }= req.params;
  const { title, content } = req.body; // req.body에서 수정할 정보인 title, content를 받아옴

  const updatePost = await prisma.post.update({
    where: { postId: +postId },
    data : {
      title,
      content
    }
  })
  return res.status(200).json({
    message: "게시글이 수정되었습니다.",
    data: updatePost
  });
});


// 5. 게시글 삭제(작성자만 가능)
router.delete('/posts/:postId', async (req,res,next) => {
  const { postId }= req.params;
  await prisma.post.delete({
    where : { postId: +postId }
  })
  return res.status(200).json({
    message: "게시글이 삭제되었습니다."
  });
})

module.exports = router;