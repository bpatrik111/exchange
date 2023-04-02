drop database exchangedb;
drop user exchange;
create user exchange with password 'pw';
create database exchangedb with template=template0 owner=exchange;
\connect exchangedb;
alter default privileges grant all on tables to exchange;
alter default privileges grant all on sequences to exchange;

CREATE TABLE public.symbols
(
    symbol_id integer NOT NULL,
    name "char"[] NOT NULL,
    PRIMARY KEY (symbol_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.symbols
    OWNER to exchange;

CREATE TABLE public."convert"
(
    convert_id integer NOT NULL,
    from_ "char"[] NOT NULL,
    to_ "char"[] NOT NULL,
    rate integer NOT NULL,
    PRIMARY KEY (convert_id)
);

ALTER TABLE IF EXISTS public."convert"
    OWNER to exchange;
