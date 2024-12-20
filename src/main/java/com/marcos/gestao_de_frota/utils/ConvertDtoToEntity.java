package com.marcos.gestao_de_frota.utils;

import com.marcos.gestao_de_frota.dto.motorista.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import com.marcos.gestao_de_frota.dto.usuario.CreateUsuarioDto;
import com.marcos.gestao_de_frota.dto.veiculo.UpdateVeiculoDto;
import com.marcos.gestao_de_frota.entities.*;
import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;
import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import com.marcos.gestao_de_frota.entities.enums.TipoDeUsuario;

public class ConvertDtoToEntity {

    public static Usuario convertToUsario(CreateUsuarioDto dto){
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setTipoDeUsuario(TipoDeUsuario.valueOf(dto.getTipoDeUsuario()));
        return usuario;
    }

    public static Motorista convertToEntity(CreateMotoristaDto dto){
        if(dto == null) return null;
        return new Motorista(null, dto.getNome(), dto.getDisponivel(), dto.getCnh(), CategoriaCNH.valueOf(dto.getCategoriaCNH()), dto.getDataNascimento());
    }

    public static Motorista convertToEntity(MotoristaDto dto){
        if(dto == null) return null;
        return new Motorista(null, dto.getNome(), dto.getDisponivel(), dto.getCnh(), CategoriaCNH.valueOf(dto.getCategoriaCNH()), dto.getDataNascimento());
    }

    public static Onibus convertToOnibus(Veiculo veiculo, UpdateVeiculoDto dto){
        Onibus onibus = (Onibus) veiculo;
        attAtributosGenericos(onibus, dto);
        Integer numeroDeAssentos = (dto.getAtributosEspecificos().containsKey("numeroDeAssentos"))?
                (Integer) dto.getAtributosEspecificos().get("numeroDeAssentos") : null;
        onibus.setNumeroDeAssentos(numeroDeAssentos);
        return onibus;
    }

    public static Caminhao convertToCaminhao(Veiculo veiculo, UpdateVeiculoDto dto){
        Caminhao caminhao = (Caminhao) veiculo;
        attAtributosGenericos(caminhao, dto);
        Integer numeroDeEixos = (dto.getAtributosEspecificos().containsKey("numeroDeEixos"))?
                (Integer) dto.getAtributosEspecificos().get("numeroDeEixos") : null;
        caminhao.setNumeroDeEixos(numeroDeEixos);
        return caminhao;
    }

    private static void attAtributosGenericos(Veiculo veiculo, UpdateVeiculoDto dto){
        veiculo.setCategoriaVeiculo(CategoriaVeiculo.valueOf(dto.getCategoriaVeiculo()));
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setCapacidade(dto.getCapacidade());
        veiculo.setCustoPorDia(dto.getCustoPorDia());
    }

}
