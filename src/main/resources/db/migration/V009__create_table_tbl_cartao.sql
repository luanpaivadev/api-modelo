CREATE TABLE public.tbl_cartao (
	cliente_id int8 NULL,
	id bigserial NOT NULL,
	bandeira varchar(255) NULL,
	cvv varchar(255) NULL,
	numero varchar(255) NULL,
	validade varchar(255) NULL,
	CONSTRAINT tbl_cartao_bandeira_check CHECK (((bandeira)::text = ANY ((ARRAY['MASTERCARD'::character varying, 'VISA'::character varying, 'ELO'::character varying, 'AMERICAN_EXPRESS'::character varying, 'HIPERCARD'::character varying])::text[]))),
	CONSTRAINT tbl_cartao_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tbl_cartao ADD CONSTRAINT fkkwfwxwi0nyqe2f8p2y3ulg1gq FOREIGN KEY (cliente_id) REFERENCES public.tbl_cliente(id);