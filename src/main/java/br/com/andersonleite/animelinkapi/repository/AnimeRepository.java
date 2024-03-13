package br.com.andersonleite.animelinkapi.repository;

import br.com.andersonleite.animelinkapi.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
