package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.service.AnimeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
  private final AnimeService animeService;

  @GetMapping
  public ResponseEntity<List<Anime>> list(){
    return ResponseEntity.ok(animeService.listAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Anime> findById(@PathVariable long id) {
    return ResponseEntity.ok(animeService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Anime> save(@RequestBody Anime anime) {
    return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    animeService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
