package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.topico.DatosCreacionTopico;
import com.challenge.foro_hub.domain.topico.DatosDetalleTopico;
import com.challenge.foro_hub.domain.topico.DatosListadoTopico;
import com.challenge.foro_hub.domain.topico.Topico;
import com.challenge.foro_hub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> crearTopico(@RequestBody @Validated DatosCreacionTopico datos,
                                                          UriComponentsBuilder uriComponentsBuilder){

        Topico topico = topicoService.crearTopico(datos);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }
}
