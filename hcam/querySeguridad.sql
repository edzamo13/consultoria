
CREATE TABLE MGV_ALL_VIEW_TRIGGERS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                DUMMY_FLAG CHAR(1),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000),
                VIEW_ID BIGINT NOT NULL,
                VIEW_NAME VARCHAR(4000),
                TRIGGER_ID BIGINT NOT NULL,
                TRIGGER_NAME VARCHAR(4000)
);


CREATE TABLE MGV_ALL_VIEWS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                DUMMY_FLAG CHAR(1),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000),
                VIEW_ID BIGINT NOT NULL,
                VIEW_NAME VARCHAR(4000)
);
COMMENT ON TABLE MGV_ALL_VIEWS IS 'View to iterate over all views in the system';


CREATE TABLE MGV_ALL_TABLE_TRIGGERS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                DUMMY_FLAG CHAR(1),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000),
                TABLE_ID BIGINT NOT NULL,
                TABLE_NAME VARCHAR(4000) NOT NULL,
                TRIGGER_ID BIGINT NOT NULL,
                TRIGGER_NAME VARCHAR(4000)
);


CREATE TABLE MGV_ALL_TABLES (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                DBURL VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000),
                TABLE_ID BIGINT NOT NULL,
                TABLE_NAME VARCHAR(4000) NOT NULL
);


CREATE TABLE MGV_ALL_STORED_PROGRAMS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000),
                STORED_PROGRAM_ID BIGINT NOT NULL,
                PROGRAMTYPE VARCHAR(20),
                STORED_PROGRAM_NAME VARCHAR(4000),
                PACKAGE_ID_FK BIGINT
);


CREATE TABLE MGV_ALL_SCHEMA (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                SCHEMA_ID BIGINT NOT NULL,
                SCHEMA_NAME VARCHAR(4000)
);


CREATE TABLE MGV_ALL_CONNECTIONS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                CONNECTION_NAME VARCHAR(255),
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                DBURL VARCHAR(4000)
);


CREATE TABLE MGV_ALL_CATALOGS (
                PROJECT_ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                CONNECTION_ID BIGINT NOT NULL,
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                DBURL VARCHAR(4000),
                CATALOG_ID BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000)
);


CREATE TABLE STAGE_MIGRLOG (
                ID BIGINT NOT NULL,
                SVRID_FK BIGINT,
                DBID_GEN_FK BIGINT,
                REF_OBJECT_ID BIGINT,
                REF_OBJECT_TYPE VARCHAR(4000),
                LOG_DATE TIMESTAMP NOT NULL,
                SEVERITY BIGINT NOT NULL,
                LOGTEXT VARCHAR(4000),
                PHASE VARCHAR(20),
                CONSTRAINT stage_migrlog_pk PRIMARY KEY (ID)
);


CREATE TABLE SEG_USUESTHIST_T (
                ID_USUESTHIST BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                ID_PROCSEG BIGINT,
                CAT_ESTADO BIGINT,
                CORREO VARCHAR(260),
                FEC_INI_VIG DATE NOT NULL,
                FEC_FIN_VIG DATE,
                ID_USU_CREACION BIGINT,
                IP_EQUIPO VARCHAR(20),
                TELEFONO VARCHAR(20),
                CONSTRAINT seg_usuesthist_pk PRIMARY KEY (ID_USUESTHIST)
);
COMMENT ON TABLE SEG_USUESTHIST_T IS 'Tabla que almacena el historico de cambios de estado del usuario';
COMMENT ON COLUMN SEG_USUESTHIST_T.ID_USUESTHIST IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_USUESTHIST_T.US_ID_USUARIO IS 'Id. del usuario';
COMMENT ON COLUMN SEG_USUESTHIST_T.ID_PROCSEG IS 'Id. del proceso por el que se cambia de estado';
COMMENT ON COLUMN SEG_USUESTHIST_T.CAT_ESTADO IS 'Estado del usuario';
COMMENT ON COLUMN SEG_USUESTHIST_T.CORREO IS 'Correo electronico';
COMMENT ON COLUMN SEG_USUESTHIST_T.FEC_INI_VIG IS 'Fecha de inicio de vigencia del estado';
COMMENT ON COLUMN SEG_USUESTHIST_T.FEC_FIN_VIG IS 'Fecha de fin de vigencia del usuario';
COMMENT ON COLUMN SEG_USUESTHIST_T.ID_USU_CREACION IS 'Usuario que crea o actualiza el registro';
COMMENT ON COLUMN SEG_USUESTHIST_T.IP_EQUIPO IS 'Ip. del equipo desde el que se registra la transaccion';


CREATE INDEX seg_usuesthist_idx1
 ON SEG_USUESTHIST_T USING BTREE
 ( US_ID_USUARIO );

CLUSTER seg_usuesthist_idx1 ON SEG_USUESTHIST_T;

CREATE TABLE SEG_USUARIOS_TBL (
                US_ID_USUARIO BIGINT NOT NULL,
                US_USUARIO VARCHAR(20),
                US_NUM_DOCUMENTO VARCHAR(20) NOT NULL,
                US_CLAVE VARCHAR(550),
                US_CLAVE_ANTERIOR VARCHAR(550),
                US_CLAVE_MIG BIGINT DEFAULT 0,
                US_FUNCIONARIO BIGINT DEFAULT 0 NOT NULL,
                US_FEC_CADUCIDAD DATE NOT NULL,
                US_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_CREACION BIGINT NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                US_FEC_ACTUALIZACION DATE,
                US_ES_BLOQUEO CHAR(3),
                US_FOTO BYTEA,
                CORREO VARCHAR(260),
                CAT_ESTADO BIGINT,
                TELEFONO VARCHAR(20),
                CA_ID_CATEGORIA BIGINT,
                CONSTRAINT seg_usuarios_pk PRIMARY KEY (US_ID_USUARIO)
);
COMMENT ON TABLE SEG_USUARIOS_TBL IS 'Tabla que contiene informacion de los usuarios y claves de acceso';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_ID_USUARIO IS 'Id. que identifica al usuario';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_USUARIO IS 'Nombre de Usuario ';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_NUM_DOCUMENTO IS 'N¿mero de documento';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_CLAVE IS 'Clave del usuario';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_CLAVE_ANTERIOR IS 'Clave de usuario con metodo de cifrado anterior';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_CLAVE_MIG IS 'Identifica con que clave es el acceso: 0: con la clave en cifrado anterior; 1: con la clave en nuevo cifrado; 2: con clave en cifrado sha1';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_FUNCIONARIO IS 'Identifica si es o no funcionario del IESS. ';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_FEC_CADUCIDAD IS 'Fecha de caducidad de la clave';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_FEC_CREACION IS 'Fecha de creaci¿n del registro';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_ID_USUARIO_CREACION IS 'Usuario de creaci¿n del registro';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_ID_USUARIO_ACT IS 'Usuario de actualizaci¿n';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_FEC_ACTUALIZACION IS 'Fecha de actualizaci¿n del registro';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_ES_BLOQUEO IS 'Estado de bloqueo(Bloqueo diario=DIA, Bloqueo Definitivo=DEF, Campo vacio=No bloqueo)';
COMMENT ON COLUMN SEG_USUARIOS_TBL.US_FOTO IS 'Foto del Usuario';
COMMENT ON COLUMN SEG_USUARIOS_TBL.CORREO IS 'Correo Electronico';
COMMENT ON COLUMN SEG_USUARIOS_TBL.CAT_ESTADO IS 'Estado del usuario';
COMMENT ON COLUMN SEG_USUARIOS_TBL.CA_ID_CATEGORIA IS 'Id que identifica la categoria a la cual pertenece el usuario.';


CREATE UNIQUE INDEX seg_usuarios_uk1
 ON SEG_USUARIOS_TBL USING BTREE
 ( US_USUARIO );

CLUSTER seg_usuarios_uk1 ON SEG_USUARIOS_TBL;

CREATE UNIQUE INDEX seg_usuarios_uk2
 ON SEG_USUARIOS_TBL USING BTREE
 ( US_NUM_DOCUMENTO );

CLUSTER seg_usuarios_uk2 ON SEG_USUARIOS_TBL;

CREATE TABLE SEG_USUARIOSHIST_TBL (
                US_ID_USUARIOHIST BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                US_CLAVE_ANTERIOR VARCHAR(300) NOT NULL,
                US_CLAVE_ACTUAL VARCHAR(300) NOT NULL,
                US_FEC_ACTUALIZACION DATE NOT NULL,
                US_DIRECCION_IP VARCHAR(20) NOT NULL,
                CONSTRAINT seg_usuarioshist_pk PRIMARY KEY (US_ID_USUARIOHIST)
);
COMMENT ON TABLE SEG_USUARIOSHIST_TBL IS 'Tabla que continen informacion historica de los usuarios';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_ID_USUARIOHIST IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_ID_USUARIO IS 'Id que identifica al usuario';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_CLAVE_ANTERIOR IS 'Clave anterior';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_CLAVE_ACTUAL IS 'Clave actual';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_FEC_ACTUALIZACION IS 'Fecha de actualizaci¿n';
COMMENT ON COLUMN SEG_USUARIOSHIST_TBL.US_DIRECCION_IP IS 'Direcci¿n IP de la que se realiza el cambio de clave';


CREATE INDEX seg_usuarioshist_tbl_index1
 ON SEG_USUARIOSHIST_TBL USING BTREE
 ( US_FEC_ACTUALIZACION, US_ID_USUARIO );

CLUSTER seg_usuarioshist_tbl_index1 ON SEG_USUARIOSHIST_TBL;

CREATE TABLE SEG_USUARIOSEXP_TBL (
                UE_ID_USUEXP BIGINT NOT NULL,
                UE_COD_APLICACION VARCHAR(10) NOT NULL,
                UE_NUM_DOCUMENTO VARCHAR(20) NOT NULL,
                UE_TRAMA VARCHAR(1000) NOT NULL,
                UE_FEC_ACCESO DATE NOT NULL,
                UE_FEC_EXPIRACION DATE NOT NULL,
                UE_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_usuariosexp_pk PRIMARY KEY (UE_ID_USUEXP)
);
COMMENT ON TABLE SEG_USUARIOSEXP_TBL IS 'Tabla que almacena información de expiracion de la sesion de los usuarios';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_ID_USUEXP IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_COD_APLICACION IS 'Codigo de aplicación';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_NUM_DOCUMENTO IS 'Número de documento del usuario';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_TRAMA IS 'Trama ';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_FEC_ACCESO IS 'Fecha en la que el usuario está dando click al boton de acceso ';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_FEC_EXPIRACION IS 'Fecha de expiracion';
COMMENT ON COLUMN SEG_USUARIOSEXP_TBL.UE_ESTADO IS 'Estado del registro. Activo ''A'', Inactivo ''I''';


CREATE INDEX seg_usuariosexp_idx01
 ON SEG_USUARIOSEXP_TBL USING BTREE
 ( UE_NUM_DOCUMENTO, UE_COD_APLICACION );

