package br.com.fps.dio.academia.digital.repository;

import br.com.fps.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  @Query("SELECT a FROM Aluno a WHERE a.dataDeNascimento= :dataDeNascimento")
  List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

  @Query("SELECT a FROM Aluno a WHERE EXTRACT(MONTH FROM a.dataDeNascimento) = :mes")
  List<Aluno> findByMesDeNascimento(@Param("mes") int mes);
}
