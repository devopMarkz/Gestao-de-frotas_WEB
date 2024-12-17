package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;

public class ConvertDtoToEntity {

    public static Motorista convertToEntity(CreateMotoristaDto dto){
        if(dto == null) return null;
        return new Motorista(null, dto.getNome(), dto.getDisponivel(), dto.getCnh(), CategoriaCNH.valueOf(dto.getCategoriaCNH()), dto.getDataNascimento());
    }

}
