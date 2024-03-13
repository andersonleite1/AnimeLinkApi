package br.com.andersonleite.animelinkapi.repository;

import br.com.andersonleite.animelinkapi.domain.Anime;
import java.util.List;

public interface AnimeRepository {
  List<Anime> listAll();
}
