package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.utils.ConvertDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public CreateMotoristaDto createMotorista(CreateMotoristaDto motoristaDto){
        Motorista motorista = ConvertDtoToEntity.convertToEntity(motoristaDto);

    }

}
