package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class DeleteController {
	@Autowired
	private BoardDaoInter boardDaoInter;
	
	@RequestMapping("delete")
	public String deleteProcess(@RequestParam("num") String num, @RequestParam("page") String page) {
		if(boardDaoInter.delete(num)) return "redirect:/list?page" + page;
		else return "redirect:/error";
	}
}