package codingon.spring_boot_jpa.controller;

import codingon.spring_boot_jpa.dto.BoardDTO;
import codingon.spring_boot_jpa.entity.Board;
import codingon.spring_boot_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

//    모든 게시판 글을 리스트로 반환
    @GetMapping
    public List<BoardDTO> listBoard() {
        return boardService.getAllPosts();
    }

//    특정 작성자의 게시판 글 반환
    @GetMapping("/{writer}")
    public List<BoardDTO> getPostByWriter(@PathVariable String writer) {
        return boardService.getPostByWriter(writer);
    }

//    새 글 작성하고 작성된 글 정보 반환
    @PostMapping
    public BoardDTO createPost(@RequestBody BoardDTO boardDTO) {
        boardService.createPost(boardDTO);
        return boardDTO;
    }

//    특정 ID의 글 내용을 수정하고 수정된 글을 반환
    @PutMapping("/{id}")
    public BoardDTO updatePost(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {
        boardDTO.builder().id(id);
        boardService.updatePost(id, boardDTO);
        return boardDTO;
    }

//    특정 ID의 글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        boardService.deletePost(id);
    }
}
