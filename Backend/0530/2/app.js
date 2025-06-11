const express = require('express');
const app = express();
const PORT = 3001;

app.use(express.json());  // JSON 요청 바디를 파싱하는 미들웨어 등록(꼭 제일 위에)

const users = [1,2,3,4,5];
const posts = [
	{
		"id": 1,
		"userId": 2,
		"title": "첫 번째 글",
		"content": "안녕하세요 게시판입니다.",
		"createdAt": "2025-05-29T10:00:00Z"
	},
	{
    "id": 2,
    "userId": 1,
    "title": "두 번째 글",
    "content": "Express 연습 중입니다.",
    "createdAt": "2024-05-29T12:00:00Z"
  }
];

// 특정 사용자의 게시글 조회

// 특정 게시글 조회
app.get('/posts/:id', (req,res)=>{
  const id = Number(req.params.id);
  const post = posts.find(post=>post.id === id);

  if (post) {
    res.send(post);
  } else res.send("일치하는 id의 게시글이 없습니다.")
})


// 사용자 전체 조회
app.get('/users', (req,res)=>{
  const result = [];
  for (let i=0; i<users.length; i++) {
    result.push({id:users[i]});
  }

  res.send(result); // 얘는 한번만 써야됨
})

// 사용자 등록
app.post('/users', (req,res)=>{
  const { id } = req.body;
  if (users.includes(id)) {
    res.send({"error": "이미 존재하는 사용자입니다."})
    return;
  }

  users.push(id);
  res.send({ id });
})

// 사용자 상세 조회
app.get('/users/:id', (req,res)=>{
  const id  = Number(req.params.id);
  console.log(id);  // 터미널에 경로에 요청 들어온거 확인

  if (users.includes(id)) {
    res.send({"id": `${id}`})
    return;
  } else res.send({"error": "해당 사용자를 찾을 수 없습니다."});

})

// 사용자 삭제
app.delete('/users/:id', (req,res)=>{
  const id = Number(req.params.id);

  if (users.includes(id)) {
    console.log(users)

    for(let i=0; i<users.length; i++) {
      if (users[i] === id) {
        users.splice(i,1);  // [i]부터 1개 삭제해라
      }
    }
    res.send({"message": "사용자가 삭제되었습니다."});
    return;
  } else res.send({"error": "해당 사용자를 찾을 수 없습니다."});
})

// 전체 게시글 조회
app.get('/posts', (req,res)=>{
  res.send(posts);
})



app.listen(PORT, ()=>{
  console.log(`http://localhost:${PORT}`)
})