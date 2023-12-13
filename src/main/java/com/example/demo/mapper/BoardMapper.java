package com.example.demo.mapper;

import com.example.demo.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getList();
    int insert(BoardDTO dto);
    BoardDTO getBoard(int bno);
    int update(BoardDTO dto);
    int delete(int bno);

    void visitcountUpdate(int bno);
}
