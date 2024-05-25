package br.com.andersonleite.animelinkapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimePostRequestBody {
  @NotEmpty(message = "The anime name cannot be empty")
  String name;
  String synopsis;
  Integer releaseYear;
  String classificationAge;
  String author;
  String animationStudio;
  boolean inProgress;

}
