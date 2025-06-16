// 서비스 = 요청에 대한 처리 파일
// 처리 흐름, 트랜잭션
const PostRepository = require('../repositories/post.repository') // 레포지토리 갖고옴(다음 플로우를 불러옴)

class PostService { // 클래스(빵틀)

  // 1. 게시글 생성(로그인 된 사람만 가능)
  async createPost(title,content,userId) {
    return await PostRepository.createPost(title,content,userId); // 결과만 반환(res는 컨트롤러가 처리하도록)
  }

  // 2. 전체 게시글 조회(누구나 조회 가능/작성자 정보도 같이 보냄join)
  async getAllPosts(){
    return await PostRepository.getAllPosts(); // 결과만 반환(res는 컨트롤러가 처리하도록)
  }

  // 3. 특정 게시글 조회(누구나 조회 가능)
  async getPostByPostId(postId){
    return await PostRepository.getPostByPostId(postId); // 결과만 반환(res는 컨트롤러가 처리하도록)
  }

  // 4. 게시글 수정(작성자만 가능)
  async updatePost(postId,title, content){
    return await PostRepository.updatePost(postId,title, content); // 결과만 반환(res는 컨트롤러가 처리하도록)
  }

  // 5. 게시글 삭제(작성자만 가능)
  async deletePost(postId){
    return await PostRepository.deletePost(postId);
  }
}

module.exports = new PostService(); // 새 인스턴스(빵) 생성해 사용할 수 있게 내보냄