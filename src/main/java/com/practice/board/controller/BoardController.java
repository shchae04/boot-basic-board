package com.practice.board.controller;

import com.practice.board.entity.Board;
import com.practice.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {

    /** RESTFul
     * /write Post
     * /list Get
     * /update PostAsa92988
     * /delete Post
     * /info/{} Get
     */


    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/write")
   public String BoardWriteForm() {

       return "boardWrite";
   }


   @PostMapping("/write")
   public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception {

       System.out.println("제목 :" + board.getTitle());
       System.out.println("내용 :" + board.getContent());

       model.addAttribute("message","글 작성이 완료되었습니다");
       model.addAttribute("searchUrl","/board/list");
       boardService.write(board,file);
        return "message";
   }

   @GetMapping("/list")
   public String boardList(Model model,
                           @PageableDefault(page = 0,size = 10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                            String searchKeyword){

        Page<Board> list = null;

        if(searchKeyword == null) {
            list = boardService.getList(pageable);
        } else {
            list = boardService.boardSearchList(searchKeyword,pageable);
        }

       int nowPage = list.getPageable().getPageNumber() + 1;
       int startPage = Math.max(nowPage-4,1);
       int endPage = Math.min(nowPage + 5,list.getTotalPages());

        model.addAttribute("list",boardService.getList(pageable));
        model.addAttribute(("nowPage"),nowPage);
        model.addAttribute(("startPage"),startPage);
        model.addAttribute(("endPage"),endPage);
        return "boardList";
   }

   @GetMapping("/view") //localhost:8080/board/view?id=1
    public String boardView(Model model,int id) {

        model.addAttribute("board",boardService.boardView(id));
        return "boardView";
   }

   @GetMapping("/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);

        return "redirect:/board/list";
   }

   @GetMapping("/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,Model model) {

        model.addAttribute("board",boardService.boardView(id));

        return "boardModify";
   }

   @PostMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,Board board, MultipartFile file) throws Exception{

        //기존글
        Board boardTemp = boardService.boardView(id);

        //수정할때 넘어온 데이터
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp,file);

        return "redirect:/board/list";
   }

}
