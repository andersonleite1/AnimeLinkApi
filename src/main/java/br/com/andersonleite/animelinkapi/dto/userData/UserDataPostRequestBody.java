package br.com.andersonleite.animelinkapi.dto.userData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataPostRequestBody {
    private String name;

    @NotBlank(message = "The user username cannot be empty")
    private String username;

    @NotBlank(message = "The user password cannot be empty")
    private String password;

    @NotBlank(message = "The user authorities cannot be empty")
    private String authorities;
}
