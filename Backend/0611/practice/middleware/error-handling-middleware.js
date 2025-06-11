module.exports = function (err,req,res,next){
  console.error(err.message)
  switch(err.message){
    case "password" : return res.status(400).send({
      errorMessage : "패스워드가 일치하지 않습니다."
    })
    case "existEmail" : return res.status(400).send({
      errorMessage : "가입된 이메일입니다."
    })
    case "Forbidden" : return res.status(401).send({
      errorMessage : "접근 권한이 없습니다."
    })

    case 'UserNotFound':
    case 'Need login':
    case 'accessTokenNotMatched' :
      return res.status(401).send({
        errorMessage : '로그인을 해주세요!'
      })
  }
}