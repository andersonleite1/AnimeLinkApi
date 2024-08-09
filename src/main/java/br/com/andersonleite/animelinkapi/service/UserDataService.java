package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService implements UserDetailsService {
  private final UserDataRepository userDataRepository;

  @Autowired
  public UserDataService(UserDataRepository userDataRepository) {
    this.userDataRepository = userDataRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username){
    return Optional.ofNullable(userDataRepository.findByUsername(username))
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

}
