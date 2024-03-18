package br.com.andersonleite.animelinkapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePostRequestBody {
  @NotEmpty(message = "The anime name cannot be empty")
  private String name;
}
