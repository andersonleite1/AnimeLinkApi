package br.com.andersonleite.animelinkapi.controller;


import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.dto.anime.AnimePostRequestBody;
import br.com.andersonleite.animelinkapi.dto.anime.AnimePutRequestBody;
import br.com.andersonleite.animelinkapi.service.AnimeService;
import br.com.andersonleite.animelinkapi.util.AnimeCreator;
import br.com.andersonleite.animelinkapi.util.AnimePostRequestBodyCreator;
import br.com.andersonleite.animelinkapi.util.AnimePutRequestBodyCreator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@ExtendWith(SpringExtension.class)
class AnimeControllerTest {
  @InjectMocks
  private AnimeController animeController;
  @Mock
  private AnimeService animeServiceMock;

  @BeforeEach
  void setUp(){
    PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
    BDDMockito.when(animeServiceMock.listAll(ArgumentMatchers.any()))
        .thenReturn(animePage);

    BDDMockito.when(animeServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
        .thenReturn(AnimeCreator.createValidAnime());

    BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
        .thenReturn(List.of(AnimeCreator.createValidAnime()));

    BDDMockito.when(animeServiceMock.save(ArgumentMatchers.any(AnimePostRequestBody.class)))
        .thenReturn(AnimeCreator.createValidAnime());

    BDDMockito.doNothing().when(animeServiceMock).replace(ArgumentMatchers.any(AnimePutRequestBody.class));

    BDDMockito.doNothing().when(animeServiceMock).delete(ArgumentMatchers.anyLong());
  }

  @Test
  @DisplayName("list returns list of animes inside page object when successful")
  void list_ReturnsListOfAnimesInsidePageObject_WhenSuccessful() {
    String expectedName = AnimeCreator.createValidAnime().getName();

    Page<Anime> animePage = animeController.list(PageRequest.of(1, 1)).getBody();

    assertThat(animePage).isNotNull();

    assertThat(animePage.toList())
            .isNotEmpty()
            .hasSize(1);

    assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
  }

  @Test
  @DisplayName("findById returns anime when successful")
  void findById_ReturnsAnime_WhenSuccessful() {
    Long expectedId = AnimeCreator.createValidAnime().getId();

    Anime anime = animeController.findById(1L).getBody();

    assertThat(anime).isNotNull();

    assertThat(anime.getId()).isEqualTo(expectedId);
  }

  @Test
  @DisplayName("findByName returns list of animes when successful")
  void findByName_ReturnsListOfAnimes_WhenSuccessful() {
    String expectedName = AnimeCreator.createValidAnime().getName();

    List<Anime> animes = animeController.findByName("Naruto").getBody();

    assertThat(animes)
            .isNotNull()
            .isNotEmpty()
            .hasSize(1);

    assertThat(animes.get(0).getName()).isEqualTo(expectedName);
  }

  @Test
  @DisplayName("save returns anime when successful")
  void save_ReturnsAnime_WhenSuccessful() {
    Anime anime = animeController.save(AnimePostRequestBodyCreator.createAnimePostRequestBody()).getBody();

    assertThat(anime).isNotNull().isEqualTo(AnimeCreator.createValidAnime());
  }

  @Test
  @DisplayName("replace updates anime when successful")
  void replace_UpdatesAnime_WhenSuccessful() {
    assertThatCode(() -> animeController.replace(AnimePutRequestBodyCreator.createAnimePutRequestBody()))
            .doesNotThrowAnyException();

    ResponseEntity<Void> entity = animeController.replace(AnimePutRequestBodyCreator.createAnimePutRequestBody());

    assertThat(entity).isNotNull();
    assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  @DisplayName("delete removes anime when successful")
  void delete_RemovesAnime_WhenSuccessful() {
    assertThatCode(() -> animeController.delete(1L)).doesNotThrowAnyException();

    ResponseEntity<Void> entity = animeController.delete(1L);

    assertThat(entity).isNotNull();

    assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

}
