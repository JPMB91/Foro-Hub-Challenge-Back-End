package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.usuario.DatosAutenticacionUsuario;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.infra.security.DatosToken;
import com.challenge.foro_hub.infra.security.TokenService;
import com.challenge.foro_hub.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<DatosToken> login(@RequestBody DatosAutenticacionUsuario datos) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.password());

        var autenticacion = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosToken(tokenJWT));
    }

}
