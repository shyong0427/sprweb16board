package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class ReplyController {
	@Autowired
	private BoardDaoInter boardDaoInter;
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView replyProcess(@RequestParam("num") String num, @RequestParam("page") String page) {
		ModelAndView modelAndView = new ModelAndView("reply", "data", boardDaoInter.getDetail(num));
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String replySubmit(BoardBean bean, @RequestParam("page") String page) {
		bean.setOnum(bean.getOnum() + 1); // onum 갱신
		boardDaoInter.updateOnum(bean);
		
		// 저장
		bean.setBdate();
		bean.setNum(boardDaoInter.currentNum() + 1); // 새 글 번호
		bean.setNested(bean.getNested() + 1); // 들여쓰기
		
		if(boardDaoInter.insertReply(bean)) return "redirect:/list?page=" + page;
		else return "redirect:/error";
	}
}