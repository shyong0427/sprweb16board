package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WriteController {
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeProcess() {
		
		return "redirect:/list?page=1"; // 추가 후 목록보기
	}
}