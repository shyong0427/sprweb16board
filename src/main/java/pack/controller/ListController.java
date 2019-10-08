package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class ListController {
	@Autowired
	@Qualifier("boardDaoImpl")
	private BoardDaoInter boardDaoInter;
	
	private int total; // 전체 레코드 수
	private int pageList = 5; // 페이지 당 행 수
	private int pageNum; // 전체 페이지 수
	
	@RequestMapping("list")
	public Model process(Model model, @RequestParam("page")int page) {
		total = boardDaoInter.totalCnt(); // 전체 페이지 수 얻기
		
		ArrayList<BoardDto> list = boardDaoInter.getList();
		
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		result = getList(list, page);
		
//		model.addAttribute("data", list); // 전체를 jsp로 전송
		model.addAttribute("data", result); // 부분을 jsp로 전송
		model.addAttribute("page", page);
		model.addAttribute("pageNum", getPageNum());
		
		return model;
	}
	
	public int getPageNum() { // 총 페이지 수 
		pageNum = total / pageList;
		
		if(total % pageList > 0) pageNum += 1; // 자투리 페이지 계산
		return pageNum;
	}
	
	public ArrayList<BoardDto> getList(ArrayList<BoardDto> list, int page) {
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		
		int start = (page - 1) * pageList;  // 0, 5, 10, ... 의 start value를 갖는다.
		int size = pageList <= list.size() - start ? pageList : list.size() - start; 
	
		System.out.println("start : " + start + ", size : " + size);
		
		for(int i = 0; i < size; i++) {
			result.add(i, list.get(start + i));
		}
				
		return result;
	}
}