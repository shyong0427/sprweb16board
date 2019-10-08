package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDaoInter;

@Controller
public class WriteController {
	@Autowired
	@Qualifier("boardDaoImpl")
	private BoardDaoInter boardDaoInter;
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeProcess(BoardBean bean) {
		bean.setBdate();
		
		int newNum = boardDaoInter.currentNum() + 1; // 새 글 번호
		
		bean.setNum(newNum);
		bean.setGnum(newNum);
		
		if(boardDaoInter.insert(bean)) return "redirect:/list?page=1"; // 추가 후 목록보기
		else return "redirect:/error";
	}
}