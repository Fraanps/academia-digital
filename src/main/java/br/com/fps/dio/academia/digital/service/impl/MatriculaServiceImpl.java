package br.com.fps.dio.academia.digital.service.impl;

import br.com.fps.dio.academia.digital.entity.Aluno;
import br.com.fps.dio.academia.digital.entity.Dto.MatriculaDto;
import br.com.fps.dio.academia.digital.entity.Matricula;
import br.com.fps.dio.academia.digital.repository.AlunoRepository;
import br.com.fps.dio.academia.digital.repository.MatriculaRepository;
import br.com.fps.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaDto matriculaDto) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(matriculaDto.getAlunoId()).get();
    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll() {
    return List.of();
  }

  @Override
  public List<Matricula> getAll(String bairro) {
    if(bairro == null){
      return matriculaRepository.findAll();
    } else {
      return matriculaRepository.findyByAlunoBairro(bairro);
    }
  }

//  @Override
//  public List<Matricula> getAll(String bairro) {
//    if(bairro == null){
//      return matriculaRepository.findAll();
//    }else{
//      return matriculaRepository.findyByAlunoBairro(bairro);
//    }
//  }

  @Override
  public void delete(Long id) {}


}
