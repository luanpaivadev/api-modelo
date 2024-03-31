CREATE TABLE public.tbl_produto (
	porcentagem_desconto float8 NULL,
	preco numeric(38, 2) NULL,
	id bigserial NOT NULL,
	descricao varchar(255) NULL,
	CONSTRAINT tbl_produto_pkey PRIMARY KEY (id)
);