DROP DATABASE IF EXISTS distribuidora_tcg;
DROP USER IF EXISTS 'admin_tcg'@'localhost';

CREATE DATABASE IF NOT EXISTS distribuidora_tcg
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- 2️ Crear usuario
CREATE USER 'admin_tcg'@'localhost' IDENTIFIED BY 'admin_tcg';

-- 3️ Otorgar permisos (equivalente a rol ADM_EJE)
GRANT ALL PRIVILEGES ON distribuidora_tcg.* TO 'admin_tcg'@'localhost' WITH GRANT OPTION;

-- 4️ Aplicar cambios
FLUSH PRIVILEGES;


USE distribuidora_tcg;

CREATE TABLE PRODUCTO (
    SKU VARCHAR(15) PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    EDICION VARCHAR(50) NOT NULL,
    LINEA VARCHAR(50),
    TIPO VARCHAR(20) NOT NULL,
    STOCK INT(4) NOT NULL,
    PRECIO INT(8) NOT NULL,
    FECHA_SALIDA date,
    DESCRIPCION VARCHAR(80),
    CANTIDAD_SOBRE INT(4),
    CANTIDAD_MAZO INT(4),
    CANTIDAD_SOBRE_ESPECIAL INT(4),
    CARTA_PROMO VARCHAR(80),
    REGALO_EXTRA VARCHAR(80)
    
);

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000012345', 'Sword & Shield: Fusion Strike Elite Trainer Box', 'Edicion 1', 'XY', 'Caja Mazos', 4, 42000, STR_TO_DATE('08/03/2021', '%d/%m/%Y'),
'Caja perteneciente a Elite Trainer XY', null, 8, null, null, null);

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000012346', 'Mega Evolution Phantasmal Flames', 'Edicion 3', 'XY', 'Caja Sobres', 10, 180000, 
STR_TO_DATE('02/12/2023', '%d/%m/%Y'),
null, 50, null, null, null, null);

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000012347', 'Charizard Ex Super Premiun Collection', 'Edicion 1', 'Super Premium', 'Caja Especial', 2, 85000, 
STR_TO_DATE('18/01/2025', '%d/%m/%Y'),
null, null, null, 8, 'Charizard EX holografico' ,'Figura Charizard');

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000054321', 'Scarlet & Violet—Obsidian Flames Booster Box', 'Edicion 1', 'Scarlet & Violet', 'Caja Sobres',
12, 155000, 
STR_TO_DATE('04/08/2023', '%d/%m/%Y'),
'Sobre de expansión con temática Obsidian Flames', 36, null, null, null, null);

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000024678', 'V Battle Deck: Lycanroc vs Corviknight', 'Edicion 2', 'V Deck Series', 'Caja Mazos',
6, 32000, 
STR_TO_DATE('11/09/2022', '%d/%m/%Y'), 
null, null, 2, null, null, null);

INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, 
CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA)
VALUES ('000000000099531', 'Pikachu VMAX Premium Figure Collection', 'Edicion 1', 'Premium Collection', 'Caja Especial',
3, 72000, 
STR_TO_DATE('22/05/2022', '%d/%m/%Y'),
'Caja especial con figura de Pikachu VMAX', null, null, 2, 'Pikachu VMAX Promo', 'Figura Pikachu');


