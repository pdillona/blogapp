package com.cos.blogapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.domain.board.Board;
import com.cos.blogapp.domain.board.BoardRepository;
import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.util.Script;
import com.cos.blogapp.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller  //컴포넌트 스캔 (스프링이 스캔하며) IoC 스캔된걸 디스패쳐서블릿이 사용한다.
public class BoardController{
// ioc했으면 di 디펜던시 인젝션 해줘야한다
// di시에 생성자 주입을 통해 
// new하면 메모리에 용량도 많이 차지하고 쓰기도어려운데
// 이를 컴포넌트 스캔으로 쫙 스캔해서 ioc컨테이너에 들어가는걸 
// ioc컨테이너에 넣어주고 그걸 di로 가져와서 공유하는데 그 과정에서
// 생성자 주입을 통해서 주입되게된면서 쉽고 뉴하지 않고도 사용이가능하다.
// 자바규칙이 final이 붙은 변수는 무조건 초기화를 해준다. 
// 이 초기화시에 오류가 나니까 생성자를 만들어줘서 이를 해결해주는데 	
//@RequiredArgsConstructor 이 어노테이션을 이용해서 쉽게해주는것이다.

	private final BoardRepository boardRepository;
	private final HttpSession session;
	
	@PostMapping("/board")
	public @ResponseBody String save(@Valid BoardSaveReqDto dto, BindingResult bindingResult) {

		User principal = (User)session.getAttribute("principal");
		
		// 인증체크
		if(principal == null) { // 로그인 안됨
			return Script.href("/loginForm","잘못된 접근입니다");
		}
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		// 10시 15분까지 -> BoardSaveReqDto 생성
		// Postman으로 테스트
		// 콘솔에 출력    
		
		
		
//		User user = new User();
//		user.setId(3);
//		boardRepository.save(dto.toEntity(user));
		
		boardRepository.save(dto.toEntity(principal));
		return Script.href("/", "글쓰기 성공");
	}
	
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}	
	
	
	
	
	
	@GetMapping({"/board"})
	public String home(Model model, int page) {
	
/*	 http://localhost:8080으로 찍었을때 홈으로보내는 1번째방법 
   if(page == null) {
		System.out.println("page값이 null입니다.");
		page = 0;
	}	*/
		
	PageRequest pageRequest = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC,"id"));	

	
	//Sort.by(Sort.Direction.DESC,"id")	
	Page<Board> boardsEntity = boardRepository.findAll(pageRequest);	
	//영속화된 오브젝트 JPA DB에서 땡겨와서 데이터가담긴 오브젝트 boardsEntity 
	
	//page타입은 content안에 데이터가 들어간다.
	model.addAttribute("boardsEntity", boardsEntity);
	
	// 아무 요청없이 그냥 주소찍으면 무조건 인덱스로 보내게되도록 설계되어있다.
	
	return "board/list";
	}
}
