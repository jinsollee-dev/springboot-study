package com.example.demo.controller;


import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("boardList", boardService.getList());

    }

    @GetMapping("/register")
    public void registerGet() {      }


    @PostMapping("/register")
    public String registerPost(BoardDTO dto) {
        int result = boardService.register(dto);
        if (result == 1) {
            return "redirect:/board/list";
        }
        return"redirect:/board/register";
    }


    @GetMapping({"/view","/modify"})
    public void viewGet(@RequestParam("bno") int bno, Model model){
        BoardDTO boardDTO = boardService.getBoard(bno);
        model.addAttribute("board", boardDTO);
    }

    @PostMapping("/modify")
    public String modifyPost(BoardDTO dto){
       int result= boardService.modify(dto);
       if(result==1) {
           return "redirect:/board/view?bno="+dto.getBno();
       }
       return "redirect:/board/modify?bno="+dto.getBno();
    }

    @GetMapping("/remove")
    public String removeGet(@RequestParam("bno") int bno){
        int result= boardService.remove(bno);
        if(result==1){
            return "redirect:/board/list";
        }
        return "redirect:/board/view?bno="+bno;
    }

}
