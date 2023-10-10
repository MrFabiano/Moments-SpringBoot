package com.api.moments.api.moments.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moments")
@Validated
@AllArgsConstructor
public class MomentsController {
}
