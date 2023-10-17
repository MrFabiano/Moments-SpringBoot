package com.api.moments.api.moments.springboot.controller;

import com.api.moments.api.moments.springboot.model.Moments;
import com.api.moments.api.moments.springboot.repository.MomentsRepository;
import com.api.moments.api.moments.springboot.service.MomentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/moments")
@AllArgsConstructor
public class MomentsController {

    private final MomentsService momentsService;

    @GetMapping
    public ResponseEntity<List<Moments>>getImage() {
        List<Moments> imageEntity = momentsService.findOneImage();
        List<Moments> imageData = new ArrayList<>(imageEntity);
        return ResponseEntity.ok(imageData);

    }

    @PostMapping
    public ResponseEntity<Moments> createMoment(@RequestPart("image") MultipartFile file) {
        try {
            Moments moments = new Moments();
            moments.setFilename(file.getOriginalFilename());
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
