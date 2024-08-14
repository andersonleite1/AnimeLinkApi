package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.UserData;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataPatchRequestBody;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataPostRequestBody;
import br.com.andersonleite.animelinkapi.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDataService implements UserDetailsService {
  private final UserDataRepository userDataRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UserDataService(UserDataRepository userDataRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
    this.userDataRepository = userDataRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserDataGetRequestBody getUserById(Long id) {
     UserData userDataFound = userDataRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
     return userDataToDto(userDataFound);
  }

  @Override
  public UserDetails loadUserByUsername(String username){
    return Optional.ofNullable(userDataRepository.findByUsername(username))
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  public UserDataGetRequestBody save(UserDataPostRequestBody user) {
      String encodedPassword = passwordEncoder.encode(user.getPassword());

      UserData userSaved = userDataRepository.save(UserData.builder()
                      .name(user.getName())
                      .username(user.getUsername())
                      .password(encodedPassword)
                      .authorities(user.getAuthorities())
              .build());
      return userDataToDto(userSaved);
  }

    public UserDataGetRequestBody update(Long userId, UserDataPatchRequestBody user) {

        UserData userRecovered = userDataRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        userRecovered.setName(user.getName());
        userRecovered.setUsername(user.getUsername());
        userRecovered.setAuthorities(user.getAuthorities());

        UserData userSaved = userDataRepository.save(userRecovered);
        return userDataToDto(userSaved);
    }

    public static UserDataGetRequestBody userDataToDto(UserData userSaved) {
        return UserDataGetRequestBody.builder()
                .id(userSaved.getId())
                .name(userSaved.getName())
                .username(userSaved.getUsername())
                .authorities(userSaved.getAuthorities().stream()
                        .map(authority -> authority.getAuthority())
                        .collect(Collectors.toList()))
                .build();
    }

    public void delete(Long id) {
        UserDataGetRequestBody user = getUserById(id);
      userDataRepository.deleteById(user.getId());
    }
}
