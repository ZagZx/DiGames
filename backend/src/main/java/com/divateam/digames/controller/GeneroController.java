package com.divateam.digames.controller;


import com.divateam.digames.dto.genero.GeneroRequest;
import com.divateam.digames.dto.genero.GeneroResponse;
import com.divateam.digames.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<List<GeneroResponse>> listarGeneros() {
        List<GeneroResponse> generos = generoService.listar().stream().map(GeneroResponse::new).toList();
        return ResponseEntity.ok(generos);
    }

    @PostMapping
    public ResponseEntity<GeneroResponse> criarGenero(@RequestBody @Valid GeneroRequest generoRequest) {
        GeneroResponse generoResponse = new GeneroResponse(generoService.criar(generoRequest));

        return new ResponseEntity<>(generoResponse, HttpStatus.CREATED);
    }
}
