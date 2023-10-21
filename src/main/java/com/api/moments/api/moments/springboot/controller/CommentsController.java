package com.api.moments.api.moments.springboot.controller;

import com.api.moments.api.moments.springboot.model.Comment;
import com.api.moments.api.moments.springboot.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/moments")
@AllArgsConstructor
@Validated
public class CommentsController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<Comment> postSaveComment(@RequestBody @Valid Comment comment){
        var novoComment = commentService.salvar(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
