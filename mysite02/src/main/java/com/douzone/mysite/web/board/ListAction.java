package com.douzone.mysite.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.repository.GuestbookRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.GuestbookVo;
import com.douzone.web.Action;
import com.douzone.web.util.MvcUtils;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//totalPage=ceil(10/4)
		//firstPageNo=
		//lastPageNo=
		//nextPageNo =
		//prevPageNo=
		//currentPageNo=
		// a 링크 빼기
	List<BoardVo> list = new BoardRepository().findAll();
		
		request.setAttribute("vo", list);
		MvcUtils.forward("board/list", request, response);
	
	}

}