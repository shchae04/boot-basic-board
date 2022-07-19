package com.practice.board.service;

import com.practice.board.entity.Board;
import com.practice.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //글 작성
    public void write(Board board, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/"+fileName);

        boardRepository.save(board);
        boardRepository.findById(3);
    };

    //게시글 리스트 처리
    public Page<Board> getList(Pageable pageable){

        return boardRepository.findAll(pageable);

    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    // 삭제
    public void boardDelete(Integer id){
      boardRepository.deleteById(id);
    };

    public Page<Board> boardSearchList(String keyword,Pageable pageable){

        return boardRepository.findByTitleContaining(keyword,pageable);

    }
}
