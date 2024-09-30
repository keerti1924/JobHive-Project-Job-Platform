package com.jobhive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Article;
import com.jobhive.model.User;
import com.jobhive.repository.ArticleRepository;

@Service
public class ArticleService {

	 @Autowired
	    private ArticleRepository articleRepository;

	    public List<Article> getAllArticles() {
	        return articleRepository.findAll();
	    }

	    public void createArticle(Article article) {
	        articleRepository.save(article);
	    }

	    public List<Article> getArticlesByAuthor(User author) {
	        return articleRepository.findByAuthor(author);
	    }

	    public Article getArticleById(Long articleId) {
	        Optional<Article> optionalArticle = articleRepository.findById(articleId);
	        return optionalArticle.orElse(null); // Return null if not found; you could also throw an exception
	    }
	    
	    public long countArticles() {
	        return articleRepository.count();
	    }
	    
	    // Fetch articles created by a specific user
	    public List<Article> getArticlesByUserId(Long userId) {
	        return articleRepository.findByAuthor_UserId(userId);
	    }
}
