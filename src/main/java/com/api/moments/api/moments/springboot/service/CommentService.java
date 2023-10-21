package com.api.moments.api.moments.springboot.service;

import com.api.moments.api.moments.springboot.model.Comment;
import com.api.moments.api.moments.springboot.repository.CommentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentsRepository commentsRepository;

    public Comment salvar(Comment comment){
        return commentsRepository.save(comment);
    }
}
