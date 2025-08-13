package com.challenge.foro_hub.service;

import com.challenge.foro_hub.domain.topico.DatosCreacionTopico;
import com.challenge.foro_hub.domain.topico.Topico;
import com.challenge.foro_hub.domain.topico.validador.ValidadorTopicoYaExiste;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.repository.TopicoRepository;
import com.challenge.foro_hub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {


    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private ValidadorTopicoYaExiste validadorTopicoYaExiste;

    public Topico crearTopico(DatosCreacionTopico datos) {

        Usuario usuario = usuarioRepository.findById(datos.usuarioId())
                .orElseThrow(() ->
                        new EntityNotFoundException("No existe un usuario con ese id: " + datos.usuarioId()));

        validadorTopicoYaExiste.validar(datos);

        Topico topico = new Topico(datos, usuario);
        return topicoRepository.save(topico);

    }
}
