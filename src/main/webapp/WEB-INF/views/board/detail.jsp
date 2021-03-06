<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
      <a href="#" class="btn btn-warning">수정</a>
		<button class="btn btn-danger" onclick="deleteById(${boardEntity.id})">삭제</button>

		<script>
		
			async function deleteById(id){
				// 1. 비동기 함수 호출 -> 비동기를 잘처리하는 방법??????
				let response = await fetch("http://localhost:8080/board/"+id, {
					method: "delete"
				}); // 약속 - 어음 (10초)
				
				// 2.코드
				let parseResponse = await response.text();
				console.log(parseResponse);
				
				alert("삭제 성공");
				location.href="/";
				// 3.코드
			}
			
			
		</script>
      
   <br /><br />
   <div>
      글 번호 : ${boardEntity.id }</span> 작성자 : <span><i>${boardEntity.user.username} </i></span>
   </div>
   <br />
   <div>
      <h3>${boardEntity.title }</h3>
   </div>
   <hr />
   <div>
      <div>${boardEntity.content }</div>
   </div>
   <hr />

   <div class="card">
      <form>
         <div class="card-body">
            <textarea id="reply-content" class="form-control" rows="1"></textarea>
         </div>
         <div class="card-footer">
            <button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
         </div>
      </form>
   </div>
   <br />
   
   <div class="card">
      <div class="card-header"><b>댓글 리스트</b></div>
      <ul id="reply-box" class="list-group">
         <li id="reply-1" class="list-group-item d-flex justify-content-between">
            <div>댓글입니다</div>
            <div class="d-flex">
               <div class="font-italic">작성자 : 홍길동 &nbsp;</div>
               <button class="badge">삭제</button>
            </div>
         </li>
      </ul>
   </div>
   <br/>
</div>

<%@ include file="../layout/footer.jsp"%>