package com.api.moments.api.moments.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Moments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @JsonProperty("image")
    private String filename;
    @JsonIgnore
    private String createad_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    @JsonIgnore
    private String updated_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    @OneToMany
    @JsonIgnore
    private List<Commenst> comments = new ArrayList<>();


}
