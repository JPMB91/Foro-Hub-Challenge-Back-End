
create table topicos (
    id bigint auto_increment primary key,
    titulo varchar(100) not null,
    mensaje text not null,
    fecha_creacion timestamp default current_timestamp,
    status varchar(20) not null default 'STATUS_ABIERTO',
    usuario_id bigint not null,
    curso varchar(80),
    constraint fk_topicos_usuario foreign key (usuario_id) references usuarios(id)
);