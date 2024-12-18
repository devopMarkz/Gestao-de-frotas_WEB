package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDto> createVeiculo(@RequestBody CreateVeiculoDto createVeiculoDto){
        VeiculoDto veiculoDto = veiculoService.insert(createVeiculoDto);
        return ResponseEntity.ok(veiculoDto);
    }

}
