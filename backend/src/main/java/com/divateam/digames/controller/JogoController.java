package com.divateam.digames.controller;

import com.divateam.digames.dto.jogo.JogoRequestDto;
import com.divateam.digames.dto.jogo.JogoResponseDto;
import com.divateam.digames.entity.Jogo;
import com.divateam.digames.service.JogoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<JogoResponseDto>> listarJogos() {
//        List<Jogo> jogos = jogoService.listar();
        List<JogoResponseDto> response = jogoService.listar().stream().map(JogoResponseDto::new).toList();
/*
        OU
        List<JogoResponseDto> response = jogos.stream().map(jogo -> new JogoResponseDto(jogo).toList();
        OU
        List<JogoResponseDto> response = new ArrayList<>();
        for (Jogo jogo : jogos) {
            response.add(new JogoResponseDto(jogo));
        }
*/
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<JogoResponseDto> criarJogo(@RequestBody @Valid JogoRequestDto dto) {
        JogoResponseDto response = new JogoResponseDto(jogoService.criar(dto));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
