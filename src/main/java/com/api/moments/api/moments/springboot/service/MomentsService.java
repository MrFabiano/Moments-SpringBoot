package com.api.moments.api.moments.springboot.service;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.repository.MomentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MomentsService {

   private final MomentsRepository momentsRepository;

    public void saveImage(Moments moments) {
        momentsRepository.save(moments);
    }

    public List<Moments> findOneImage() {
        return momentsRepository.findAll();
    }

    public Optional<Moments> findByIdMoments(Long id) throws Exception {
        return Optional.ofNullable(momentsRepository.findById(id).orElseThrow(() -> new Exception("ID não encontrado")));

    }

    public Moments findByIdUpdate(Long id){
        return momentsRepository.getReferenceById(id);
    }

    public void delete(Long id){
        try{
        momentsRepository.deleteById(id);
    }catch (Exception e){
            throw new RuntimeException("Não foi possivel excluir");
        }
    }
}
