CREATE TABLE public.tbl_usuario (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	senha varchar(255) NULL,
	roles _int2 NULL,
	CONSTRAINT tbl_usuario_pkey PRIMARY KEY (id)
);