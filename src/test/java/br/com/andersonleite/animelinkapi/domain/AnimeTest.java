package br.com.andersonleite.animelinkapi.domain;

import br.com.andersonleite.animelinkapi.util.AnimeCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimeTest {
    private Anime anime;
    private Anime animeValid;

    @BeforeEach
    void setUp() {
        anime = new Anime();
        animeValid = AnimeCreator.createValidAnime();
    }

    @Test
    void testSettersAndGetters() {
        anime.setId(animeValid.getId());
        anime.setName(animeValid.getName());
        anime.setSynopsis(animeValid.getSynopsis());
        anime.setReleaseYear(animeValid.getReleaseYear());
        anime.setClassificationAge(animeValid.getClassificationAge());
        anime.setAuthor(animeValid.getAuthor());
        anime.setAnimationStudio(animeValid.getAnimationStudio());
        anime.setInProgress(true);

        assertEquals(animeValid.getId(), anime.getId());
        assertEquals(animeValid.getName(), anime.getName());
        assertEquals(animeValid.getSynopsis(), anime.getSynopsis());
        assertEquals(animeValid.getReleaseYear(), anime.getReleaseYear());
        assertEquals(animeValid.getClassificationAge(), anime.getClassificationAge());
        assertEquals(animeValid.getAuthor(), anime.getAuthor());
        assertEquals(animeValid.getAnimationStudio(), anime.getAnimationStudio());
        assertTrue(anime.isInProgress());
    }

    @Test
    void testNotEmptyName() {
        anime.setName("");
        Set<ConstraintViolation<Anime>> violations = Validation.buildDefaultValidatorFactory()
                .getValidator().validate(anime);

        Assertions.assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("The anime name cannot be empty")));
    }

    @Test
    void testBuilder() {
        Anime builtAnime = Anime.builder()
                .id(animeValid.getId())
                .name(animeValid.getName())
                .synopsis(animeValid.getSynopsis())
                .releaseYear(animeValid.getReleaseYear())
                .classificationAge(animeValid.getClassificationAge())
                .author(animeValid.getAuthor())
                .animationStudio(animeValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertEquals(animeValid.getId(), builtAnime.getId());
        assertEquals(animeValid.getName(), builtAnime.getName());
        assertEquals(animeValid.getSynopsis(), builtAnime.getSynopsis());
        assertEquals(animeValid.getReleaseYear(), builtAnime.getReleaseYear());
        assertEquals(animeValid.getClassificationAge(), builtAnime.getClassificationAge());
        assertEquals(animeValid.getAuthor(), builtAnime.getAuthor());
        assertEquals(animeValid.getAnimationStudio(), builtAnime.getAnimationStudio());
        assertTrue(builtAnime.isInProgress());
    }

    @Test
    void testToString() {
        String expectedToString = "Anime(id=1, name=Naruto, synopsis=A ninja story, releaseYear=2002, classificationAge=PG-13, author=Masashi Kishimoto, animationStudio=Studio Pierrot, inProgress=true)";
        assertEquals(expectedToString, animeValid.toString());
    }

    @Test
    void testHashCode() {
        Anime anime1 = Anime.builder()
                .id(animeValid.getId())
                .name(animeValid.getName())
                .synopsis(animeValid.getSynopsis())
                .releaseYear(animeValid.getReleaseYear())
                .classificationAge(animeValid.getClassificationAge())
                .author(animeValid.getAuthor())
                .animationStudio(animeValid.getAnimationStudio())
                .inProgress(true)
                .build();

        Anime anime2 = Anime.builder()
                .id(animeValid.getId())
                .name(animeValid.getName())
                .synopsis(animeValid.getSynopsis())
                .releaseYear(animeValid.getReleaseYear())
                .classificationAge(animeValid.getClassificationAge())
                .author(animeValid.getAuthor())
                .animationStudio(animeValid.getAnimationStudio())
                .inProgress(true)
                .build();

        Anime anime3 = Anime.builder()
                .id(2L)
                .name("Death Note")
                .synopsis("A high school student discovers a supernatural notebook.")
                .releaseYear(2006)
                .classificationAge("16+")
                .author("Tsugumi Ohba")
                .animationStudio("Madhouse")
                .inProgress(false)
                .build();

        // Verificar se objetos iguais produzem o mesmo hash code
        assertEquals(anime1.hashCode(), anime2.hashCode());

        // Verificar se objetos diferentes produzem hash codes diferentes
        Assertions.assertNotEquals(anime1.hashCode(), anime3.hashCode());
    }
}
