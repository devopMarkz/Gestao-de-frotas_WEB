package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.motorista.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.usuario.CreateUsuarioDto;
import com.marcos.gestao_de_frota.dto.usuario.LoginRequestDto;
import com.marcos.gestao_de_frota.dto.usuario.UsuarioDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.Usuario;
import com.marcos.gestao_de_frota.repositories.MotoristaRepository;
import com.marcos.gestao_de_frota.repositories.UsuarioRepository;
import com.marcos.gestao_de_frota.services.exceptions.EmailJaExistenteException;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaJaExistenteException;
import com.marcos.gestao_de_frota.services.exceptions.UsuarioInexistenteException;
import com.marcos.gestao_de_frota.utils.ConvertDtoToEntity;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioDto insert(CreateUsuarioDto createUsuarioDto){
        try {
            Usuario usuario = ConvertDtoToEntity.convertToUsario(createUsuarioDto);
            String passwordEncode = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(passwordEncode);
            usuario = usuarioRepository.save(usuario);
            return ConvertEntityToDto.convertToUsuarioDto(usuario);
        } catch (DataIntegrityViolationException e){
            throw new EmailJaExistenteException("Este e-mail já possui cadastro no sistema.");
        }
    }

    @Transactional
    public UsuarioDto insertMotoristaForUsuario(String email, CreateMotoristaDto createMotoristaDto){
        Usuario novoUsuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioInexistenteException("Não existe usuário cadastrado com este e-mail."));

        Motorista motorista = ConvertDtoToEntity.convertToEntity(createMotoristaDto);

        if(motoristaRepository.findByCnh(motorista.getCnh()).isPresent()){
            throw new MotoristaJaExistenteException("Já existe um motorista cadastrado com essa CNH.");
        }

        motorista = motoristaRepository.save(motorista);

        novoUsuario.setMotorista(motorista);

        Usuario usuario = usuarioRepository.save(novoUsuario);

        return ConvertEntityToDto.convertToUsuarioDto(usuario);
    }

    @Transactional(readOnly = true)
    public UsuarioDto login(LoginRequestDto loginRequest) {
        Usuario usuario = usuarioRepository.findByEmailAndPassword(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ).orElseThrow(() -> new UsuarioInexistenteException("Login ou senha inválidos."));

        return ConvertEntityToDto.convertToUsuarioDto(usuario);
    }

}