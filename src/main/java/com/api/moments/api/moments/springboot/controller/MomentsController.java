package com.api.moments.api.moments.springboot.controller;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.service.MomentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/moments")
@AllArgsConstructor
public class MomentsController {

    private final MomentsService momentsService;

    @PostMapping
    public ResponseEntity<Moments> uploadImage(@RequestPart("image") MultipartFile file) {
        try {
            Moments moments = new Moments();
            moments.setFileImage(file.getOriginalFilename());
            moments.setTitle(file.getContentType());
            moments.setDescription(file.getName());

            momentsService.saveImage(moments);
            return new ResponseEntity<>(moments, HttpStatus.CREATED);

        } catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Moments());
        }
    }
}
