// 컨트롤러 = 요청과 응답을 담당(자기책임) 파일
// HTTP 요청/응답 처리
// 요청에 대한 처리는 서비스에게 위임!
const PostService = require('../services/post.service') // 서비스 갖고옴(다음 플로우를 불러옴)

class PostController {  // 클래스(빵틀)

  // 1. 게시글 생성(로그인 된 사람만 가능)
  async createPost(req,res,next) {
    try {
      const { title, content } = req.body; // req.body에서 게시글의 제목, 내용, 작성자 ID를 받아옴
      const userId = req.user;

      const newPost = await PostService.createPost(title,content,userId);

      return res.status(201).send({
        msg: "게시글이 등록되었습니다.",
        data: newPost
      }); // 생성된 게시글 정보 반환
    } catch(e) {
      next(new Error(e));
    }
  }

  // 2. 전체 게시글 조회(누구나 조회 가능/작성자 정보도 같이 보냄join)
  async getAllPosts(req,res,next){
    try{
      const posts = await PostService.getAllPosts();

      return res.send({
      data: posts
      }); // DB에서 모든 게시글 출력
    } catch(e){
      next(new Error(e))
    }
  }

  // 3. 특정 게시글 조회(누구나 조회 가능)
  async getPostByPostId(req,res,next){
    try{
      const {postId} = req.params;

      const post = await PostService.getPostByPostId(postId);

      return res.status(200).json({data: post});
    } catch(e){
      next(new Error(e))
    }
  }

  // 4. 게시글 수정(작성자만 가능)
  async updatePost(req,res,next){
    try{
      const { postId } = req.params;
      const { title, content } = req.body; // req.body에서 수정할 정보인 title, content를 받아옴

      const updatePost = await PostService.updatePost(postId,title, content);

      return res.status(200).json({
        message: "게시글이 수정되었습니다.",
        data: updatePost
      });
    }catch(e){
      next(new Error(e))
    }
  }

  // 5. 게시글 삭제(작성자만 가능)
  async deletePost(req,res,next){
    try{
      const { postId }= req.params;

      const deleted = await PostService.deletePost(postId);

      console.log(deleted);

      if(deleted){
        return res.status(200).json({
          message: "게시글이 삭제되었습니다."
        });
      }

      // 의도된 에러: 비즈니스 로직 에러
      return next(new Error("NotFoundDeletedPost"));  // 삭제될 게시글을 찾지 못한 경우
    }catch(e){
      console.log("삭제 중 시스템 에러:", e);
      return next(e); //Express에게 “에러가 났으니, 에러 핸들러 미들웨어로 넘어가라”고 알려줌
    }
  }
}

module.exports = new PostController();  // 새 인스턴스(빵) 생성해 사용할 수 있게 내보냄