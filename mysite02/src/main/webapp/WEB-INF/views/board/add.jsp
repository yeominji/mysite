<%@page import="com.douzone.mysite.repository.BoardRepository"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.douzone.mysite.vo.BoardVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String Title = request.getParameter("title");
	String Contents = request.getParameter("contents");
	

	BoardVo vo = new BoardVo();
	
	vo.setTitle(Title);
	vo.setContents(Contents);

	vo.setRegDate(LocalDateTime.now().toString());
	
      new BoardRepository().insert(vo);
	response.sendRedirect(request.getContextPath());
%>