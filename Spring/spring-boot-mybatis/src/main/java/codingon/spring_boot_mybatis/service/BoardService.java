package codingon.spring_boot_mybatis.service;

import codingon.spring_boot_mybatis.domain.Board;
import codingon.spring_boot_mybatis.dto.BoardDTO;
import codingon.spring_boot_mybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired  // 서비스가 매퍼를 사용하기에 매퍼인터페이스의 구현체를 자동 주입받음
    private BoardMapper boardMapper;

//    모든 게시판 글(DB로 부터 읽어온 domain.Board 리스트)을 BoardDTO로 반환
    public List<BoardDTO> getAllPosts() {
//        1) 모든 domain.Board 객체 가져옴
        List<Board> board = boardMapper.findAll();
//        2) 새로운 DTO 객체 생성 (이걸 반환하게 될거임)
        List<BoardDTO> boardDTOs = new ArrayList<>();
//        3) 반복문을 이용해 각 board 객체를 boardDTO로 변환하고 리스트에 추가
        for (Board post: board) {
            BoardDTO boardDTO = convertToDto(post);
            boardDTOs.add(boardDTO);
        }
//        4) BoardDTOs 리스트 반환
        return boardDTOs;
    }

//    특정 작성자의 게시판 글을 BoardDTO로 변환
    public BoardDTO getPostByWriter(String writer) {
        Board board = boardMapper.findByWriter(writer);

        return convertToDto(board);
    }

//    새 글 작성
    public void createPost(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);    // dto -> domain
        boardMapper.insert(board);  // domain을 기반으로 mapper한테 insert 요청

    }

//    domain to dto
    private BoardDTO convertToDto(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setId(board.getId());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());

        return dto;
    }

//    dto to domain
    private Board convertToEntity(BoardDTO dto) {
        Board board = new Board();
        board.setId(dto.getId());
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());

        return board;
    }
}
