create table usuarios (
id bigint auto_increment primary key,
nombre varchar(45) not null,
email varchar(255) not null unique,
password varchar(255) not null,
fecha_registro timestamp default current_timestamp,
activo boolean default true
);

