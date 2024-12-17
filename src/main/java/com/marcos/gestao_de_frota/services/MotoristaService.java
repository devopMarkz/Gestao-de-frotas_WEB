package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaInexistenteException;
import com.marcos.gestao_de_frota.utils.ConvertDtoToEntity;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public MotoristaDto insert(CreateMotoristaDto createMotoristaDto){
        Motorista motorista = ConvertDtoToEntity.convertToEntity(createMotoristaDto);
        motorista = motoristaRepository.save(motorista);
        return ConvertEntityToDto.convertToMotoristaDto(motorista);
    }

    @Transactional(readOnly = true)
    public Page<MotoristaDto> getAll(Pageable pageable){
        Page<Motorista> motoristas = motoristaRepository.findAll(pageable);
        return motoristas.map(ConvertEntityToDto::convertToMotoristaDto);
    }

    @Transactional(readOnly = true)
    public MotoristaDto getById(Long id){
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new MotoristaInexistenteException("O motorista de id " + id + " não existe no sistema."));
        return ConvertEntityToDto.convertToMotoristaDto(motorista);
    }

}
