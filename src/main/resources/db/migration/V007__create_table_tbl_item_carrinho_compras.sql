CREATE TABLE public.tbl_item_carrinho_compras (
	quantidade int4 NULL,
	carrinho_compras_id int8 NULL,
	id bigserial NOT NULL,
	produto_id int8 NULL,
	CONSTRAINT tbl_item_carrinho_compras_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tbl_item_carrinho_compras ADD CONSTRAINT fksoj2722c7qo5opimjfiiu0dxk FOREIGN KEY (carrinho_compras_id) REFERENCES public.tbl_carrinho_compras(id);
ALTER TABLE public.tbl_item_carrinho_compras ADD CONSTRAINT fksprifbjx873ibnhbvb55iluhq FOREIGN KEY (produto_id) REFERENCES public.tbl_produto(id);