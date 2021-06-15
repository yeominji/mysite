package com.douzone.mysite.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.security.AuthUser;
import com.douzone.mysite.service.BoardService;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<BoardVo> vo = boardService.findAll();
		model.addAttribute("vo", vo);
		return "board/index";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}

	@Auth
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(@AuthUser UserVo authUser, String title, String contents) {
		BoardVo vo = new BoardVo();
		vo.setUserNo(authUser.getNo());
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setDepth(0);
		vo.setHit(0);
		vo.setOrderNo(0);
		int no =boardService.findgroupNo();
		vo.setGroupNo(no+1);
		vo.setUserName(authUser.getName());
		System.out.println(vo.toString());
		
		boardService.write(vo);
		return "redirect:/board";
	}

	@RequestMapping(value="/reply/{no}", method =RequestMethod .GET)
	public String reply(@PathVariable(value="no") String no, Model model) {
		BoardVo vo = boardService.findByNo(Long.parseLong(no));
		model.addAttribute("vo", vo);
		return "/board/reply";
	}
	
	@RequestMapping(value="/reply/{no}", method=RequestMethod.POST)
	public String reply(@PathVariable(value="no")String no, BoardVo vo, @AuthUser UserVo authUser  ) {
		//BoardVo vo =boardService
		System.out.println(vo.toString());
		boardService.insertreply(no,vo,authUser);
		return "redirect:/board";
	}
	
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable(value="no") String no, Model model, @AuthUser UserVo authUser) {
		BoardVo vo = boardService.findByNo(Long.parseLong(no));
		boardService.updatehit(vo);
		model.addAttribute("vo", vo);
		model.addAttribute("authUser", authUser);
		
		return "board/view";
	}
	
	@Auth
	@RequestMapping(value="modify/{no}", method = RequestMethod.GET)
	public String modify(@PathVariable(value="no") String no, Model model, @AuthUser UserVo authUser) {
		BoardVo vo = boardService.findByNo(Long.parseLong(no));
		if (vo.getUserNo() != authUser.getNo()) {
			return "redirect:/board";
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("authUser", authUser);
		return "board/modify";
	}
	
	@Auth
	@RequestMapping(value="modify/{no}", method = RequestMethod.POST)
	public String modify(@PathVariable(value="no") String no, HttpServletRequest request, @AuthUser UserVo authUser, Model model) {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		model.addAttribute("authUser", authUser);
	
		BoardVo vo = boardService.findByNo(Long.parseLong(no));
		if (vo.getUserNo() != authUser.getNo()) {
			return "redirect:/board";
		}
		
		vo.setTitle(title);
		vo.setContents(contents);
		
		boardService.update(vo);
		return "redirect:/board";
	}
	@Auth
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable(value="no") String no) {
		boardService.delete(Long.parseLong(no));
		return "redirect:/board";
	}
}