CLUSTER seg_usuariosexp_idx01 ON SEG_USUARIOSEXP_TBL;

CREATE TABLE SEG_TIPOSSERVICIOS_TBL (
                TS_ID_TIPOSERVICIO BIGINT NOT NULL,
                TS_TIPO_SERVICIO VARCHAR(20) NOT NULL,
                TS_NOMBRE VARCHAR(120) NOT NULL,
                TS_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_tiposservicios_pk PRIMARY KEY (TS_ID_TIPOSERVICIO)
);
COMMENT ON TABLE SEG_TIPOSSERVICIOS_TBL IS 'Tabla que contine informacion de los tipos de servicios web';
COMMENT ON COLUMN SEG_TIPOSSERVICIOS_TBL.TS_ID_TIPOSERVICIO IS 'Id que identifica el tipo de servicio';
COMMENT ON COLUMN SEG_TIPOSSERVICIOS_TBL.TS_TIPO_SERVICIO IS 'Codigo del tipo de servicio. Externo(EXT); Interno(INT); Mixto(MIX) ';
COMMENT ON COLUMN SEG_TIPOSSERVICIOS_TBL.TS_NOMBRE IS 'Nombre del tipo de servicio web';
COMMENT ON COLUMN SEG_TIPOSSERVICIOS_TBL.TS_ESTADO IS 'Estado del tipo de servcicio web. Activo(A); Incativo(I).';


CREATE TABLE SEG_TIPOROLES_TBL (
                TR_ID_TIPOROL BIGINT NOT NULL,
                TR_NOMBRE VARCHAR(200) NOT NULL,
                TR_DESCRIPCION VARCHAR(500) NOT NULL,
                TR_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_tiporoles_pk PRIMARY KEY (TR_ID_TIPOROL)
);
COMMENT ON TABLE SEG_TIPOROLES_TBL IS 'Tabla que contiene los tipos de roles ';
COMMENT ON COLUMN SEG_TIPOROLES_TBL.TR_ID_TIPOROL IS 'Id. que identifica el tipo de rol';
COMMENT ON COLUMN SEG_TIPOROLES_TBL.TR_NOMBRE IS 'Nombre del Rol';
COMMENT ON COLUMN SEG_TIPOROLES_TBL.TR_DESCRIPCION IS 'Descripci¿n del rol';
COMMENT ON COLUMN SEG_TIPOROLES_TBL.TR_ESTADO IS 'Estado del Rol. Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_TIPODATOXSERVICIO_TBL (
                TD_ID_TIP_DATO BIGINT NOT NULL,
                TD_NOMBRE VARCHAR(100) NOT NULL,
                TD_ESTADO VARCHAR(1) NOT NULL,
                TD_PRIMITIVO BIGINT NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                TD_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                TD_FEC_ACTUALIZACION DATE,
                SW_ID_SERVICIO BIGINT,
                CONSTRAINT seg_tipodatoxservicio_pk PRIMARY KEY (TD_ID_TIP_DATO)
);
COMMENT ON TABLE SEG_TIPODATOXSERVICIO_TBL IS 'Tabla que contiene informacion de los tipos de datos que puede usar un parametro de servicio web';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_ID_TIP_DATO IS 'Id que identifica el tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_NOMBRE IS 'Nombre del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_ESTADO IS 'Estado del tipo de dato. Activo(A); Inactivo(I)';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_PRIMITIVO IS 'Identifica el tipo de dato. Es primitivo(1), No es primitivo (0)';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica al usuario de creacion del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_FEC_CREACION IS 'Fecha de creacion del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.US_ID_USUARIO_ACT IS 'Id que identifica al usuario de la ultima actualizacion';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.TD_FEC_ACTUALIZACION IS 'Fecha de la utlima actualizacion del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVICIO_TBL.SW_ID_SERVICIO IS 'Id que identifica el tipo de dato asociado al servicio';


CREATE TABLE SEG_TIPODATOXSERVDET_TBL (
                DD_ID_TIPODATODET BIGINT NOT NULL,
                DD_ATRIBUTO VARCHAR(80) NOT NULL,
                TD_ID_TIP_DATO BIGINT NOT NULL,
                TD_ID_TIP_DATO_ATRIB BIGINT NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                DD_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                DD_FEC_ACTUALIZACION DATE,
                DD_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_tipodatoxservdet_pk PRIMARY KEY (DD_ID_TIPODATODET)
);
COMMENT ON TABLE SEG_TIPODATOXSERVDET_TBL IS 'Tabla que contiene informacion de los atributos por tipos de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.DD_ID_TIPODATODET IS 'Id que identifica el detalle del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.DD_ATRIBUTO IS 'Nombre del atributo del tipo de dato';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.TD_ID_TIP_DATO IS 'Id que identifica el tipo de dato padre al que pertenece el atributo';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.TD_ID_TIP_DATO_ATRIB IS 'Id. que identifica el tipo de dato del atributo';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica el usuario de la creacion del detalle';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.DD_FEC_CREACION IS 'Fecha de creacion del detalle';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.US_ID_USUARIO_ACT IS 'Id que identifica el usuario de la ultima actualizacion del detalle';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.DD_FEC_ACTUALIZACION IS 'Fecha de la ultima actualizacion del detalle ';
COMMENT ON COLUMN SEG_TIPODATOXSERVDET_TBL.DD_ESTADO IS 'Estado del detalle. Activo(A); Inactivo(I)';


CREATE TABLE SEG_SOLICITUDESXCONEXION_TBL (
                SC_ID_SOLCONEXION BIGINT NOT NULL,
                SC_RUC_EMPRESA VARCHAR(13) NOT NULL,
                SC_EMPRESA VARCHAR(100) NOT NULL,
                SC_NUM_DOCUMENTO VARCHAR(10) NOT NULL,
                SC_NOMBRE VARCHAR(100) NOT NULL,
                SC_DIRECCION VARCHAR(120) NOT NULL,
                SC_TELEFONO VARCHAR(20) NOT NULL,
                SC_CORREO VARCHAR(60) NOT NULL,
                SC_CLAVE VARCHAR(300) NOT NULL,
                SC_DIRECCION_IP VARCHAR(20) NOT NULL,
                SC_ESTADO VARCHAR(1) NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                SC_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                SC_FEC_ACTUALIZACION DATE,
                CONSTRAINT seg_solicitudesxconexion_pk PRIMARY KEY (SC_ID_SOLCONEXION)
);
COMMENT ON TABLE SEG_SOLICITUDESXCONEXION_TBL IS 'Tabla que contiene informacion de las solicitud de conexion con servicios web';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_ID_SOLCONEXION IS 'Id que identifica la solicitud de conexion';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_RUC_EMPRESA IS 'Numero de ruc de la empresa';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_EMPRESA IS 'Nombre de la empresa solicitante';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_NUM_DOCUMENTO IS 'Numero de documento del responsable';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_NOMBRE IS 'Nombre del responsable ';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_DIRECCION IS 'Direccion del responsable';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_TELEFONO IS 'Numero de telefono del responsable';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_CORREO IS 'Direccion de correo electronico del responsable';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_CLAVE IS 'Clave encriptada de acceso del responsable';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_DIRECCION_IP IS 'Direccion IP del responsable de acceso ';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_ESTADO IS 'Estado de la solicitud. Activo(A); Inactivo(I)';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica al usuario que crea la solicitud';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_FEC_CREACION IS 'Fecha de creacion de la solicitud';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.US_ID_USUARIO_ACT IS 'Id que identifica al usuario de la ultima actualizacion';
COMMENT ON COLUMN SEG_SOLICITUDESXCONEXION_TBL.SC_FEC_ACTUALIZACION IS 'Fecha de la ultima actualizacion de la solicitud';


CREATE TABLE SEG_SERVICIOSWEB_TBL (
                SW_ID_SERVICIO BIGINT NOT NULL,
                SW_NOMBRE VARCHAR(200) NOT NULL,
                SW_DESCRIPCION VARCHAR(500) NOT NULL,
                SW_ESTADO VARCHAR(1) NOT NULL,
                TS_ID_TIPOSERVICIO BIGINT NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                SW_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                SW_FEC_ACTUALIZACION DATE,
                CONSTRAINT seg_serviciosweb_pk PRIMARY KEY (SW_ID_SERVICIO)
);
COMMENT ON TABLE SEG_SERVICIOSWEB_TBL IS 'Tabla que contiene informacion de los servicios web';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_ID_SERVICIO IS 'Id que identifica el servicio';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_NOMBRE IS 'Nombre del servicio web';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_DESCRIPCION IS 'Descripcion del servicio web';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_ESTADO IS 'Estado del servcicio web. Activo(A); Incativo(I).';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.TS_ID_TIPOSERVICIO IS 'Id que identifica el tipo de servicio web';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica al usuario de creacion';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_FEC_CREACION IS 'Fecha de creacion';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.US_ID_USUARIO_ACT IS 'Id que identifica al usuario de la ultima actualizacion';
COMMENT ON COLUMN SEG_SERVICIOSWEB_TBL.SW_FEC_ACTUALIZACION IS 'Fecha de la ultima actualizacion del servicio';


CREATE TABLE SEG_ROLES_TBL (
                RO_ID_ROL BIGINT NOT NULL,
                TR_ID_TIPOROL BIGINT NOT NULL,
                RO_NOMBRE VARCHAR(200) NOT NULL,
                RO_DESCRIPCION VARCHAR(500) NOT NULL,
                RO_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_roles_pk PRIMARY KEY (RO_ID_ROL)
);
COMMENT ON TABLE SEG_ROLES_TBL IS 'Tabla que almacena la informaci¿n de los roles de usuario';
COMMENT ON COLUMN SEG_ROLES_TBL.RO_ID_ROL IS 'Id. que identifica el Rol';
COMMENT ON COLUMN SEG_ROLES_TBL.TR_ID_TIPOROL IS 'Id que identifica el tipo de rol';
COMMENT ON COLUMN SEG_ROLES_TBL.RO_NOMBRE IS 'Nombre del rol';
COMMENT ON COLUMN SEG_ROLES_TBL.RO_DESCRIPCION IS 'Descripci¿n del rol';
COMMENT ON COLUMN SEG_ROLES_TBL.RO_ESTADO IS 'Estado del Rol. Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_ROLXUSUARIO_TBL (
                RU_ID_ROLXUSU BIGINT NOT NULL,
                RO_ID_ROL BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                RU_ESTADO VARCHAR(1) NOT NULL,
                FEC_CREACION DATE,
                ID_USU_CREACION BIGINT,
                IP_EQUIPO VARCHAR(20),
                CONSTRAINT seg_rolxusuario_pk PRIMARY KEY (RU_ID_ROLXUSU)
);
COMMENT ON TABLE SEG_ROLXUSUARIO_TBL IS 'Tabla que contiene informacion de los roles asignados a los usuarios';
COMMENT ON COLUMN SEG_ROLXUSUARIO_TBL.RU_ID_ROLXUSU IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_ROLXUSUARIO_TBL.RO_ID_ROL IS 'Id que identifica al rol relacionado al usuario';
COMMENT ON COLUMN SEG_ROLXUSUARIO_TBL.US_ID_USUARIO IS 'Id que identifica al usuario relacionado al rol';
COMMENT ON COLUMN SEG_ROLXUSUARIO_TBL.RU_ESTADO IS 'Estado del registro. Activo ''A'', Inactivo ''I''';


