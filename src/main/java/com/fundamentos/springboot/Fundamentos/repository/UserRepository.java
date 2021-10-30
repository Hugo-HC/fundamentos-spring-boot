package com.fundamentos.springboot.Fundamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fundamentos.springboot.Fundamentos.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("Select u From User u Where u.email=?1 ")
	Optional<User> findByUserEmail(String email);
	
	@Query("Select u From User u Where name like ?1%")
	List<User> findAndSort(String name, Sort sort);
}
