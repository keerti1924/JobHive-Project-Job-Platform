package com.jobhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobhive.model.Article;
import com.jobhive.model.User;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByAuthor(User author);
	
	long count();
	List<Article> findByAuthor_UserId(Long authorId);
}
