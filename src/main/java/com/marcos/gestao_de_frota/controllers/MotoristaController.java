package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.services.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    /**
     * Metodo responsavel por cadastrar um novo motorista no sistema.
     * @param createMotoristaDto DTO dedicado a criação de um novo motorista.
     * @return MotoristaDTO com status 201
     */
    @PostMapping
    public ResponseEntity<MotoristaDto> createMotorista(@Valid @RequestBody CreateMotoristaDto createMotoristaDto){
        MotoristaDto motoristaDto = motoristaService.insert(createMotoristaDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(motoristaDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(motoristaDto);
    }

    /**
     * Metodo responsável por realizar uma busca de todos os motoristas cadastrados no sistema.
     * @param pageable Representa as configurações da paginação, cujo valor padrão para página ativa é 0 e valor padrão
     *                 para quantidade de elementos presentes numa página é 10.
     * @return Um resultado paginado com todos os motoristas cadastrados no sistema.
     */
    @GetMapping
    public ResponseEntity<Page<MotoristaDto>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok(motoristaService.getAll(pageable));
    }


}