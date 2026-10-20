package br.com.cadastro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
  @NotBlank(message = "nome obrigatório")
  @Size(max = 100, message = "máximo de 10 caracteres")
  String name,
  @NotBlank(message = "email obrigatório")
  @Email(message = "email invalido")
  String email,
  @NotBlank(message = "senha obrigatória")
  @Size(min = 8, max = 16, message = "a senha deve ter entre 8 e 16 caracteres")
  String passwd
) {}
