package pack.model;

import java.util.ArrayList;

import pack.controller.BoardBean;

public interface BoardDaoInter {
	ArrayList<BoardDto> getList();
	int totalCnt();
	
	boolean insert(BoardBean bean);
	int currentNum();
	
	ArrayList<BoardDto> getSearch(BoardBean bean);
	
	boolean updateReadCnt(String num);
}