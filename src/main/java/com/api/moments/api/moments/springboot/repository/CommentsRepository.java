package com.api.moments.api.moments.springboot.repository;

import com.api.moments.api.moments.springboot.model.Commenst;
import com.api.moments.api.moments.springboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
