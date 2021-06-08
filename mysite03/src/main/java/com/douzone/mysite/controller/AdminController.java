package com.douzone.mysite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.exception.GlobalExceptionHandler;
import com.douzone.mysite.security.Auth;
import com.douzone.mysite.vo.SiteVo;
@Auth(role ="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	  private static final Log LOGGER =LogFactory.getLog(GlobalExceptionHandler.class);
   @RequestMapping("")	
	 public String main() {
	   
	  return "admin/main";
 }
   
   @RequestMapping(value="/main/update",method=RequestMethod.POST)	
	 public String updteMain(SiteVo vo) {
	   
	  return "redirect:/admin";
}
   
   @RequestMapping("/guestbook")	
	 public String guestbook() {
	   
	  return "admin/guestbook";
}
   
   @RequestMapping("/boa")	
	 public String board() {
	   
	  return "admin/board";
}
   @RequestMapping("/board")	
	 public String user() {
	   
	  return "admin/user";
}
   
}
  