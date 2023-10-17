/*package com.api.moments.api.moments.springboot.service;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.repository.MomentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MomentsServiceImpl implements MomentsService {

    @Autowired
    private MomentsRepository momentsRepository;

    @Override
    public Moments saveImage(Moments moments) {
      return momentsRepository.save(moments);
    }

//    @Override
//    public List<Moments> buscarTodos() {
//        return momentsRepository.findAll();
//    }

    @Override
    public Moments findOneImage(String filename) {
        return momentsRepository.findOne(filename);
    }

}
*/