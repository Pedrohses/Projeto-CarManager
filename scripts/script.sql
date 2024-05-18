CREATE TABLE IF NOT EXISTS carros (
    id             BIGSERIAL             NOT NULL PRIMARY KEY,
    modelo         TEXT                  NOT NULL,
    marca          TEXT                  NOT NULL,
    ano            SMALLINT              NOT NULL,
    cor            VARCHAR(255)          NOT NULL,
    preco          INTEGER               NOT NULL,
    estado         CHARACTER VARYING(2)  NOT NULL,
    placa          CHARACTER VARYING(10) NOT NULL,
    portas         SMALLINT              NOT NULL,
    combustivel    VARCHAR(255)          NOT NULL,
    qtd_passageiros SMALLINT              NOT NULL
);

CREATE TABLE IF NOT EXISTS caminhoes (
    id         BIGSERIAL             NOT NULL PRIMARY KEY,
    modelo     TEXT                  NOT NULL,
    marca      TEXT                  NOT NULL,
    ano        SMALLINT              NOT NULL,
    cor        VARCHAR(255)          NOT NULL,
    preco      INTEGER               NOT NULL,
    estado     CHARACTER VARYING(2)  NOT NULL,
    placa      CHARACTER VARYING(10) NOT NULL,
    capacidade REAL                  NOT NULL,
    eixos      SMALLINT              NOT NULL,
    carroceria VARCHAR(255)          NOT NULL
);

CREATE TABLE IF NOT EXISTS motos (
    id          BIGSERIAL             NOT NULL PRIMARY KEY,
    modelo      TEXT                  NOT NULL,
    marca       TEXT                  NOT NULL,
    ano         SMALLINT              NOT NULL,
    cor         VARCHAR(255)          NOT NULL,
    preco       INTEGER               NOT NULL,
    estado      CHARACTER VARYING(2)  NOT NULL,
    placa       CHARACTER VARYING(10) NOT NULL,
    cilindrada  SMALLINT              NOT NULL,
    tipo_partida VARCHAR(255)          NOT NULL
);