package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class EditController {
	@Autowired
	private BoardDaoInter boardDaoInter;
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView editProcess(@RequestParam("num") String num, @RequestParam("page") String page) {
		ModelAndView modelAndView = new ModelAndView("edit", "data", boardDaoInter.getDetail(num));
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}
}