package com.jobhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobhive.model.Comment;
import com.jobhive.model.Post;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPost_PostIdOrderByTimestampAsc(Long postId);
	Long countByParentComment(Comment parentComment);
	
	//For Notification
	List<Comment> findByPost(Post post);
	
	int countByPost_PostId(Long postId);
}