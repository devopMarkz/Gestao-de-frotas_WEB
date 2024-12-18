package com.marcos.gestao_de_frota.factory;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.entities.Veiculo;

public interface VeiculoFactory {
    Veiculo criarVeiculo(CreateVeiculoDto createVeiculoDto);
}
