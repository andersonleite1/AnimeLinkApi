package br.com.andersonleite.animelinkapi.repository;

import br.com.andersonleite.animelinkapi.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

  UserData findByUsername(String username);
}
