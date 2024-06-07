package br.com.andersonleite.animelinkapi.dto;

import br.com.andersonleite.animelinkapi.util.AnimePostRequestBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimePostRequestBodyTest {

    private AnimePostRequestBody animePostRequestBodyValid;

    @BeforeEach
    void setUp() {
        animePostRequestBodyValid = AnimePostRequestBodyCreator.createAnimePostRequestBody();
    }

    @Test
    void testEquals_Reflexive() {
        AnimePostRequestBody animePostRequestBody = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertEquals(animePostRequestBody, animePostRequestBody);
    }

    @Test
    void testEquals_Symmetric() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertEquals(anime1, anime2);
        assertEquals(anime2, anime1);
    }

    @Test
    void testEquals_Transitive() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime3 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertEquals(anime1, anime2);
        assertEquals(anime2, anime3);
        assertEquals(anime1, anime3);
    }

    @Test
    void testEquals_Consistent() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        for (int i = 0; i < 10; i++) {
            assertEquals(anime1, anime2);
        }
    }

    @Test
    void testEquals_Null() {
        AnimePostRequestBody animePostRequestBody = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertNotEquals(null, animePostRequestBody);
    }

    @Test
    void testEquals_DifferentClass() {
        AnimePostRequestBody animePostRequestBody = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        String differentClassObject = "I am a String";

        assertNotEquals(animePostRequestBody, differentClassObject);
    }

    @Test
    void testEquals_DifferentFields() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name("Naruto Shippuden")
                .synopsis("A ninja story continued")
                .releaseYear(2007)
                .classificationAge("PG-13")
                .author("Masashi Kishimoto")
                .animationStudio("Studio Pierrot")
                .inProgress(false)
                .build();

        assertNotEquals(anime1, anime2);
    }

    @Test
    void testHashCode_Consistent() {
        AnimePostRequestBody animePostRequestBody = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        int initialHashCode = animePostRequestBody.hashCode();

        for (int i = 0; i < 10; i++) {
            assertEquals(initialHashCode, animePostRequestBody.hashCode());
        }
    }

    @Test
    void testHashCode_EqualObjects() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        assertEquals(anime1.hashCode(), anime2.hashCode());
    }

    @Test
    void testHashCode_UnequalObjects() {
        AnimePostRequestBody anime1 = AnimePostRequestBody.builder()
                .name(animePostRequestBodyValid.getName())
                .synopsis(animePostRequestBodyValid.getSynopsis())
                .releaseYear(animePostRequestBodyValid.getReleaseYear())
                .classificationAge(animePostRequestBodyValid.getClassificationAge())
                .author(animePostRequestBodyValid.getAuthor())
                .animationStudio(animePostRequestBodyValid.getAnimationStudio())
                .inProgress(true)
                .build();

        AnimePostRequestBody anime2 = AnimePostRequestBody.builder()
                .name("Naruto Shippuden")
                .synopsis("A ninja story continued")
                .releaseYear(2007)
                .classificationAge("PG-13")
                .author("Masashi Kishimoto")
                .animationStudio("Studio Pierrot")
                .inProgress(false)
                .build();

        assertNotEquals(anime1.hashCode(), anime2.hashCode());
    }

    @Test
    void testToString() {
        String expectedToString = "AnimePostRequestBody(name=Naruto, synopsis=A ninja story, releaseYear=2002, classificationAge=PG-13, author=Masashi Kishimoto, animationStudio=Studio Pierrot, inProgress=true)";
        assertEquals(expectedToString, animePostRequestBodyValid.toString());
    }

    @Test
    void testSetName() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setName("Naruto");
        assertEquals("Naruto", animePostRequestBody.getName());
    }

    @Test
    void testSetSynopsis() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setSynopsis("A ninja story");
        assertEquals("A ninja story", animePostRequestBody.getSynopsis());
    }

    @Test
    void testSetReleaseYear() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setReleaseYear(2002);
        assertEquals(2002, animePostRequestBody.getReleaseYear());
    }

    @Test
    void testSetClassificationAge() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setClassificationAge("PG-13");
        assertEquals("PG-13", animePostRequestBody.getClassificationAge());
    }

    @Test
    void testSetAuthor() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setAuthor("Masashi Kishimoto");
        assertEquals("Masashi Kishimoto", animePostRequestBody.getAuthor());
    }

    @Test
    void testSetAnimationStudio() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setAnimationStudio("Studio Pierrot");
        assertEquals("Studio Pierrot", animePostRequestBody.getAnimationStudio());
    }

    @Test
    void testSetInProgress() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();
        animePostRequestBody.setInProgress(true);
        assertTrue(animePostRequestBody.isInProgress());
    }

    @Test
    void testDefaultConstructor() {
        AnimePostRequestBody animePostRequestBody = new AnimePostRequestBody();

        // Verifica se os atributos são inicializados com valores padrão ou nulos
        assertNull(animePostRequestBody.getName());
        assertNull(animePostRequestBody.getSynopsis());
        assertNull(animePostRequestBody.getReleaseYear());
        assertNull(animePostRequestBody.getClassificationAge());
        assertNull(animePostRequestBody.getAuthor());
        assertNull(animePostRequestBody.getAnimationStudio());
        assertFalse(animePostRequestBody.isInProgress());
    }
}
