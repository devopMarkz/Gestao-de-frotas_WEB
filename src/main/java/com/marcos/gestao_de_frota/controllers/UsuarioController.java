package com.marcos.gestao_de_frota.controllers;

import com.marcos.gestao_de_frota.dto.usuario.CreateMotoristaForUsuarioDto;
import com.marcos.gestao_de_frota.dto.usuario.CreateUsuarioDto;
import com.marcos.gestao_de_frota.dto.usuario.LoginRequestDto;
import com.marcos.gestao_de_frota.dto.usuario.UsuarioDto;
import com.marcos.gestao_de_frota.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody CreateUsuarioDto createUsuarioDto){
        UsuarioDto usuarioDto = usuarioService.insert(createUsuarioDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(usuarioDto.getEmail())
                .toUri();
        return ResponseEntity.created(location).body(usuarioDto);
    }

    @PostMapping("/usuario/motorista")
    public ResponseEntity<UsuarioDto> createMotoristaForUsuario(@Valid @RequestBody CreateMotoristaForUsuarioDto createMotoristaForUsuarioDto){
        UsuarioDto usuarioDto = usuarioService.insertMotoristaForUsuario(createMotoristaForUsuarioDto.getEmail(), createMotoristaForUsuarioDto.getCadastroDeMotorista());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(usuarioDto.getEmail())
                .toUri();
        return ResponseEntity.created(location).body(usuarioDto);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody LoginRequestDto loginRequest) {
        UsuarioDto usuarioDto = usuarioService.login(loginRequest);
        return ResponseEntity.ok(usuarioDto);
    }

}
