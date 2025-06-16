const express = require("express");
const router = express.Router();
const authenticateToken = require('../middleware/authenticate-middleware')

const { signUpValidator,loginValidator,handleValidationResult } = require('../middleware/validation-result-handler')
const AuthController = require('../controllers/auth.controller')  // 컨트롤러 가져옴


/** 회원가입 API
 * 1. 이메일, 비밀번호, 닉네임 입력이 정확하게 왔는지 검증(signUpValidator)
 * 2. 비밀번호 6글자 이상 검증(signUpValidator)
 * 3. 이메일이 중복이 있는지 확인(signUpValidator)
 * 4. 데이터베이스에 저장(AuthController.signUp)
 */
router.post('/sign-up', signUpValidator, handleValidationResult, AuthController.signUp)


/** 로그인 API
 * 1. 이메일, 비밀번호 입력 여부 확인(loginValidator)
 * 2. 이메일에 해당하는 사용자 찾기(AuthRepository.login)
 * 3. 사용자 존재 여부(AuthService.login)
 * 4. 비밀번호 일치 여부 확인(AuthService.login)
 * 5. JWT 토큰 발급(AuthService.signUp)
 * 6. 생성된 데이터를 전달(AuthController.login)
 */
router.post('/login',
  loginValidator,
  handleValidationResult,
  AuthController.login
)

router.get("/user",authenticateToken, (req,res,next)=>{
  // 토큰 검증을 하면 되겠죠?
  // next(new Error("Forbidden"))
  console.log(req.user);
})

module.exports = router;