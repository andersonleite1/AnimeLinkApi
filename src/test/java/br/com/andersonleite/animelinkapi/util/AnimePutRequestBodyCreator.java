package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.dto.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
  public static AnimePutRequestBody createAnimePutRequestBody(){
    return AnimePutRequestBody.builder()
        .id(AnimeCreator.createValidUpdatedAnime().getId())
        .name(AnimeCreator.createValidUpdatedAnime().getName())
        .build();
  }
}
