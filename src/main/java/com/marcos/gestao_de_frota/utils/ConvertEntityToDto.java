package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import com.marcos.gestao_de_frota.dto.veiculo.CaminhaoDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.Caminhao;
import com.marcos.gestao_de_frota.entities.Motorista;

public class ConvertEntityToDto {

    public static MotoristaDto convertToMotoristaDto(Motorista motorista){
        if(motorista == null) return null;
        return new MotoristaDto(motorista.getId(), motorista.getNome(), motorista.getDisponivel(), motorista.getCnh(), motorista.getCategoriaCNH().name(), motorista.getDataNascimento());
    }

    public static CaminhaoDto convertToCaminhaoDto(Caminhao caminhao){
        if(caminhao == null) return null;
        return new CaminhaoDto(caminhao.getId(), caminhao.getDisponivel(), caminhao.getMarca(), caminhao.getModelo(), caminhao.getAnoFabricacao(), caminhao.getCapacidade(), caminhao.getCustoPorDia(), caminhao.getCategoriaVeiculo().name(), caminhao.getNumeroDeEixos());
    }

}
