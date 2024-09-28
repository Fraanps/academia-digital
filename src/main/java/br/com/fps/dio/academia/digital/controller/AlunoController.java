package br.com.fps.dio.academia.digital.controller;

import br.com.fps.dio.academia.digital.entity.Aluno;
import br.com.fps.dio.academia.digital.entity.AvaliacaoFisica;
import br.com.fps.dio.academia.digital.entity.Dto.AlunoDto;
import br.com.fps.dio.academia.digital.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl alunoService;

  @GetMapping("/{id}")
  public Aluno getById(@PathVariable Long id) {
    return alunoService.getById(id);
  }

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoDto alunoDto) {
    return alunoService.create(alunoDto);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
    return alunoService.getAllAvaliacaoFisica(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
    return alunoService.getAll(dataDeNascimento);
  }


}
