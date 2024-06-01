package br.com.andersonleite.animelinkapi.util;

import br.com.andersonleite.animelinkapi.domain.Anime;
import br.com.andersonleite.animelinkapi.domain.UserData;

public class UserDataCreator {
    public static UserData createValidUserData(){
        return UserData.builder()
                .id(1L)
                .name("John Doe")
                .username("john_doe")
                .password("password456")
                .authorities("ROLE_USER,ROLE_ADMIN")
                .build();
    }
}
