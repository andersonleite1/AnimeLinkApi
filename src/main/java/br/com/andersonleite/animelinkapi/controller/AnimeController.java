package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.dto.AnimePostRequestBody;
import br.com.andersonleite.animelinkapi.dto.AnimePutRequestBody;
import br.com.andersonleite.animelinkapi.service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
  private final AnimeService animeService;

  @GetMapping
  @Operation(summary = "List all anime's paginated",
          description = "The default size is 20, use the parameter size to change the default value",
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful Operation"),
          @ApiResponse(responseCode = "204", description = "No Content"),
          @ApiResponse(responseCode = "400", description = "Invalid Parameters")
  })
  public ResponseEntity<Page<Anime>> list(@ParameterObject Pageable pageable) {
    return ResponseEntity.ok(animeService.listAll(pageable));
  }

  @GetMapping(path = "/{id}")
  @Operation(summary = "Find anime by ID",
          description = "Returns a single anime",
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful Operation"),
          @ApiResponse(responseCode = "404", description = "Anime Not Found")
  })
  public ResponseEntity<Anime> findById(@PathVariable long id) {
    return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
  }

  @GetMapping(path = "by-id/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Find anime by ID (Admin Only)",
          description = "Returns a single anime. Requires admin role",
          security = @SecurityRequirement(name = "bearerAuth"),
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful Operation"),
          @ApiResponse(responseCode = "403", description = "Forbidden"),
          @ApiResponse(responseCode = "404", description = "Anime Not Found")
  })
  public ResponseEntity<Anime> findByIdAuthenticationPrincipal(@PathVariable long id) {
    return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
  }

  @GetMapping(path = "/find")
  @Operation(summary = "Find animes by name",
          description = "Returns a list of animes with the specified name",
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful Operation"),
          @ApiResponse(responseCode = "404", description = "Anime Not Found")
  })
  public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(animeService.findByName(name));
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Create a new anime",
          description = "Creates a new anime. Requires admin role",
          security = @SecurityRequirement(name = "bearerAuth"),
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Anime Created"),
          @ApiResponse(responseCode = "400", description = "Invalid Input")
  })
  public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody) {
    return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
  }

  @PutMapping
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Update an existing anime",
          description = "Updates an existing anime. Requires admin role",
          security = @SecurityRequirement(name = "bearerAuth"),
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "204", description = "Successful Operation"),
          @ApiResponse(responseCode = "400", description = "Invalid Input"),
          @ApiResponse(responseCode = "404", description = "Anime Not Found")
  })
  public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
    animeService.replace(animePutRequestBody);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Delete an anime",
          description = "Deletes an anime. Requires admin role",
          security = @SecurityRequirement(name = "bearerAuth"),
          tags = {"anime"})
  @ApiResponses(value = {
          @ApiResponse(responseCode = "204", description = "Successful Operation"),
          @ApiResponse(responseCode = "400", description = "Invalid ID"),
          @ApiResponse(responseCode = "404", description = "Anime Not Found")
  })
  public ResponseEntity<Void> delete(@PathVariable long id) {
    animeService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
