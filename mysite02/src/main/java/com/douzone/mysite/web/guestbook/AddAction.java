package com.douzone.mysite.web.guestbook;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.repository.GuestbookRepository;
import com.douzone.mysite.vo.GuestbookVo;
import com.douzone.web.Action;
import com.douzone.web.util.MvcUtils;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Message = request.getParameter("message");
		
	
		GuestbookVo vo = new GuestbookVo();
		vo.setName(Name);
		vo.setPassword(Password);
		vo.setMessage(Message);
		
	      new GuestbookRepository().insert(vo);
	      MvcUtils.redirect(request.getContextPath() + "/guestbook", request, response);

	}

}
