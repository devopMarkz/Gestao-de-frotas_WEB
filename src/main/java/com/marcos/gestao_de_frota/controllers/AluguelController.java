package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.aluguel.AluguelDto;
import com.marcos.gestao_de_frota.dto.aluguel.CreateAluguelDto;
import com.marcos.gestao_de_frota.services.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping
    public ResponseEntity<AluguelDto> createAluguel(@Valid @RequestBody CreateAluguelDto createAluguelDto){
        AluguelDto aluguelDto = aluguelService.insertAluguel(createAluguelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelDto);
    }

}
