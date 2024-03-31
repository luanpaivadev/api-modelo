CREATE TABLE public.tbl_estoque (
	quantidade int4 NULL,
	id bigserial NOT NULL,
	produto_id int8 NULL,
	CONSTRAINT tbl_estoque_pkey PRIMARY KEY (id),
	CONSTRAINT tbl_estoque_produto_id_key UNIQUE (produto_id)
);

ALTER TABLE public.tbl_estoque ADD CONSTRAINT fk6o3fwta2b92u6v5yj0iosguji FOREIGN KEY (produto_id) REFERENCES public.tbl_produto(id);