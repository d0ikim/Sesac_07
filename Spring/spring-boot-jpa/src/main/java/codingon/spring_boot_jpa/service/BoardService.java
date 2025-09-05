package codingon.spring_boot_jpa.service;

import codingon.spring_boot_jpa.dto.BoardDTO;
import codingon.spring_boot_jpa.entity.Board;
import codingon.spring_boot_jpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

//    모든 게시판 글(DB로 부터 읽어온 entity.Board 리스트)을 BoardDTO로 변환
    public List<BoardDTO> getAllPosts() {
//        1. Repository 게층에서 모든 entity.Board 객체 가져옴
        List<Board> board = boardRepository.findAll();
//        2. 새로운 DTO 객체 리스트 생성
        List<BoardDTO> boardDTOs = new ArrayList<>();
//        3. 반복문을 이용해 각 Board 객체를 boardDTO로 변환하고 리스트에 추가
        for(Board post: board) {
            BoardDTO boardDTO = convertToDTO(post);
            boardDTOs.add(boardDTO);
        }
        return boardDTOs;
    }

//    특정 작성자의 게시판 글 반환
    public List<BoardDTO> getPostByWriter(String writer) {
        List<Board> board = boardRepository.findAllByWriter(writer);
        List<BoardDTO> boardDTOs = new ArrayList<>();
        for (Board post: board) {
            boardDTOs.add(convertToDTO(post));
        }
        return boardDTOs;
    }

//    새 글 작성하고 작성된 글 정보 반환
    public BoardDTO createPost(BoardDTO boardDTO) {
        Board post = convertToEntity(boardDTO);

        boardRepository.save(post);
        return boardDTO;
    }

//    특정 ID의 글 내용을 수정하고 수정된 글을 반환
    public BoardDTO updatePost(Long id, BoardDTO boardDTO) {
        Board post = convertToEntityWithId(id, boardDTO);
        boardRepository.save(post);

        return convertToDTO(post);
    }

//    특정 ID의 글 삭제
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

//    entity to dto
    private BoardDTO convertToDTO(Board board) {
//        builder 패턴을 이용해 DTO 객체 생성
        return BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
    }

//    dto to entity
    private Board convertToEntity(BoardDTO dto) {
        return Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

//    dto to entity with id
    private Board convertToEntityWithId(Long id, BoardDTO dto) {
        return Board.builder()
                .id(id)
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }
}