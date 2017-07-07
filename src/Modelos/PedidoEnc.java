package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PedidoEnc generated by hbm2java
 */
public class PedidoEnc implements java.io.Serializable {

    private String id;
    private String id_empresa;
    private String id_centroCostos;
    private String cliente;
    private String id_documento;
    private String estadoFactura;
    private String tipoTransaccion;
    private String nombreCliente;
    private String apellidosCte;
    private String montoBruto;
    private String montoNeto;
    private String porcDescuento;
    private String montoDesc;
    private String montoImpuestos;
    private String montoGravado;
    private String montoExento;
    private String estado;
    private Date fechaInsercion;
    private String usuarioInsercion;
    private String idAsesor;
    private String notas;
    private Date fechaActualizacion;
    private String usuarioActualizacion;
    private String idCondicion;
    private BigDecimal tasaMoneda;
    private String idMoneda;
    private Long referencia;
    private String rnc;
    private Date fechaDocumento;
    private BigDecimal montoExonerado;
    private String calDesc;
    private BigDecimal tasaExoneracion;
    private BigDecimal tasaImp;
    private Date fechaVenc;
    private String impresion;
    private Date fechaDespacho;
    private String idMecanico;
    private Long trOrigen;
    private BigDecimal montoInicial;
    private Integer noPagos;
    private Boolean efectivo;
    private Boolean cheque;
    private Boolean tarjeta;
    private String idTipoTransFac;
    private String idDocumento;
    private BigDecimal montoCuota;
    private String idTipoNcf;
    private String noTransaccion;
    private Boolean tipoFt;
    private String notaDescuento;
    private String noOrden;
    private String fechaPedido;
    private String codTransporte;
    private Date fechaEnvio;
    private Short numeroDias;
    private Date fechaRealizacion;
    private BigDecimal montoAdicionales;
    private Character recibirVehiculo;
    private Character tipoFactura;
    private String idTipoServicio;
    private String idSupervisor;
    private Short dias;
    private Date fechaAnulacion;
    private String idPersonalFacturador;
    private BigDecimal devuelta;
    private Boolean autOrdenCompra;
    private String recibidoPor;
    private String realizadoPor;
    private Character ultimoFlujoComp;
    private Short numeroDiasPe;
    private Date fechaRealizacionPe;
    private Integer noPagosPe;
    private BigDecimal montoPe;
    private BigDecimal valorCuota;
    private Date fechaPrestamo;
    private String idOferta;
    private Character tipoTasaMoneda;
    private String id_inspeccion;

    public PedidoEnc() {
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }



