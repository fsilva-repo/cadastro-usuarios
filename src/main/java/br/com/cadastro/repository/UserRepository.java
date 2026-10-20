package br.com.cadastro.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cadastro.model.User;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByEmail(String email);
  boolean existexistsByEmail(String email);
}
