<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 response.sendRedirect("/board?page=0"); 
//request.getRequestDispatcher("/board?page=0").forward(request, response);
//아래의 것은 ?page=0이거 안보이게 해주기위해서 하는 코딩
%>
<!-- 그냥 슬러쉬 찍으면 list페이지로 보내기위해서 리다이렉션 해서 보내주게 됬다.  -->