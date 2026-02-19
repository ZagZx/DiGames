package com.divateam.digames.service;

import com.divateam.digames.dto.jogo.JogoRequestDto;
import com.divateam.digames.entity.Genero;
import com.divateam.digames.entity.Jogo;
import com.divateam.digames.repository.GeneroRepository;
import com.divateam.digames.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;
    private final GeneroRepository generoRepository;

    public JogoService(JogoRepository jogoRepository, GeneroRepository generoRepository) {
        this.jogoRepository = jogoRepository;
        this.generoRepository = generoRepository;
    }

    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    public Jogo criar(JogoRequestDto dto) {
        List<Genero> generos = generoRepository.findAllById(dto.generosId());

        Jogo jogo = new Jogo(
                dto.nome(),
                dto.status(),
                dto.preco(),
                dto.descricao(),
                generos
        );

        return jogoRepository.save(jogo);
    }
}
