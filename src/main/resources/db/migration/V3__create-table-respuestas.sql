create table respuestas (
id bigint auto_increment primary key,
mensaje text not null,
topico_id bigint not null,
fecha_creacion timestamp not null default current_timestamp,
usuario_id bigint not null,
solucion boolean default false,
constraint fk_respuestas_topico foreign key (topico_id) references topicos(id),
constraint fk_respuestas_usuario foreign key (usuario_id) references usuarios(id)
);