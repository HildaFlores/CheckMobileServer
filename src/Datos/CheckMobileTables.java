package Datos;

/**
 *
 * @author Prueba
 */
public class CheckMobileTables {

    public static final class TIPO_TELEFONO {

        public static final String TABLE_NAME = "tipo_telefono";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_TIPO = "id_tipo";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String ESTADO = "estado";
        public static final String USUARIO_INSERCION = "usuario_insercion";

    }

    public static final class TELEFONOS {

        public static final String TABLE_NAME = "telefonos";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_ENTIDAD = "id_entidad";
        public static final String TIPO_ENTIDAD = "tipo_entidad";
        public static final String ID_TIPO = "id_tipo";
        public static final String NUMERO = "numero";
        public static final String PRIORIDAD = "prioridad";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String DESCRIPCION_TIPO = "desc_tipo";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String ESTADO = "estado";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACTUALIZACION = "usario_actualizacion";

    }

    public static final class TIPO_COMP_FISCAL {

        public static final String TABLE_NAME = "tipo_comp_fiscal";
        public static final String ID_TIPO_NCF = "id_tipo_ncf";
        public static final String DESCRIPCION = "descripcion";
        public static final String VALOR_FISCAL = "valor_fiscal";
        public static final String DOCUMENTO = "documento";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class CLIENTE {

        public static final String TABLE_NAME = "cliente";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_CLIENTE = "id_cliente";
        public static final String LIMITE_CREDITO = "limite_credito";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String EDAD = "edad";
        public static final String SEXO = "sexo";
        public static final String ESTADO_CIVIL = "estado_civil";
        public static final String DOCUMENTO_IDENTIDAD = "documento_identidad";
        public static final String RNC = "rnc";
        public static final String NOMBRE_EMPRESA = "nombre_empresa";
        public static final String CONTACTO_PRINCIPAL = "contacto principal";
        public static final String ID_CONDICION = "id_condicion";
        public static final String DESCRIPCION_CONDICION = "desc_con";
        public static final String NACIONALIDAD = "nacionalidad";
        public static final String APODO = "apodo";
        public static final String NOTAS = "notas";
        public static final String PAIS = "pais";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String FECHA_NACIMIENTO = "fecha_nac";
        public static final String CIUDAD_PROVINCIA = "ciudad_provincia";
        public static final String DIRECCION = "linea1";
        public static final String PROXIMOA= "linea2";
        public static final String TELEFONO = "telefono";
        public static final String CELULAR = "telefono_movil";
        public static final String CORREO = "direccion_email";
    }

    public static final class CONDICION_PAGO {

        public static final String TABLE_NAME = "condicion_pago";
        public static final String ID_CONDICION = "id_condicion";
        public static final String DIAS = "dias";
        public static final String DESCRIPCION = "descripcion";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class CLIENTE_DIRECCIONES {

        public static final String TABLE_NAME = "cliente_direcciones";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_CLIENTE = "id_cliente";
        public static final String SECUENCIA = "secuencia";
        public static final String CIUDAD_PROVINCIA = "ciudad";
        public static final String DESCRIPCION = "descripcion";
        public static final String SECTOR = "sector";
        public static final String MUNICIPIO = "municipio";
        public static final String PAIS = "pais";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String EDIFICIO = "edificio";
        public static final String APARTAMENTO = "apartamento";
        public static final String NOTAS = "linea2";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
    }

    public static final class COMBUSTIBLE_VEHICULO {

        public static final String TABLE_NAME = "combustible_vehiculo";
        public static final String ID_COMBUSTIBLE = "id_combustible";
        public static final String DESCRIPCION = "descripcion";
        public static final String ESTADO = "estado";

    }

    public static final class TIPO_VEHICULO {

        public static final String TABLE_NAME = "tipo_vehiculo";
        public static final String ID_TIPO_VEHICULO = "id_tipo_vehiculo";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";

    }

    public static final class VEHICULO {

