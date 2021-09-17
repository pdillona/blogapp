<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- 서블릿에서 jsp가 html로 바뀌는 과정에서 실행시 헤더가  포함이 된다.  -->

<div class="container">
	<!-- 컨테이너는가운데 정렬되면서 전체의 80%를 차지한다. -->
	<form>
		<div class="form-group">
			<input type="text"  value="${sessionScope.principal.username}"  class="form-control" placeholder="Enter username" required="required"  maxlength="20" readonly="readonly">
		</div>
		<div class="form-group">
			<input type="password"  value="${sessionScope.principal.password}"  class="form-control" placeholder="Enter password" required="required"  maxlength="20">
		</div>
		<div class="form-group">
			<input type="email"  value="${sessionScope.principal.email}" class="form-control" placeholder="Enter email" >
		</div>
		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>