package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.dto.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
  public static AnimePostRequestBody createAnimePostRequestBody(){
    return AnimePostRequestBody.builder()
        .name(AnimeCreator.createAnimeToBeSaved().getName())
        .build();
  }
}
