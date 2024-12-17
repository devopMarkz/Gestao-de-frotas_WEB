package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.services.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<MotoristaDto> createMotorista(@Valid @RequestBody CreateMotoristaDto createMotoristaDto){
        MotoristaDto motoristaDto = motoristaService.insert(createMotoristaDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(motoristaDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(motoristaDto);
    }

}
