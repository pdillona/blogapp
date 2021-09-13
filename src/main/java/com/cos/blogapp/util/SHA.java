package com.cos.blogapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA {
		//static :재사용(한번보였다가 사라지지만) 필요할때마다 땡겨쓰면됨
	    //함수전체 :add throw 

		public static String encrypt(String rawPassword, MyAlgorithm algorithm) {
			
			// SHA256함수를 가진 클래스 객체를 가저온다.
			MessageDigest md = null;
			try { 
				md = MessageDigest.getInstance(algorithm.getType()); //SHA 256 , SHA 512
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			//2. 비밀번호 1234 ->SHA256 던지기 (byte로 던짐)
			md.update(rawPassword.getBytes());
		    
		
			StringBuilder sb =  new StringBuilder();
			for(Byte b : md.digest()) { //update ->md.digest
				sb.append(String.format("%02x", b));
			}
			return sb.toString();

		}
}

