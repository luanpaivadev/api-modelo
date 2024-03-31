CREATE TABLE public.tbl_endereco (
	cliente_id int8 NULL,
	id bigserial NOT NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	complemento varchar(255) NULL,
	localidade varchar(255) NULL,
	logradouro varchar(255) NULL,
	uf varchar(255) NULL,
	CONSTRAINT tbl_endereco_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tbl_endereco ADD CONSTRAINT fk12g7ejgk29fa3vhn4avd586ac FOREIGN KEY (cliente_id) REFERENCES public.tbl_cliente(id);