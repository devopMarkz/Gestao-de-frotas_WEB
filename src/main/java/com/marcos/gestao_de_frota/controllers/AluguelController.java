package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.aluguel.AluguelDto;
import com.marcos.gestao_de_frota.dto.aluguel.CreateAluguelDto;
import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;
import com.marcos.gestao_de_frota.services.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping
    public ResponseEntity<Page<AluguelDto>> findAll(@RequestParam(name = "startDate", defaultValue = "") LocalDateTime startDate,
                                                    @RequestParam(name = "endDate", defaultValue = "") LocalDateTime endDate,
                                                    @RequestParam(name = "statusAluguel", defaultValue = "EM_ANDAMENTO") String statusAluguel,
                                                    @PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<AluguelDto> aluguelDtos = aluguelService.getAlugueis(startDate, endDate, StatusAluguel.valueOf(statusAluguel), pageable);
        return ResponseEntity.ok(aluguelDtos);
    }

}
