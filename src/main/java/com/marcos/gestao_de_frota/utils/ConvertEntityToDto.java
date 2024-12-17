package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;

public class ConvertEntityToDto {

    public static MotoristaDto convertToMotoristaDto(Motorista motorista){
        if(motorista == null) return null;
        return new MotoristaDto(motorista.getId(), motorista.getDisponivel(), motorista.getCnh(), motorista.getCategoriaCNH(), motorista.getDataNascimento());
    }

}
