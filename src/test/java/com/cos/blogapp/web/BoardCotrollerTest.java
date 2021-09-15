package com.cos.blogapp.web;

import org.junit.jupiter.api.Test;

import com.cos.blogapp.domain.board.Board;

public class BoardCotrollerTest {

	@Test
	public void 익셉션테스트() {
		
	try {
		Board b = null;
		System.err.println(b.getContent());
	}	catch (Exception e) {
	//	System.err.println("오류가 났어요");
	//	System.err.println(e.getMessage());
	
	}
	
	
	}	
	@Test
	public void 익셉션테스트2() throws Exception{
		throw new Exception();
	}
}
