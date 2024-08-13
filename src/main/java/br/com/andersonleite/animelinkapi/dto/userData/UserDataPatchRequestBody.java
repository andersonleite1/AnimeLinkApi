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
public class UserDataPatchRequestBody {
    private String name;
    @NotBlank(message = "The user username cannot be blank")
    private String username;
    @NotEmpty(message = "The user authorities cannot be empty")
    private String authorities;

}
