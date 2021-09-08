package com.cos.blogapp.domain.board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.blogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //테이블만들어주는데 어플리케이션yml에서 create해야 만들어진다.
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	
	private int id; 					 
	private String title; 
	private String content; 
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;	//s
	
}
