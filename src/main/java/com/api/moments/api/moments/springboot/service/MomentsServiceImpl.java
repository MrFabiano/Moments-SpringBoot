package com.api.moments.api.moments.springboot.service;


import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.repository.MomentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MomentsServiceImpl implements MomentsService {

    private final MomentsRepository momentsRepository;

    @Override
    public Moments saveImage(Moments moments) {
      return   momentsRepository.save(moments);
    }

}
