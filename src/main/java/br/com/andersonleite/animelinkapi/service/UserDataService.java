package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.UserData;
import br.com.andersonleite.animelinkapi.dto.userData.UserDataGetRequestBody;
import br.com.andersonleite.animelinkapi.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDataService implements UserDetailsService {
  private final UserDataRepository userDataRepository;

  @Autowired
  public UserDataService(UserDataRepository userDataRepository) {
    this.userDataRepository = userDataRepository;
  }

  public UserDataGetRequestBody getUserById(Long id) {
     UserData userDataFound = userDataRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

     return new UserDataGetRequestBody(
             userDataFound.getId(),
             userDataFound.getName(),
             userDataFound.getUsername(),
             userDataFound.getAuthorities().stream().map(authority -> authority.getAuthority())
                     .collect(Collectors.toList())
     );
  }

  @Override
  public UserDetails loadUserByUsername(String username){
    return Optional.ofNullable(userDataRepository.findByUsername(username))
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

}
