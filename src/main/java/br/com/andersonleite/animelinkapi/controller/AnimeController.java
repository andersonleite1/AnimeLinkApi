package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.util.DateUtil;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
  private final DateUtil dateUtil;

  @GetMapping(path = "list")
  public List<Anime> list(){
    log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
    return List.of(new Anime("Boku No Hero"), new Anime("Berserk"));
  }

}
