package br.com.fps.dio.academia.digital.service;

import br.com.fps.dio.academia.digital.entity.Aluno;
import br.com.fps.dio.academia.digital.entity.AvaliacaoFisica;
import br.com.fps.dio.academia.digital.entity.Dto.AlunoDto;
import br.com.fps.dio.academia.digital.entity.Dto.AlunoUpdateDto;

import java.util.List;

public interface IAlunoService {


  /**
   * Cria um Aluno e salva no banco de dados.
   * @param form - formulário referente aos dados para criação de um Aluno no banco de dados.
   * @return - Aluno recém-criado.
   */
  Aluno create(AlunoDto form);

  /**
   * Retorna um Aluno que está no banco de dados de acordo com seu Id.
   * @param id - id do Aluno que será exibido.
   * @return - Aluno de acordo com o Id fornecido.
   */
  Aluno getById(Long id);

  /**
   * Retorna todos os Alunos que estão no banco de dados.
   * @return - Uma lista os Alunos que estão salvas no DB.
   */
  //List<Aluno> getAll();

  List<Aluno> getAll(String dataDeNascimento);

  /**
   * Atualiza o Aluno.
   * @param id - id do Aluno que será atualizado.
   * @param formUpdate - formulário referente aos dados necessários para atualização do Aluno
   * no banco de dados.
   * @return - Aluno recém-atualizado.
   */
  Aluno update(Long id, AlunoUpdateDto formUpdate);

  /**
   * Deleta um Aluno específico.
   * @param id - id do Aluno que será removido.
   */
  void delete(Long id);

  List<AvaliacaoFisica>getAllAvaliacaoFisica(Long id);
}
