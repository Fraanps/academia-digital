package br.com.fps.dio.academia.digital.entity.Dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AvaliacaoFisicaDto {

  private Long alunoId;
  private double peso;
  private double altura;
}
