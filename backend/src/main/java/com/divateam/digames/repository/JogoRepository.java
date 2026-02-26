package com.divateam.digames.repository;

import com.divateam.digames.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    boolean existsJogoByNome(String nome);
    List<Jogo> findAllByNomeLike(String nome);
}
