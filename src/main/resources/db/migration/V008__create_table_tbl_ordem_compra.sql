CREATE TABLE public.tbl_ordem_compra (
	carrinho_compras_id int8 NULL,
	cliente_id int8 NULL,
	endereco_id int8 NULL,
	id bigserial NOT NULL,
	forma_pagamento varchar(255) NULL,
	CONSTRAINT tbl_ordem_compra_carrinho_compras_id_key UNIQUE (carrinho_compras_id),
	CONSTRAINT tbl_ordem_compra_forma_pagamento_check CHECK (((forma_pagamento)::text = ANY ((ARRAY['BOLETO'::character varying, 'PIX'::character varying, 'CARTAO_CREDITO'::character varying, 'CARTAO_DEBITO'::character varying])::text[]))),
	CONSTRAINT tbl_ordem_compra_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tbl_ordem_compra ADD CONSTRAINT fkf7s0v5mqfl24i10phwew7ityj FOREIGN KEY (carrinho_compras_id) REFERENCES public.tbl_carrinho_compras(id);
ALTER TABLE public.tbl_ordem_compra ADD CONSTRAINT fkqddb0fl3vghho7c6kpe31s82d FOREIGN KEY (endereco_id) REFERENCES public.tbl_endereco(id);
ALTER TABLE public.tbl_ordem_compra ADD CONSTRAINT fkslto4nktyqlfdbtv8jab10fl5 FOREIGN KEY (cliente_id) REFERENCES public.tbl_cliente(id);