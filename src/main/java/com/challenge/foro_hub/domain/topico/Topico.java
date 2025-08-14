package com.challenge.foro_hub.domain.topico;

import com.challenge.foro_hub.domain.respuesta.Respuesta;
import com.challenge.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosCreacionTopico datos, Usuario usuario) {

        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.STATUS_ACTIVO;
        this.usuario = usuario;
        this.curso = datos.curso();
    }


    public void cerrar(Status status){
        this.status = Status.STATUS_CERRADO;
    }

    public void borrar(Status status){
        this.status = Status.STATUS_BORRADO;
    }

    public void agregarRespuesta(Respuesta respuesta){
        respuestas.add(respuesta);
        respuesta.setTopico(this);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
