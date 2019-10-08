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
	
	@RequestMapping("list")
	public Model process(Model model, @RequestParam("page")int page) {
		
		ArrayList<BoardDto> list = boardDaoInter.getList();
		
		model.addAttribute("data", list);
		model.addAttribute("page", page);
		
		return model;
	}
}