CREATE INDEX seg_rolxusuario_idx01
 ON SEG_ROLXUSUARIO_TBL USING BTREE
 ( US_ID_USUARIO );

CLUSTER seg_rolxusuario_idx01 ON SEG_ROLXUSUARIO_TBL;

CREATE TABLE SEG_ROLXUSUHIST_TBL (
                ID_ROLXUSUHIST BIGINT NOT NULL,
                RU_ID_ROLXUSU BIGINT NOT NULL,
                FEC_INI_VIG DATE NOT NULL,
                FEC_FIN_VIG DATE,
                ESTADO VARCHAR(1),
                ID_USU_CREACION BIGINT,
                IP_EQUIPO VARCHAR(20) NOT NULL,
                CONSTRAINT seg_rolxusuhist_pk PRIMARY KEY (ID_ROLXUSUHIST)
);
COMMENT ON TABLE SEG_ROLXUSUHIST_TBL IS 'Tabla que almacena el historico de los roles asignados a los usuarios';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.ID_ROLXUSUHIST IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.RU_ID_ROLXUSU IS 'Id. que identifica el rol por usuario para el que se va a guardar el histórico';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.FEC_INI_VIG IS 'Fecha Inicial de vigencia';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.FEC_FIN_VIG IS 'Fecha final de vigencia';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.ESTADO IS 'Estado del rol. Activo A, Inactivo I';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.ID_USU_CREACION IS 'Id. del usuario que registra la transacción';
COMMENT ON COLUMN SEG_ROLXUSUHIST_TBL.IP_EQUIPO IS 'Ip. del equipo desde el que se registra la transaccion';


CREATE INDEX seg_rolxusuhist_idx1
 ON SEG_ROLXUSUHIST_TBL USING BTREE
 ( RU_ID_ROLXUSU );

CLUSTER seg_rolxusuhist_idx1 ON SEG_ROLXUSUHIST_TBL;

CREATE TABLE SEG_ROLXDEPENDENCIAS_TBL (
                RD_ID_ROLXDEP BIGINT NOT NULL,
                RO_ID_ROL BIGINT NOT NULL,
                DE_ID_DEPENDENCIA BIGINT NOT NULL,
                RD_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_rolxdependencias_pk PRIMARY KEY (RD_ID_ROLXDEP)
);
COMMENT ON TABLE SEG_ROLXDEPENDENCIAS_TBL IS 'Tabla que contiene informacion de los roles asignados a las dependencias';
COMMENT ON COLUMN SEG_ROLXDEPENDENCIAS_TBL.RD_ID_ROLXDEP IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_ROLXDEPENDENCIAS_TBL.RO_ID_ROL IS 'Id que identifica al rol asignado';
COMMENT ON COLUMN SEG_ROLXDEPENDENCIAS_TBL.DE_ID_DEPENDENCIA IS 'Id que identifica la dependencia';
COMMENT ON COLUMN SEG_ROLXDEPENDENCIAS_TBL.RD_ESTADO IS 'Estado del registro. Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_REQXPROCSEG_T (
                ID_REQUISITO BIGINT NOT NULL,
                ID_EVENTOXPRO BIGINT NOT NULL,
                ID_REQUISITODET BIGINT NOT NULL,
                VALOR VARCHAR(20) NOT NULL,
                CONSTRAINT seg_reqxvalidacion_pk PRIMARY KEY (ID_REQUISITO)
);
COMMENT ON TABLE SEG_REQXPROCSEG_T IS 'Tabla que almacena la informacion de los requisitos por proceso de seguridad';
COMMENT ON COLUMN SEG_REQXPROCSEG_T.ID_REQUISITO IS 'Id. que identifica el requisito';
COMMENT ON COLUMN SEG_REQXPROCSEG_T.ID_EVENTOXPRO IS 'Id. que identifica el evento para el que se registra el requisito';
COMMENT ON COLUMN SEG_REQXPROCSEG_T.ID_REQUISITODET IS 'Id. que identifica el detalle del requisito';
COMMENT ON COLUMN SEG_REQXPROCSEG_T.VALOR IS 'Valor del Requisito/Documentacion. ';


CREATE TABLE SEG_PROCESOSSEG_TP (
                ID_PROCSEG BIGINT NOT NULL,
                DESCRIPCION VARCHAR(260) NOT NULL,
                VAL_INTENTOS VARCHAR(1) NOT NULL,
                NUM_INTENTOS BIGINT,
                ESTADO VARCHAR(1) NOT NULL,
                COD_PROC_SEG VARCHAR(10),
                CONSTRAINT seg_procesosseg_pk PRIMARY KEY (ID_PROCSEG)
);
COMMENT ON TABLE SEG_PROCESOSSEG_TP IS 'Tabla que almacena los procesos de validacion de seguridades';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.ID_PROCSEG IS 'Id. que identifica el proceso';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.DESCRIPCION IS 'Descripcion del proceso';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.VAL_INTENTOS IS 'Indica si debe o no validar intentos';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.NUM_INTENTOS IS 'Numero de intentos permitidos';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.ESTADO IS 'Indica el estado del proceso. Activo A, Inactivo I';
COMMENT ON COLUMN SEG_PROCESOSSEG_TP.COD_PROC_SEG IS 'Codigo que identifica el proceso';


CREATE TABLE SEG_PARAMETROS_TBL (
                PA_ID_PARAMETRO BIGINT NOT NULL,
                PA_NOMBRE VARCHAR(100) NOT NULL,
                PA_DESCRIPCION VARCHAR(300) NOT NULL,
                PA_VALOR VARCHAR(120) NOT NULL,
                PA_TIPO_DATO VARCHAR(1) NOT NULL,
                PA_ESTADO VARCHAR(1) NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                PA_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                PA_FEC_ACTUALIZACION DATE,
                CONSTRAINT seg_parametros_pk PRIMARY KEY (PA_ID_PARAMETRO)
);
COMMENT ON TABLE SEG_PARAMETROS_TBL IS 'Tabla que contiene parametros de configuracion de seguridades';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_ID_PARAMETRO IS 'Id que identifica el parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_NOMBRE IS 'Nombre del parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_DESCRIPCION IS 'Descripcion de la funcionalidad del parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_VALOR IS 'Valor del parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_TIPO_DATO IS 'Tipo de dato del parametro para establecer conversion de datos: (T)texto; (F)Fecha; (N)numerico';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_ESTADO IS 'Estado del parametro. Activo ''A'', Inactivo ''I''';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica el usuario que crea el parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_FEC_CREACION IS 'Fecha de creacion del parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.US_ID_USUARIO_ACT IS 'Id que identifica el usuario que actualiza el parametro';
COMMENT ON COLUMN SEG_PARAMETROS_TBL.PA_FEC_ACTUALIZACION IS 'Fecha de actualizacion dle parametro';


CREATE TABLE SEG_PARAMETROSHIST_TBL (
                PH_ID_PARHIST BIGINT NOT NULL,
                PA_ID_PARAMETRO BIGINT NOT NULL,
                PH_VALOR_ANTERIOR VARCHAR(30),
                PH_VALOR_ACTUAL VARCHAR(30),
                PH_ESTADO_ANTERIOR VARCHAR(1),
                PH_ESTADO_ACTUAL VARCHAR(1),
                PH_DIRECCION_IP VARCHAR(20) NOT NULL,
                US_ID_USUARIO_ACT BIGINT NOT NULL,
                PH_FEC_ACTUALIZACION DATE NOT NULL,
                CONSTRAINT seg_parametroshist_pk PRIMARY KEY (PH_ID_PARHIST)
);
COMMENT ON TABLE SEG_PARAMETROSHIST_TBL IS 'Tabla que contiene informacion de las modificaciones sobre los parametros de seguridad';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_ID_PARHIST IS 'Id que identifica el historico del parametro modificado';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PA_ID_PARAMETRO IS 'Id que identifica el parametro ';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_VALOR_ANTERIOR IS 'Valor anterior del paramtro';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_VALOR_ACTUAL IS 'Valor actual del parametro';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_ESTADO_ANTERIOR IS 'Valor anterior del estado';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_ESTADO_ACTUAL IS 'Valor actual del estado';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_DIRECCION_IP IS 'Direccion Ip del cambio de valor';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.US_ID_USUARIO_ACT IS 'Usuario que realiza la actualizacion';
COMMENT ON COLUMN SEG_PARAMETROSHIST_TBL.PH_FEC_ACTUALIZACION IS 'Fecha de actualizacion';


CREATE TABLE SEG_METODOSXSERVICIO_TBL (
                MS_ID_METODO BIGINT NOT NULL,
                MS_NOMBRE VARCHAR(120) NOT NULL,
                SW_ID_SERVICIO BIGINT NOT NULL,
                MS_URL VARCHAR(300) NOT NULL,
                MS_ESTADO VARCHAR(1) NOT NULL,
                MS_AUDITORIA BIGINT NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                MS_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                MS_FEC_ACTUALIZACION DATE,
                MS_DESCRIPCION VARCHAR(500) NOT NULL,
                MS_CODIGO VARCHAR(25) DEFAULT '1' NOT NULL,
                CONSTRAINT seg_metodosxservicio_pk PRIMARY KEY (MS_ID_METODO)
);
COMMENT ON TABLE SEG_METODOSXSERVICIO_TBL IS 'Tabla que contiene informacion de los metodos implementados en los servicios web';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_ID_METODO IS 'Id que identifica los metodos por servicio web';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_NOMBRE IS 'Nombre de los metodos de los servicios web';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.SW_ID_SERVICIO IS 'Id que identifica el servicio web al que pertenece el metodo';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_URL IS 'URL de los metodos de los servicios web';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_ESTADO IS 'Estado de los metodos por servcicio web. Activo(A); Incativo(I).';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_AUDITORIA IS 'Indica si el metodo es auditable';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica el usuario de creación de los metodos';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_FEC_CREACION IS 'Fecha de creacion de los metodos';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.US_ID_USUARIO_ACT IS 'Id que identifica al usuario de la ultima actualizacion';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_FEC_ACTUALIZACION IS 'Fecha de la ultima actualizacion de los metodos';
COMMENT ON COLUMN SEG_METODOSXSERVICIO_TBL.MS_DESCRIPCION IS 'Descripcion del metodo';


