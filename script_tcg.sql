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




