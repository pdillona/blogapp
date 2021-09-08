package com.cos.blogapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	

	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	// /WEB-INF/views/user/login.jsp
	// /WEB-INF/views/login.jsp
	
	//  /WEB-INF/views/user/login.jsp
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";  //ViewResolver
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";	//ViewResolver
	}
	
	@PostMapping("/login")
	public String login(@Valid LoginReqDto dto, BindingResult bindingResult, Model model) {
		
		//Valid는 내가 체크할 항목 앞에 놔야함

		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error: bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드:"+error.getField());
				System.out.println("메시지:"+error.getDefaultMessage());
			}
			model.addAttribute("errorMap", errorMap);
			return "error/error";
		}

		// 1. username, password 받기
		// 2. 받은 데이터 DB에서 조회하기
		User userEntity =  userRepository.mLogin(dto.getUsername(), dto.getPassword());{
			
			
				if(userEntity == null) {
					
					return"redirect:/loginForm";
					
				}else {
					
					 session.setAttribute("principal",userEntity); 
					return"redirect:/home";
					
				}
		}
		

		
		// 3-1 (DB에 데이터가 있으면) session에 저장(나중에 다시 불러올때 아예 
		//새로 불러와야하는데 세션에 두면 쉽게 불러온다.)
		// 3-2 (DB에 데이터가 없으면)
		// 4. 메인페이지를 돌려주기 
//----------------- 아이디 비번 받기 검사----------------------		
		//System.out.println(dto.getUsername());
		//System.out.println(dto.getPassword());

	//	return "home";
	}
	
	@PostMapping("/join")
	public String join(@Valid JoinReqDto dto, BindingResult bindingResult, Model model) { // username = love&password=1234&email=love@nate.com
		
		/* User user = new User(); */
		
		/*
		 * user.setUsername(dto.getUsername()); 
		 * user.setPassword(dto.getPassword());
		 * user.setEmail(dto.getEmail());
		 * 
		 * userRepository.save(user);
		 * 
		 * return "redirect:/loginform";
		 */
		
		System.out.println("에러사이즈:"+bindingResult.getFieldErrors().size()); 
		
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error: bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드:"+error.getField());
				System.out.println("메시지:"+error.getDefaultMessage());
			}
			model.addAttribute("errorMap", errorMap);
			return "error/error";
		}
		
		
		
		userRepository.save(dto.toEntity());
		
		return "redirect:/loginForm";  //리다이렉션(300) 
	}

	//response.send redirection  사용자가 A페이지 요청했는데 B페이지 보여주는것
}

