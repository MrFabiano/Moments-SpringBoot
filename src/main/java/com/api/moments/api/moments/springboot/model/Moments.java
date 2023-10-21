package com.api.moments.api.moments.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Moments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String image;
    private String createad_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String updated_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    @OneToMany
    private List<Commenst> comments = new ArrayList<>();

}
