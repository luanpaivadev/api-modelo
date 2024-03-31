CREATE TABLE public.tbl_carrinho_compras (
	valor_total numeric(38, 2) NULL,
	id bigserial NOT NULL,
	CONSTRAINT tbl_carrinho_compras_pkey PRIMARY KEY (id)
);