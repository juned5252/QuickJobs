package com.Team4.example.QuickJobs.Service;

import com.Team4.example.QuickJobs.Entity.Comment;
import com.Team4.example.QuickJobs.Entity.User;
import com.Team4.example.QuickJobs.Repository.CommentRepository;
import com.Team4.example.QuickJobs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    public UserRepository userRepository;

    public List<Comment> retrieveAllComments(){
        List<Comment> listOfComments = commentRepository.findAll();

        return listOfComments;
    }

    public String createComment(Long id, Long commentorId, Comment comment){
        Comment userComment = comment;

        userComment.setFirstName(userRepository.findById(commentorId).orElse(null).getFirstName());
        userComment.setLastName(userRepository.findById(commentorId).orElse(null).getLastName());
        userComment.setCommentorId(userRepository.findById(commentorId).orElse(null).getUserId());

        User commentReceiver = userRepository.findById(id).orElse(null);
        commentReceiver.getCommentList().add(userComment);
        userRepository.save(commentReceiver);
        return userComment.toString();
    }

    public Comment findCommentById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public Comment updateComment(Comment comment, Long commentId){
        Comment currentComment = commentRepository.findById(commentId).orElse(null);
        currentComment.setDescription(comment.getDescription());
        return commentRepository.save(currentComment);
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }
}

