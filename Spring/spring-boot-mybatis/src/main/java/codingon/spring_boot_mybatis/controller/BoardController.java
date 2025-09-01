package codingon.spring_boot_mybatis.controller;

import codingon.spring_boot_mybatis.dto.BoardDTO;
import codingon.spring_boot_mybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired  // 컨트롤러계층은 서비스게층을 사용
    private BoardService boardService;

//    모든 게시판 글을 리스트로 반환
    @GetMapping
    public List<BoardDTO> listBoard() {
        return boardService.getAllPosts();
    }

//    GET /api/board/:writer : 특정 작성자의 게시판 글 반환
    @GetMapping("/{writer}")
    public BoardDTO getPost(@PathVariable String writer) {
        return boardService.getPostByWriter(writer);
    }

//    POST /api/board : 새 글 작성하고 작성된 글 정보 반환
    @PostMapping
    public BoardDTO createPost(@RequestBody BoardDTO boardDTO) {
        boardService.createPost(boardDTO);
        return boardDTO;
    }

//    PUT /api/board/:id : 특정 ID의 글 내용을 수정하고 수정된 글을 반환
    @PutMapping("/{id}")
    public BoardDTO updatePost(@PathVariable int id, @RequestBody BoardDTO boardDTO) {
        boardDTO.setId(id);
        boardService.updatePost(boardDTO);
        return boardDTO;
    }

}
