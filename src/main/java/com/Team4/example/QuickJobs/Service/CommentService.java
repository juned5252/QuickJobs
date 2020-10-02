package com.Team4.example.QuickJobs.Service;

import com.Team4.example.QuickJobs.Entity.Comment;
import com.Team4.example.QuickJobs.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepository;

    public List<Comment> retrieveAllComments(){
        List<Comment> listOfComments = (List<Comment>) commentRepository.findAll();

        return listOfComments;
    }

    public void createComment(Comment comment){
        commentRepository.save(comment);
    }

    public Optional<Comment> findCommentById(Integer id){
        return commentRepository.findById(id);
    }

    public Comment updateComment(Comment comment, Integer commentId){
        return commentRepository.save(comment);
    }

    public void deleteComment(Integer commentId){
        commentRepository.deleteById(commentId);
    }
}

