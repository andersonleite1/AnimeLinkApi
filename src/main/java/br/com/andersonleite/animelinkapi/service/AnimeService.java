package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.Anime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {
  public List<Anime> listAll() {
    return List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk"));
  }
}
