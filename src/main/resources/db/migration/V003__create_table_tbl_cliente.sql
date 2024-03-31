CREATE TABLE public.tbl_cliente (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	CONSTRAINT tbl_cliente_pkey PRIMARY KEY (id)
);