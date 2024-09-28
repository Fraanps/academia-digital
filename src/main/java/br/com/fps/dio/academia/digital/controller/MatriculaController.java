package br.com.fps.dio.academia.digital.controller;

import br.com.fps.dio.academia.digital.entity.Dto.MatriculaDto;
import br.com.fps.dio.academia.digital.entity.Matricula;
import br.com.fps.dio.academia.digital.service.impl.MatriculaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl matriculaService;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaDto matriculaDto){
    return matriculaService.create(matriculaDto);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
    return matriculaService.getAll(bairro);
  }
}
