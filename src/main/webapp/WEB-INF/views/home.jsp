<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<%-- <h1>${sessionScope.principal.getUsername()}</h1> 요건 처음에 우리가하던 로그인시 메인에 이름뜨게했던 작업 --%>

<div class="container">
	<c:forEach begin="0" end="2">
		<%-- 4번줄 라이브러리 추가를 통해 for문이 사용가능해지면서 for문으로 늘리기--%>

		<!-- 카드 글 시작 -->
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Title 부분입니다.</h4>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>

		<br />
		<!-- 카드 글 끝 -->

	</c:forEach>
	<div class="d-flex justify-content-center">
		<ul class="pagination">      <%--  <ul class="pagination justify-content-center"> div로 안감싸고 이런식으로 해도 디자인들어감 --%>
			<li class="page-item disabled"><a class="page-link" href="#">Prev</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>

</div>




<%@ include file="layout/footer.jsp"%>