package com.douzone.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.web.Action;
import com.douzone.web.util.MvcUtils;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session =request.getSession();
	 if(session !=null) {
		 /*로그아웃*/
		 session.removeAttribute("authUesr");
		 session.invalidate();
	 
	}

	 MvcUtils.redirect(request.getContextPath(), request, response);
 }
}