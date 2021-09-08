package com.cos.blogapp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.blogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoinReqDto {
/*		User user = new User();
		
		user.setId(1);*/
	
		@Size(min = 2, max = 20) //사이즈를 최소 2~ 최대 20
		@NotBlank   //javax의 밸리데이션으로임포트  not null은 널이면안된다 not empty는 공백이면안된다. 블랭크는 2개를 동시에 다막음
		private String username;
		
		@Size(min = 4, max = 20) 
		@NotBlank 
		private String password;
		
		@Size(min = 4, max = 50) 
		@NotBlank 
		private String email;
		/* return user; */
		
		public User toEntity() {
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			return user;
			
		}
		
		
}
