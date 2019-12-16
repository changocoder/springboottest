-- Table: public.peoples

-- DROP TABLE public.peoples;

CREATE TABLE public.peoples
(
    "Id" integer NOT NULL DEFAULT nextval('"peoples_Id_seq"'::regclass),
    name character varying(128) COLLATE pg_catalog."default",
    "lastName" character varying(128) COLLATE pg_catalog."default",
    "documentNumber" integer,
    CONSTRAINT pk_peoples PRIMARY KEY ("Id")
)

TABLESPACE pg_default;

ALTER TABLE public.peoples
    OWNER to postgres;