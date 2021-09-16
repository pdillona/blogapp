package com.cos.blogapp.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.handler.ex.MyNotFoundException;
import com.cos.blogapp.util.Script;


//@ControllerAdvice 는 1. 익셉션 핸들링, 2. @Controller의 역할까지 한다.
@ControllerAdvice
public class GlobalExceptionHandler {
//@ResponseBody는 데이터를 리턴할때 사용한다.
	// 어떤 익셉션은 파일~~~
	// 어떤 익셉션은 데이터~~~
	// 어떤 익셉션은 뒤로 가기
	// 어떤 익셉션은 / 메인 페이지로 가게!!

	@ExceptionHandler(value = MyNotFoundException.class)
	public @ResponseBody String error1(MyNotFoundException e) {
			return Script.href("/", e.getMessage());
		}
}
