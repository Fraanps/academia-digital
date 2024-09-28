package br.com.fps.dio.academia.digital.service.impl;

import br.com.fps.dio.academia.digital.entity.Aluno;
import br.com.fps.dio.academia.digital.entity.AvaliacaoFisica;
import br.com.fps.dio.academia.digital.entity.Dto.AvaliacaoFisicaDto;
import br.com.fps.dio.academia.digital.entity.Dto.AvaliacaoFisicaUpdateDto;
import br.com.fps.dio.academia.digital.repository.AlunoRepository;
import br.com.fps.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import br.com.fps.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaDto avaliacaoDto) {
    AvaliacaoFisica avaliacao = new AvaliacaoFisica();
    //pegando o aluno
    Aluno aluno = alunoRepository.findById(avaliacaoDto.getAlunoId()).get();
    avaliacao.setAluno(aluno);
    avaliacao.setPeso(avaliacaoDto.getPeso());
    avaliacao.setAltura(avaliacaoDto.getAltura());
    return avaliacaoRepository.save(avaliacao);
  }

  @Override
  public AvaliacaoFisica getById(Long id) {
    return avaliacaoRepository.findById(id).orElse(null);
  }

  @Override
  public List<AvaliacaoFisica> getAll() {
    return avaliacaoRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDto formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
