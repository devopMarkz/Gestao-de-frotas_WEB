package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.services.VeiculoService;
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
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDto> createVeiculo(@Valid @RequestBody CreateVeiculoDto createVeiculoDto){
        VeiculoDto veiculoDto = veiculoService.insert(createVeiculoDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculoDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(veiculoDto);
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDto>> findAll(@RequestParam(name = "disponivel", defaultValue = "true") String disponivel,
                                                    @RequestParam(name = "categoriaVeiculo", defaultValue = "") String categoriaVeiculo,
                                                    @PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<VeiculoDto> veiculoDtos = veiculoService.getAll(disponivel, categoriaVeiculo, pageable);
        return ResponseEntity.ok(veiculoDtos);
    }

}
