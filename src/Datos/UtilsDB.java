/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Util.conexion.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelos.*;
import Datos.CheckMobileTables.*;
import Util.Constantes;
import Util.Utils;
import static Util.conexion.getThinConnection;
import java.util.HashSet;

//Queries//
public class UtilsDB {

    public static String idVehiculo, idCliente, idInspeccion;
    public static int contador = 0;

    public static List<Object> executeQuery(SqlStatement sql, ObjetosDB dbObject) throws SQLException {
        List<Object> objetos = null;

        try (Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql.toString());
                ResultSet resultSet = preparedStatement.executeQuery()) {
            switch (dbObject) {
                case TIPO_TELEFONO: {
                    objetos = getTipo_telefono(resultSet);
                    break;
                }
                case TELEFONO: {
                    objetos = getTelefono(resultSet);
                    break;
                }
                case CLIENTE: {
                    objetos = getCliente(resultSet);
                    break;
                }
                case TIPO_COMP_FISCAL: {
                    objetos = getTipo_comp_fiscal(resultSet);
                    break;
                }

                case CONDICION_PAGO: {
                    objetos = getCondicion_pago(resultSet);
                    break;
                }

                case CLIENTE_DIRECCIONES: {
                    objetos = getCliente_direcciones(resultSet);
                    break;
                }

                case COMBUSTIBLE_VEHICULO: {
                    objetos = getCombustible_vehiculo(resultSet);
                    break;
                }

                case TIPO_VEHICULO: {
                    objetos = getTipo_vehiculo(resultSet);
                    break;
                }

                case VEHICULO: {
                    objetos = getVehiculo(resultSet);
                    break;
                }

                case VEHICULO_MARCA: {
                    objetos = getVehiculo_marca(resultSet);
                    break;
                }

                case VEHICULO_MODELO: {
                    objetos = getVehiculo_Modelo(resultSet);
                    break;
                }

                case VEHICULO_ESTILO: {
                    objetos = getVehiculo_estilo(resultSet);
                    break;
                }

                case VEHICULO_TRACCION: {
                    objetos = getVehiculo_traccion(resultSet);
                    break;
                }

                case INSPECCION_VEHICULO: {
                    objetos = getInspeccion_vehiculo(resultSet);
                    break;
                }

                case INSPECCION_VEHICULO_DETALLE: {
                    objetos = getInspeccion_vehiculo_detalle(resultSet);
                    break;
                }

                case VEHICULO_DOCUMENTO: {
                    objetos = getVehiculo_documento(resultSet);
                    break;
                }

                case LISTA_PARAMETROS_DET: {
                    objetos = getLista_parametros_det(resultSet);
                    break;
                }

                case LISTA_PARAMETROS_ENC: {
                    objetos = getLista_parametros_enc(resultSet);
                    break;
                }

                case CTE_REPRESENTANTE_VEN: {
                    objetos = getCte_representante_ven(resultSet);
                    break;
                }

                case TIPO_TRASACCION: {
                    objetos = getTipo_transaccion(resultSet);
                    break;
                }

                case CENTRO_COSTOS: {
                    objetos = getCentro_costos(resultSet);
                    break;
                }

                case PEDIDO_ENC: {
                    objetos = getPedido_enc(resultSet);
                    break;
                }

                case PEDIDO_PRODUCTO: {
                    objetos = getPedido_producto(resultSet);
                    break;
                }

                case PRODUCTO_CLASIFICACION: {
                    objetos = getProducto_clasificacion(resultSet);
                    break;
                }

                case IMPUESTO: {
                    objetos = getImpuesto(resultSet);
                    break;
                }

                case PRODUCTO_SERVICIOS: {
                    objetos = getProducto_servicios(resultSet);
                    break;
                }

                case PRODUCTO_PRECIO: {
                    objetos = getProducto_precio(resultSet);
                    break;
                }

                case PERSONAL:
                    objetos = getPersonal(resultSet);
                     {
                        break;
                    }

                case MARCA: {
                    objetos = getMarca(resultSet);
                    break;
                }

                case TABLA_DGII: {
                    objetos = getTabla_DGII(resultSet);
                    break;
                }
                case PAIS: {
                    objetos = getPais(resultSet);
                    break;

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objetos;
    }

    public static int executeInsert(Object object, ObjetosDB dbObject) {
        int registrosInsertados = 0;
        switch (dbObject) {
            case CLIENTE: {
                registrosInsertados = llamarFuncionInsercionCliente(object);
                //ClienteInsert(object);
                break;
            }
            case INSPECCION_VEHICULO: {
                registrosInsertados = llamarFuncionInsertInspeccionVeh(object);
                //InspeccionInsert(object);
                break;
            }
            case INSPECCION_VEHICULO_DETALLE: {
                registrosInsertados = llamarFuncionInsertInspeccionDetalle(object);
                break;
            }
            case PRODUCTO_SERVICIOS: {
                registrosInsertados = ProductoInsert(object);
                break;
            }
            case PEDIDO_ENC: {
                registrosInsertados = pedidoInsert(object);
                break;
            }
            case PEDIDO_PRODUCTO: {
                registrosInsertados = pedidoProdInsert(object);
                break;
            }
            case VEHICULO_MARCA: {
                registrosInsertados = vehMarcaInsert(object);
                break;
            }
            case VEHICULO_MODELO:
                registrosInsertados = vehModeloInsert(object);
                break;
            case VEHICULO_ESTILO: {
                registrosInsertados = vehEstiloInsert(object);
                break;
            }
            case VEHICULO: {
                registrosInsertados = llamarFuncionInsercionvehiculo(object);
//vehInsert(object);
                break;
            }
            case PRODUCTO_PRECIO: {
                registrosInsertados = productoPInsert(object);
                break;
            }

        }

        return registrosInsertados;
    }

    private static List<Object> getTipo_telefono(ResultSet resultSet) throws SQLException {
        List<Object> TipoTel_List = new ArrayList<>();
        while (resultSet.next()) {
            TipoTelefono tipo = new TipoTelefono();
            tipo.setId(resultSet.getString(TIPO_TELEFONO.ID_TIPO));
            tipo.setDescripcion(resultSet.getString(TIPO_TELEFONO.DESCRIPCION));
            tipo.setFechaInsercion(resultSet.getDate(TIPO_TELEFONO.FECHA_INSERCION));
            tipo.setUsuarioInsercion(resultSet.getString(TIPO_TELEFONO.USUARIO_INSERCION));

            TipoTel_List.add(tipo);
        }
        return TipoTel_List;

    }

    private static List<Object> getTelefono(ResultSet resultSet) throws SQLException {
        List<Object> Tel_list = new ArrayList<>();
        while (resultSet.next()) {
            Telefonos tel = new Telefonos();
            tel.setId(resultSet.getString(TELEFONOS.ID_ENTIDAD));
            tel.setNombres(resultSet.getString(TELEFONOS.NOMBRES));
            tel.setApellidos(resultSet.getString(TELEFONOS.APELLIDOS));
            tel.setDescripcion_tipo(resultSet.getString(TELEFONOS.DESCRIPCION_TIPO));
            tel.setId_tipo(resultSet.getString(TELEFONOS.ID_TIPO));
            tel.setId(resultSet.getString(TELEFONOS.NUMERO));
            tel.setPrioridad(resultSet.getInt(TELEFONOS.PRIORIDAD));
            tel.setFechaInsercion(null);
            Tel_list.add(tel);

        }
        return Tel_list;
    }

    private static List<Object> getTipo_comp_fiscal(ResultSet resultSet) throws SQLException {
        List<Object> tipo_comp_list = new ArrayList<>();

        while (resultSet.next()) {
            TipoCompFiscal tipoComp = new TipoCompFiscal();
            tipoComp.setIdTipoNcf(resultSet.getString(TIPO_COMP_FISCAL.ID_TIPO_NCF));
            tipoComp.setDescripcion(resultSet.getString(TIPO_COMP_FISCAL.DESCRIPCION));
            tipoComp.setValorFiscal(resultSet.getBoolean(TIPO_COMP_FISCAL.VALOR_FISCAL));
            tipoComp.setUsuarioInsercion(resultSet.getString(TIPO_COMP_FISCAL.USUARIO_INSERCION));
            tipoComp.setFechaInsercion(resultSet.getDate(TIPO_COMP_FISCAL.FECHA_INSERCION));
            tipo_comp_list.add(tipoComp);
        }

        return tipo_comp_list;
    }

    private static List<Object> getCliente(ResultSet resultSet) throws SQLException {
        List<Object> cliente_list = new ArrayList<>();

        while (resultSet.next()) {
            Cliente cte = new Cliente();
            cte.setId(resultSet.getString(CLIENTE.ID_CLIENTE));
            cte.setId_empresa(resultSet.getString(CLIENTE.ID_EMPRESA));
            cte.setNombres(resultSet.getString(CLIENTE.NOMBRES));
            cte.setApellidos(resultSet.getString(CLIENTE.APELLIDOS));
            cte.setNombreEmpresa(resultSet.getString(CLIENTE.NOMBRE_EMPRESA));
            cte.setApodo(resultSet.getString(CLIENTE.APODO));
            cte.setDocumentoIdentidad(resultSet.getString(CLIENTE.DOCUMENTO_IDENTIDAD));
            cte.setLimiteCredito(resultSet.getInt(CLIENTE.LIMITE_CREDITO));
            cte.setFecha_nacimiento(resultSet.getDate(CLIENTE.FECHA_NACIMIENTO));
            cte.setEdad(resultSet.getString(CLIENTE.EDAD));
            cte.setSexo(resultSet.getString(CLIENTE.SEXO));
            cte.setEstadoCivil(resultSet.getString(CLIENTE.ESTADO_CIVIL));
            cte.setIdCondicion(resultSet.getString(CLIENTE.ID_CONDICION));
            cte.setNacionalidad(resultSet.getString(CLIENTE.NACIONALIDAD));
            cte.setNotas(resultSet.getString(CLIENTE.NOTAS));
            cte.setPais(resultSet.getString(CLIENTE.PAIS));
            cte.setUsuarioInsercion(resultSet.getString(CLIENTE.USUARIO_INSERCION));
            cte.setUsuarioActualizacion(resultSet.getString(CLIENTE.USUARIO_ACT));
            cte.setFechaInsercion(resultSet.getDate(CLIENTE.FECHA_INSERCION));
            cte.setFechaActualizacion(resultSet.getDate(CLIENTE.FECHA_ACT));
            cte.setDescripcion_condicion(resultSet.getString(CLIENTE.DESCRIPCION_CONDICION));
            cte.setRnc(resultSet.getString(CLIENTE.RNC));
            cte.setTelefono(resultSet.getString(CLIENTE.TELEFONO));
            cte.setTelefono_movil(resultSet.getString(CLIENTE.CELULAR));
            cte.setDireccion_email(resultSet.getString(CLIENTE.CORREO));
            cte.setCiudad_provincia(resultSet.getString(CLIENTE.CIUDAD_PROVINCIA));
            cte.setLinea1(resultSet.getString(CLIENTE.DIRECCION));
            cte.setLinea2(resultSet.getString(CLIENTE.PROXIMOA));

            cliente_list.add(cte);
        }

        return cliente_list;
    }

    private static List<Object> getCondicion_pago(ResultSet resultSet) throws SQLException {
        List<Object> condicion_list = new ArrayList<>();
        while (resultSet.next()) {
            CondicionPago con = new CondicionPago();
            con.setId(resultSet.getString(CONDICION_PAGO.ID_CONDICION));
            con.setDescripcion(resultSet.getString(CONDICION_PAGO.DESCRIPCION));
            con.setEstado(resultSet.getString(CONDICION_PAGO.ESTADO));
            condicion_list.add(con);

        }
        return condicion_list;

    }

    private static List<Object> getCliente_direcciones(ResultSet resultSet) throws SQLException {
        List<Object> direccion_list = new ArrayList<>();
        while (resultSet.next()) {
            ClienteDirecciones dir = new ClienteDirecciones();
            dir.setIdCliente(resultSet.getString(CLIENTE_DIRECCIONES.ID_CLIENTE));
            dir.setEstado(resultSet.getString(CLIENTE_DIRECCIONES.ESTADO));
            dir.setSecuencia(resultSet.getString(CLIENTE_DIRECCIONES.SECUENCIA));
            dir.setIdEmpresa(resultSet.getString(CLIENTE_DIRECCIONES.ID_EMPRESA));
            dir.setDescripcion(resultSet.getString(CLIENTE_DIRECCIONES.DESCRIPCION));
            dir.setCiudad(resultSet.getString(CLIENTE_DIRECCIONES.CIUDAD_PROVINCIA));
            dir.setSector(resultSet.getString(CLIENTE_DIRECCIONES.SECTOR));
            dir.setMunicipio(resultSet.getString(CLIENTE_DIRECCIONES.MUNICIPIO));
            dir.setEdificio(resultSet.getString(CLIENTE_DIRECCIONES.EDIFICIO));
            dir.setApartamento(resultSet.getString(CLIENTE_DIRECCIONES.APARTAMENTO));
            dir.setNombres(resultSet.getString(CLIENTE_DIRECCIONES.NOMBRES));
            dir.setApellidos(resultSet.getString(CLIENTE_DIRECCIONES.APELLIDOS));
            direccion_list.add(dir);
        }

        return direccion_list;

    }

    private static List<Object> getCombustible_vehiculo(ResultSet resultSet) throws SQLException {
        List<Object> Combustible_list = new ArrayList<>();
        while (resultSet.next()) {
            CombustibleVehiculo com = new CombustibleVehiculo();

            com.setIdCombustible(resultSet.getString(COMBUSTIBLE_VEHICULO.ID_COMBUSTIBLE));
            com.setDescripcion(resultSet.getString(COMBUSTIBLE_VEHICULO.DESCRIPCION));
            com.setEstado(resultSet.getString(COMBUSTIBLE_VEHICULO.ESTADO));

            Combustible_list.add(com);
        }

        return Combustible_list;
    }

    private static List<Object> getTipo_vehiculo(ResultSet resultSet) throws SQLException {
        List<Object> TipoVeh_list = new ArrayList<>();
        while (resultSet.next()) {
            TipoVehiculo tipo = new TipoVehiculo();
            tipo.setIdTipoVehiculo(resultSet.getString(TIPO_VEHICULO.ID_TIPO_VEHICULO));
            tipo.setDescripcion(resultSet.getString(TIPO_VEHICULO.DESCRIPCION));
            tipo.setEstado(resultSet.getString(TIPO_VEHICULO.ESTADO));
            TipoVeh_list.add(tipo);
        }
        return TipoVeh_list;

    }

    private static List<Object> getVehiculo(ResultSet resultSet) throws SQLException {
        List<Object> Veh_list = new ArrayList<>();
        while (resultSet.next()) {
            Vehiculo veh = new Vehiculo();
            veh.setId(resultSet.getString(VEHICULO.ID_VEHICULO));
            veh.setId_empresa(resultSet.getString(VEHICULO.ID_EMPRESA));
            veh.setIdCliente(resultSet.getString(VEHICULO.ID_CLIENTE));
            veh.setReferencia(resultSet.getString(VEHICULO.REFERENCIA));
            veh.setIdCombustible(resultSet.getString(VEHICULO.ID_COMBUSTIBLE));
            veh.setIdMarca(resultSet.getString(VEHICULO.ID_MARCA));
            veh.setIdModelo(resultSet.getString(VEHICULO.ID_MODELO));
            veh.setIdEstilo(resultSet.getString(VEHICULO.ID_ESTILO));
            veh.setChasis(resultSet.getString(VEHICULO.CHASIS));
            veh.setCilindros(resultSet.getInt(VEHICULO.CILINDRO));
            veh.setCilindraje(resultSet.getString(VEHICULO.CILINDRAJE));
            veh.setColor(resultSet.getString(VEHICULO.COLOR));
            veh.setFilaAsiento(resultSet.getInt(VEHICULO.FILA_ASIENTO));
            veh.setColorInterior(resultSet.getString(VEHICULO.COLOR_INTERIOR));
            veh.setCantPuerta(resultSet.getInt(VEHICULO.CANT_PUERTA));
            veh.setEstado(resultSet.getString(VEHICULO.ESTADO));
            veh.setIdTipoVehiculo(resultSet.getString(VEHICULO.ID_TIPO_VEHICULO));
            veh.setAno(resultSet.getString(VEHICULO.ANIO));
            veh.setNota(resultSet.getString(VEHICULO.NOTA));
            veh.setDesc_marca(resultSet.getString(VEHICULO.DESC_MARCA));
            veh.setDesc_modelo(resultSet.getString(VEHICULO.DESC_MODELO));
            veh.setDesc_estilo(resultSet.getString(VEHICULO.DESC_ESTILO));
            veh.setEstadoVeh(resultSet.getString(VEHICULO.ESTADO_VEH));
            veh.setIdTransmision(resultSet.getString(VEHICULO.ID_TRANSMISION));
            veh.setGarantia(resultSet.getString(VEHICULO.GARANTIA));
            veh.setIdTraccion(resultSet.getString(VEHICULO.ID_TRACCION));

            Veh_list.add(veh);
        }
        return Veh_list;

    }

    private static List<Object> getVehiculo_marca(ResultSet resultSet) throws SQLException {
        List<Object> marca_list = new ArrayList<>();
        while (resultSet.next()) {
            VehiculoMarca mar = new VehiculoMarca();
            mar.setId(resultSet.getString(VEHICULO_MARCA.ID_MARCA));
            mar.setId_empresa(resultSet.getString(VEHICULO_MARCA.ID_EMPRESA));
            mar.setDescripcion(resultSet.getString(VEHICULO_MARCA.DESCRIPCION));
            mar.setEstado(resultSet.getString(VEHICULO_MARCA.ESTADO));

            marca_list.add(mar);
        }
        return marca_list;
    }

    private static List<Object> getVehiculo_Modelo(ResultSet resultSet) throws SQLException {
        List<Object> modelo_list = new ArrayList<>();
        while (resultSet.next()) {
            VehiculoModelo mod = new VehiculoModelo();
            mod.setId(resultSet.getString(VEHICULO_MODELO.ID_MODELO));
            mod.setDescripcion(resultSet.getString(VEHICULO_MODELO.DESCRIPCION));
            mod.setEstado(resultSet.getString(VEHICULO_MODELO.ESTADO));
            mod.setVehiculoMarca(resultSet.getString(VEHICULO_MODELO.ID_MARCA));

            modelo_list.add(mod);
        }

        return modelo_list;
    }

    private static List<Object> getVehiculo_estilo(ResultSet resultSet) throws SQLException {
        List<Object> estilo_list = new ArrayList<>();
        while (resultSet.next()) {
            VehiculoEstilo est = new VehiculoEstilo();
            est.setId(resultSet.getString(VEHICULO_ESTILO.ID_ESTILO));
            est.setId_modelo(resultSet.getString(VEHICULO_ESTILO.ID_MODELO));
            est.setDescripcion(resultSet.getString(VEHICULO_ESTILO.DESCRIPCION));
            est.setEstado(resultSet.getString(VEHICULO_ESTILO.ESTADO));

            estilo_list.add(est);
        }

        return estilo_list;
    }

    private static List<Object> getVehiculo_traccion(ResultSet resultSet) throws SQLException {
        List<Object> traccion_list = new ArrayList<>();
        while (resultSet.next()) {
            VehiculoTraccion tra = new VehiculoTraccion();
            tra.setId(resultSet.getString(VEHICULO_TRACCION.ID_TRACCION));
            tra.setId_empresa(resultSet.getString(VEHICULO_TRACCION.ID_EMPRESA));
            tra.setDescripcion(resultSet.getString(VEHICULO_TRACCION.DESCRIPCION));
            tra.setEstado(resultSet.getString(VEHICULO_TRACCION.ESTADO));

            traccion_list.add(tra);
        }

        return traccion_list;
    }

    private static List<Object> getInspeccion_vehiculo_detalle(ResultSet resultSet) throws SQLException {
        List<Object> inspeccion_list = new ArrayList<>();
        while (resultSet.next()) {
            InspeccionVehiculoDetalle ins = new InspeccionVehiculoDetalle();
            ins.setId(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_INSPECCION));
            ins.setId_empresa(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_EMPRESA));
            ins.setIdVehiculo(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_VEHICULO));
            ins.setIdTipoTrans(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_TIPO_TRANS));
            ins.setIdElementoInspeccion(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_ELEMENTO_INSPECCION));
            ins.setIdRespuesta(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ID_RESPUESTA));
            ins.setObservacion(resultSet.getString(INSPECCION_VEHICULO_DETALLE.OBSERVACION));
            ins.setEstado(resultSet.getString(INSPECCION_VEHICULO_DETALLE.ESTADO));
            inspeccion_list.add(ins);
        }
        return inspeccion_list;
    }

    private static List<Object> getInspeccion_vehiculo(ResultSet resultSet) throws SQLException {
        List<Object> inspeccion_list = new ArrayList<>();
        while (resultSet.next()) {
            InspeccionVehiculo ins = new InspeccionVehiculo();
            ins.setId(resultSet.getString(INSPECCION_VEHICULO.ID_INSPECCION));
            ins.setId_empresa(resultSet.getString(INSPECCION_VEHICULO.ID_EMPRESA));
            ins.setIdVehiculo(resultSet.getString(INSPECCION_VEHICULO.ID_VEHICULO));
            ins.setChasis(resultSet.getString(INSPECCION_VEHICULO.CHASIS));
            ins.setIdCliente(resultSet.getString(INSPECCION_VEHICULO.ID_CLIENTE));
            ins.setIdAsesor(resultSet.getString(INSPECCION_VEHICULO.ID_ASESOR));
            ins.setObservaciones(resultSet.getString(INSPECCION_VEHICULO.OBSERVACIONES));
            ins.setReferencia(resultSet.getString(INSPECCION_VEHICULO.REFERENCIA));
            ins.setSupervisor(resultSet.getString(INSPECCION_VEHICULO.SUPERVISOR));
            ins.setEstado(resultSet.getString(INSPECCION_VEHICULO.ESTADO));

            inspeccion_list.add(ins);
        }
        return inspeccion_list;

    }

    private static List<Object> getVehiculo_documento(ResultSet resultSet) throws SQLException {
        List<Object> doc_list = new ArrayList<>();
        while (resultSet.next()) {
            VehiculoDocumento doc = new VehiculoDocumento();
            doc.setId(resultSet.getString(VEHICULO_DOCUMENTO.ID_DOCUMENTO));
            doc.setId_empresa(resultSet.getString(VEHICULO_DOCUMENTO.ID_EMPRESA));
            doc.setId_tipo_trans(resultSet.getString(VEHICULO_DOCUMENTO.ID_TIPO_TRANS));
            doc.setRutaDocumento(resultSet.getString(VEHICULO_DOCUMENTO.RUTA_DOCUMENTO));
            doc.setEstado(resultSet.getString(VEHICULO_DOCUMENTO.ESTADO));
            doc.setNota(resultSet.getString(VEHICULO_DOCUMENTO.NOTA));
            doc_list.add(doc);
        }
        return doc_list;
    }

    private static List<Object> getLista_parametros_det(ResultSet resultSet) throws SQLException {
        List<Object> param_list = new ArrayList<>();
        while (resultSet.next()) {
            ListaParametrosDet param = new ListaParametrosDet();
            param.setId(resultSet.getString(LISTA_PARAMETROS_DET.ID_LISTA));
            param.setValor(resultSet.getString(LISTA_PARAMETROS_DET.VALOR));
            param.setId_empresa(resultSet.getString(LISTA_PARAMETROS_DET.ID_EMPRESA));
            param.setRutaImagen(resultSet.getString(LISTA_PARAMETROS_DET.RUTA_IMAGEN));
            param.setEstado(resultSet.getString(LISTA_PARAMETROS_DET.ESTADO));
            param.setDescripcion(resultSet.getString(LISTA_PARAMETROS_DET.DESCRIPCION));
            param_list.add(param);
        }
        return param_list;
    }

    private static List<Object> getLista_parametros_enc(ResultSet resultSet) throws SQLException {
        List<Object> param_list = new ArrayList<>();
        while (resultSet.next()) {
            ListaParametrosEnc param = new ListaParametrosEnc();
            param.setId_empresa(resultSet.getString(LISTA_PARAMETROS_ENC.ID_EMPRESA));
            param.setDescripcion(resultSet.getString(LISTA_PARAMETROS_ENC.DESCRIPCION));
            param.setId_lista(resultSet.getString(LISTA_PARAMETROS_ENC.ID_LISTA));

            param_list.add(param);
        }
        return param_list;
    }

    private static List<Object> getCte_representante_ven(ResultSet resultSet) throws SQLException {
        List<Object> mecanico_list = new ArrayList<>();
        while (resultSet.next()) {
            CteRepresentanteVen mec = new CteRepresentanteVen();
            mec.setId(resultSet.getString(CTE_REPRESENTANTE_VEN.ID_REPRESENTANTE));
            mec.setEstado(resultSet.getString(CTE_REPRESENTANTE_VEN.ESTADO));
            mec.setNombres(resultSet.getString(CTE_REPRESENTANTE_VEN.NOMBRES));
            mec.setApellidos(resultSet.getString(CTE_REPRESENTANTE_VEN.APELLIDOS));
            mec.setDocumentoIdentidad(resultSet.getString(CTE_REPRESENTANTE_VEN.DOCUMENTO_IDENTIDAD));
            mec.setCiudadProvincia(resultSet.getString(CTE_REPRESENTANTE_VEN.CIUDAD_PROVINCIA));
            mec.setMunicipio(resultSet.getString(CTE_REPRESENTANTE_VEN.MUNICIPIO));

            mecanico_list.add(mec);
        }
        return mecanico_list;
    }

    private static List<Object> getTipo_transaccion(ResultSet resultSet) throws SQLException {
        List<Object> tipo_list = new ArrayList<>();
        while (resultSet.next()) {
            TipoTransaccion trans = new TipoTransaccion();
            trans.setId(resultSet.getString(TIPO_TRANSACCION.ID_TIPO_TRANS));
            trans.setSecuencia(resultSet.getLong(TIPO_TRANSACCION.SECUENCIA));
            trans.setId_empresa(resultSet.getString(TIPO_TRANSACCION.ID_EMPRESA));
            tipo_list.add(trans);
        }
        return tipo_list;
    }

    private static List<Object> getCentro_costos(ResultSet resultSet) throws SQLException {
        List<Object> centro_list = new ArrayList<>();
        while (resultSet.next()) {
            CentroCostos dato = new CentroCostos();
            dato.setId(resultSet.getString(CENTRO_COSTOS.ID_CENTRO));
            dato.setId_empresa(resultSet.getString(CENTRO_COSTOS.ID_EMPRESA));
            dato.setNombreCc(resultSet.getString(CENTRO_COSTOS.NOMBRE_CC));
            dato.setEstado(resultSet.getString(CENTRO_COSTOS.ESTADO));
            centro_list.add(dato);
        }
        return centro_list;
    }

    private static List<Object> getPedido_enc(ResultSet resultSet) throws SQLException {
        List<Object> pedEnc_list = new ArrayList<>();
        while (resultSet.next()) {
            PedidoEnc dato = new PedidoEnc();
            dato.setId(resultSet.getString(PEDIDO_ENC.ID_DOCUMENTO));
            dato.setId_empresa(resultSet.getString(PEDIDO_ENC.ID_EMPRESA));
            dato.setIdMecanico(resultSet.getString(PEDIDO_ENC.ID_MECANICO));
            dato.setIdSupervisor(resultSet.getString(PEDIDO_ENC.ID_SUPERVISOR));
            dato.setCliente(resultSet.getString(PEDIDO_ENC.ID_CLIENTE));
            dato.setTipoTransaccion(resultSet.getString(PEDIDO_ENC.ID_TIPO_TRANS));
            dato.setMontoBruto(resultSet.getBigDecimal(PEDIDO_ENC.MONTO_BRUTO));
            dato.setMontoNeto(resultSet.getBigDecimal(PEDIDO_ENC.MONTO_NETO));
            dato.setPorcDescuento(resultSet.getBigDecimal(PEDIDO_ENC.PORC_DESCUENTO));
            dato.setMontoDesc(resultSet.getBigDecimal(PEDIDO_ENC.MONTO_DESC));
            dato.setMontoImpuestos(resultSet.getBigDecimal(PEDIDO_ENC.MONTO_IMPUESTOS));
            dato.setIdCondicion(resultSet.getString(PEDIDO_ENC.ID_CONDICION));
            dato.setEstadoFactura(resultSet.getString(PEDIDO_ENC.ESTADO_DOCUMENTO));
            dato.setEstado(resultSet.getString(PEDIDO_ENC.ESTADO));
            dato.setFechaDocumento(resultSet.getDate(PEDIDO_ENC.FECHA_DOCUMENTO));
            dato.setFechaDespacho(resultSet.getDate(PEDIDO_ENC.FECHA_DESPACHO));
            dato.setNoOrden(resultSet.getString(PEDIDO_ENC.NO_ORDEN));
            dato.setRecibidoPor(resultSet.getString(PEDIDO_ENC.RECIBIDO_POR));
            dato.setRealizadoPor(resultSet.getString(PEDIDO_ENC.REALIZADO_POR));

            pedEnc_list.add(dato);
        }
        return pedEnc_list;
    }

    private static List<Object> getPedido_producto(ResultSet resultSet) throws SQLException {
        List<Object> pedPro_list = new ArrayList<>();
        while (resultSet.next()) {
            PedidoProducto dato = new PedidoProducto();
            dato.setId_documento(resultSet.getString(PEDIDO_PRODUCTO.ID_DOCUMENTO));
            dato.setId_empresa(resultSet.getString(PEDIDO_PRODUCTO.ID_EMPRESA));
            dato.setId_centro_costo(resultSet.getString(PEDIDO_PRODUCTO.ID_CENTRO_COSTO));
            dato.setId_producto(resultSet.getString(PEDIDO_PRODUCTO.ID_SERVICIO));
            dato.setId_rep_ven(resultSet.getString(PEDIDO_PRODUCTO.MECANICO));
            dato.setId_impuesto(resultSet.getString(PEDIDO_PRODUCTO.ID_IMPUESTO));
            dato.setId_tipo_trans(resultSet.getString(PEDIDO_PRODUCTO.ID_TIPO_TRANS));
            dato.setEstado(resultSet.getString(PEDIDO_PRODUCTO.ESTADO));
            dato.setCod_barra(resultSet.getString(PEDIDO_PRODUCTO.COD_BARRA));

            pedPro_list.add(dato);
        }
        return pedPro_list;
    }

    private static List<Object> getProducto_clasificacion(ResultSet resultSet) throws SQLException {
        List<Object> prod_list = new ArrayList<>();
        while (resultSet.next()) {
            ProductoClasificacion dato = new ProductoClasificacion();
            dato.setId_empresa(resultSet.getString(PRODUCTO_CLASIFICACION.ID_EMPRESA));
            dato.setId_clasificacion(resultSet.getString(PRODUCTO_CLASIFICACION.ID_CLASIFICACION));
            dato.setDescripcion(resultSet.getString(PRODUCTO_CLASIFICACION.DESCRIPCION));
            dato.setEstado(resultSet.getString(PRODUCTO_CLASIFICACION.ESTADO));

            prod_list.add(dato);
        }
        return prod_list;
    }

    private static List<Object> getImpuesto(ResultSet resultSet) throws SQLException {
        List<Object> imp_list = new ArrayList<>();
        while (resultSet.next()) {
            Impuesto dato = new Impuesto();
            dato.setId_empresa(resultSet.getString(IMPUESTO.ID_EMPRESA));
            dato.setId_impuesto(resultSet.getString(IMPUESTO.ID_IMPUESTO));
            dato.setDescripcion(resultSet.getString(IMPUESTO.DESCRIPCION));
            dato.setTasa(resultSet.getString(IMPUESTO.TASA));
            dato.setEstado(resultSet.getString(IMPUESTO.ESTADO));
            imp_list.add(dato);
        }
        return imp_list;
    }

    private static List<Object> getProducto_servicios(ResultSet resultSet) throws SQLException {
        List<Object> prod_list = new ArrayList<>();
        while (resultSet.next()) {
            ProductoServicios dato = new ProductoServicios();
            dato.setId_empresa(resultSet.getString(PRODUCTO_SERVICIOS.ID_EMPRESA));
            dato.setId_clasificacion(resultSet.getString(PRODUCTO_SERVICIOS.ID_CLASIFICACION));
            dato.setDesc_servicio(resultSet.getString(PRODUCTO_SERVICIOS.DESC_SERVICIO));
            dato.setId_producto(resultSet.getString(PRODUCTO_SERVICIOS.ID_SERVICIO));
            dato.setId_marca(resultSet.getString(PRODUCTO_SERVICIOS.ID_MARCA));
            dato.setReferencia(resultSet.getString(PRODUCTO_SERVICIOS.REFERENCIA));
            dato.setPrecio_servicio(resultSet.getString(PRODUCTO_SERVICIOS.PRECIO_SERVICIO));
            dato.setEstado(resultSet.getString(PRODUCTO_SERVICIOS.ESTADO));
            prod_list.add(dato);
        }
        return prod_list;
    }

    private static List<Object> getPersonal(ResultSet resultSet) throws SQLException {
        List<Object> personal_list = new ArrayList<>();
        while (resultSet.next()) {
            Personal dato = new Personal();
            dato.setId(resultSet.getString(PERSONAL.ID_USUARIO));
            dato.setNombres(resultSet.getString(PERSONAL.NOMBRES));
            dato.setApellidos(resultSet.getString(PERSONAL.APELLIDOS));
            dato.setClave(resultSet.getString(PERSONAL.CLAVE));
            dato.setEstadoCivil(resultSet.getString(PERSONAL.ESTADO_CIVIL));
            dato.setfechaNac(resultSet.getDate(PERSONAL.FECHA_NACIMIENTO));
            dato.setTelefono(resultSet.getString(PERSONAL.TELEFONO));
            dato.setTelefonoMovil(resultSet.getString(PERSONAL.TELEFONO_MOVIL));
            dato.setMunicipio(resultSet.getString(PERSONAL.MUNICIPIO));
            dato.setPais(resultSet.getString(PERSONAL.PAIS));
            dato.setCiudad(resultSet.getString(PERSONAL.CIUDAD));
            dato.setLugarNac(resultSet.getString(PERSONAL.LUGAR_NAC));
            dato.setDocumentoIdentidad(resultSet.getLong(PERSONAL.DOCUMENTO_IDENTIDAD));
            dato.setEstado(resultSet.getString(PERSONAL.ESTADO));
            personal_list.add(dato);
        }
        return personal_list;
    }

    private static List<Object> getMarca(ResultSet resultSet) throws SQLException {
        List<Object> marca_list = new ArrayList<>();
        while (resultSet.next()) {
            Marca dato = new Marca();
            dato.setId_marca(resultSet.getString(MARCA.ID_MARCA));
            dato.setId_empresa(resultSet.getString(MARCA.ID_EMPRESA));
            dato.setDescripcion(resultSet.getString(MARCA.DESCRIPCION));
            dato.setEstado(resultSet.getString(MARCA.ESTADO));

            marca_list.add(dato);
        }
        return marca_list;
    }

    private static List<Object> getTabla_DGII(ResultSet resultSet) throws SQLException {
        List<Object> dgii_list = new ArrayList<>();
        while (resultSet.next()) {
            TablaDgii dgii = new TablaDgii();
            dgii.setRncCedula(resultSet.getString(TABLA_DGII.RNC_CEDULA));
            dgii.setRazonSocial(resultSet.getString(TABLA_DGII.RAZON_SOCIAL));
            dgii_list.add(dgii);
        }

        return dgii_list;

    }

    /*
     Inserts 
    
     */
    private static int llamarFuncionInsercionCliente(Object object) {
        int insertedRows = 0;

        ArrayList<Cliente> cliente = (ArrayList<Cliente>) object;
        try (Connection conexion = getThinConnection();
                CallableStatement cst = conexion.prepareCall("{? = call PKG_CLIENTE.inserta_cliente(?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {

            conexion.setAutoCommit(false);
            cst.registerOutParameter(1, Types.INTEGER);

            for (Cliente cte : cliente) {
                cst.setString(2, Constantes.ID_EMPRESA);
                cst.setString(3, "IC");
                cst.setInt(4, cte.getIdTipoCliente());
                cst.setInt(5, cte.getLimiteCredito());
                cst.setString(6, cte.getNombres());
                cst.setString(7, cte.getApellidos());
                cst.setString(8, cte.getEdad());
                cst.setString(9, cte.getSexo());
                cst.setString(10, cte.getEstadoCivil());
                cst.setString(11, cte.getDocumentoIdentidad());
                cst.setString(12, cte.getBalanceCuenta());
                cst.setString(13, cte.getRnc());
                cst.setString(14, cte.getNombreEmpresa());
                cst.setString(15, cte.getContactoPrincipal());
                cst.setString(16, cte.getIdCondicion());
                cst.setString(17, cte.getNacionalidad());
                cst.setString(18, cte.getApodo());
                cst.setString(19, cte.getOcupacion());
                cst.setString(20, cte.getNotas());
                cst.setString(21, cte.getPais());
                cst.setString(22, cte.getValorFiscal());
                cst.setString(23, cte.getIdTipoNcf());
                cst.setString(24, cte.getLimiteFactPendCte());
                cst.setString(25, cte.getAplicaMora());
                cst.setString(26, cte.getCuentaContable());
                cst.setString(27, cte.getIdCondicionVend());
                cst.setString(28, cte.getIdClasificacion());
                cst.setString(29, cte.getLimiteDescuento());
                cst.setString(30, cte.getComisionVen());
                cst.setDate(31, Utils.getSqlDate(cte.getFecha_nacimiento()));
                cst.setString(32, cte.getTelefono());
                cst.setString(33, cte.getDireccion_email());
                cst.setString(34, cte.getTelefono_movil());
                cst.setString(35, cte.getCiudad_provincia());
                cst.setString(36, cte.getLinea1());
                cst.setString(37, cte.getLinea2());
                cst.setString(38, cte.getLugar_nac());
                cst.setString(39, cte.getCalDescDef());
                cst.setString(40, cte.getIdEntidad());
            }
            cst.registerOutParameter(41, Types.VARCHAR);

            cst.execute();
            conexion.commit();

            idCliente = cst.getString(41);
            insertedRows = cst.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows;
    }

    private static int ClienteInsert(Object object) {
        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.CLIENTE(ID_EMPRESA, "
                + "ID_CLIENTE, NOMBRES, APELLIDOS, FECHA_NACIMIENTO, EDAD, "
                + "SEXO, DOCUMENTO_IDENTIDAD, RNC, NOMBRE_EMPRESA, "
                + "ID_CONDICION, NACIONALIDAD,  APODO, NOTAS, ID_TIPO_NCF, NO_PASAPORTE,"
                + "USUARIO_INSERCION, ESTADO, ID_TIPO_CLIENTE,FECHA_INSERCION, LIMITE_CREDITO) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        ArrayList<Cliente> cliente = (ArrayList<Cliente>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (Cliente cte : cliente) {
                preparedStatement.setString(1, cte.getId_empresa());
                preparedStatement.setString(2, cte.getId());
                preparedStatement.setString(3, cte.getNombres());
                preparedStatement.setString(4, cte.getApellidos());
                preparedStatement.setDate(5, Utils.getSqlDate(cte.getFecha_nacimiento()));
                preparedStatement.setString(6, cte.getEdad());
                preparedStatement.setString(7, cte.getSexo());
                preparedStatement.setString(9, cte.getDocumentoIdentidad());
                preparedStatement.setString(10, cte.getRnc());
                preparedStatement.setString(11, cte.getNombreEmpresa());
                preparedStatement.setString(12, cte.getIdCondicion());
                preparedStatement.setString(13, cte.getNacionalidad());
                preparedStatement.setString(14, cte.getApodo());
                preparedStatement.setString(15, cte.getNotas());
                preparedStatement.setString(16, cte.getIdTipoNcf());
                preparedStatement.setString(17, cte.getNoPasaporte());
                preparedStatement.setString(18, cte.getUsuarioInsercion());
                preparedStatement.setString(19, cte.getEstado());
                preparedStatement.setInt(20, cte.getIdTipoCliente());
                preparedStatement.setDate(21, Utils.getSqlDate(cte.getFechaInsercion()));
                preparedStatement.setInt(22, cte.getLimiteCredito());

                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();

            conexion.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows.length;
    }

    private static int llamarFuncionInsertInspeccionVeh(Object object) {
        int insertedRows = 0;

        ArrayList<InspeccionVehiculo> inspeccion = (ArrayList<InspeccionVehiculo>) object;
        try (Connection conexion = getThinConnection();
                CallableStatement cst = conexion.prepareCall("{? = call PKG_INSPECCION.inserta_inspeccion_vehiculo(?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {

            conexion.setAutoCommit(false);
            cst.registerOutParameter(1, Types.INTEGER);
            for (InspeccionVehiculo ins : inspeccion) {
                cst.setString(2, Constantes.ID_EMPRESA);
                cst.setString(3, "IV");
                cst.setString(4, ins.getIdVehiculo());
                cst.setString(5, ins.getChasis());
                cst.setString(6, ins.getReferencia());
                cst.setDate(7, Utils.getSqlDate(ins.getFechaInspeccion()));
                cst.setString(8, ins.getSerieGomas());
                cst.setString(9, ins.getNivelCombustible());
                cst.setString(10, ins.getIdMecanico());
                cst.setString(11, ins.getSupervisor());
                cst.setString(12, ins.getIdAsesor());
                cst.setString(13, ins.getIdCliente());
                cst.setString(14, ins.getObservaciones());
                cst.setString(15, ins.getKilometraje());

            }
            cst.registerOutParameter(16, Types.VARCHAR);

            cst.execute();
            conexion.commit();
            idInspeccion = cst.getString(16);
            insertedRows = cst.getInt(1);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return insertedRows;

    }

    private static int InspeccionInsert(Object object) {
        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.INSPECCION_VEHICULO (ID_EMPRESA, ID_INSPECCION,ID_VEHICULO"
                + "ID_CLIENTE, CHASIS,REFERENCIA,FECHA_INSPECCION, SUPERVISOR,ID_ASESOR,OBSERVACIONES,ESTADO"
                + "FECHA_INSERCION,USUARIO_INSERCION,FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<InspeccionVehiculo> inspeccion = (ArrayList<InspeccionVehiculo>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (InspeccionVehiculo ins : inspeccion) {
                preparedStatement.setString(1, ins.getId_empresa());
                preparedStatement.setString(2, ins.getId());
                preparedStatement.setString(3, ins.getIdVehiculo());
                preparedStatement.setString(4, ins.getIdCliente());
                preparedStatement.setString(5, ins.getChasis());
                preparedStatement.setString(6, ins.getReferencia());
                preparedStatement.setDate(7, Utils.getSqlDate(ins.getFechaInspeccion()));
                preparedStatement.setString(8, ins.getSupervisor());
                preparedStatement.setString(9, ins.getIdAsesor());
                preparedStatement.setString(10, ins.getObservaciones());
                preparedStatement.setString(11, ins.getEstado());
                preparedStatement.setDate(12, Utils.getSqlDate(ins.getFechaInsercion()));
                preparedStatement.setString(13, ins.getUsuarioInsercion());
                preparedStatement.setDate(14, Utils.getSqlDate(ins.getFechaActualizacion()));
                preparedStatement.setString(15, ins.getUsuarioActualizacion());

                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return insertedRows.length;

    }

    private static int llamarFuncionInsertInspeccionDetalle(Object object) {
        int insertedRows[] = {};

        List<InspeccionVehiculoDetalle> inspeccion = (List<InspeccionVehiculoDetalle>) object;
        try (Connection conexion = getThinConnection();
                CallableStatement cst = conexion.prepareCall("{call PKG_INSPECCION.inserta_inspeccion_veh_det(?,?,"
                        + "?,?,?,?,?,?,?)}");) {
            conexion.setAutoCommit(false);

           
            for (InspeccionVehiculoDetalle ins : inspeccion) {
                cst.setString(1, Constantes.ID_EMPRESA);
                cst.setString(2, ins.getId());
                cst.setString(3, ins.getIdVehiculo());
                cst.setString(4, "IV");
                cst.setString(5, ins.getIdElementoInspeccion());
                cst.setString(6, ins.getGrado());
                cst.setString(7, ins.getPuntuacion());
                cst.setString(8, ins.getObservacion());
                cst.setString(9, ins.getIdRespuesta());
                cst.addBatch();
            }
           insertedRows = cst.executeBatch();
            conexion.commit();

            //insertedRows = cst.getInt(1);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows.length;

    }

    private static int InspeccionDetInsert(Object object) {
        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.INSPECCION_VEHICULO_DET (ID_EMPRESA, ID_INSPECCION,ID_VEHICULO"
                + "ID_ELEMENTO_INSPECCION,ID_TIPO_TRANS,OBSERVACION,ID_RESPUESTA,PUNTUACION,"
                + " GRADO, ESTADO, FECHA_INSERCION,USUARIO_INSERCION,FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<InspeccionVehiculoDetalle> inspeccion = (ArrayList<InspeccionVehiculoDetalle>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (InspeccionVehiculoDetalle ins : inspeccion) {
                preparedStatement.setString(1, ins.getId_empresa());
                preparedStatement.setString(2, ins.getId());
                preparedStatement.setString(3, ins.getIdVehiculo());
                preparedStatement.setString(4, ins.getIdElementoInspeccion());
                preparedStatement.setString(5, ins.getIdTipoTrans());
                preparedStatement.setString(6, ins.getObservacion());
                preparedStatement.setString(7, ins.getIdRespuesta());
                preparedStatement.setString(8, ins.getPuntuacion());
                preparedStatement.setString(9, ins.getGrado());
                preparedStatement.setString(10, ins.getEstado());
                preparedStatement.setDate(11, Utils.getSqlDate(ins.getFechaInsercion()));
                preparedStatement.setString(12, ins.getUsuarioInsercion());
                preparedStatement.setDate(13, Utils.getSqlDate(ins.getFechaActualizacion()));
                preparedStatement.setString(14, ins.getUsuarioActualizacion());
                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows.length;

    }

    private static int ProductoInsert(Object object) {
        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.PRODUCTO_SERVICIOS (id_empresa,id_producto,id_clasificacion, desc_servicio,fecha_insercion,"
                + "usuario_insercion,estado,id_marca,referencia,nota,permite_descuento,precio_servicio,id_impuesto )"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<ProductoServicios> producto = (ArrayList<ProductoServicios>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (ProductoServicios dato : producto) {
                preparedStatement.setString(1, dato.getId_empresa());
                preparedStatement.setString(2, dato.getId_producto());
                preparedStatement.setString(3, dato.getId_clasificacion());
                preparedStatement.setString(4, dato.getDesc_servicio());
                preparedStatement.setDate(5, Utils.getSqlDate(dato.getFecha_insercion()));
                preparedStatement.setString(6, dato.getUsuario_insercion());
                preparedStatement.setString(7, dato.getEstado());
                preparedStatement.setString(8, dato.getId_marca());
                preparedStatement.setString(9, dato.getReferencia());
                preparedStatement.setString(10, dato.getNota());
                preparedStatement.setString(11, dato.getPermite_descuento());
                preparedStatement.setString(12, dato.getPrecio_servicio());
                preparedStatement.setString(13, dato.getId_impuesto());

                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows.length;

    }

    private static int pedidoInsert(Object object) {

        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.PEDIDO_ENC (id_empresa,id_cliente,id_tipo_trans,id_documento, "
                + "monto_bruto, monto_neto,porc_descuento,monto_desc,monto_impuesto,monto_gravado, "
                + "monto_exento,estado_factura,id_asesor, notas,id_condicion, tasa_moneda, id_moneda,"
                + "fecha_documento,impresion,id_tipo_servicio, id_supervisor,no_orden,"
                + "recibido_por, realizado_por,id_mecanico,fecha_insercion,usuario_insercion,estado)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<PedidoEnc> pedido = (ArrayList<PedidoEnc>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (PedidoEnc dato : pedido) {
                preparedStatement.setString(1, dato.getId_empresa());
                preparedStatement.setString(2, dato.getCliente());
                preparedStatement.setString(3, dato.getTipoTransaccion());
                preparedStatement.setString(4, dato.getId_documento());
                preparedStatement.setBigDecimal(5, dato.getMontoBruto());
                preparedStatement.setBigDecimal(6, dato.getMontoNeto());
                preparedStatement.setBigDecimal(7, dato.getPorcDescuento());
                preparedStatement.setBigDecimal(8, dato.getMontoDesc());
                preparedStatement.setBigDecimal(9, dato.getMontoImpuestos());
                preparedStatement.setBigDecimal(10, dato.getMontoGravado());
                preparedStatement.setBigDecimal(11, dato.getMontoExento());
                preparedStatement.setString(12, dato.getEstadoFactura());
                preparedStatement.setString(13, dato.getIdAsesor());
                preparedStatement.setString(14, dato.getNotas());
                preparedStatement.setString(15, dato.getIdCondicion());
                preparedStatement.setBigDecimal(16, dato.getTasaMoneda());
                preparedStatement.setString(17, dato.getIdMoneda());
                preparedStatement.setDate(18, Utils.getSqlDate(dato.getFechaDocumento()));
                preparedStatement.setString(19, dato.getImpresion());
                preparedStatement.setString(20, dato.getIdTipoServicio());
                preparedStatement.setString(21, dato.getIdSupervisor());
                preparedStatement.setString(22, dato.getNoOrden());
                preparedStatement.setString(23, dato.getRecibidoPor());
                preparedStatement.setString(24, dato.getRealizadoPor());
                preparedStatement.setDate(25, Utils.getSqlDate(dato.getFechaInsercion()));
                preparedStatement.setString(26, dato.getUsuarioInsercion());
                preparedStatement.setDate(27, Utils.getSqlDate(dato.getFechaActualizacion()));

                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return insertedRows.length;
    }

    private static int vehMarcaInsert(Object object) {
        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.VEHICULO_MARCA (id_empresa,id_marca,descripcion,estado, fecha_insercion,"
                + "usuario_insercion) VALUES (?,?,?,?,?,?)";

        ArrayList<VehiculoMarca> marca = (ArrayList<VehiculoMarca>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);

            for (VehiculoMarca mar : marca) {
                preparedStatement.setString(1, mar.getId_empresa());
                preparedStatement.setString(2, mar.getId());
                preparedStatement.setString(3, mar.getDescripcion());
                preparedStatement.setString(4, mar.getEstado());
                preparedStatement.setDate(5, Utils.getSqlDate(mar.getFechaInsercion()));
                preparedStatement.setString(6, mar.getUsuarioInsercion());

                preparedStatement.addBatch();
            }

            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return insertedRows.length;

    }

    private static int vehModeloInsert(Object object) {

        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.VEHICULO_MODELO (id_empresa,id_modelo, id_marca, descripcion,estado, fecha_insercion,"
                + "usuario_insercion) VALUES (?,?,?,?,?,?,?)";

        ArrayList<VehiculoModelo> modelo = (ArrayList<VehiculoModelo>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);

            for (VehiculoModelo mod : modelo) {
                preparedStatement.setString(1, mod.getId_empresa());
                preparedStatement.setString(2, mod.getId());
                preparedStatement.setString(3, mod.getIdMarca());
                preparedStatement.setString(4, mod.getDescripcion());
                preparedStatement.setString(5, mod.getEstado());
                preparedStatement.setDate(6, Utils.getSqlDate(mod.getFechaInsercion()));
                preparedStatement.setString(7, mod.getUsuarioInsercion());

                preparedStatement.addBatch();
            }

            conexion.commit();
            insertedRows = preparedStatement.executeBatch();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return insertedRows.length;

    }

    private static int llamarFuncionInsercionvehiculo(Object object) {
        int insertedRows = 0;
        ArrayList<Vehiculo> vehiculo = (ArrayList<Vehiculo>) object;

        try (Connection conexion = getThinConnection();
                CallableStatement cst = conexion.prepareCall("{? = call PKG_VEHICULOS.inserta_vehiculo(?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {

            conexion.setAutoCommit(false);
            cst.registerOutParameter(1, Types.INTEGER);
            for (Vehiculo veh : vehiculo) {
                cst.setString(2, Constantes.ID_EMPRESA);
                cst.setString(3, "VEHI");
                cst.setString(4, veh.getIdTipoVehiculo());
                cst.setInt(5, veh.getSecuenciaEntrada());
                cst.setString(6, veh.getChasis());
                cst.setString(7, veh.getIdMarca());
                cst.setString(8, veh.getIdModelo());
                cst.setString(9, veh.getIdEstilo());
                cst.setString(10, veh.getNota());
                cst.setString(11, veh.getColor());
                cst.setString(12, veh.getColorInterior());
                cst.setString(13, veh.getAno());
                cst.setString(14, veh.getFechaCompra());
                cst.setString(15, veh.getIdIntermediario());
                cst.setString(16, veh.getNombreIntermediario());
                cst.setInt(17, veh.getFilaAsiento());
                cst.setInt(18, veh.getCantPuerta());
                cst.setString(19, veh.getIdCombustible());
                cst.setString(20, veh.getIdTraccion());
                cst.setString(21, veh.getCilindraje());
                cst.setString(22, veh.getMillaje());
                cst.setString(23, veh.getKilometraje());
                cst.setString(24, veh.getReferencia());
                cst.setString(25, veh.getIdMoneda());
                cst.setString(26, veh.getPrecioCompra());
                cst.setString(27, veh.getPlaca());
                cst.setString(28, veh.getFicha());
                cst.setString(29, veh.getLlamar());
                cst.setString(30, veh.getIdCliente());
                cst.setString(31, veh.getNombre());
                cst.setString(32, veh.getTelefono());
                cst.setString(33, veh.getCelular());
                cst.setString(34, veh.getUlt_fecha_llamado());
                cst.setString(35, veh.getCantidad_dias_llamar());
                cst.setString(36, veh.getIdTransmision());
                cst.setString(37, veh.getOrigen_fab());
                cst.setString(38, veh.getOrigenComp());
                cst.setString(39, veh.getCondicionVehi());
                cst.setString(40, veh.getEstadoVeh());
                cst.setString(41, veh.getCarga());
                cst.setString(42, veh.getPasajeros());
                cst.setInt(43, veh.getCilindros());
                cst.setString(44, veh.getIdEntGarantia());
                cst.setString(45, veh.getKmGarantia());
                cst.setString(46, veh.getTiempoGarantia());
                cst.setString(47, veh.getGarantia());
                cst.setString(48, veh.getNotasGarantia());
                cst.setString(49, veh.getIdUso());
                cst.setString(50, veh.getNoVelocidades());
                cst.setString(51, veh.getVmUbicacion());
                cst.setString(52, veh.getIdTipoVehDgii());
                cst.setString(53, veh.getModeloSegunDgii());

            }
            cst.registerOutParameter(54, Types.VARCHAR);

            conexion.commit();

            cst.execute();
            idVehiculo = cst.getString(54);
            insertedRows = cst.getInt(1);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return insertedRows;

    }

    private static int vehInsert(Object object) {

        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.VEHICULO(id_empresa,id_vehiculo,chasis,"
                + " id_cliente,id_combustible, id_estilo, id_modelo, id_marca,"
                + "id_traccion, id_tipo_vehiculo, color, color_interior, cant_puerta,"
                + " ano, fila_asiento,estado,tiempo_garantia,garantia,placa, usuario_insercion,fecha_insercion,"
                + " secuencia_entrada, referencia, id_estado_veh,cilindraje, cilindros, id_transmision, nota)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<Vehiculo> vehiculo = (ArrayList<Vehiculo>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);

            for (Vehiculo veh : vehiculo) {
                preparedStatement.setString(1, veh.getId_empresa());
                preparedStatement.setString(2, veh.getId());
                preparedStatement.setString(3, veh.getChasis());
                preparedStatement.setString(4, veh.getIdCliente());
                preparedStatement.setString(5, veh.getIdCombustible());
                preparedStatement.setString(6, veh.getIdEstilo());
                preparedStatement.setString(7, veh.getIdModelo());
                preparedStatement.setString(8, veh.getIdMarca());
                preparedStatement.setString(9, veh.getIdTraccion());
                preparedStatement.setString(10, veh.getIdTipoVehiculo());
                preparedStatement.setString(11, veh.getColor());
                preparedStatement.setString(12, veh.getColorInterior());
                preparedStatement.setInt(13, veh.getCantPuerta());
                preparedStatement.setString(14, veh.getAno());
                preparedStatement.setInt(15, veh.getFilaAsiento());
                preparedStatement.setString(16, veh.getEstado());
                preparedStatement.setString(17, veh.getTiempoGarantia());
                preparedStatement.setString(18, veh.getGarantia());
                preparedStatement.setString(19, veh.getPlaca());
                preparedStatement.setString(20, veh.getUsuarioInsercion());
                preparedStatement.setDate(21, Utils.getSqlDate(veh.getFechaInsercion()));
                preparedStatement.setInt(22, veh.getSecuenciaEntrada());
                preparedStatement.setString(23, veh.getReferencia());
                preparedStatement.setString(24, veh.getEstadoVeh());
                preparedStatement.setString(25, veh.getCilindraje());
                preparedStatement.setInt(26, veh.getCilindros());
                preparedStatement.setString(27, veh.getIdTransmision());
                preparedStatement.setString(28, veh.getNota());

                preparedStatement.addBatch();
            }

            conexion.commit();
            insertedRows = preparedStatement.executeBatch();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return insertedRows.length;

    }

    private static int vehEstiloInsert(Object object) {

        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.VEHICULO_ESTILO (id_empresa,id_modelo,id_estilo,"
                + " descripcion,estado,usuario_insercion) VALUES (?,?,?,?,?,?)";

        ArrayList<VehiculoEstilo> estilo = (ArrayList<VehiculoEstilo>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);

            for (VehiculoEstilo est : estilo) {
                preparedStatement.setString(1, est.getId_empresa());
                preparedStatement.setString(2, est.getId_modelo());
                preparedStatement.setString(3, est.getId());
                preparedStatement.setString(4, est.getDescripcion());
                preparedStatement.setString(5, est.getEstado());
                preparedStatement.setString(6, est.getUsuarioInsercion());
                preparedStatement.addBatch();
            }

            conexion.commit();
            insertedRows = preparedStatement.executeBatch();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return insertedRows.length;

    }

    private static int productoPInsert(Object object) {
        int[] insertedRows = {};
        String sql = "INSERT INTO TRANSACCIONAL.PRODUCTO_PRECIO (id_empresa,id_producto,cod_barra, estado,costo_compra,"
                + "precio_venta,fecha_insercion,usuario_insercion,"
                + "margen_beneficio,id_moneda,modifica_manual_precio)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<ProductoPrecio> producto = (ArrayList<ProductoPrecio>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (ProductoPrecio dato : producto) {
                preparedStatement.setString(1, dato.getId_empresa());
                preparedStatement.setString(2, dato.getId_producto());
                preparedStatement.setString(3, dato.getCod_barra());
                preparedStatement.setString(4, dato.getEstado());
                preparedStatement.setString(5, dato.getCosto_compra());
                preparedStatement.setString(6, dato.getPrecio_venta());
                preparedStatement.setDate(7, Utils.getSqlDate(dato.getFecha_insercion()));
                preparedStatement.setString(8, dato.getUsuario_insercion());
                preparedStatement.setString(9, dato.getMargen_beneficio());
                preparedStatement.setString(10, dato.getId_moneda());
                preparedStatement.setString(11, dato.getModifica_manual_precio());
                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return insertedRows.length;
    }

    private static int pedidoProdInsert(Object object) {

        int[] insertedRows = {};

        String sql = "INSERT INTO TRANSACCIONAL.PEDIDO_PRODUCTO (id_empresa,id_tipo_trans,id_documento,id_centro_costo, "
                + "id_producto, id_impuesto,secuencia,precio,fecha_insercion,usuario_insercion, "
                + "estado, cantidad,unidad, porc_descuento, monto_impuesto,"
                + "monto_descuento,importe_itbis, precio_neto,observaciones,"
                + "precio_bruto, unidad_referencia,id_rep_ven,descuento,precio_final_sin_impuestos,"
                + "impuestos,porc_impuesto, precio_final_con_impuestos,referencia )"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ArrayList<PedidoProducto> pedido = (ArrayList<PedidoProducto>) object;
        try (Connection conexion = getThinConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            for (PedidoProducto dato : pedido) {
                preparedStatement.setString(1, dato.getId_empresa());
                preparedStatement.setString(2, dato.getId_tipo_trans());
                preparedStatement.setString(3, dato.getId_documento());
                preparedStatement.setString(4, dato.getId_centro_costo());
                preparedStatement.setString(5, dato.getId_producto());
                preparedStatement.setString(6, dato.getId_impuesto());
                preparedStatement.setString(7, dato.getSecuencia());
                preparedStatement.setString(8, dato.getPrecio());
                preparedStatement.setString(9, dato.getFecha_insercion());
                preparedStatement.setString(10, dato.getUsuario_insercion());
                preparedStatement.setString(11, dato.getEstado());
                preparedStatement.setString(12, dato.getCantidad());
                preparedStatement.setString(13, dato.getUnidad());
                preparedStatement.setString(14, dato.getPorc_descuento());
                preparedStatement.setString(15, dato.getMonto_impuesto());
                preparedStatement.setString(16, dato.getMonto_descuento());
                preparedStatement.setString(17, dato.getImporte_itbis());
                preparedStatement.setString(18, dato.getPrecio_neto());
                preparedStatement.setString(19, dato.getObservaciones());
                preparedStatement.setString(20, dato.getPrecio_bruto());
                preparedStatement.setString(21, dato.getUnidad_referencia());
                preparedStatement.setString(22, dato.getId_rep_ven());
                preparedStatement.setString(23, dato.getDescuento());
                preparedStatement.setString(24, dato.getPrecio_final_sin_impuestos());
                preparedStatement.setString(25, dato.getPorc_impuesto());
                preparedStatement.setString(26, dato.getPrecio_final_con_impuestos());
                preparedStatement.setString(27, dato.getReferencia());

                preparedStatement.addBatch();
            }
            insertedRows = preparedStatement.executeBatch();
            conexion.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return insertedRows.length;
    }

    private static List<Object> getProducto_precio(ResultSet resultSet) throws SQLException {
        List<Object> prod_list = new ArrayList<>();
        while (resultSet.next()) {
            ProductoPrecio dato = new ProductoPrecio();
            dato.setId_empresa(resultSet.getString(PRODUCTO_PRECIO.ID_EMPRESA));
            dato.setCod_barra(resultSet.getString(PRODUCTO_PRECIO.CHASIS));
            dato.setId_producto(resultSet.getString(PRODUCTO_PRECIO.ID_SERVICIO));
            dato.setCosto_compra(resultSet.getString(PRODUCTO_PRECIO.COSTO_COMPRA));
            dato.setMargen_beneficio(resultSet.getString(PRODUCTO_PRECIO.MARGEN_BENEFICIO));
            dato.setPrecio_venta(resultSet.getString(PRODUCTO_PRECIO.PRECIO_VENTA));
            dato.setEstado(resultSet.getString(PRODUCTO_PRECIO.ESTADO));
            prod_list.add(dato);
        }
        return prod_list;
    }

    private static List<Object> getPais(ResultSet resultSet) throws SQLException {

        List<Object> pais_list = new ArrayList<>();
        while (resultSet.next()) {
            Pais pais = new Pais();
            pais.setId_pais(resultSet.getString(PAIS.ID_PAIS));
            pais.setDesc_pais(resultSet.getString(PAIS.DESC_PAIS));
            pais.setNacionalidad(resultSet.getString(PAIS.NACIONALIDAD));
            pais.setEstado(resultSet.getString(PAIS.ESTADO));

            pais_list.add(pais);
        }

        return pais_list;

    }

}