package com.api.moments.api.moments.springboot.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

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
    private String fileImage;
    @JsonIgnore
    private String createad_at;
    @JsonIgnore
    private String updated_at;
    @JsonIgnore
    @OneToMany
    private List<Commenst> comments = new ArrayList<>();


}
