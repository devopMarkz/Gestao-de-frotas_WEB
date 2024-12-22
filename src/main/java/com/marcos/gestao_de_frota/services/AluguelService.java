package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.aluguel.AluguelDto;
import com.marcos.gestao_de_frota.dto.aluguel.CreateAluguelDto;
import com.marcos.gestao_de_frota.entities.Aluguel;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.Veiculo;
import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;
import com.marcos.gestao_de_frota.projections.UsuarioEmailProjection;
import com.marcos.gestao_de_frota.repositories.AluguelRepository;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.repositories.VeiculoRepository;
import com.marcos.gestao_de_frota.services.exceptions.*;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AluguelService {

    private AluguelRepository aluguelRepository;
    private MotoristaRepository motoristaRepository;
    private VeiculoRepository veiculoRepository;
    private SendEmailService sendEmailService;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository, MotoristaRepository motoristaRepository, VeiculoRepository veiculoRepository, SendEmailService sendEmailService) {
        this.aluguelRepository = aluguelRepository;
        this.motoristaRepository = motoristaRepository;
        this.veiculoRepository = veiculoRepository;
        this.sendEmailService = sendEmailService;
    }

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

        aluguel.finalizarAluguel();

        aluguel = aluguelRepository.save(aluguel);

        enviarRelatorioDeAluguel(aluguel);

        return ConvertEntityToDto.convertToAluguelDto(aluguel);
    }

    @Transactional(readOnly = true)
    public Page<AluguelDto> getAlugueis(LocalDateTime startDate, LocalDateTime endDate, StatusAluguel statusAluguel, Pageable pageable){
        Page<Aluguel> alugueis = aluguelRepository.searchByFilters(startDate, endDate, statusAluguel, pageable);
        return alugueis.map(ConvertEntityToDto::convertToAluguelDto);
    }

    private void enviarRelatorioDeAluguel(Aluguel aluguel){
        String relatorio = "Prezado(a), seu aluguel foi efetuado com sucesso!\n"
                + aluguel.toString() + "\n"
                + aluguel.getMotorista().toString() + "\n"
                + aluguel.getVeiculo().toString();

        String userEmail = buscarEmailDoUsuarioDoMotorista(aluguel.getMotorista());

        sendEmailService.sendEmail(userEmail, "Relatório de Aluguel", relatorio);
    }

    private String buscarEmailDoUsuarioDoMotorista(Motorista motorista){
        UsuarioEmailProjection usuarioEmailProjection = motoristaRepository.searchDriveUserEmailByCnh(motorista.getCnh());
        return usuarioEmailProjection.getEmail();
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
