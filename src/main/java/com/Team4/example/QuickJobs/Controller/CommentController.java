package com.Team4.example.QuickJobs.Controller;

import com.Team4.example.QuickJobs.Entity.Comment;
import com.Team4.example.QuickJobs.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {
    public CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping(value = "/getComment", headers = "Accept=application/json")
    public List<Comment> getComment(){
        return commentService.retrieveAllComments();
    }

    @GetMapping(value = "/getComment/{commentId}", headers = "Accept=application/json")
    public Optional<Comment> getSingleComment(@PathVariable Integer commentId){
        return commentService.findCommentById(commentId);
    }

    @PostMapping(value = "/postComment", headers = "Accept=application/json")
    public ResponseEntity<Void> createComment(@RequestBody Comment comment, UriComponentsBuilder uriComponentsBuilder){
        commentService.createComment(comment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/{commentId}").buildAndExpand(comment.getCommentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateComment", headers = "Accept=application/json")
    public ResponseEntity<String> updateComment(@RequestBody Comment currentComment){
        Optional<Comment> updatedComment = commentService.findCommentById(currentComment.getCommentId());
        if(updatedComment==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        commentService.updateComment(currentComment,currentComment.getCommentId());
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteComment/{commentId}", headers = "Accept=application/json")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId){
        Optional<Comment> product = commentService.findCommentById(commentId);
        if(commentId==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        commentService.deleteComment(commentId);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

    }

}

