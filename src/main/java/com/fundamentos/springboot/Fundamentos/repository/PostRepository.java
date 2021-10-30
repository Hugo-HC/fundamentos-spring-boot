package com.fundamentos.springboot.Fundamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentos.springboot.Fundamentos.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
