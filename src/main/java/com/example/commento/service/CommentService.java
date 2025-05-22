package com.example.commento.service;

import com.example.commento.model.Comment;
import com.example.commento.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    public List<Comment> getUnusedComments() {
        return commentRepository.findAll().stream().filter(comment -> comment.isUsed() == false).toList();
    }
}
