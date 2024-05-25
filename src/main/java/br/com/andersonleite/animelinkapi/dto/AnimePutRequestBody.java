package br.com.andersonleite.animelinkapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimePutRequestBody {
  private Long id;
  private String name;
  private String synopsis;
  private Integer releaseYear;
  private String classificationAge;
  private String author;
  private String animationStudio;
  private boolean inProgress;
}
