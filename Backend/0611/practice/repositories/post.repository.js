// 레포지토리 = DB에 접근하는 파일(Prisma)
const prisma = require('../utils/prisma/index')  // DB 불러옴(다음 플로우를 불러옴)

class PostRepository {  // 클래스(빵틀)

  // 1. 게시글 생성(로그인 된 사람만 가능)
  async createPost(title,content,userId){
    return await prisma.post.create({
      data: {
        title,
        content,
        userId
      }
    });
  }

  // 2. 전체 게시글 조회(누구나 조회 가능/작성자 정보도 같이 보냄join)
  async getAllPosts(){
    return await prisma.post.findMany({
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
    })
  }

  // 3. 특정 게시글 조회(누구나 조회 가능)
  async getPostByPostId(postId){
    return await prisma.post.findUnique({
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
  }

  // 4. 게시글 수정(작성자만 가능)
  async updatePost(postId,title, content){
    return await prisma.post.update({
      where: { postId: +postId },
      data : {
        title,
        content
      }
    })
  }

  // 5. 게시글 삭제(작성자만 가능)
  async deletePost(postId){
    return await prisma.post.delete({
    where : { postId: +postId }
  })
  }
}

module.exports = new PostRepository(); // 새 인스턴스(빵) 생성해 사용할 수 있게 내보냄