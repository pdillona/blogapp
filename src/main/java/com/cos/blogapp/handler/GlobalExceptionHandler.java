package com.cos.blogapp.handler;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.util.Script;


//@ControllerAdvice 는 1. 익셉션 핸들링, 2. @Controller의 역할까지 한다.
@ControllerAdvice
public class GlobalExceptionHandler {
//@ResponseBody는 데이터를 리턴할때 사용한다.
		@ExceptionHandler(value= NoSuchElementException.class)
		public @ResponseBody String error1(NoSuchElementException e) {
			System.out.println("오류 터졌다"+e.getMessage());
			return Script.href("/", "게시글 id를 찾을수 없습니다.");
		}
}
