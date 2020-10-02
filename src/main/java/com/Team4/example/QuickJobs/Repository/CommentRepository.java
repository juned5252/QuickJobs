package com.Team4.example.QuickJobs.Repository;


import com.Team4.example.QuickJobs.Entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {

        }



