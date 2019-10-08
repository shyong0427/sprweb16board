package pack.model;

import java.util.ArrayList;

import pack.controller.BoardBean;

public interface BoardDaoInter {
	ArrayList<BoardDto> getList();
	
	boolean insert(BoardBean bean);
	int currentNum();
}