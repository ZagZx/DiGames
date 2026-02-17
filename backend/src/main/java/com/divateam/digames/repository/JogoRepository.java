package com.divateam.digames.repository;

import com.divateam.digames.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Jogo findByNomeLike(String nome);
}
