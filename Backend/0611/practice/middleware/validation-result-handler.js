// 유효성 검사 핸들러 파일
const { body, param, validationResult } = require('express-validator')

// 회원가입 검사기
exports.signUpValidator = [
  body('email')
    .isEmail().withMessage('이메일형식이 아닙니다')
    .notEmpty().withMessage('이메일이 없습니다.'),
  body('password')
    .isLength({ min: 6 }).withMessage('비밀번호가 6자 이하')
    .notEmpty().withMessage('패스워드드이 없습니다.'),
  body('nickname')
    .notEmpty().withMessage('패스워드드이 없습니다.'),
];

// 로그인 입력 검사기
exports.loginValidator = [
  body('email')
    .isEmail().withMessage('이메일형식이 아닙니다')
    .notEmpty().withMessage('이메일이 없습니다.'),
  body('password')
    .isLength({ min: 6 }).withMessage('비밀번호가 6자 이하')
    .notEmpty().withMessage('패스워드드이 없습니다.'),
]

// 1. 게시글 작성 검사기
exports.createPostValidator = [
  body('title')
    .notEmpty().withMessage('타이틀이 없습니다.'),
  body('content')
    .notEmpty().withMessage('컨텐츠가 없습니다.'),
]

// 3. 특정 게시글 조회, 삭제 검사기
exports.getPostValidator = [
  param('postId')
    .isInt().withMessage('postId가 숫자여야함')
    .notEmpty().withMessage('postId가 필요합니다.'),
]

// 4. 게시글 수정 검사기
exports.updatePostValidator = [
  param('postId')
    .isInt().withMessage('postId가 숫자여야함')
    .notEmpty().withMessage('postId가 필요합니다.'),
  body('title')
    .notEmpty().withMessage('타이틀이 없습니다.'),
  body('content')
    .notEmpty().withMessage('컨텐츠가 없습니다.'),
]


exports.handleValidationResult = (req, res, next) => {
  const result = validationResult(req).errors;
  if (result.length !== 0) {
    // 입력 오류가 있는 경우
    const extracteError = result.map(err => err.msg)
    // console.log(extracteError)
    return next(new Error("InputValidation"));
  }
  next();
}