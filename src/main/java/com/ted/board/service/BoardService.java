package com.ted.board.service;

import com.ted.board.domain.entity.Board;
import com.ted.board.domain.repository.BoardRepository;
import com.ted.board.dto.BoardDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    //게시글 작성처리
    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getIdn();
    }

    //게시글 목록
    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boardList){
            BoardDto boardDto = BoardDto.builder()
                    .idn(board.getIdn())
                    .name(board.getName())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
                    boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    //게시글 세부내용
    //@Transactional의 사용목적, 필요한 경우 ... etc 개념숙지 필요
    public BoardDto getPost(Long idn){
        Board board = boardRepository.findById(idn).get();
        BoardDto boardDto = BoardDto.builder()
                .idn(board.getIdn())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .build();
        return boardDto;
    }

    //게시글 삭제
    @Transactional
    public void deletePost(Long idn){
        boardRepository.deleteById(idn);
    }

    //jwt 테스트

}
