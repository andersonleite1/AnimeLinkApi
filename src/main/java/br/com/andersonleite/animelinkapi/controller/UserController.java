package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataPatchRequestBody;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataPostRequestBody;
import br.com.andersonleite.animelinkapi.service.UserDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    UserDataService userDataService;

    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Find user by ID",
            description = "Returns a single user",
            tags = {"anime"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })
    public ResponseEntity<UserDataGetRequestBody> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userDataService.getUserById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new user",
            description = "Creates a new user. Requires admin role",
            security = @SecurityRequirement(name = "bearerAuth"),
            tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created"),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    public ResponseEntity<UserDataGetRequestBody> save(@Valid @RequestBody UserDataPostRequestBody userData) {
        return new ResponseEntity<>(userDataService.save(userData), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update an existing user",
            description = "Updates an existing user. Requires admin role",
            security = @SecurityRequirement(name = "bearerAuth"),
            tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Input"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })
    public ResponseEntity<UserDataGetRequestBody> update(@PathVariable Long id, @Valid @RequestBody UserDataPatchRequestBody userData) {
        return new ResponseEntity<>(userDataService.update(id, userData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete an user",
            description = "Deletes an user. Requires admin role",
            security = @SecurityRequirement(name = "bearerAuth"),
            tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userDataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
