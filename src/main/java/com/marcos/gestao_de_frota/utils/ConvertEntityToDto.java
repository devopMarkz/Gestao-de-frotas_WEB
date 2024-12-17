package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;

public class ConvertEntityToDto {

    public static MotoristaDto convertToMotoristaDto(Motorista motorista){
        if(motorista == null) return null;
        return new MotoristaDto(motorista.getId(), motorista.getNome(), motorista.getDisponivel(), motorista.getCnh(), motorista.getCategoriaCNH().name(), motorista.getDataNascimento());
    }

}
