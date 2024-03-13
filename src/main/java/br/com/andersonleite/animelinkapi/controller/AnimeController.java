package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.service.AnimeService;
import br.com.andersonleite.animelinkapi.util.DateUtil;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
  private final DateUtil dateUtil;
  private final AnimeService animeService;

  @GetMapping
  public ResponseEntity<List<Anime>> list(){
    return ResponseEntity.ok(animeService.listAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Anime> findById(@PathVariable long id){
    return ResponseEntity.ok(animeService.findById(id));
  }

}
