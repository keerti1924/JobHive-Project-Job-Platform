package com.jobhive.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Comment;
import com.jobhive.model.Post;
import com.jobhive.model.User;
import com.jobhive.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPost_PostIdOrderByTimestampAsc(postId);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
    public void likeComment(Long commentId, User user) {
        Comment comment = getCommentById(commentId);
        if (comment != null) {
            Set<User> likes = comment.getLikes();
            if (likes == null) {
                likes = new HashSet<>();
            }
            if (likes.contains(user)) {
                likes.remove(user); // Unlike
                comment.setLikeCount(comment.getLikeCount() - 1);
            } else {
                likes.add(user); // Like
                comment.setLikeCount(comment.getLikeCount() + 1);
            }
            comment.setLikes(likes);
            commentRepository.save(comment);
        }
    }
    
    public Long getReplyCount(Comment comment) {
        return commentRepository.countByParentComment(comment);
    }
    
    public Comment getCommentWithReplies(Long commentId) {
        return commentRepository.findById(commentId)
            .map(comment -> {
                // Load replies for this comment
                comment.getReplies().size();
                return comment;
            })
            .orElseThrow();
    }
    
    //For Notification
 // Method to get comments by post
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepository.findByPost(post);
    }

}
