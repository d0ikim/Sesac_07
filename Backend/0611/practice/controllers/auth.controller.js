// 컨트롤러 = 요청과 응답을 담당(자기책임) 파일
// HTTP 요청/응답 처리
// 요청에 대한 처리는 서비스에게 위임!
const AuthService = require('../services/auth.service') // 서비스 갖고옴


class AuthController {  // 클래스(빵틀)
  async signUp(req,res,next) {
    //  인증, 인가, validation 등 체크
    const { email, password, nickname } = req.body;

    const newUser = await AuthService.signUp(email, password, nickname);

    return res.status(201).json({
      message: '회원가입이 성공적으로 완료',
      newUser
    }) 
  }

  async login(req,res,next){
    const { email, password } = req.body;
    const token = await AuthService.login(email,password);
    
    return res.status(200).send(token)
  }
      
}

module.exports = new AuthController();  // 새 인스턴스(빵) 생성해 사용할 수 있게 내보냄