    public String getEstadoFactura() {
        return this.estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getTipoTransaccion() {
        return this.tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidosCte() {
        return this.apellidosCte;
    }

    public void setApellidosCte(String apellidosCte) {
        this.apellidosCte = apellidosCte;
    }

    public String getMontoBruto() {
        return this.montoBruto;
    }

    public void setMontoBruto(String montoBruto) {
        this.montoBruto = montoBruto;
    }

    public String getMontoNeto() {
        return this.montoNeto;
    }

    public void setMontoNeto(String montoNeto) {
        this.montoNeto = montoNeto;
    }

    public String getPorcDescuento() {
        return this.porcDescuento;
    }

    public void setPorcDescuento(String porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public String getMontoDesc() {
        return this.montoDesc;
    }

    public void setMontoDesc(String montoDesc) {
        this.montoDesc = montoDesc;
    }

    public String getMontoImpuestos() {
        return this.montoImpuestos;
    }

    public void setMontoImpuestos(String montoImpuestos) {
        this.montoImpuestos = montoImpuestos;
    }

    public String getMontoGravado() {
        return this.montoGravado;
    }

    public void setMontoGravado(String montoGravado) {
        this.montoGravado = montoGravado;
    }

    public String getMontoExento() {
        return this.montoExento;
    }

    public void setMontoExento(String montoExento) {
        this.montoExento = montoExento;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInsercion() {
        return this.fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public String getUsuarioInsercion() {
        return this.usuarioInsercion;
    }

    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    public String getIdAsesor() {
        return this.idAsesor;
    }

    public void setIdAsesor(String idAsesor) {
        this.idAsesor = idAsesor;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return this.usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getIdCondicion() {
        return this.idCondicion;
    }

    public void setIdCondicion(String idCondicion) {
        this.idCondicion = idCondicion;
    }

    public BigDecimal getTasaMoneda() {
        return this.tasaMoneda;
    }

    public void setTasaMoneda(BigDecimal tasaMoneda) {
        this.tasaMoneda = tasaMoneda;
    }

    public String getIdMoneda() {
        return this.idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Long getReferencia() {
        return this.referencia;
    }

    public void setReferencia(Long referencia) {
        this.referencia = referencia;
    }

    public String getRnc() {
        return this.rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public Date getFechaDocumento() {
        return this.fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public BigDecimal getMontoExonerado() {
        return this.montoExonerado;
    }

    public void setMontoExonerado(BigDecimal montoExonerado) {
        this.montoExonerado = montoExonerado;
    }

    public String getCalDesc() {
        return this.calDesc;
    }

    public void setCalDesc(String calDesc) {
        this.calDesc = calDesc;
    }

    public BigDecimal getTasaExoneracion() {
        return this.tasaExoneracion;
    }

    public void setTasaExoneracion(BigDecimal tasaExoneracion) {
        this.tasaExoneracion = tasaExoneracion;
    }

    public BigDecimal getTasaImp() {
        return this.tasaImp;
    }

    public void setTasaImp(BigDecimal tasaImp) {
        this.tasaImp = tasaImp;
    }

    public Date getFechaVenc() {
        return this.fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getImpresion() {
        return this.impresion;
    }

    public void setImpresion(String impresion) {
        this.impresion = impresion;
    }

    public Date getFechaDespacho() {
        return this.fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getIdMecanico() {
        return this.idMecanico;
    }

    public void setIdMecanico(String idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Long getTrOrigen() {
        return this.trOrigen;
    }

    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }

    public BigDecimal getMontoInicial() {
        return this.montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Integer getNoPagos() {
        return this.noPagos;
    }

    public void setNoPagos(Integer noPagos) {
        this.noPagos = noPagos;
    }

    public Boolean getEfectivo() {
        return this.efectivo;
    }

    public void setEfectivo(Boolean efectivo) {
        this.efectivo = efectivo;
    }

    public Boolean getCheque() {
        return this.cheque;
    }

    public void setCheque(Boolean cheque) {
        this.cheque = cheque;
    }

    public Boolean getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(Boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getIdTipoTransFac() {
        return this.idTipoTransFac;
    }

    public void setIdTipoTransFac(String idTipoTransFac) {
        this.idTipoTransFac = idTipoTransFac;
    }

    public String getIdDocumento() {
        return this.idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public BigDecimal getMontoCuota() {
        return this.montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public String getIdTipoNcf() {
        return this.idTipoNcf;
    }

    public void setIdTipoNcf(String idTipoNcf) {
        this.idTipoNcf = idTipoNcf;
    }

    public String getNoTransaccion() {
        return this.noTransaccion;
    }

    public void setNoTransaccion(String noTransaccion) {
        this.noTransaccion = noTransaccion;
    }

    public Boolean getTipoFt() {
        return this.tipoFt;
    }

    public void setTipoFt(Boolean tipoFt) {
        this.tipoFt = tipoFt;
    }

    public String getNotaDescuento() {
        return this.notaDescuento;
    }

    public void setNotaDescuento(String notaDescuento) {
        this.notaDescuento = notaDescuento;
    }

    public String getNoOrden() {
        return this.noOrden;
    }

    public void setNoOrden(String noOrden) {
        this.noOrden = noOrden;
    }

    public String getFechaPedido() {
        return this.fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getCodTransporte() {
        return this.codTransporte;
    }

    public void setCodTransporte(String codTransporte) {
        this.codTransporte = codTransporte;
    }

    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Short getNumeroDias() {
        return this.numeroDias;
    }

    public void setNumeroDias(Short numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Date getFechaRealizacion() {
        return this.fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public BigDecimal getMontoAdicionales() {
        return this.montoAdicionales;
    }

    public void setMontoAdicionales(BigDecimal montoAdicionales) {
        this.montoAdicionales = montoAdicionales;
    }

    public Character getRecibirVehiculo() {
        return this.recibirVehiculo;
    }

    public void setRecibirVehiculo(Character recibirVehiculo) {
        this.recibirVehiculo = recibirVehiculo;
    }

    public Character getTipoFactura() {
        return this.tipoFactura;
    }

    public void setTipoFactura(Character tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getIdTipoServicio() {
        return this.idTipoServicio;
    }

    public void setIdTipoServicio(String idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getIdSupervisor() {
        return this.idSupervisor;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Short getDias() {
        return this.dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public Date getFechaAnulacion() {
        return this.fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getIdPersonalFacturador() {
        return this.idPersonalFacturador;
    }

    public void setIdPersonalFacturador(String idPersonalFacturador) {
        this.idPersonalFacturador = idPersonalFacturador;
    }

    public BigDecimal getDevuelta() {
        return this.devuelta;
    }

    public void setDevuelta(BigDecimal devuelta) {
        this.devuelta = devuelta;
    }

    public Boolean getAutOrdenCompra() {
        return this.autOrdenCompra;
    }

    public void setAutOrdenCompra(Boolean autOrdenCompra) {
        this.autOrdenCompra = autOrdenCompra;
    }

    public String getRecibidoPor() {
        return this.recibidoPor;
    }

    public void setRecibidoPor(String recibidoPor) {
        this.recibidoPor = recibidoPor;
    }

    public String getRealizadoPor() {
        return this.realizadoPor;
    }

    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    public Character getUltimoFlujoComp() {
        return this.ultimoFlujoComp;
    }

    public void setUltimoFlujoComp(Character ultimoFlujoComp) {
        this.ultimoFlujoComp = ultimoFlujoComp;
    }

    public Short getNumeroDiasPe() {
        return this.numeroDiasPe;
    }

    public void setNumeroDiasPe(Short numeroDiasPe) {
        this.numeroDiasPe = numeroDiasPe;
    }

    public Date getFechaRealizacionPe() {
        return this.fechaRealizacionPe;
    }

    public void setFechaRealizacionPe(Date fechaRealizacionPe) {
        this.fechaRealizacionPe = fechaRealizacionPe;
    }

    public Integer getNoPagosPe() {
        return this.noPagosPe;
    }

    public void setNoPagosPe(Integer noPagosPe) {
        this.noPagosPe = noPagosPe;
    }

    public BigDecimal getMontoPe() {
        return this.montoPe;
    }

    public void setMontoPe(BigDecimal montoPe) {
        this.montoPe = montoPe;
    }

    public BigDecimal getValorCuota() {
        return this.valorCuota;
    }

    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Date getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getIdOferta() {
        return this.idOferta;
    }

    public void setIdOferta(String idOferta) {
        this.idOferta = idOferta;
    }

    public Character getTipoTasaMoneda() {
        return this.tipoTasaMoneda;
    }

    public void setTipoTasaMoneda(Character tipoTasaMoneda) {
        this.tipoTasaMoneda = tipoTasaMoneda;
    }

    /**
     * @return the id_empresa
     */
    public String getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the id_centroCostos
     */
    public String getId_centroCostos() {
        return id_centroCostos;
    }

    /**
     * @param id_centroCostos the id_centroCostos to set
     */
    public void setId_centroCostos(String id_centroCostos) {
        this.id_centroCostos = id_centroCostos;
    }

    /**
     * @return the id_documento
     */
    public String getId_documento() {
        return id_documento;
    }

    /**
     * @param id_documento the id_documento to set
     */
    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }

    /**
     * @return the id_inspeccion
     */
    public String getId_inspeccion() {
        return id_inspeccion;
    }

    /**
     * @param id_inspeccion the id_inspeccion to set
     */
    public void setId_inspeccion(String id_inspeccion) {
        this.id_inspeccion = id_inspeccion;
    }

}
