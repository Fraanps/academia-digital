package br.com.fps.dio.academia.digital.entity.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MatriculaDto {

  @NotNull(message = "Preencha o campo corretamente")
  @Positive(message = "O id do aluno precisa ser positivo")
  private Long alunoId;

}
