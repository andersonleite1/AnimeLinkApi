package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.domain.Anime;

public class AnimeCreator {

  public static Anime createAnimeToBeSaved(){
    return Anime.builder()
            .name("Naruto")
            .synopsis("A ninja story")
            .releaseYear(2002)
            .classificationAge("PG-13")
            .author("Masashi Kishimoto")
            .animationStudio("Studio Pierrot")
            .inProgress(true)
            .build();
  }

  public static Anime createValidAnime(){
    return Anime.builder()
            .id(1L)
            .name("Naruto")
            .synopsis("A ninja story")
            .releaseYear(2002)
            .classificationAge("PG-13")
            .author("Masashi Kishimoto")
            .animationStudio("Studio Pierrot")
            .inProgress(true)
            .build();
  }

  public static Anime createValidUpdatedAnime(){
    return Anime.builder()
            .id(1L)
            .name("Naruto")
            .synopsis("A ninja story")
            .releaseYear(2002)
            .classificationAge("PG-13")
            .author("Masashi Kishimoto")
            .animationStudio("Studio Pierrot")
            .inProgress(true)
            .build();
  }
}
