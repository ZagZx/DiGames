package com.divateam.digames.service;

import com.divateam.digames.dto.jogo.JogoRequest;
import com.divateam.digames.entity.Genero;
import com.divateam.digames.entity.Jogo;
import com.divateam.digames.repository.GeneroRepository;
import com.divateam.digames.repository.JogoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {
    private static final Logger log = LoggerFactory.getLogger(JogoService.class);
    private final JogoRepository jogoRepository;
    private final GeneroRepository generoRepository;

    public JogoService(JogoRepository jogoRepository, GeneroRepository generoRepository) {
        this.jogoRepository = jogoRepository;
        this.generoRepository = generoRepository;
    }

    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    public Jogo buscar(Long id) {
        return jogoRepository.findById(id).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado")
        );
    }

    public Jogo criar(JogoRequest jogoRequest) {
        if (jogoRepository.existsJogoByNome(jogoRequest.nome())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um jogo com esse nome");
        }

        List<Genero> generos = generoRepository.findAllById(jogoRequest.generosId());

        Jogo jogo = new Jogo(
                jogoRequest.nome(),
                jogoRequest.status(),
                jogoRequest.preco(),
                jogoRequest.descricao(),
                generos
        );

        return jogoRepository.save(jogo);
    }

    public void deletar(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
        jogoRepository.deleteById(id);
    }
}
