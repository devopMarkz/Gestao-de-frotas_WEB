package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.aluguel.AluguelDto;
import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import com.marcos.gestao_de_frota.dto.usuario.UsuarioDto;
import com.marcos.gestao_de_frota.dto.veiculo.CaminhaoDto;
import com.marcos.gestao_de_frota.dto.veiculo.OnibusDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.*;
import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;

public class ConvertEntityToDto {

    public static AluguelDto convertToAluguelDto(Aluguel aluguel){
        if(aluguel == null) return null;
        VeiculoDto veiculoDto;
        if(aluguel.getVeiculo().getCategoriaVeiculo().equals(CategoriaVeiculo.ONIBUS)){
            veiculoDto = convertToOnibusDto((Onibus) aluguel.getVeiculo());
        } else if(aluguel.getVeiculo().getCategoriaVeiculo().equals(CategoriaVeiculo.CAMINHAO)) {
            veiculoDto = convertToCaminhaoDto((Caminhao) aluguel.getVeiculo());
        } else {
            veiculoDto = null;
        }
        return new AluguelDto(convertToMotoristaDto(aluguel.getMotorista()), veiculoDto, aluguel.getDataHoraInicio(), aluguel.getDataHoraFim(), aluguel.getStatusAluguel(), aluguel.getValorAluguel());
    }

    public static UsuarioDto convertToUsuarioDto(Usuario usuario){
        if(usuario == null) return null;
        return new UsuarioDto(usuario.getEmail(), usuario.getTipoDeUsuario().name(), convertToMotoristaDto(usuario.getMotorista()));
    }

    public static MotoristaDto convertToMotoristaDto(Motorista motorista){
        if(motorista == null) return null;
        return new MotoristaDto(motorista.getId(), motorista.getNome(), motorista.getDisponivel(), motorista.getCnh(), motorista.getCategoriaCNH().name(), motorista.getDataNascimento());
    }

    public static CaminhaoDto convertToCaminhaoDto(Caminhao caminhao){
        if(caminhao == null) return null;
        return new CaminhaoDto(caminhao.getId(), caminhao.getDisponivel(), caminhao.getPlaca(), caminhao.getMarca(), caminhao.getModelo(), caminhao.getAnoFabricacao(), caminhao.getCapacidade(), caminhao.getCustoPorDia(), caminhao.getCategoriaVeiculo().name(), caminhao.getNumeroDeEixos());
    }

    public static OnibusDto convertToOnibusDto(Onibus onibus){
        if(onibus == null) return null;
        return new OnibusDto(onibus.getId(), onibus.getDisponivel(), onibus.getPlaca(), onibus.getMarca(), onibus.getModelo(), onibus.getAnoFabricacao(), onibus.getCapacidade(), onibus.getCustoPorDia(), onibus.getCategoriaVeiculo().name(), onibus.getNumeroDeAssentos());
    }

}
