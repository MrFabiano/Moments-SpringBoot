package com.api.moments.api.moments.springboot.controller;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.service.MomentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moments")
@AllArgsConstructor
@Validated
public class MomentsController {

    private final MomentsService momentsService;

    @PostMapping
    public ResponseEntity<Moments> createMoment(@RequestPart("image") @Valid MultipartFile file) {
        try {
            Moments moments = new Moments();
            moments.setImage(file.getOriginalFilename());
            moments.setTitle(file.getContentType());
            moments.setDescription(file.getName());

            momentsService.saveImage(moments);
            return new ResponseEntity<>(moments, HttpStatus.CREATED);

        } catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Moments());
        }
    }

    @GetMapping
    public ResponseEntity<List<Moments>>getImage() {
        List<Moments> imageEntity = momentsService.findOneImage();
        List<Moments> imageData = new ArrayList<>(imageEntity);
        return ResponseEntity.ok(imageData);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Moments>> getMoment(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(momentsService.findByIdMoments(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moments> updateMoment(@RequestBody Moments moments, @PathVariable Long id){
        Moments serviceByIdUpdate = momentsService.findByIdUpdate(id);
        if (serviceByIdUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceByIdUpdate.setTitle(moments.getTitle());
        serviceByIdUpdate.setDescription(moments.getDescription());
        serviceByIdUpdate.setImage(moments.getImage());
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//       do various things, perhaps:
//        String someJsonString = mapper.writeValueAsString(moments1);
//        Moments someClassInstance = mapper.readValue(someJsonString, Moments.class);
        momentsService.saveImage(serviceByIdUpdate);
        // Return a response with serviceByIdUpdate updated book and HTTP status 200 (OK)
        return new ResponseEntity<>(serviceByIdUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       momentsService.delete(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/uploads")
    public ResponseEntity<List<Moments>> uploadGet(){
            return ResponseEntity.ok(momentsService.findOneImage());
    }
}
