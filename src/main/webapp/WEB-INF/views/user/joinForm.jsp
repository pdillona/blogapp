<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- 서블릿에서 jsp가 html로 바뀌는 과정에서 실행시 헤더가  포함이 된다.  -->

<div class="container">
	<!-- 컨테이너는가운데 정렬되면서 전체의 80%를 차지한다. -->
	<form action="/join"  method="post">
		<div class="form-group">
			<input type="text"  name= "username" class="form-control" placeholder="Enter username" required="required">
		</div>
		<div class="form-group">
			<input type="password" name= "password" class="form-control" placeholder="Enter password" required="required">
		</div>
		<div class="form-group">
			<input type="email" name= "email" class="form-control" placeholder="Enter email" required="required">
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>