package br.com.andersonleite.animelinkapi.controller;

import br.com.andersonleite.animelinkapi.domain.UserData;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
import br.com.andersonleite.animelinkapi.service.UserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
