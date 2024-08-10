package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.UserData;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
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

     return UserDataGetRequestBody.builder()
             .id(userDataFound.getId())
             .name(userDataFound.getName())
             .username(userDataFound.getUsername())
             .authorities(userDataFound.getAuthorities().stream().map(authority -> authority.getAuthority())
                     .collect(Collectors.toList()))
             .build();
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

      return UserDataGetRequestBody.builder()
              .id(userSaved.getId())
              .name(userSaved.getName())
              .username(userSaved.getUsername())
              .authorities(userSaved.getAuthorities().stream().map(authority -> authority.getAuthority())
                      .collect(Collectors.toList()))
              .build();
  }

}
