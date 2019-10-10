package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class DetailController {
	@Autowired
	private BoardDaoInter boardDaoInter;

	@RequestMapping("datail")
	public Model detailProcess(Model model, @RequestParam("num") String num, @RequestParam("page") String page) {
		// 조회 수 증가
		boardDaoInter.updateReadCnt(num);

		// 해당 레코드 읽기
		return model;
	}
}