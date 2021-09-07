<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<!-- 서블릿에서 jsp가 html로 바뀌는 과정에서 헤더가 실행시 포함이 된다.  -->
<!-- 이 헤더와 풋터 사이에 디자인을 넣는다  -->

<div class="container">
	<!-- 컨테이너는가운데 정렬되면서 전체의 80%를 차지한다. -->
	<form action="/login"  method="post">
		<!-- 폼은 한번에 많은 데이터를 전송하기 위해 사용한다.  -->
		<!-- 메서드를 포스트로 보내주고 폼태그는 풋딜리트를 들고있지 않다. -->
		<div class="form-group">
			<input type="text"  name= "username" class="form-control" placeholder="Enter username"  required="required">
		</div>
		<!-- 클래스는 css를 연결하는 디자인 -->
		<div class="form-group">
			<input type="password" name= "password" class="form-control" placeholder="Enter password"  required="required">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
<!-- url의 ?뒤의것을 쿼리스트링이라고 한다. 지배하는 문자열이란의미인데 이는 구체적 
요청이며 디비와 연결되는데 ?뒤는 where절에 해당한다. get으로 전송하면 
username= ~~ password=~~ 하고 일치하는걸 요청하는모습을 볼수 있는 것과 같다
(get요청은 바디데이터(내가 전달하고픈 내용)가없다 (get은 256바이트밖에 못받는다 
영어로는256자 한국어는 3바이트니 85자 즉 상세한 만 가능하다 
구구절요청절있는건 get으로 못쓴다)) sql = 스트럭쳐 쿼리 랭기지 -->
<!-- 로그인만 예외로 post로 사용한다 포스트가 은닉이라는 의미는 옛날 생각이고 정확히는
인서트시에 사용하는것인데 로그인만 좀 가릴려고 예외적으로 사용한다. -->
<!-- SLECT * FROM USER
WHERE USERNAME = "SSAR" AND PASSWORD = "1234" 이걸하는게 원래는 셀렉트문이니
겟인데 예외적으로 POST사용 -->
<!-- 인터넷에서는 데이터를 전송시MIME타입으로 전송한다. -->
<%@ include file="../layout/footer.jsp"%>

</body>
</html>