        public static final String TABLE_NAME = "vehiculo";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_VEHICULO = "id_vehiculo";
        public static final String ID_TIPO_VEHICULO = "id_tipo_vehiculo";
        public static final String SECUENCIA_ENTRADA = "secuencia_entrada";
        public static final String CHASIS = "chasis";
        public static final String ID_MARCA = "id_marca";
        public static final String ID_MODELO = "id_modelo";
        public static final String ID_ESTILO = "id_estilo";
        public static final String NOTA = "nota";
        public static final String COLOR = "color";
        public static final String COLOR_INTERIOR = "color_interior";
        public static final String ANIO = "ano";
        public static final String FECHA_COMPRA = "fecha_compra";
        public static final String FILA_ASIENTO = "fila_asiento";
        public static final String CANT_PUERTA = "cant_puerta";
        public static final String ID_COMBUSTIBLE = "id_combustible";
        public static final String ID_TRACCION = "id_traccion";
        public static final String CILINDRAJE = "cilindraje";
        public static final String REFERENCIA = "referencia";
        public static final String PLACA = "placa";
        public static final String ID_CLIENTE = "id_cliente";
        public static final String ID_TIPO_VEH_DGII = "id_tipo_veh_dgii";
        public static final String MODELO_SEGUN_DGII = "modelo_segun_dgii";
        public static final String GARANTIA = "garantia";
        public static final String TIEMPO_GARANTIA = "tiempo_garantia";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String DESC_MARCA = "desc_marca";
        public static final String DESC_MODELO = "desc_modelo";
        public static final String DESC_ESTILO = "desc_estilo";
        public static final String CONDICION_VEHI = "condicion_vehi";
        public static final String CILINDRO = "cilindros";
        public static final String ESTADO_VEH = "estado_veh";
        public static final String ID_TRANSMISION = "id_transmision";
    }

    public static final class VEHICULO_MARCA {

