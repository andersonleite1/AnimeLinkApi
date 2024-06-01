package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.dto.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
  public static AnimePostRequestBody createAnimePostRequestBody() {
    return AnimePostRequestBody.builder()
            .name(AnimeCreator.createAnimeToBeSaved().getName())
            .synopsis(AnimeCreator.createAnimeToBeSaved().getSynopsis())
            .releaseYear(AnimeCreator.createAnimeToBeSaved().getReleaseYear())
            .classificationAge(AnimeCreator.createAnimeToBeSaved().getClassificationAge())
            .author(AnimeCreator.createAnimeToBeSaved().getAuthor())
            .animationStudio(AnimeCreator.createAnimeToBeSaved().getAnimationStudio())
            .inProgress(AnimeCreator.createAnimeToBeSaved().isInProgress())
            .build();
  }
}
