package br.com.cadastro.dto;

import br.com.cadastro.model.User;

public record UserDTO(
  String id,
  String name,
  String email,
  String paper
) {
  public UserDTO(User user) {
    this(
      user.getId(),
      user.getName(),
      user.getEmail(),
      user.getPaper()
    );
  }
}
