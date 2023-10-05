package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
	
	@Query(value="select * from author where email = :email" ,nativeQuery = true)
	Author getAuthorWithMailAddress(String email);
	
	@Query("select a from Author a where a.email = :email")
	Author getAuthorWithMailAddressWithoutNative(String email);
	
	Author findByEmail(String email);

}
