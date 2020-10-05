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

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/getAllComments", headers = "Accept=application/json")
    public ResponseEntity<List<Comment>> getComments(){
        return ResponseEntity.ok(commentService.retrieveAllComments());
    }

    @GetMapping(value = "/getComment/{commentId}", headers = "Accept=application/json")
    public ResponseEntity<Comment> getSingleComment(@PathVariable Long commentId){
        return ResponseEntity.ok(commentService.findCommentById(commentId));
    }

    @PostMapping(value = "/postComment/{commentReceiverId}/{commentGiverId}", headers = "Accept=application/json")
    public ResponseEntity<String> createComment(@PathVariable Long commentReceiverId,@PathVariable Long commentGiverId,@RequestBody Comment comment, UriComponentsBuilder uriComponentsBuilder){
          if (commentReceiverId.equals(commentGiverId)){
              return ResponseEntity.ok().body("You cannot comment on yourself");
          }
        return ResponseEntity.ok(commentService.createComment(commentReceiverId,commentGiverId,comment));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriComponentsBuilder.path("/api/{commentId}").buildAndExpand(comment.getCommentId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateComment/{commentId}/{commentorId}", headers = "Accept=application/json")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId,@PathVariable Long commentorId,@RequestBody Comment newComment){
        Comment tempComment = commentService.findCommentById(commentId);
        if (tempComment.getCommentorId() != commentorId){
            return ResponseEntity.ok().body("you cannot update any comments besides your own");
        }
        return ResponseEntity.ok().body(commentService.updateComment(newComment, commentId).toString());
    }

    @DeleteMapping(value = "/deleteComment/{commentId}/{commentorId}", headers = "Accept=application/json")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId, @PathVariable Long commentorId ){
        Comment tempComment = commentService.findCommentById(commentId);
        if (tempComment.getCommentorId() != commentorId){
            return ResponseEntity.ok().body("you cannot delete any comments besides your own");
        }
        commentService.deleteComment(commentId);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

}

