package com.douzone.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.GuestbookService;
import com.douzone.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@RequestMapping("")
	public String index() {
	//List GusetbookVo vo = new 
		return "/guestbook/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookService.add(vo);
		return "redirect:/guestbook";
	}
//	@ExceptionHandler(Exception.class)
//    public String handlerEception() {
//	//1.logging
//	return "error/exception";//2. 사과 페이지...
//  }

}

