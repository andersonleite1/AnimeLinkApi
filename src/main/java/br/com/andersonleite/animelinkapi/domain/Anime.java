package br.com.andersonleite.animelinkapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "animes")
@Builder
public class Anime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "The anime name cannot be empty")
  private String name;

  private String synopsis;

  @Column(name = "release_year")
  private Integer releaseYear;

  @Column(name = "classification_age")
  private String classificationAge;

  private String author;

  @Column(name = "animation_studio")
  private String animationStudio;

  @Column(name = "in_progres")
  private boolean inProgress = false;

}
