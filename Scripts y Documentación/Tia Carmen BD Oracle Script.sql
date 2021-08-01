CREATE TABLE venta (
    numeroventa number(18) NOT NULL,
    montopagar number(10) NOT NULL,
    fechaventa date NOT NULL,
    tipoventa char(1) NOT NULL,
    estado char(1) NOT NULL,
    id_voucher number(18) NOT NULL,
    PRIMARY KEY (numeroventa)
);

CREATE TABLE voucher (
    id_voucher number(18) NOT NULL,
    PRIMARY KEY (id_voucher)
);


CREATE TABLE boleta (
    id_boleta number(18) NOT NULL,
    numeroventa number(18) NOT NULL,
    PRIMARY KEY (id_boleta)
);

CREATE TABLE factura (
    id_factura number(18) NOT NULL,
    numeroventa number(18) NOT NULL,
	RUT VARCHAR2(12)  NOT NULL,
    PRIMARY KEY (id_factura)
);

CREATE TABLE producto (
    id_producto number(18) NOT NULL,
    nombre varchar2(100) NOT NULL,
    codigobarra varchar2(1000) NOT NULL,
    preciocosto number(10) NOT NULL,
    precioventa number(10) NOT NULL,
    PRIMARY KEY (id_producto)
);


CREATE TABLE detallevoucher (
    id_voucher number(18) NOT NULL,
    id_producto number(18) NOT NULL,
    cantidad  NUMBER (8,5) NOT NULL,
    PRIMARY KEY (id_voucher, id_producto)
);


CREATE TABLE empresa (
    rut varchar2(12) NOT NULL,
    nombre_empresa varchar2(255) NOT NULL,
    telefono_empresa varchar2(12) NOT NULL,
    email_empresa varchar2(200) NOT NULL,
    PRIMARY KEY (rut)
);

CREATE TABLE representantelegal (
    rut_empresa varchar2(12) NOT NULL,
    rut_representante_legal varchar2(12) NOT NULL,
    nombre_representante_legal varchar2(255) NOT NULL,
    telefono_representante_legal varchar2(12) NOT NULL,
    email_representante_legal varchar2(200) NOT NULL,
    PRIMARY KEY (rut_representante_legal)
);


ALTER TABLE venta ADD CONSTRAINT FK_venta__id_voucher FOREIGN KEY (id_voucher) REFERENCES voucher(id_voucher);
ALTER TABLE boleta ADD CONSTRAINT FK_boleta__numeroventa FOREIGN KEY (numeroventa) REFERENCES venta(numeroventa);
ALTER TABLE factura ADD CONSTRAINT FK_factura__numeroventa FOREIGN KEY (numeroventa) REFERENCES venta(numeroventa);
ALTER TABLE detallevoucher ADD CONSTRAINT FK_detallevoucher__id_voucher FOREIGN KEY (id_voucher) REFERENCES voucher(id_voucher);
ALTER TABLE detallevoucher ADD CONSTRAINT FK_detallevoucher__id_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto);
ALTER TABLE representantelegal ADD CONSTRAINT FK_rep_legal_rut_empresa FOREIGN KEY (rut_empresa) REFERENCES empresa(rut);