        public static final String TABLE_NAME = "vehiculo_marca";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_MARCA = "id_marca";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class VEHICULO_MODELO {

        public static final String TABLE_NAME = "vehiculo_modelo";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_MODELO = "id_modelo";
        public static final String ID_MARCA = "id_marca";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class VEHICULO_ESTILO {

        public static final String TABLE_NAME = "vehiculo_estilo";
        public static final String ID_MODELO = "id_modelo";
        public static final String ID_ESTILO = "id_estilo";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class VEHICULO_TRACCION {

        public static final String TABLE_NAME = "vehiculo_traccion";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_TRACCION = "id_traccion";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class INSPECCION_VEHICULO {

        public static final String TABLE_NAME = "inspeccion_vehiculo";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_INSPECCION = "id_inspeccion";
        public static final String ID_VEHICULO = "id_vehiculo";
        public static final String ID_CLIENTE = "id_cliente";
        public static final String CHASIS = "chasis";
        public static final String REFERENCIA = "referencia";
        public static final String FECHA_INSPECCION = "fecha_inspeccion";
        public static final String SUPERVISOR = "supervisor";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String ID_ASESOR = "id_asesor";
        public static final String OBSERVACIONES = "observaciones";
        public static final String KILOMETRAJE = "kilometraje";
        public static final String MOTOR = "motor";
        public static final String ESTADO_INSPECCION = "estado_inspeccion";
    }

    public static final class INSPECCION_VEHICULO_DETALLE {

        public static final String TABLE_NAME = "inspeccion_vehiculo_detalle";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_INSPECCION = "id_inspeccion";
        public static final String ID_VEHICULO = "id_vehiculo";
        public static final String ID_GRUPO_INSPECCION = "id_grupo_inspeccion";
        public static final String ID_ELEMENTO_INSPECCION = "id_elemento_inspeccion";
        public static final String ID_TIPO_TRANS = "id_tipo_trans";
        public static final String OBSERVACION = "observacion";
        public static final String PUNTUACION = "puntuacion";
        public static final String GRADO = "grado";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String ID_RESPUESTA = "id_respuesta";
        public static final String ID_LISTA_PARAMETRO = "id_lista_parametro";
        public static final String DESC_RESPUESTA = "desc_respuesta";
        public static final String DESC_ELEMENTO = "desc_elemento";

    }

    public static final class CTE_REPRESENTANTE_VEN {

        public static final String TABLE_NAME = "cte_representante_ven";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_REPRESENTANTE = "id_rep_ven";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String DOCUMENTO_IDENTIDAD = "documento_identidad";
        public static final String NOTAS = "notas";
        public static final String CIUDAD_PROVINCIA = "ciudad_provincia";
        public static final String MUNICIPIO = "municipio";
        public static final String SECTOR = "sector";
        public static final String ID_CENTRO_COSTO = "id_centro_costo";
        public static final String TELEFONO = "telefono";
        public static final String CELULAR = "celular";
        public static final String CERTIFICADO_MAGNA = "certificado_magna";
        public static final String CERTIFICADO_DELTA = "certificado_delta";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class TIPO_TRANSACCION {

        public static final String TABLE_NAME = "tipo_transaccion";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_TIPO_TRANS = "id_tipo_trans";
        public static final String SECUENCIA = "secuencia";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class CENTRO_COSTOS {

        public static final String TABLE_NAME = "centro_costos";
        public static final String ID_CENTRO = "id_centro_costo";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String NOMBRE_CC = "nombre_cc";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class PEDIDO_ENC {

        public static final String TABLE_NAME = "pedido_enc";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_CLIENTE = "id_cliente";
        public static final String ID_TIPO_TRANS = "id_tipo_trans";
        public static final String ID_DOCUMENTO = "id_documento";
        public static final String MONTO_BRUTO = "monto_bruto";
        public static final String MONTO_NETO = "monto_neto";
        public static final String PORC_DESCUENTO = "porc_descuento";
        public static final String MONTO_DESC = "monto_desc";
        public static final String MONTO_IMPUESTOS = "monto_impuestos";
        public static final String MONTO_GRAVADO = "monto_gravado";
        public static final String MONTO_EXENTO = "monto_exento";
        public static final String ESTADO_DOCUMENTO = "estado_factura";
        public static final String ID_ASESOR = "id_asesor";
        public static final String NOTAS = "notas";
        public static final String ID_CONDICION = "id_condicion";
        public static final String TASA_MONEDA = "tasa_moneda";
        public static final String ID_MONEDA = "id_moneda";
        public static final String FECHA_DOCUMENTO = "fecha_documento";
        public static final String FECHA_DESPACHO = "fecha_despacho";
        public static final String IMPRESION = "impresion";
        public static final String ID_TIPO_SERVICIO = "id_tipo_servicio";
        public static final String ID_SUPERVISOR = "id_supervisor";
        public static final String NO_ORDEN = "no_orden";
        public static final String FECHA_ANULACION = "fecha_anulacion";
        public static final String RECIBIDO_POR = "recibido_por";
        public static final String REALIZADO_POR = "realizado_por";
        public static final String ID_MECANICO = "id_mecanico";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";

    }

    public static final class LISTA_PARAMETROS_ENC {

        public static final String TABLE_NAME = "lista_parametro_enc";
        public static final String ID_LISTA = "id_lista";
        public static final String DESCRIPCION = "descripcion";
        public static final String COMENTARIO = "comentario";
        public static final String ID_CLASIFICACION = "id_clasificacion";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String ESTADO = "estado";
    }

    public static final class LISTA_PARAMETROS_DET {

        public static final String TABLE_NAME = "lista_parametro_det";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_LISTA = "id_lista";
        public static final String ID_CLASIFICACION = "id_clasificacion";
        public static final String VALOR = "valor";
        public static final String ORDEN = "orden";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String ESTADO = "estado";
        public static final String RUTA_IMAGEN = "ruta_imagen";
    }

    public static final class VEHICULO_DOCUMENTO {

        public static final String TABLE_NAME = "vehiculo_documento";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_VEHICULO = "id_vehiculo";
        public static final String ID_DOCUMENTO = "id_documento";
        public static final String ID_TIPO_TRANS = "id_tipo_trans";
        public static final String SECUENCIA = "secuencia";
        public static final String RUTA_DOCUMENTO = "ruta_documento";
        public static final String NOTA = "nota";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String ID_LADO = "id_lado";
    }

    public static final class PEDIDO_PRODUCTO {

        public static final String TABLE_NAME = "pedido_producto";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_TIPO_TRANS = "id_tipo_trans";
        public static final String ID_DOCUMENTO = "id_documento";
        public static final String ID_CENTRO_COSTO = "id_centro_costo";
        public static final String ID_SERVICIO = "id_producto";
        public static final String COD_BARRA = "cod_barra";
        public static final String ID_IMPUESTO = "id_impuesto";
        public static final String SECUENCIA = "secuencia";
        public static final String DESCRIPCION_SERVICIO = "descripcion_producto";
        public static final String PRECIO = "precio";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String CANTIDAD = "cantidad";
        public static final String UNIDAD = "unidad";
        public static final String PORC_DESCUENTO = "porc_descuento";
        public static final String MONTO_IMPUESTO = "monto_impuesto";
        public static final String MONTO_DESCUENTO = "monto_descuento";
        public static final String IMPORTE = "importe";
        public static final String IMPORTE_ITBIS = "importe_itbis";
        public static final String PRECIO_NETO = "precio_neto";
        public static final String OBSERVACIONES = "observaciones";
        public static final String PRECIO_BRUTO = "precio_bruto";
        public static final String UNIDAD_REFERENCIA = "unidad_referencia";
        public static final String MECANICO = "id_rep_ven";
        public static final String DESCUENTO = "descuento";
        public static final String PRECIO_FINAL_SIN_IMPUESTOS = "precio_final_sin_impuestos";
        public static final String IMPUESTO = "impuestos";
        public static final String PORC_IMPUESTO = "porc_impuesto";
        public static final String PRECIO_FINAL_CON_IMPUESTOS = "precio_final_con_impuestos";
        public static final String REFERENCIA = "referencia";
    }

    public static final class PRODUCTO_CLASIFICACION {

        public static final String TABLE_NAME = "producto_clasificacion";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_CLASIFICACION = "ïd_clasificacion";
        public static final String DESCRIPCION = "descripcion";
        public static final String OBSERVACION = "observacion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String CLASIFICACION_PADRE = "clasificacion_padre";

    }

    public static final class IMPUESTO {

        public static final String TABLE_NAME = "impuesto";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String DESCRIPCION = "descripcion";
        public static final String ID_IMPUESTO = "id_impuesto";
        public static final String TASA = "tasa";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
    }

    public static final class PRODUCTO_SERVICIOS {

        public static final String TABLE_NAME = "producto_servicios";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_SERVICIO = "id_producto";
        public static final String ID_CLASIFICACION = "id_clasificacion";
        public static final String DESC_SERVICIO = "desc_servicio";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String ESTADO = "estado";
        public static final String ESMODIFICABLE = "esmodificable";
        public static final String ID_MARCA = "id_marca";
        public static final String REFERENCIA = "referencia";
        public static final String OTRAS_ESPECIFICACIONES = "otras_especificaciones";
        public static final String NOTA = "nota";
        public static final String PERMITE_DESCUENTO = "permite_descuento";
        public static final String PRECIO_SERVICIO = "precio_servicio";

    };

    public static final class PRODUCTO_PRECIO {

        public static final String TABLE_NAME = "producto_precio";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String ID_SERVICIO = "id_producto";
        public static final String CHASIS = "cod_barra";
        public static final String ESTADO = "estado";
        public static final String COSTO_COMPRA = "costo_compra";
        public static final String PRECIO_VENTA = "precio_venta";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_ACTUALIZACION = "fecha_actualizacion";
        public static final String USUARIO_ACTUALIZACION = "usuario_actualizacion";
        public static final String MARGEN_BENEFICIO = "margen_beneficio";
        public static final String ID_MONEDA = " id_moneda";
        public static final String MODIFICA_MANUAL_PRECIO = "modifica_manual_precio";
    };

    public static final class PERSONAL {

        public static final String TABLE_NAME = "personal";
        public static final String ID_USUARIO = "id_personal";
        public static final String USUARIO = "usuario";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String CLAVE = "clave";
        public static final String ESTADO = "estado";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
        public static final String LUGAR_NAC = "lugar_nac";
        public static final String ESTADO_CIVIL = "estado_civil";
        public static final String DOCUMENTO_IDENTIDAD = "documento_identidad";
        public static final String SEXO = "sexo";
        public static final String TELEFONO = "telefono";
        public static final String DIRECCION_EMAIL = "direccion_email";
        public static final String TELEFONO_MOVIL = "telefono_movil";
        public static final String PAIS = "pais";
        public static final String CIUDAD = "ciudad";
        public static final String MUNICIPIO = "municipio";
        public static final String SECTOR = "sector";
        public static final String CALLE = "calle";
        public static final String EDIFICIO = "edificio";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";

    }

    public static final class MARCA {

        public static final String TABLE_NAME = "marca";
        public static final String ID_EMPRESA = "id_empresa";
        public static final String FECHA_ACT = "fecha_actualizacion";
        public static final String USUARIO_ACT = "usuario_actualizacion";
        public static final String FECHA_INSERCION = "fecha_insercion";
        public static final String USUARIO_INSERCION = "usuario_insercion";
        public static final String ID_MARCA = "id_marca";
        public static final String DESCRIPCION = "descripcion";
        public static final String ESTADO = "estado";
    }

    public static final class TABLA_DGII {

        public static final String TABLE_NAME = "tabla_dgii";
        public static final String RNC_CEDULA = "rnc_cedula";
        public static final String RAZON_SOCIAL = "razon_social";
        public static final String SIGLAS = "siglas";
        public static final String TIPO_NEGOCIO = "tipo_negocio";
        public static final String CALLE = "calle";
        public static final String NUM_CALLE = "num_calle";

    }

    public static final class PAIS {
        public static final String TABLE_NAME = "pais";
        public static final String ID_PAIS = "id_pais";
        public static final String DESC_PAIS = "desc_pais";
        public static final String NACIONALIDAD = "nacionalidad";
        public static final String ESTADO = "estado";
    }
}
