package org.blog.repository;

import java.util.Optional;

import org.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//JPQL -- java parsistence query language
	
	@Query(value = "SELECT * FROM USER u WHERE u.user_Email = ?1 ",nativeQuery = true  )
	public Optional<User> findByuserEmail(String email);
	
	
	@Query(value = "SELECT * FROM USER u WHERE u.user_Email = 1 AND u.user_Password = 2 ",nativeQuery = true  )
	public Optional<User> findByuserEmailAndPassword(String email, String password);


}
