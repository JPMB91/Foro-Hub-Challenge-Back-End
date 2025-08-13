package com.challenge.foro_hub.domain.topico.validador;

import com.challenge.foro_hub.domain.topico.DatosCreacionTopico;
import com.challenge.foro_hub.infra.exceptions.ValidacionCreacionTopicoException;
import com.challenge.foro_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoYaExiste {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosCreacionTopico datos){
        boolean isTopicoExiste = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if(isTopicoExiste){
            throw  new ValidacionCreacionTopicoException("Un topico identico a este ya existe");
        }
    }
}
