package com.divateam.digames.controller;

import com.divateam.digames.dto.jogo.JogoRequest;
import com.divateam.digames.dto.jogo.JogoResponse;
import com.divateam.digames.service.JogoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<JogoResponse>> listarJogos() {
//        List<Jogo> jogos = jogoService.listar();
        List<JogoResponse> jogos = jogoService.listar().stream().map(JogoResponse::new).toList();
/*
        OU
        List<JogoResponseDto> jogos = jogos.stream().map(jogo -> new JogoResponseDto(jogo).toList();
        OU
        List<JogoResponseDto> jogos = new ArrayList<>();
        for (Jogo jogo : jogos) {
            jogos.add(new JogoResponseDto(jogo));
        }
*/
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponse> buscarJogo(@PathVariable Long id) {
        JogoResponse jogoResponse = new JogoResponse(jogoService.buscar(id));
        return ResponseEntity.ok(jogoResponse);
    }

    @PostMapping
    public ResponseEntity<JogoResponse> criarJogo(@RequestBody @Validated JogoRequest jogoRequest) {
        JogoResponse jogoResponse = new JogoResponse(jogoService.criar(jogoRequest));

        return new ResponseEntity<>(jogoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable Long id) {
        jogoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
