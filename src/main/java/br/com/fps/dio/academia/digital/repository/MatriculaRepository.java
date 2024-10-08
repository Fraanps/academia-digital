package br.com.fps.dio.academia.digital.repository;

import br.com.fps.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

  @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro")
  List<Matricula> findyByAlunoBairro(@Param("bairro") String bairro);
}
