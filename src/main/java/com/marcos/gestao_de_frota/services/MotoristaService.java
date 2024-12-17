package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.MotoristaDto;
import com.marcos.gestao_de_frota.dto.UpdateMotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaInexistenteException;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaJaExistenteException;
import com.marcos.gestao_de_frota.utils.ConvertDtoToEntity;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public MotoristaDto insert(CreateMotoristaDto createMotoristaDto){
        try {
            Motorista motorista = ConvertDtoToEntity.convertToEntity(createMotoristaDto);
            motorista = motoristaRepository.save(motorista);
            return ConvertEntityToDto.convertToMotoristaDto(motorista);
        } catch (DataIntegrityViolationException e){
            throw new MotoristaJaExistenteException("Já existe um motorista cadastrado com a CNH " + createMotoristaDto.getCnh());
        }
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

    @Transactional
    public MotoristaDto updateMotorista(UpdateMotoristaDto motoristaDto){
        Motorista motorista = motoristaRepository.findById(motoristaDto.getId())
                .orElseThrow(() -> new MotoristaInexistenteException("O motorista de id " + motoristaDto.getId() + " não existe no sistema."));

        // Verifica se já existe um motorista com a CNH pra qual o usuário pretende atualizar
        validateMotoristaCnhExists(motorista, motoristaDto);

        Motorista motoristaAtualizado = attMotorista(motorista, motoristaDto);
        motoristaRepository.save(motoristaAtualizado);
        return ConvertEntityToDto.convertToMotoristaDto(motoristaAtualizado);
    }

    /**
     * Metodo que atualiza um Motorista com base nos dados recebidos em MotoristaDTO
     * @param motorista A entidade mapeada de motorista que deverá ser atualizada
     * @param motoristaDto O DTO recebido do usuário com os dados já atualizados
     * @return A entidade Motorista com os dados atualizados
     */
    private Motorista attMotorista(Motorista motorista, UpdateMotoristaDto motoristaDto){
        if(motoristaDto == null) return motorista;
        Optional.ofNullable(motoristaDto.getNome()).ifPresent(motorista::setNome);
        Optional.ofNullable(motoristaDto.getCnh()).ifPresent(motorista::setCnh);
        Optional.ofNullable(motoristaDto.getCategoriaCNH()).ifPresent(s -> motorista.setCategoriaCNH(CategoriaCNH.valueOf(s)));
        return motorista;
    }

    /**
     * Metodo que verifica se já existe um motorista com a CNH pra qual o usuário pretende atualizar
     * @param motorista Entidade que será atualizada
     * @param motoristaDto DTO com os dados atualizados que serão passados para a entidade
     * @throws MotoristaJaExistenteException Lançada caso já exista um motorista com essa CNH
     */
    private void validateMotoristaCnhExists(Motorista motorista, UpdateMotoristaDto motoristaDto){
        if(motoristaRepository.findByCnh(motoristaDto.getCnh()) != null){
            if (motoristaRepository.findByCnh(motoristaDto.getCnh()).getId() != motorista.getId()){
                throw new MotoristaJaExistenteException("Já existe um motorista cadastrado com a CNH " + motoristaDto.getCnh());
            }
        }
    }

}
