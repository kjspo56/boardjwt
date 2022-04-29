package com.ted.board.controller;

import com.ted.board.dto.BoardDto;
import com.ted.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    //게시글 리스트화면
    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList", boardDtoList);
        return "board/list.html";
    }

    //게시글 작성화면
    @GetMapping("/post")
    public String post(){
        return "board/post.html";
    }

    //게시글 작성처리
    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    //게시글 세부내용
    @GetMapping("/post/{idn}")
    public String read(@PathVariable("idn") Long idn, Model model){
        BoardDto boardDto = boardService.getPost(idn);
        model.addAttribute("post", boardDto);
        return "board/read.html";
    }

    //게시글 수정
    @GetMapping("/post/modify/{idn}")
    public String modify(@PathVariable("idn") Long idn, Model model){
        BoardDto boardDto = boardService.getPost(idn);
        model.addAttribute("post", boardDto);
        return "board/modify.html";
    }

    //게시글 수정처리
    @PutMapping("/post/modify/{idn}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    //게시글 삭제처리
    @DeleteMapping("/post/{idn}")
    public String delete(@PathVariable("idn") Long idn){
        boardService.deletePost(idn);
        return "redirect:/";
    }
}
