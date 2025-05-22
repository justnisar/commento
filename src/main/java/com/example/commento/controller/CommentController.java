package com.example.commento.controller;

import com.example.commento.model.Comment;
import com.example.commento.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> getComments(@RequestParam(required = false) Boolean used){
        if(used != null) {
            return commentService.getUnusedComments();
        }
        return commentService.getAllComments();
    }

    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment){
       return commentService.addComment(comment);
    }

}
