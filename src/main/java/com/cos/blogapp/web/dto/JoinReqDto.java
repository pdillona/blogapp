package com.cos.blogapp.web.dto;

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
		private String username;
		private String password;
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