CREATE TABLE SEG_PARAMXMETODO_TBL (
                PM_ID_PARMETODO BIGINT NOT NULL,
                PM_NOMBRE VARCHAR(60) NOT NULL,
                PM_ESTADO VARCHAR(1) NOT NULL,
                PM_TIPO_PARAMETRO VARCHAR(1) NOT NULL,
                TD_ID_TIP_DATO BIGINT NOT NULL,
                MS_ID_METODO BIGINT NOT NULL,
                US_ID_USUARIO_CREACION BIGINT,
                PM_FEC_CREACION DATE NOT NULL,
                US_ID_USUARIO_ACT BIGINT,
                PM_FEC_ACTUALIZACION DATE,
                CONSTRAINT seg_paramxmetodo_pk PRIMARY KEY (PM_ID_PARMETODO)
);
COMMENT ON TABLE SEG_PARAMXMETODO_TBL IS 'Tabla que contiene informacion de los parametros que usan los metodos de los servicios web';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_ID_PARMETODO IS 'Id que identifica los parametros de los metodos';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_NOMBRE IS 'Nombre del parametro';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_ESTADO IS 'Estado del parametro. Activo(A); Inactivo(I)';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_TIPO_PARAMETRO IS 'Tipo de parametro. Entrada(E); Salida(S)';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.TD_ID_TIP_DATO IS 'Id que identifica el tipo de dato del parametro';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.MS_ID_METODO IS 'Id que identifica el metodo al que esta relacionado el parametro';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.US_ID_USUARIO_CREACION IS 'Id que identifica al usuario responsable de la creacion';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_FEC_CREACION IS 'Fecha de la creacion del parametro';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.US_ID_USUARIO_ACT IS 'Id que identifica al usuario de la ultima actualizacion';
COMMENT ON COLUMN SEG_PARAMXMETODO_TBL.PM_FEC_ACTUALIZACION IS 'Fecha de la ultima actualizacion';


CREATE TABLE SEG_METODOSXSOL_TBL (
                MS_ID_METSOL BIGINT NOT NULL,
                MS_ESTADO VARCHAR(1) NOT NULL,
                SC_ID_SOLCONEXION BIGINT NOT NULL,
                MS_ID_METODO BIGINT NOT NULL,
                CONSTRAINT seg_metodosxsol_pk PRIMARY KEY (MS_ID_METSOL)
);
COMMENT ON TABLE SEG_METODOSXSOL_TBL IS 'Tabla que contiene informacion de los metodos asociados a las solicitudes de conexion';
COMMENT ON COLUMN SEG_METODOSXSOL_TBL.MS_ID_METSOL IS 'Id que identifica el medoto relacionado a la solicitud';
COMMENT ON COLUMN SEG_METODOSXSOL_TBL.MS_ESTADO IS 'Estado de los metodos por solicitud. Activo(A); Inactivo(I)';
COMMENT ON COLUMN SEG_METODOSXSOL_TBL.SC_ID_SOLCONEXION IS 'Id que identifica la solicitud de conexion';
COMMENT ON COLUMN SEG_METODOSXSOL_TBL.MS_ID_METODO IS 'Id que identifica el metodo de la solicitud de conexion';


CREATE TABLE SEG_MENU_TBL (
                ME_ID_OPCION BIGINT NOT NULL,
                ME_ID_OPCION_PADRE BIGINT,
                AP_ID_APLICACION BIGINT NOT NULL,
                ME_ETIQUETA VARCHAR(500) NOT NULL,
                ME_ORDEN BIGINT NOT NULL,
                ME_URL VARCHAR(500),
                ME_NODO_FINAL BIGINT DEFAULT 0 NOT NULL,
                ME_ACCION VARCHAR(200),
                ME_ESTADO VARCHAR(1) NOT NULL,
                ME_AUDITORIA BIGINT NOT NULL,
                CONSTRAINT seg_menu_pk PRIMARY KEY (ME_ID_OPCION)
);
COMMENT ON TABLE SEG_MENU_TBL IS 'Tabla que contiene informacion de las opciones de menu';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ID_OPCION IS 'Id. de Opci¿n de Men¿';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ID_OPCION_PADRE IS 'Id. padre de la opcion';
COMMENT ON COLUMN SEG_MENU_TBL.AP_ID_APLICACION IS 'Id que identifica a la aplicacion';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ETIQUETA IS 'Etiqueta de la opci¿n';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ORDEN IS 'Orden de la opci¿n';
COMMENT ON COLUMN SEG_MENU_TBL.ME_URL IS 'Url de la opci¿n';
COMMENT ON COLUMN SEG_MENU_TBL.ME_NODO_FINAL IS 'Indica si la opci¿n ejecuta o no una acci¿n: 1: Ejecuta accion; 0: No ejecuta accion';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ACCION IS 'Acci¿n que ejecuta la opci¿n';
COMMENT ON COLUMN SEG_MENU_TBL.ME_ESTADO IS 'Estado de la opci¿n. Activo ''A'', Inactivo ''I''';
COMMENT ON COLUMN SEG_MENU_TBL.ME_AUDITORIA IS 'Identifica si la opcion de menu tiene activa la auditoria. Con auditoria (1); Sin auditoria (0)';


CREATE INDEX seg_menu_idx01
 ON SEG_MENU_TBL USING BTREE
 ( ME_ID_OPCION_PADRE );

CLUSTER seg_menu_idx01 ON SEG_MENU_TBL;

CREATE INDEX seg_menu_idx02
 ON SEG_MENU_TBL USING BTREE
 ( AP_ID_APLICACION );

CLUSTER seg_menu_idx02 ON SEG_MENU_TBL;

CREATE TABLE SEG_ROLXMENU_TBL (
                RM_ID_ROLXMENU BIGINT NOT NULL,
                ME_ID_OPCION BIGINT NOT NULL,
                RO_ID_ROL BIGINT NOT NULL,
                RM_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_rolxmenu_pk PRIMARY KEY (RM_ID_ROLXMENU)
);
COMMENT ON TABLE SEG_ROLXMENU_TBL IS 'Tabla que continene informacion de las opciones de menu relacionadas a los roles';
COMMENT ON COLUMN SEG_ROLXMENU_TBL.RM_ID_ROLXMENU IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_ROLXMENU_TBL.ME_ID_OPCION IS 'Id. que identifica la opci¿n de men¿';
COMMENT ON COLUMN SEG_ROLXMENU_TBL.RO_ID_ROL IS 'Id. que identifica el rol';
COMMENT ON COLUMN SEG_ROLXMENU_TBL.RM_ESTADO IS 'Estado del registo. Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_INSTITUCIONES_TBL (
                IN_ID_INSTITUCION BIGINT NOT NULL,
                IN_NOMBRE VARCHAR(120) NOT NULL,
                IN_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_instituciones_pk PRIMARY KEY (IN_ID_INSTITUCION)
);
COMMENT ON TABLE SEG_INSTITUCIONES_TBL IS 'Tabla que continen informacion de las instituciones';
COMMENT ON COLUMN SEG_INSTITUCIONES_TBL.IN_ID_INSTITUCION IS 'Id. que identifica la institucion';
COMMENT ON COLUMN SEG_INSTITUCIONES_TBL.IN_NOMBRE IS 'Nombre de la instituci¿n';
COMMENT ON COLUMN SEG_INSTITUCIONES_TBL.IN_ESTADO IS 'Estado de la instituci¿n. Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_EVENTOSLOGIN_TBL (
                EL_ID_EVENTO BIGINT NOT NULL,
                US_ID_USUARIO BIGINT,
                US_USUARIO VARCHAR(20) NOT NULL,
                US_CLAVE VARCHAR(300) NOT NULL,
                EL_DIRECCION_IP VARCHAR(20) NOT NULL,
                EL_FEC_EVENTO DATE NOT NULL,
                EL_TIPO_EVENTO VARCHAR(1) NOT NULL,
                EL_ESTADO_LOGUEO BIGINT DEFAULT 0 NOT NULL,
                EL_ID_SESION_NAV VARCHAR(200),
                EL_NAVEGADOR VARCHAR(120),
                CONSTRAINT seg_eventoslogin_pk PRIMARY KEY (EL_ID_EVENTO)
);
COMMENT ON TABLE SEG_EVENTOSLOGIN_TBL IS 'Tabla que contiene informacion de los eventos de logueo';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.EL_ID_EVENTO IS 'Id. que identifica el registro';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.US_ID_USUARIO IS 'Id. que identifica el usuario que realiza el evento';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.US_USUARIO IS 'Nombre del usuario';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.US_CLAVE IS 'Clave con la que se registra el evento';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.EL_DIRECCION_IP IS 'Direcci¿n IP por la que se realiza el evento';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.EL_FEC_EVENTO IS 'Fecha en la que se realiz¿ el evento';
COMMENT ON COLUMN SEG_EVENTOSLOGIN_TBL.EL_TIPO_EVENTO IS 'Indica el tipo de evento. Exitoso ''E'', Fallido ''F''';


CREATE INDEX seg_eventoslogin_idx01
 ON SEG_EVENTOSLOGIN_TBL USING BTREE
 ( EL_ESTADO_LOGUEO );

CLUSTER seg_eventoslogin_idx01 ON SEG_EVENTOSLOGIN_TBL;

CREATE INDEX seg_eventoslogin_idx02
 ON SEG_EVENTOSLOGIN_TBL USING BTREE
 ( US_USUARIO );

CLUSTER seg_eventoslogin_idx02 ON SEG_EVENTOSLOGIN_TBL;

CREATE TABLE SEG_DEPENDENCIAS_TBL (
                DE_ID_DEPENDENCIA BIGINT NOT NULL,
                DE_NOMBRE VARCHAR(200) NOT NULL,
                IN_ID_INSTITUCION BIGINT NOT NULL,
                DE_TIPO_DEPENDENCIA VARCHAR(3) NOT NULL,
                DE_ID_DEPENDENCIA_PADRE BIGINT,
                DE_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_dependencias_pk PRIMARY KEY (DE_ID_DEPENDENCIA)
);
COMMENT ON TABLE SEG_DEPENDENCIAS_TBL IS 'Tabla que contine informacion de las dependencias que conforman las instituciones';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.DE_ID_DEPENDENCIA IS 'Id. que identifica a la direcci¿n ';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.DE_NOMBRE IS 'Nombre de la dependencia';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.IN_ID_INSTITUCION IS 'Id que identifica a la institucion';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.DE_TIPO_DEPENDENCIA IS 'Tipo que define la dependencia: DIR: direccion, NEG: negocio';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.DE_ID_DEPENDENCIA_PADRE IS 'Id. de la dependencia padre';
COMMENT ON COLUMN SEG_DEPENDENCIAS_TBL.DE_ESTADO IS 'Estado de la dependencia. Activo ''A'', Inactivo ''I''';


CREATE INDEX seg_dependencias_idx01
 ON SEG_DEPENDENCIAS_TBL USING BTREE
 ( DE_ID_DEPENDENCIA_PADRE );

CLUSTER seg_dependencias_idx01 ON SEG_DEPENDENCIAS_TBL;

