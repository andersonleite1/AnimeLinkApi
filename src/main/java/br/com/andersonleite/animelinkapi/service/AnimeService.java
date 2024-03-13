package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.dto.AnimePostRequestBody;
import br.com.andersonleite.animelinkapi.dto.AnimePutRequestBody;
import br.com.andersonleite.animelinkapi.repository.AnimeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;

  public List<Anime> listAll() {
    return animeRepository.findAll();
  }

  public Anime findByIdOrThrowBadRequestException(long id) {
    return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
  }

  public Anime save(AnimePostRequestBody animePostRequestBody) {
    return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
  }

  public void replace(AnimePutRequestBody animePutRequestBody) {
    Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
    Anime anime = Anime.builder()
        .id(savedAnime.getId())
        .name(animePutRequestBody.getName())
        .build();

    animeRepository.save(anime);
  }

  public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
  }
}
