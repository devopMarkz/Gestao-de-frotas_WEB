package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.aluguel.AluguelDto;
import com.marcos.gestao_de_frota.dto.aluguel.CreateAluguelDto;
import com.marcos.gestao_de_frota.entities.Aluguel;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.Veiculo;
import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;
import com.marcos.gestao_de_frota.repositories.AluguelRepository;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.repositories.VeiculoRepository;
import com.marcos.gestao_de_frota.services.exceptions.*;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public AluguelDto insertAluguel(CreateAluguelDto createAluguelDto){
        Motorista motorista = motoristaRepository.findByCnh(createAluguelDto.getCnh())
                .orElseThrow(() -> new MotoristaInexistenteException("Não existe motorista no sistema cadastrado com a CNH informada."));

        Veiculo veiculo = veiculoRepository.findByPlaca(createAluguelDto.getPlaca())
                .orElseThrow(() -> new VeiculoInexistenteException("Não existe veiculo no sistema cadastrado com essa placa."));

        // Verifica se tanto o motorista como o veículo estão disponíveis para que o aluguel seja efetuado
        validateDriverAndVehicleAvailability(motorista, veiculo);

        LocalDateTime dataHoraInicio = createAluguelDto.getDataHoraInicio();
        LocalDateTime dataHoraFim = validateDataHoraFim(dataHoraInicio, createAluguelDto.getDataHoraFim());

        motorista.setDisponivel(false);
        veiculo.setDisponivel(false);

        Aluguel aluguel = new Aluguel(motorista, veiculo, dataHoraInicio, dataHoraFim, StatusAluguel.EM_ANDAMENTO);

        motoristaRepository.save(motorista);
        veiculoRepository.save(veiculo);

        aluguel = aluguelRepository.save(aluguel);

        return ConvertEntityToDto.convertToAluguelDto(aluguel);
    }

    private void validateDriverAndVehicleAvailability(Motorista motorista, Veiculo veiculo){
        if(!motorista.getDisponivel()) throw new MotoristaIndisponivelException("O motorista " + motorista.getNome() + " está indisponível.");
        if(!veiculo.getDisponivel()) throw new VeiculoIndisponivelException("O veículo de placa " + veiculo.getPlaca() + " está indisponível.");
    }

    private LocalDateTime validateDataHoraFim(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim){
        if(dataHoraFim.isBefore(dataHoraInicio)){
            throw new DataFimMenorQueDataInicioException("A data final do aluguel não pode ser menor que a data inicial.");
        } else {
            return dataHoraFim;
        }
    }

}