CREATE TABLE SEG_DATOSAUTENT_TP (
                ID_DATAUT BIGINT NOT NULL,
                TIPO VARCHAR(1) NOT NULL,
                PREGUNTA VARCHAR(160),
                IMAGEN BYTEA,
                ESTADO VARCHAR(1),
                PREG_IMAGEN VARCHAR(1),
                ID_USU_CREACION BIGINT NOT NULL,
                FEC_CREACION DATE,
                IP_EQUIPO VARCHAR(20) NOT NULL,
                CONSTRAINT seg_datosautent_pk PRIMARY KEY (ID_DATAUT)
);
COMMENT ON TABLE SEG_DATOSAUTENT_TP IS 'Tabla que almacena el catalgo de datos de autenticacion';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.ID_DATAUT IS 'Id. que identifica la pregunta o imagen';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.TIPO IS 'Indica el tipo. Pregunta P, Imagen I';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.PREGUNTA IS 'Pregunta descriptiva';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.IMAGEN IS 'Imagen';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.ESTADO IS 'Estado de la pregunta. Activa A, Inactiva I';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.PREG_IMAGEN IS 'Indica si la pregunta corresponde a la de imagen';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.ID_USU_CREACION IS 'Usuario que crea el registro';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.FEC_CREACION IS 'Fecha de creacion de la pregunta';
COMMENT ON COLUMN SEG_DATOSAUTENT_TP.IP_EQUIPO IS 'Ip. del equipo desde el que se registra la pregunta';


CREATE TABLE SEG_RESPXUSU_T (
                ID_RESPUESTA BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                ID_DATAUT BIGINT NOT NULL,
                RESPUESTA VARCHAR(550),
                IMAGEN TEXT,
                FEC_CREACION DATE NOT NULL,
                IP_EQUIPO VARCHAR(20),
                CONSTRAINT seg_respxusu_pk PRIMARY KEY (ID_RESPUESTA)
);
COMMENT ON TABLE SEG_RESPXUSU_T IS 'Tabla que almacena la informacion de las respuestas del usuario';
COMMENT ON COLUMN SEG_RESPXUSU_T.ID_RESPUESTA IS 'Id.que identifica la respuesta';
COMMENT ON COLUMN SEG_RESPXUSU_T.US_ID_USUARIO IS 'Id. que identifica al usuario';
COMMENT ON COLUMN SEG_RESPXUSU_T.ID_DATAUT IS 'Id. que identifica la pregunta ';
COMMENT ON COLUMN SEG_RESPXUSU_T.RESPUESTA IS 'Respuesta de las preguntas';
COMMENT ON COLUMN SEG_RESPXUSU_T.IMAGEN IS 'Imagen seleccionada por el usuario';
COMMENT ON COLUMN SEG_RESPXUSU_T.FEC_CREACION IS 'Fecha de creacion del registro';
COMMENT ON COLUMN SEG_RESPXUSU_T.IP_EQUIPO IS 'Ip del equipo desde el que se genera';


CREATE INDEX seg_respxusu_idx1
 ON SEG_RESPXUSU_T USING BTREE
 ( US_ID_USUARIO );

CLUSTER seg_respxusu_idx1 ON SEG_RESPXUSU_T;

CREATE TABLE SEG_CLAVESDESC_T (
                ID_CLAVE BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                CLAVE_DESCARTABLE VARCHAR(550) NOT NULL,
                FEC_CREACION DATE NOT NULL,
                FEC_CADUCIDAD DATE,
                IP_EQUIPO VARCHAR(20) NOT NULL,
                ID_USU_CREACION BIGINT NOT NULL,
                ID_PROCSEG BIGINT NOT NULL,
                ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_clavesdesc_pk PRIMARY KEY (ID_CLAVE)
);
COMMENT ON TABLE SEG_CLAVESDESC_T IS 'Tabla que almacena la informacion de las claves descartables';
COMMENT ON COLUMN SEG_CLAVESDESC_T.ID_CLAVE IS 'Id. que identifica la clave';
COMMENT ON COLUMN SEG_CLAVESDESC_T.US_ID_USUARIO IS 'Id.que identifica al usuario';
COMMENT ON COLUMN SEG_CLAVESDESC_T.CLAVE_DESCARTABLE IS 'Clave descartable ';
COMMENT ON COLUMN SEG_CLAVESDESC_T.FEC_CREACION IS 'Fecha de creacion de la clave';
COMMENT ON COLUMN SEG_CLAVESDESC_T.FEC_CADUCIDAD IS 'Fecha de caducidad de la clave';
COMMENT ON COLUMN SEG_CLAVESDESC_T.IP_EQUIPO IS 'Ip del equipo desde el que se registra la transaccion';
COMMENT ON COLUMN SEG_CLAVESDESC_T.ID_USU_CREACION IS 'Id. del usuario que crea el registro';
COMMENT ON COLUMN SEG_CLAVESDESC_T.ID_PROCSEG IS 'Id. que identifica el proceso';
COMMENT ON COLUMN SEG_CLAVESDESC_T.ESTADO IS 'Estado del registro. Activo A, Inactivo';


CREATE TABLE SEG_CATEGORIAS_TBL (
                CA_ID_CATEGORIA BIGINT NOT NULL,
                CA_NOMBRE VARCHAR(60) NOT NULL,
                CA_DESCRIPCION VARCHAR(300) NOT NULL,
                CA_ORDEN BIGINT NOT NULL,
                CA_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_categorias_pk PRIMARY KEY (CA_ID_CATEGORIA)
);
COMMENT ON TABLE SEG_CATEGORIAS_TBL IS 'Tabla que contiene las categorias';
COMMENT ON COLUMN SEG_CATEGORIAS_TBL.CA_ID_CATEGORIA IS 'Id que identifica la categoria';
COMMENT ON COLUMN SEG_CATEGORIAS_TBL.CA_NOMBRE IS 'Nombre de la categoria';
COMMENT ON COLUMN SEG_CATEGORIAS_TBL.CA_DESCRIPCION IS 'Descripcion de la categoria';
COMMENT ON COLUMN SEG_CATEGORIAS_TBL.CA_ORDEN IS 'Especifica el orden de visualizacion de las categorias';
COMMENT ON COLUMN SEG_CATEGORIAS_TBL.CA_ESTADO IS 'Estado de la categoria: Activo ''A'', Inactivo ''I''';


CREATE TABLE SEG_BLOQUEOS_TBL (
                BL_ID_REGISTRO BIGINT NOT NULL,
                BL_TIPO_BLOQUEO VARCHAR(3) NOT NULL,
                BL_FEC_REGISTRO DATE NOT NULL,
                US_USR_BLOQUEO BIGINT NOT NULL,
                BL_IP_BLOQUEO VARCHAR(20) NOT NULL,
                BL_TIPO_DESBLOQUEO VARCHAR(3),
                US_USR_DESBLOQUEO BIGINT,
                BL_FEC_DESBLOQUEO DATE,
                BL_IP_DESBLOUEO VARCHAR(20),
                BL_ESTADO VARCHAR(1) NOT NULL,
                CONSTRAINT seg_bloqueos_pk PRIMARY KEY (BL_ID_REGISTRO)
);
COMMENT ON TABLE SEG_BLOQUEOS_TBL IS 'Tabla que contiene informacion de los bloqueos provocados por errores de usuario';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_ID_REGISTRO IS 'Id que identifica el registro';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_TIPO_BLOQUEO IS 'Tipo de bloqueo: Bloqueo diario(DIA), Bloqueo Definitivo(DEF)';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_FEC_REGISTRO IS 'Fecha de registro';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.US_USR_BLOQUEO IS 'Id de usuario que provoca el bloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_IP_BLOQUEO IS 'Direccion Ip donde se genera el bloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_TIPO_DESBLOQUEO IS 'Tipo de desbloqueo: Manual(MAN); Automatico(AUT)';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.US_USR_DESBLOQUEO IS 'Id del usuario que genera el desbloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_FEC_DESBLOQUEO IS 'Fecha de desbloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_IP_DESBLOUEO IS 'Direccion IP donde se realiza el desbloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_TBL.BL_ESTADO IS 'Estado del registro. Activo(A); Inactivo(I)';


CREATE TABLE SEG_BLOQUEOS_T (
                ID_BLOQUEO BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                TIPO VARCHAR(1) NOT NULL,
                IP_EQUIPO VARCHAR(20) NOT NULL,
                FEC_CREACION DATE NOT NULL,
                CONSTRAINT seg_bloqueo_pk PRIMARY KEY (ID_BLOQUEO)
);
COMMENT ON TABLE SEG_BLOQUEOS_T IS 'Tabla que almacena la informacion de los bloqueos de los usuarios';
COMMENT ON COLUMN SEG_BLOQUEOS_T.ID_BLOQUEO IS 'Id. que identifica el proceso ';
COMMENT ON COLUMN SEG_BLOQUEOS_T.US_ID_USUARIO IS 'Id. del usuario que se bloquea';
COMMENT ON COLUMN SEG_BLOQUEOS_T.TIPO IS 'Indica si es un bloqueo B, Desbloqueo D';
COMMENT ON COLUMN SEG_BLOQUEOS_T.IP_EQUIPO IS 'Ip del equipo que registra el bloqueo';
COMMENT ON COLUMN SEG_BLOQUEOS_T.FEC_CREACION IS 'Fecha de creacion del registro';


CREATE TABLE SEG_EVENTOSXPROC_T (
                ID_EVENTOXPRO BIGINT NOT NULL,
                CAT_MECANISMO BIGINT NOT NULL,
                ID_PROCSEG BIGINT NOT NULL,
                TIPO_CEDULA VARCHAR(2),
                MOTIVO VARCHAR(250),
                CEDIDEUSU CHAR(10) NOT NULL,
                IND_DEDOS VARCHAR(1),
                INDICE_DACTILAR VARCHAR(550),
                FEC_EXP_CEDULA DATE,
                ESTADO VARCHAR(1),
                CAT_MOTIVO_FALLA BIGINT,
                US_ID_USUARIO BIGINT NOT NULL,
                ID_USU_CREACION BIGINT NOT NULL,
                FEC_CREACION DATE NOT NULL,
                IP_EQUIPO VARCHAR(20) NOT NULL,
                ID_BLOQUEO BIGINT NOT NULL,
                CONSTRAINT seg_eventosxproc_pk PRIMARY KEY (ID_EVENTOXPRO)
);
COMMENT ON TABLE SEG_EVENTOSXPROC_T IS 'Tabla que almacena los eventos de seguridad';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.ID_EVENTOXPRO IS 'Id. que identifica el evento por proceso';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.CAT_MECANISMO IS 'Indica el tipo de validacion';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.ID_PROCSEG IS 'Identificador del proceso';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.TIPO_CEDULA IS 'Indica el tipo de cedula. Electronica E, Papel P';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.MOTIVO IS 'Motivo por el cual no se presenta la cedula electronica';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.CEDIDEUSU IS 'Identificacion del afiliado, pensionista,etc.';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.IND_DEDOS IS 'Indica si tiene o no dedos. Tiene dedos S, no tiene dedos N';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.INDICE_DACTILAR IS 'Codigo del indice dactilar';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.FEC_EXP_CEDULA IS 'Fecha de expedicion de la cedula ';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.ESTADO IS 'Estado del evento. Fallido ''F'', Exitoso ''E''';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.CAT_MOTIVO_FALLA IS 'Motivo de falla del intento';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.US_ID_USUARIO IS 'Id. del usuario creado';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.ID_USU_CREACION IS 'Usuario que crea el registro';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.FEC_CREACION IS 'Fecha de creacion del registro';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.IP_EQUIPO IS 'Ip del equipo desde el que se realiza la transaccion';
COMMENT ON COLUMN SEG_EVENTOSXPROC_T.ID_BLOQUEO IS 'Id. que identifica el bloqueo';


