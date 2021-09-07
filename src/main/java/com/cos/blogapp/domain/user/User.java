package com.cos.blogapp.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//테이블 모델
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	
	private int id; 					 //pk(자동증가번호)
	@Column(nullable = false, length = 20, unique = true)  //유저네임 무조건 들어와야해 = not null ,  유저네임 길이 바이트기준 = varchar2( 여기에 해당 ), 중복 방지 unique
	private String username; //아이디
	@Column(nullable = false, length = 20) 
	private String password; 
	@Column(nullable = false, length = 50) 
	private String email;

}