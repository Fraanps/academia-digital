package br.com.fps.dio.academia.digital.entity.Dto;

import br.com.fps.dio.academia.digital.infra.jackson.deser.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente.")
  @CPF(message = "'${validatedValue}' é inválido" )
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente")
  @Past(message = "Data'${validatedValue}' é inválida.")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataDeNascimento;
}
