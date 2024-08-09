package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.dto.anime.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
  public static AnimePutRequestBody createAnimePutRequestBody() {
    return AnimePutRequestBody.builder()
            .id(AnimeCreator.createValidUpdatedAnime().getId())
            .name(AnimeCreator.createValidUpdatedAnime().getName())
            .synopsis(AnimeCreator.createValidUpdatedAnime().getSynopsis())
            .releaseYear(AnimeCreator.createValidUpdatedAnime().getReleaseYear())
            .classificationAge(AnimeCreator.createValidUpdatedAnime().getClassificationAge())
            .author(AnimeCreator.createValidUpdatedAnime().getAuthor())
            .animationStudio(AnimeCreator.createValidUpdatedAnime().getAnimationStudio())
            .inProgress(AnimeCreator.createValidUpdatedAnime().isInProgress())
            .build();
  }
}
