package br.com.fps.dio.academia.digital.controller;

import br.com.fps.dio.academia.digital.entity.AvaliacaoFisica;
import br.com.fps.dio.academia.digital.entity.Dto.AvaliacaoFisicaDto;
import br.com.fps.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  public AvaliacaoFisicaServiceImpl avaliacaoService;

  @GetMapping
  public List<AvaliacaoFisica> getAll() {
    return avaliacaoService.getAll();
  }

  @GetMapping("/{id}")
  public AvaliacaoFisica getById(@PathVariable Long id) {
    return avaliacaoService.getById(id);
  }

  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaDto avaliacaoDto) {
    return avaliacaoService.create(avaliacaoDto);
  }
}
