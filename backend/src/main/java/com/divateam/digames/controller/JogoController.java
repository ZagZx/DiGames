package com.divateam.digames.controller;

import com.divateam.digames.dto.jogo.JogoRequestDto;
import com.divateam.digames.dto.jogo.JogoResponseDto;
import com.divateam.digames.entity.Jogo;
import com.divateam.digames.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Jogo>> listarJogos() {
        return ResponseEntity.ok(jogoService.listar());
    }

    @PostMapping
    public ResponseEntity<JogoResponseDto> criarJogo(@Valid @RequestBody JogoRequestDto dto) {
        Jogo jogo = jogoService.criar(dto);
        JogoResponseDto response = new JogoResponseDto(jogo);

        return ResponseEntity.ok(response);
    }
}
