package com.cos.blogapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

@Controller
public class UserController {

	private UserRepository userRepository;
	private HttpSession session;
	
	// DI
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		 this.session = session;
	}
	
	@GetMapping("/test/query/join")
	public void testQueryJoin() {
		userRepository.join("cos", "1234", "cos@nate.com");
	}
	
	@GetMapping("/test/join")
	public void testJoin() {
		User user = new User();
		user.setUsername("ssar");
		user.setPassword("1234");
		user.setEmail("ssar@nate.com");
		
		// insert into user(username, password, email) values('ssar', '1234', 'ssar@nate.com');
		userRepository.save(user);
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// /WEB-INF/views/user/login.jsp
	// /WEB-INF/views/login.jsp
	
	//  /WEB-INF/views/user/login.jsp
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		
	

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
	public String join(JoinReqDto dto) { // username = love&password=1234&email=love@nate.com
		
		/* User user = new User(); */
		
	 // user.setUsername(dto.getUsername());
	 // user.setPassword(dto.getPassword());
	 // user.setEmail(dto.getEmail());
		/*
		 * user.setUsername(dto.getUsername()); 
		 * user.setPassword(dto.getPassword());
		 * user.setEmail(dto.getEmail());
		 */
		
		
		
		userRepository.save(dto.toEntity());
		
		return "redirect:/loginform";  //리다이렉션(300)
	}

	
}

