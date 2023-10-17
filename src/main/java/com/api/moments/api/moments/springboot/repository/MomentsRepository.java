package com.api.moments.api.moments.springboot.repository;

import com.api.moments.api.moments.springboot.model.Moments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MomentsRepository extends JpaRepository<Moments, Long> {}