CREATE TABLE SEG_BITACCESOAPP_TBL (
                BA_ID_BITACORA BIGINT NOT NULL,
                AP_ID_APLICACION BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                US_USUARIO VARCHAR(20) NOT NULL,
                BA_ESTADO VARCHAR(1) NOT NULL,
                BA_FEC_ACCESO DATE NOT NULL,
                CONSTRAINT seg_bitaccesoapp_pk PRIMARY KEY (BA_ID_BITACORA)
);
COMMENT ON TABLE SEG_BITACCESOAPP_TBL IS 'Tabla que almacena una bitacora de acceso a las aplicaciones';
COMMENT ON COLUMN SEG_BITACCESOAPP_TBL.BA_ID_BITACORA IS 'Id.que identifica el registro';
COMMENT ON COLUMN SEG_BITACCESOAPP_TBL.AP_ID_APLICACION IS 'Id. que identifica a la aplicacion';
COMMENT ON COLUMN SEG_BITACCESOAPP_TBL.US_ID_USUARIO IS 'Id. que identifica al usuario';
COMMENT ON COLUMN SEG_BITACCESOAPP_TBL.US_USUARIO IS 'Usuario que registra el acceso';


CREATE TABLE SEG_AUDITORIASWS_TBL (
                AW_ID_AUWS BIGINT NOT NULL,
                SW_ID_SERVICIO BIGINT NOT NULL,
                SW_NOMBRE_SERVICIO VARCHAR(200) NOT NULL,
                MS_ID_METODO BIGINT NOT NULL,
                MS_NOMBRE_METODO VARCHAR(200) NOT NULL,
                TS_ID_TIPOSERVICIO BIGINT NOT NULL,
                AW_NUM_DOCUMENTO VARCHAR(10) NOT NULL,
                AW_NOMBRE VARCHAR(100) NOT NULL,
                AW_CLAVE VARCHAR(300) NOT NULL,
                AW_DIRECCION_IP VARCHAR(20) NOT NULL,
                AW_FECHA_TRANSACCION DATE NOT NULL,
                ID_PROCSEG BIGINT NOT NULL,
                AW_TRAMA_ENTRADA TEXT NOT NULL,
                AW_TRAMA_SALIDA TEXT,
                CONSTRAINT seg_accesoshist_pk PRIMARY KEY (AW_ID_AUWS)
);
COMMENT ON TABLE SEG_AUDITORIASWS_TBL IS 'Tabla que contine informacion historica de los accesos de los servicios web';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_ID_AUWS IS 'Id que identifica al historico de acceso';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.SW_ID_SERVICIO IS 'Id que identifica el servicio web';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.SW_NOMBRE_SERVICIO IS 'Nombre del servicio web';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.MS_ID_METODO IS 'Id que identifica el metodo';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.MS_NOMBRE_METODO IS 'Nombre del metodo del servicio web';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.TS_ID_TIPOSERVICIO IS 'Id que identifica el tipo de servicio web';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_NUM_DOCUMENTO IS 'Numero de documento del responsable del acceso';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_NOMBRE IS 'Nombre del responsable del acceso';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_CLAVE IS 'Clave de acceso del responsable del acceso';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_DIRECCION_IP IS 'Direccion IP del responsable del acceso';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.AW_FECHA_TRANSACCION IS 'Fecha de la transacción';
COMMENT ON COLUMN SEG_AUDITORIASWS_TBL.ID_PROCSEG IS 'Id. del proceso para el que se utiliza el servicio web';


CREATE TABLE SEG_AUDITORIASAPP_TBL (
                AA_ID_AUDITORIAAPP BIGINT NOT NULL,
                US_ID_USUARIO BIGINT NOT NULL,
                US_USUARIO VARCHAR(20) NOT NULL,
                US_NUM_DOCUMENTO VARCHAR(20) NOT NULL,
                AA_FEC_AUDITORIA DATE NOT NULL,
                AA_DIRECCION_IP VARCHAR(20) NOT NULL,
                RO_ID_ROL BIGINT NOT NULL,
                RO_NOMBRE VARCHAR(200) NOT NULL,
                ME_ID_OPCION BIGINT NOT NULL,
                ME_ETIQUETA VARCHAR(500) NOT NULL,
                AP_ID_APLICACION BIGINT NOT NULL,
                AP_NOMBRE VARCHAR(200) NOT NULL,
                AA_TIPO VARCHAR(1),
                CONSTRAINT seg_auditoriasapp_pk PRIMARY KEY (AA_ID_AUDITORIAAPP)
);
COMMENT ON TABLE SEG_AUDITORIASAPP_TBL IS 'Tabal que contiene informacion del acceso a las opciones de menu asignadas a los usuarios';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AA_ID_AUDITORIAAPP IS 'Id que identifica el registro';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.US_ID_USUARIO IS 'Id que identifica al usuario que utiliza la opcion';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.US_USUARIO IS 'Nombre de usuario que usa la aplicacion';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.US_NUM_DOCUMENTO IS 'Numero del documento del usuario';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AA_FEC_AUDITORIA IS 'Fecha en que se registra la auditoria';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AA_DIRECCION_IP IS 'Direccion IP donde se ejecuta la opcion de menu';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.RO_ID_ROL IS 'Id que identifica el rol del usuario';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.RO_NOMBRE IS 'Nombre del rol asignado al usuario';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.ME_ID_OPCION IS 'Id que identifica  la opcion de menu utilizada por el rol del usuario';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.ME_ETIQUETA IS 'Etiqueta de la opcion';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AP_ID_APLICACION IS 'Id que identifica la aplicacion asignada a  la opcion de menu utilizada por el rol del usuario';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AP_NOMBRE IS 'Nombre de la aplicacion';
COMMENT ON COLUMN SEG_AUDITORIASAPP_TBL.AA_TIPO IS 'Id que identifica el registro';


CREATE TABLE SEG_APLICACIONES_TBL (
                AP_ID_APLICACION BIGINT NOT NULL,
                AP_NOMBRE VARCHAR(200) NOT NULL,
                AP_DESCRIPCION VARCHAR(500) NOT NULL,
                AP_IMAGEN BYTEA,
                AP_URL VARCHAR(300) NOT NULL,
                AP_TIPO VARCHAR(5) NOT NULL,
                AP_ESTADO VARCHAR(1) NOT NULL,
                DE_ID_DEPENDENCIA BIGINT NOT NULL,
                CA_ID_CATEGORIA BIGINT NOT NULL,
                AP_EXT_IMG VARCHAR(5),
                AP_COD_APLICACION VARCHAR(10),
                AP_VISIBLE BIGINT NOT NULL,
                AP_NOM_IMG VARCHAR(50),
                AP_DES_CONT VARCHAR(500),
                CONSTRAINT seg_aplicaciones_pk PRIMARY KEY (AP_ID_APLICACION)
);
COMMENT ON TABLE SEG_APLICACIONES_TBL IS 'Tabla que contiene informacion de las aplicaciones';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_ID_APLICACION IS 'Id. que identifica a la aplicacion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_NOMBRE IS 'Nombre de la Aplicacion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_DESCRIPCION IS 'Descripci¿n de la aplicaci¿n';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_IMAGEN IS 'Imagen que identifica la aplicaci¿n';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_URL IS 'Url de la aplicaci¿n';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_TIPO IS 'Tipo de aplicaci¿n: APX: Apex; JEE:Java';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_ESTADO IS 'Estado de la aplicacion. Activo ''A'', Inactivo ''I''';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.DE_ID_DEPENDENCIA IS 'Id que identifica a la dependencia relacionada a la aplicacion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.CA_ID_CATEGORIA IS 'Identifica la categoria a la que pertenece la aplicacion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_EXT_IMG IS 'Extension de la imagen de la opcion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_COD_APLICACION IS 'Codigo de aplicacion';
COMMENT ON COLUMN SEG_APLICACIONES_TBL.AP_VISIBLE IS 'Visible (1=visible,0=no visible).';


CREATE UNIQUE INDEX seg_aplicaciones_uk
 ON SEG_APLICACIONES_TBL USING BTREE
 ( AP_COD_APLICACION );

CLUSTER seg_aplicaciones_uk ON SEG_APLICACIONES_TBL;

CREATE INDEX seg_aplicaciones_idx01
 ON SEG_APLICACIONES_TBL USING BTREE
 ( DE_ID_DEPENDENCIA );

CLUSTER seg_aplicaciones_idx01 ON SEG_APLICACIONES_TBL;

