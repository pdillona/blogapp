package com.cos.blogapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



//save()라는 함수를 jdk가 제공해주는데 이는 인서트와 업데이트를 수행해준다.
//save() 는 같은아이디가 있으면 업데이트 없으면 인서트해준다.

//save(user)
//findById(1) 셀렉트
//findAll()전체셀렉트
//deleteById(I)  1번 한건 삭제

// DAO
//@Repository 내부적으로 (부모 클래스에) 걸려있어서 안써줘도됨
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "insert into user (username, password, email) values (:username, :password, :email)", nativeQuery = true)
	void join(String username, String password, String email);
	
	@Query(value = "select * from user where username = :username and password = :password", nativeQuery = true)
	User mLogin(String username, String password);

}

