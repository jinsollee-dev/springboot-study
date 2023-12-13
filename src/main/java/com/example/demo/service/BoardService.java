package com.example.demo.service;

import com.example.demo.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();

    int register(BoardDTO dto);

    BoardDTO getBoard(int bno);

    int modify(BoardDTO dto);

    int remove(int bno);


}
