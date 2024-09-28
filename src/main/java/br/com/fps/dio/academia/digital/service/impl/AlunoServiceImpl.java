package br.com.fps.dio.academia.digital.service.impl;


import br.com.fps.dio.academia.digital.entity.Aluno;
import br.com.fps.dio.academia.digital.entity.AvaliacaoFisica;
import br.com.fps.dio.academia.digital.entity.Dto.AlunoDto;
import br.com.fps.dio.academia.digital.entity.Dto.AlunoUpdateDto;
import br.com.fps.dio.academia.digital.infra.utils.JavaTimeUtils;
import br.com.fps.dio.academia.digital.repository.AlunoRepository;
import br.com.fps.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import br.com.fps.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {


  @Autowired
  private AlunoRepository alunoRepository;
  @Autowired
  private AvaliacaoFisicaRepository avaliacaoRepository;


  @Override
  public Aluno create(AlunoDto alunoDto) {
    Aluno aluno = new Aluno();
    aluno.setNome(alunoDto.getNome());
    aluno.setCpf(alunoDto.getCpf());
    aluno.setBairro(alunoDto.getBairro());
    aluno.setDataDeNascimento(alunoDto.getDataDeNascimento());
    return alunoRepository.save(aluno);
  }

  @Override
  public Aluno getById(Long id) {
    return alunoRepository.findById(id).orElse(null);
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {
    if (dataDeNascimento == null){
      return alunoRepository.findAll();
    } else {
      LocalDate date = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      int mes = date.getMonthValue(); // extrai o mês da data
      return alunoRepository.findByMesDeNascimento(mes);
    }

  }

  @Override
  public Aluno update(Long id, AlunoUpdateDto formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
    Aluno aluno = alunoRepository.findById(id).get();
    return aluno.getAvaliacoes();
  }




  }
