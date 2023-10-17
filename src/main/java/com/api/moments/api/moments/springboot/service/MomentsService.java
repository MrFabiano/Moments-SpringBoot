package com.api.moments.api.moments.springboot.service;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.repository.MomentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MomentsService {

   private final MomentsRepository momentsRepository;

    public Moments saveImage(Moments moments) {
        return momentsRepository.save(moments);
    }

    public List<Moments> findOneImage() {
        return momentsRepository.findAll();
    }
}
