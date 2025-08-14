package com.challenge.foro_hub.service;

import com.challenge.foro_hub.domain.topico.*;
import com.challenge.foro_hub.domain.topico.validador.ValidadorTopicoYaExiste;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.repository.TopicoRepository;
import com.challenge.foro_hub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Page<DatosListadoTopico> listarTopicos(Pageable pagination) {

        return topicoRepository.findAll(pagination).map(DatosListadoTopico::new);
    }


    public DatosDetalleTopico obtenerTopico(Long id) {

        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isPresent()) {
            return new DatosDetalleTopico(optionalTopico.get());
        } else {
            throw new EntityNotFoundException("No existe un tópico con esa id: " + id);
        }
    }

    public void actualizarTopico(Long id, DatosActualizacionTopico datos) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            throw new EntityNotFoundException("No existe un tópico con esa id: " + id);
        } else {

            Topico topicofound = optionalTopico.get();

            if (datos.titulo() != null) topicofound.setTitulo(datos.titulo());
            if (datos.mensaje() != null) topicofound.setMensaje(datos.mensaje());

            topicoRepository.save(topicofound);
        }

    }

    public void eliminarTopico(Long id) {

        if (topicoRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe un tópico con esa id: " + id);
        }
        topicoRepository.deleteById(id);
    }
}
