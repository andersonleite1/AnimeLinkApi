package br.com.andersonleite.animelinkapi.dto;

import br.com.andersonleite.animelinkapi.dto.anime.AnimePutRequestBody;
import br.com.andersonleite.animelinkapi.util.AnimePutRequestBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimePutRequestBodyTest {

    private AnimePutRequestBody animePutRequestBodyValid;

    @BeforeEach
    void setUp() {
        animePutRequestBodyValid = AnimePutRequestBodyCreator.createAnimePutRequestBody();
    }

    @Test
    void testSetId() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setId(1L);
        assertEquals(1L, animePutRequestBody.getId());
    }

    @Test
    void testSetName() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setName("Naruto");
        assertEquals("Naruto", animePutRequestBody.getName());
    }

    @Test
    void testSetSynopsis() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setSynopsis("A ninja story");
        assertEquals("A ninja story", animePutRequestBody.getSynopsis());
    }

    @Test
    void testSetReleaseYear() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setReleaseYear(2002);
        assertEquals(2002, animePutRequestBody.getReleaseYear());
    }

    @Test
    void testSetClassificationAge() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setClassificationAge("PG-13");
        assertEquals("PG-13", animePutRequestBody.getClassificationAge());
    }

    @Test
    void testSetAuthor() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setAuthor("Masashi Kishimoto");
        assertEquals("Masashi Kishimoto", animePutRequestBody.getAuthor());
    }

    @Test
    void testSetAnimationStudio() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setAnimationStudio("Studio Pierrot");
        assertEquals("Studio Pierrot", animePutRequestBody.getAnimationStudio());
    }

    @Test
    void testSetInProgress() {
        AnimePutRequestBody animePutRequestBody = new AnimePutRequestBody();
        animePutRequestBody.setInProgress(true);
        assertTrue(animePutRequestBody.isInProgress());
    }

    @Test
    void testEquals_Reflexive() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );
        assertEquals(anime1, anime1);
    }

    @Test
    void testEquals_Symmetric() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        assertTrue(anime1.equals(anime2) && anime2.equals(anime1));
    }

    @Test
    void testEquals_Transitive() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime3 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        assertTrue(anime1.equals(anime2) && anime2.equals(anime3) && anime1.equals(anime3));
    }

    @Test
    void testEquals_Consistent() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        for (int i = 0; i < 10; i++) {
            assertEquals(anime1, anime2);
        }
    }

    @Test
    void testEquals_Null() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        assertNotEquals(null, anime1);
    }

    @Test
    void testEquals_DifferentClass() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        String differentClassObject = "I am a String";
        assertNotEquals(anime1, differentClassObject);
    }

    @Test
    void testEquals_DifferentFields() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(2L, "Naruto Shippuden", "A ninja story continued", 2007, "PG-13", "Masashi Kishimoto", "Studio Pierrot", false);
        assertNotEquals(anime1, anime2);
    }

    @Test
    void testHashCode_Consistent() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        int initialHashCode = anime1.hashCode();

        for (int i = 0; i < 10; i++) {
            assertEquals(initialHashCode, anime1.hashCode());
        }
    }

    @Test
    void testHashCode_EqualObjects() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        assertEquals(anime1.hashCode(), anime2.hashCode());
    }

    @Test
    void testHashCode_UnequalObjects() {
        AnimePutRequestBody anime1 = new AnimePutRequestBody(
                animePutRequestBodyValid.getId(),
                animePutRequestBodyValid.getName(),
                animePutRequestBodyValid.getSynopsis(),
                animePutRequestBodyValid.getReleaseYear(),
                animePutRequestBodyValid.getClassificationAge(),
                animePutRequestBodyValid.getAuthor(),
                animePutRequestBodyValid.getAnimationStudio(),
                true
        );

        AnimePutRequestBody anime2 = new AnimePutRequestBody(2L, "Naruto Shippuden", "A ninja story continued", 2007, "PG-13", "Masashi Kishimoto", "Studio Pierrot", false);
        assertNotEquals(anime1.hashCode(), anime2.hashCode());
    }

    @Test
    void testToString() {

        String expectedToString = "AnimePutRequestBody(id=1, name=Naruto, synopsis=A ninja story, releaseYear=2002, classificationAge=PG-13, author=Masashi Kishimoto, animationStudio=Studio Pierrot, inProgress=true)";
        assertEquals(expectedToString, animePutRequestBodyValid.toString());
    }

}
