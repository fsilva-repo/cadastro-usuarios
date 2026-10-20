package br.com.cadastro.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cadastro.dto.RegisterDTO;
import br.com.cadastro.dto.UserDTO;
import br.com.cadastro.model.User;
import br.com.cadastro.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  
  public UserDTO register(RegisterDTO data) {
    String email = data.email().trim().toLowerCase();

    if (repository.existexistsByEmail(email)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "email já cadastrado");
    }

    User user = new User(data.name().trim(), email, passwordEncoder.encode(data.passwd()));
    user.setPaper("ROLE_USER");

    user = repository.save(user);

    return new UserDTO(user);

  }
}
