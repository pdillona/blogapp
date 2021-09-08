package com.cos.blogapp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserControllerTest {

	@GetMapping("/test/join")
	public @ResponseBody String testJoin() {
		
		
		return "test/join";
	}
	@GetMapping("/test/login")
	public @ResponseBody String testLogin() {
		
		
		return "<script>alert('hello');</script>";
	}
	
	//주소?name=홍길동
	//  /test/data/num (내가 1요청시 저 num 자리에 1이온다.)
	@GetMapping("/test/data/{num}")
	public @ResponseBody String testData(@PathVariable int num) {
		
		if(num == 1) { //정상
			StringBuilder sb = new StringBuilder();
			sb.append("<script>");
			sb.append("location.href='/';");
			sb.append("</script>");
			
			return sb.toString();
			
		} else { //오류
			
			return "오류가났습니다";
		}
		
		
	}
}
