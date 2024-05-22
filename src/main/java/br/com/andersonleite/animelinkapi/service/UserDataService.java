package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDataService implements UserDetailsService {
  private final UserDataRepository userDataRepository;

  @Override
  public UserDetails loadUserByUsername(String username){
    return Optional.ofNullable(userDataRepository.findByUsername(username))
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

}
