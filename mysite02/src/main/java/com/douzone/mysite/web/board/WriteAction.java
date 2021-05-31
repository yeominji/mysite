package com.douzone.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.Action;
import com.douzone.web.util.MvcUtils;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String Title = request.getParameter("title");
		String Contents = request.getParameter("contents");
	
	
		BoardVo vo = new BoardVo();
		vo.setTitle(Title);
		vo.setContents(Contents);
		
		
	      new BoardRepository().insert(vo);
		
		
		MvcUtils.forward("board/write", request, response);

	}

}
