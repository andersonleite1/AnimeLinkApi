package br.com.andersonleite.animelinkapi.repository;

import br.com.andersonleite.animelinkapi.domain.Anime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

  List<Anime> findByName(String name);
}
