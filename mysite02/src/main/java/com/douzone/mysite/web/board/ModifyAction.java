package com.douzone.mysite.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.Action;
import com.douzone.web.util.MvcUtils;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession(true);
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return;
		}
		    String no = request.getParameter("no");
		    String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardVo vo =new BoardRepository().findByNo(Long.parseLong(no));
			
		
			vo.setTitle(title);
			vo.setContents(content);
			
			
		new BoardRepository().updateBoard(title, content, vo.getNo());
			
			
			
			MvcUtils.redirect(request.getContextPath()+"/board", request, response);
	}
	}


