// [역할] 게시글(Post)와 관련된 작업을 하는 API 라우터
// : 'Posts' 테이블을 건드리는 파일임
// [연결] app.js에서 '/posts' 경로에 등록되어 동작함
const express = require("express");
const router = express.Router();
const prisma = require('../utils/prisma/index') // 내보낸 prisma라는 유저(?)객체 가져옴
const authenticateToken = require('../middleware/authenticate-middleware')
const { createPostValidator, getPostValidator, updatePostValidator, handleValidationResult} = require('../middleware/validation-result-handler')  // 유효성검사기
const {checkPostOwner} = require('../middleware/authorization-middleware')  // 인가

const PostController = require('../controllers/post.controller')  // 컨트롤러 갖고옴(다음 플로우를 불러옴)


// 1. 게시글 생성(로그인 된 사람만 가능)
router.post('/posts',
  authenticateToken,
  createPostValidator,
  handleValidationResult,
  PostController.createPost)

// 2. 전체 게시글 조회(누구나 조회 가능/작성자 정보도 같이 보냄join)
router.get('/posts',
  PostController.getAllPosts)

// 3. 특정 게시글 조회(누구나 조회 가능)
router.get('/posts/:postId',
  getPostValidator,
  handleValidationResult,
  PostController.getPostByPostId
)

// 4. 게시글 수정(작성자만 가능)
router.put('/posts/:postId',
  authenticateToken,  // 작성자만 가능하기때문에
  updatePostValidator,
  handleValidationResult,
  checkPostOwner, // 인가
  PostController.updatePost
)

// 5. 게시글 삭제(작성자만 가능)
router.delete('/posts/:postId',
  authenticateToken,
  getPostValidator,
  handleValidationResult,
  PostController.deletePost
)

module.exports = router;