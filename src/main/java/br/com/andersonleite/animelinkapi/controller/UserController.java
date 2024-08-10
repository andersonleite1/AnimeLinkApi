package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataPostRequestBody;
import br.com.andersonleite.animelinkapi.service.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDataGetRequestBody> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userDataService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDataGetRequestBody> save(@Valid @RequestBody UserDataPostRequestBody userData) {
        return new ResponseEntity<>(userDataService.save(userData), HttpStatus.CREATED);
    }
}
