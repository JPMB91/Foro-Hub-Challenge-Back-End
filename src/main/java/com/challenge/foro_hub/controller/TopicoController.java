package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.topico.*;
import com.challenge.foro_hub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> crearTopico(@RequestBody @Validated DatosCreacionTopico datos,
                                                          UriComponentsBuilder uriComponentsBuilder) {

        Topico topico = topicoService.crearTopico(datos);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10) Pageable pagination) {

        var page = topicoService.listarTopicos(pagination);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerTopico(@PathVariable Long id) {

        var topico = topicoService.obtenerTopico(id);

        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id,
                                              @RequestBody DatosActualizacionTopico datos) {
        topicoService.actualizarTopico(id, datos);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {

        topicoService.eliminarTopico(id);
        return ResponseEntity.ok().build();
    }
}