CREATE TABLE MIGR_DATATYPE_TRANSFORM_MAP (
                ID BIGINT NOT NULL,
                PROJECT_ID_FK BIGINT NOT NULL,
                MAP_NAME VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT migr_datatype_transform_m_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MIGR_DATATYPE_TRANSFORM_MAP IS 'Table for storing data type maps.  A map is simply a collection of rules';
COMMENT ON COLUMN MIGR_DATATYPE_TRANSFORM_MAP.ID IS 'Primary Key';
COMMENT ON COLUMN MIGR_DATATYPE_TRANSFORM_MAP.PROJECT_ID_FK IS '//PARENTFIELD';
COMMENT ON COLUMN MIGR_DATATYPE_TRANSFORM_MAP.MAP_NAME IS 'A name for the map';


CREATE TABLE MD_TABLES (
                ID BIGINT NOT NULL,
                SCHEMA_ID_FK BIGINT NOT NULL,
                TABLE_NAME VARCHAR(4000) NOT NULL,
                NATIVE_SQL TEXT,
                NATIVE_KEY VARCHAR(4000),
                QUALIFIED_NATIVE_NAME VARCHAR(4000) NOT NULL,
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_tables_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_TABLES IS 'Table used to store information about tables.';
COMMENT ON COLUMN MD_TABLES.ID IS 'Primary Key';
COMMENT ON COLUMN MD_TABLES.SCHEMA_ID_FK IS 'Schema in which this table resides //PARENTFIELD';
COMMENT ON COLUMN MD_TABLES.TABLE_NAME IS 'Name of the table //OBJECTNAME';
COMMENT ON COLUMN MD_TABLES.NATIVE_SQL IS 'SQL Used to create this table at soruce';
COMMENT ON COLUMN MD_TABLES.NATIVE_KEY IS 'Unique identifier for this table at source';


CREATE TABLE MD_PROJECTS (
                ID BIGINT NOT NULL,
                PROJECT_NAME VARCHAR(4000) NOT NULL,
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_projects_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_PROJECTS IS 'This is a top level container for a set of connections.';
COMMENT ON COLUMN MD_PROJECTS.ID IS 'Primary key';
COMMENT ON COLUMN MD_PROJECTS.PROJECT_NAME IS 'Name of the project //OBJECTNAME';


CREATE TABLE MD_PRIVILEGES (
                ID BIGINT NOT NULL,
                SCHEMA_ID_FK BIGINT NOT NULL,
                PRIVILEGE_NAME VARCHAR(4000) NOT NULL,
                PRIVELEGE_OBJECT_ID BIGINT,
                PRIVELEGEOBJECTTYPE VARCHAR(4000) NOT NULL,
                PRIVELEGE_TYPE VARCHAR(4000) NOT NULL,
                ADMIN_OPTION CHAR(1),
                NATIVE_SQL TEXT NOT NULL,
                NATIVE_KEY VARCHAR(4000),
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_privileges_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_PRIVILEGES IS 'This table stores privilege information';
COMMENT ON COLUMN MD_PRIVILEGES.ID IS 'Primary Key';
COMMENT ON COLUMN MD_PRIVILEGES.SCHEMA_ID_FK IS 'The schema to which this object belongs //PARENTFIELD';
COMMENT ON COLUMN MD_PRIVILEGES.PRIVILEGE_NAME IS 'The name of the privilege //OBJECTNAME';
COMMENT ON COLUMN MD_PRIVILEGES.PRIVELEGE_OBJECT_ID IS 'This references the table, view, etc on which the privelege exists.  This can be NULL for things like system wide privileges';
COMMENT ON COLUMN MD_PRIVILEGES.PRIVELEGEOBJECTTYPE IS 'The type the privelege is on (e.g. INDEX)';
COMMENT ON COLUMN MD_PRIVILEGES.PRIVELEGE_TYPE IS 'e.g.select';
COMMENT ON COLUMN MD_PRIVILEGES.ADMIN_OPTION IS 'Flag to show if this was granted with admin option.  ''Y'' means it was granted with admin option ''N'' means it was NOT granted with admin option.  NULL means not applicable (e.g. not known, not supported by source platform, etc.)';
COMMENT ON COLUMN MD_PRIVILEGES.NATIVE_SQL IS 'The SQL used to create this privilege at source';
COMMENT ON COLUMN MD_PRIVILEGES.NATIVE_KEY IS 'An identifier for this object at source.';


CREATE TABLE MD_CONNECTIONS (
                ID BIGINT NOT NULL,
                PROJECT_ID_FK BIGINT NOT NULL,
                TYPE VARCHAR(4000),
                HOST VARCHAR(4000),
                PORT BIGINT,
                USERNAME VARCHAR(4000),
                PASSWORD VARCHAR(4000),
                DBURL VARCHAR(4000),
                NAME VARCHAR(255),
                NATIVE_SQL TEXT,
                STATUS VARCHAR(30),
                NUM_CATALOGS BIGINT,
                NUM_COLUMNS BIGINT,
                NUM_CONSTRAINTS BIGINT,
                NUM_GROUPS BIGINT,
                NUM_ROLES BIGINT,
                NUM_INDEXES BIGINT,
                NUM_OTHER_OBJECTS BIGINT,
                NUM_PACKAGES BIGINT,
                NUM_PRIVILEGES BIGINT,
                NUM_SCHEMAS BIGINT,
                NUM_SEQUENCES BIGINT,
                NUM_STORED_PROGRAMS BIGINT,
                NUM_SYNONYMS BIGINT,
                NUM_TABLES BIGINT,
                NUM_TABLESPACES BIGINT,
                NUM_TRIGGERS BIGINT,
                NUM_USER_DEFINED_DATA_TYPES BIGINT,
                NUM_USERS BIGINT,
                NUM_VIEWS BIGINT,
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_connections_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_CONNECTIONS IS 'This table is used to store connection information.  For example, in migrations, we could be carrying out a consolidation which occurs across many connections.';
COMMENT ON COLUMN MD_CONNECTIONS.ID IS 'Primary key';
COMMENT ON COLUMN MD_CONNECTIONS.PROJECT_ID_FK IS 'The project to which this connection belongs //PARENTFIELD';
COMMENT ON COLUMN MD_CONNECTIONS.TYPE IS 'The type of the connection - For example it could be used to store "ORACLE" or "MYSQL"';
COMMENT ON COLUMN MD_CONNECTIONS.HOST IS 'The host to which this connection connects.';
COMMENT ON COLUMN MD_CONNECTIONS.PORT IS 'The port to which this connection connects';
COMMENT ON COLUMN MD_CONNECTIONS.USERNAME IS 'The username used to make the connection';
COMMENT ON COLUMN MD_CONNECTIONS.PASSWORD IS 'The password used to make this connection';
COMMENT ON COLUMN MD_CONNECTIONS.DBURL IS 'The database url used to make this connection';
COMMENT ON COLUMN MD_CONNECTIONS.NAME IS '//OBJECTNAME';
COMMENT ON COLUMN MD_CONNECTIONS.NATIVE_SQL IS 'The native sql used to create this connection';
COMMENT ON COLUMN MD_CONNECTIONS.STATUS IS 'Status of Migration, = captured,converted,generated,datamoved';


CREATE TABLE MD_COLUMNS (
                ID BIGINT NOT NULL,
                TABLE_ID_FK BIGINT NOT NULL,
                COLUMN_NAME VARCHAR(4000) NOT NULL,
                COLUMN_ORDER BIGINT NOT NULL,
                COLUMN_TYPE VARCHAR(4000),
                PRECISION BIGINT,
                SCALE BIGINT,
                NULLABLE CHAR(1) NOT NULL,
                DEFAULT_VALUE VARCHAR(4000),
                NATIVE_SQL TEXT,
                NATIVE_KEY VARCHAR(4000),
                DATATYPE_TRANSFORMED_FLAG CHAR(1),
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_BY VARCHAR(255),
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                LAST_UPDATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                CONSTRAINT md_columns_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_COLUMNS IS 'Column information is stored in this table.';
COMMENT ON COLUMN MD_COLUMNS.ID IS 'Primary Key';
COMMENT ON COLUMN MD_COLUMNS.TABLE_ID_FK IS 'The table that this column is part of //PARENTFIELD';
COMMENT ON COLUMN MD_COLUMNS.COLUMN_NAME IS 'The name of the column //OBJECTNAME';
COMMENT ON COLUMN MD_COLUMNS.COLUMN_ORDER IS 'The order this appears in the table';
COMMENT ON COLUMN MD_COLUMNS.COLUMN_TYPE IS 'The type of the column';
COMMENT ON COLUMN MD_COLUMNS.PRECISION IS 'The precision on the column';
COMMENT ON COLUMN MD_COLUMNS.SCALE IS 'The scale of the column';
COMMENT ON COLUMN MD_COLUMNS.NULLABLE IS 'Yes or No.  Null signifies NO';
COMMENT ON COLUMN MD_COLUMNS.DEFAULT_VALUE IS 'Default value on the column';
COMMENT ON COLUMN MD_COLUMNS.NATIVE_SQL IS 'The SQL used to create this column at source';
COMMENT ON COLUMN MD_COLUMNS.NATIVE_KEY IS 'Unique identifier for this object at source';
COMMENT ON COLUMN MD_COLUMNS.DATATYPE_TRANSFORMED_FLAG IS 'This is set to ''Y'' to show if the data type was transformed.  This is useful so we don''t apply more than 1 datatype transformation to a column';


CREATE TABLE MD_CATALOGS (
                ID BIGINT NOT NULL,
                CONNECTION_ID_FK BIGINT NOT NULL,
                CATALOG_NAME VARCHAR(4000),
                DUMMY_FLAG CHAR(1) DEFAULT 'N' ,
                NATIVE_SQL TEXT,
                NATIVE_KEY VARCHAR(4000),
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_catalogs_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_CATALOGS IS 'Store catalogs in this table.';
COMMENT ON COLUMN MD_CATALOGS.CONNECTION_ID_FK IS 'Foreign key into the connections table - Shows what connection this catalog belongs to //PARENTFIELD';
COMMENT ON COLUMN MD_CATALOGS.CATALOG_NAME IS 'Name of the catalog //OBJECTNAME';
COMMENT ON COLUMN MD_CATALOGS.DUMMY_FLAG IS 'Flag to show if this catalog is a "dummy" catalog which is used as a placeholder for those platforms that do not support catalogs.  ''N'' signifies that this is NOT a dummy catalog, while ''Y'' signifies that it is.';
COMMENT ON COLUMN MD_CATALOGS.NATIVE_SQL IS 'THe SQL used to create this catalog';
COMMENT ON COLUMN MD_CATALOGS.NATIVE_KEY IS 'A unique identifier used to identify the catalog at source.';


CREATE TABLE MD_SCHEMAS (
                ID BIGINT NOT NULL,
                CATALOG_ID_FK BIGINT NOT NULL,
                NAME VARCHAR(4000),
                TYPE CHAR(1),
                CHARACTER_SET VARCHAR(4000),
                VERSION_TAG VARCHAR(40),
                NATIVE_SQL TEXT,
                NATIVE_KEY VARCHAR(4000),
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_schemas_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_SCHEMAS IS 'This is the holder for schemas';
COMMENT ON COLUMN MD_SCHEMAS.ID IS 'Primary Key';
COMMENT ON COLUMN MD_SCHEMAS.CATALOG_ID_FK IS 'Catalog to which this schema blongs //PARENTFIELD';
COMMENT ON COLUMN MD_SCHEMAS.NAME IS 'Name of the schema //OBJECTNAME';
COMMENT ON COLUMN MD_SCHEMAS.TYPE IS 'Type of this schema.  Eaxamples are ''CAPTURED'' OR ''CONVERTED''';
COMMENT ON COLUMN MD_SCHEMAS.CHARACTER_SET IS 'The characterset of this schema';
COMMENT ON COLUMN MD_SCHEMAS.VERSION_TAG IS 'A version string that can be used for tagging/baseling a schema';
COMMENT ON COLUMN MD_SCHEMAS.NATIVE_SQL IS 'The native SQL used to create this schema';
COMMENT ON COLUMN MD_SCHEMAS.NATIVE_KEY IS 'A unique identifier that this schema is known as in its source state.';


CREATE TABLE MD_PACKAGES (
                ID BIGINT NOT NULL,
                SCHEMA_ID_FK BIGINT NOT NULL,
                NAME VARCHAR(4000) NOT NULL,
                PACKAGE_HEADER TEXT,
                NATIVE_SQL TEXT,
                NATIVE_KEY VARCHAR(4000),
                LANGUAGE VARCHAR(40) NOT NULL,
                COMMENTS VARCHAR(4000),
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_packages_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_PACKAGES IS 'For storing packages';
COMMENT ON COLUMN MD_PACKAGES.ID IS 'Primary Key';
COMMENT ON COLUMN MD_PACKAGES.SCHEMA_ID_FK IS 'the schema in which this package resides //PARENTFIELD';
COMMENT ON COLUMN MD_PACKAGES.NAME IS 'Name of this package //OBJECTNAME';
COMMENT ON COLUMN MD_PACKAGES.NATIVE_SQL IS 'The SQL used to create this package at source';
COMMENT ON COLUMN MD_PACKAGES.NATIVE_KEY IS 'A unique identifer for this object at source.';
COMMENT ON COLUMN MD_PACKAGES.LANGUAGE IS '//PUBLIC';


CREATE TABLE MD_APPLICATIONS (
                ID BIGINT NOT NULL,
                NAME VARCHAR(4000),
                DESCRIPTION VARCHAR(4000),
                BASE_DIR VARCHAR(4000),
                OUTPUT_DIR VARCHAR(4000),
                BACKUP_DIR VARCHAR(4000),
                INPLACE BIGINT,
                PROJECT_ID_FK BIGINT NOT NULL,
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(255),
                LAST_UPDATED_ON DATE,
                LAST_UPDATED_BY VARCHAR(255),
                CONSTRAINT md_applications_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_APPLICATIONS IS 'This is the base table for application projects.  It holds the base information for applications associated with a database';
COMMENT ON COLUMN MD_APPLICATIONS.ID IS 'Primary Key';
COMMENT ON COLUMN MD_APPLICATIONS.NAME IS 'Name of the application suite  //OBJECTNAME';
COMMENT ON COLUMN MD_APPLICATIONS.DESCRIPTION IS 'Overview of what the application does.';
COMMENT ON COLUMN MD_APPLICATIONS.BASE_DIR IS 'This is the base src directory for the application.  It could be an svn checkout, a clearcase view or something similar';
COMMENT ON COLUMN MD_APPLICATIONS.OUTPUT_DIR IS 'This is the output directory where the scanner will present the converted files, if there are converted or modified.';
COMMENT ON COLUMN MD_APPLICATIONS.BACKUP_DIR IS 'This is the directory in which the application files are backed up if a backp is chosen';
COMMENT ON COLUMN MD_APPLICATIONS.INPLACE IS 'Designates whether the changes have been made inplace, in the source directory or not';
COMMENT ON COLUMN MD_APPLICATIONS.PROJECT_ID_FK IS 'project of the database(s) this application relates to';


CREATE TABLE MD_APPLICATIONFILES (
                ID BIGINT NOT NULL,
                APPLICATIONS_ID_FK BIGINT NOT NULL,
                NAME VARCHAR(200) NOT NULL,
                URI VARCHAR(4000) NOT NULL,
                TYPE VARCHAR(100) NOT NULL,
                STATE VARCHAR(100) NOT NULL,
                LANGUAGE VARCHAR(100),
                LOC BIGINT,
                SECURITY_GROUP_ID BIGINT DEFAULT 0  NOT NULL,
                CREATED_ON DATE DEFAULT sysdate  NOT NULL,
                CREATED_BY VARCHAR(4000),
                UPDATED_ON DATE,
                UPDATED_BY VARCHAR(4000),
                CONSTRAINT md_applicationfiles_pk PRIMARY KEY (ID)
);
COMMENT ON TABLE MD_APPLICATIONFILES IS 'Holds a tuple for each file that is being processed whether it is changed or not.';
COMMENT ON COLUMN MD_APPLICATIONFILES.NAME IS 'file name  //OBJECTNAME';
COMMENT ON COLUMN MD_APPLICATIONFILES.URI IS 'The uri is the part of the file url after the base dir has been removed.  See MD_APPLICATION for base dir';
COMMENT ON COLUMN MD_APPLICATIONFILES.TYPE IS 'This will denote the type of file we have, including DIR, FILE (text), BINARY, IGNORE (where we choose to ignore files)';
COMMENT ON COLUMN MD_APPLICATIONFILES.STATE IS 'State will be how this file is operated on.  For example. it will be OPEN, NEW, FIXED, IGNORED, REVIEWED, COMPLETE';
COMMENT ON COLUMN MD_APPLICATIONFILES.LANGUAGE IS 'Language of the file that has been processed.';
COMMENT ON COLUMN MD_APPLICATIONFILES.SECURITY_GROUP_ID IS 'APEX';
COMMENT ON COLUMN MD_APPLICATIONFILES.CREATED_ON IS 'APEX';
COMMENT ON COLUMN MD_APPLICATIONFILES.CREATED_BY IS 'APEX';
COMMENT ON COLUMN MD_APPLICATIONFILES.UPDATED_ON IS 'APEX';
COMMENT ON COLUMN MD_APPLICATIONFILES.UPDATED_BY IS 'APEX';


CREATE INDEX md_app_file_type_idx
 ON MD_APPLICATIONFILES USING BTREE
 ( TYPE, ID );

CLUSTER md_app_file_type_idx ON MD_APPLICATIONFILES;

CREATE INDEX md_state_type__id
 ON MD_APPLICATIONFILES USING BTREE
 ( STATE, TYPE, ID );

CLUSTER md_state_type__id ON MD_APPLICATIONFILES;

ALTER TABLE SEG_BLOQUEOS_T ADD CONSTRAINT seg_usu_bloqueos_fk
FOREIGN KEY (US_ID_USUARIO)
REFERENCES SEG_USUARIOS_TBL (US_ID_USUARIO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_SERVICIOSWEB_TBL ADD CONSTRAINT seg_tiposserv_serviciosweb_fk
FOREIGN KEY (TS_ID_TIPOSERVICIO)
REFERENCES SEG_TIPOSSERVICIOS_TBL (TS_ID_TIPOSERVICIO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLES_TBL ADD CONSTRAINT seg_tiporol_roles_fk
FOREIGN KEY (TR_ID_TIPOROL)
REFERENCES SEG_TIPOROLES_TBL (TR_ID_TIPOROL)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_PARAMXMETODO_TBL ADD CONSTRAINT seg_tipodato_parxmet_fk
FOREIGN KEY (TD_ID_TIP_DATO)
REFERENCES SEG_TIPODATOXSERVICIO_TBL (TD_ID_TIP_DATO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_METODOSXSOL_TBL ADD CONSTRAINT seg_solicconex_metxsol_fk
FOREIGN KEY (SC_ID_SOLCONEXION)
REFERENCES SEG_SOLICITUDESXCONEXION_TBL (SC_ID_SOLCONEXION)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_METODOSXSERVICIO_TBL ADD CONSTRAINT seg_servicweb_metodxserv_fk
FOREIGN KEY (SW_ID_SERVICIO)
REFERENCES SEG_SERVICIOSWEB_TBL (SW_ID_SERVICIO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLXDEPENDENCIAS_TBL ADD CONSTRAINT seg_roles_rolxdep_fk
FOREIGN KEY (RO_ID_ROL)
REFERENCES SEG_ROLES_TBL (RO_ID_ROL)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLXMENU_TBL ADD CONSTRAINT seg_roles_rolxmenu_fk
FOREIGN KEY (RO_ID_ROL)
REFERENCES SEG_ROLES_TBL (RO_ID_ROL)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLXUSUARIO_TBL ADD CONSTRAINT seg_roles_rolxusuario_fk
FOREIGN KEY (RO_ID_ROL)
REFERENCES SEG_ROLES_TBL (RO_ID_ROL)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLXUSUHIST_TBL ADD CONSTRAINT seg_rolxusu_rolxusuhist_fk
FOREIGN KEY (RU_ID_ROLXUSU)
REFERENCES SEG_ROLXUSUARIO_TBL (RU_ID_ROLXUSU)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_AUDITORIASWS_TBL ADD CONSTRAINT seg_procseg_auditws_fk
FOREIGN KEY (ID_PROCSEG)
REFERENCES SEG_PROCESOSSEG_TP (ID_PROCSEG)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_PARAMETROSHIST_TBL ADD CONSTRAINT seg_parametros_paramethist_fk
FOREIGN KEY (PA_ID_PARAMETRO)
REFERENCES SEG_PARAMETROS_TBL (PA_ID_PARAMETRO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_METODOSXSOL_TBL ADD CONSTRAINT seg_metodos_metxsol_fk
FOREIGN KEY (MS_ID_METODO)
REFERENCES SEG_METODOSXSERVICIO_TBL (MS_ID_METODO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_PARAMXMETODO_TBL ADD CONSTRAINT seg_metxserv_parxmet_fk
FOREIGN KEY (MS_ID_METODO)
REFERENCES SEG_METODOSXSERVICIO_TBL (MS_ID_METODO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_ROLXMENU_TBL ADD CONSTRAINT seg_menu_rolxmenu_fk
FOREIGN KEY (ME_ID_OPCION)
REFERENCES SEG_MENU_TBL (ME_ID_OPCION)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_DEPENDENCIAS_TBL ADD CONSTRAINT seg_institucion_dependencia_fk
FOREIGN KEY (IN_ID_INSTITUCION)
REFERENCES SEG_INSTITUCIONES_TBL (IN_ID_INSTITUCION)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_APLICACIONES_TBL ADD CONSTRAINT seg_dependencia_aplicacion_fk
FOREIGN KEY (DE_ID_DEPENDENCIA)
REFERENCES SEG_DEPENDENCIAS_TBL (DE_ID_DEPENDENCIA)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_RESPXUSU_T ADD CONSTRAINT seg_dataut_respxusu_fk
FOREIGN KEY (ID_DATAUT)
REFERENCES SEG_DATOSAUTENT_TP (ID_DATAUT)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_APLICACIONES_TBL ADD CONSTRAINT seg_categoria_aplicacion_fk
FOREIGN KEY (CA_ID_CATEGORIA)
REFERENCES SEG_CATEGORIAS_TBL (CA_ID_CATEGORIA)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE SEG_EVENTOSXPROC_T ADD CONSTRAINT seg_bloq_evenxproc_fk
FOREIGN KEY (ID_BLOQUEO)
REFERENCES SEG_BLOQUEOS_T (ID_BLOQUEO)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_COLUMNS ADD CONSTRAINT md_columns_md_tables_fk1
FOREIGN KEY (TABLE_ID_FK)
REFERENCES MD_TABLES (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_APPLICATIONS ADD CONSTRAINT md_app_proj_fk
FOREIGN KEY (PROJECT_ID_FK)
REFERENCES MD_PROJECTS (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_CATALOGS ADD CONSTRAINT md_catalogs_md_connection_fk1
FOREIGN KEY (CONNECTION_ID_FK)
REFERENCES MD_CONNECTIONS (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_SCHEMAS ADD CONSTRAINT md_schemas_md_catalogs_fk1
FOREIGN KEY (CATALOG_ID_FK)
REFERENCES MD_CATALOGS (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_PACKAGES ADD CONSTRAINT md_packages_md_schemas_fk1
FOREIGN KEY (SCHEMA_ID_FK)
REFERENCES MD_SCHEMAS (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE MD_APPLICATIONFILES ADD CONSTRAINT md_file_app_fk
FOREIGN KEY (APPLICATIONS_ID_FK)
REFERENCES MD_APPLICATIONS (ID)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;
