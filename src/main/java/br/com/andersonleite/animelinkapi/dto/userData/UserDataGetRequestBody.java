package br.com.andersonleite.animelinkapi.dto.userData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataGetRequestBody {
    private Long id;
    private String name;
    private String username;
    private List<String> authorities;

}
