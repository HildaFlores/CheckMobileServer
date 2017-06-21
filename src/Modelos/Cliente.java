package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private String id;
     private String id_empresa;
     private Empresa empresa;
     private String estadoCliente;
     private int idTipoCliente;
     private int limiteCredito;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private String nombres;
     private String apellidos;
     private String edad;
     private String sexo;
     private String estadoCivil;
     private String documentoIdentidad;
     private String balanceCuenta;
     private String rnc;
     private String nombreEmpresa;
     private String contactoPrincipal;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private String idCondicion;
     private String nacionalidad;
     private String apodo;
     private String ocupacion;
     private String notas;
     private String pais;
     private String valorFiscal;
     private String idTipoNcf;
     private String calDescDef;
     private String idMonedaDef;
     private Boolean idTipoIdent;
     private String idCentroCosto;
     private String limiteFactPendCte;
     private Long trOrigen;
     private BigDecimal porcImpRetenido;
     private String aplicaMora;
     private String cuentaContable;
     private String idCondicionVend;
     private String idClasificacion;
     private Boolean clientevip;
     private Long limteFactPendVenc;
     private Short descFactura;
     private String limiteDescuento;
     private String idSubTipoCte;
     private String idEntidad;
     private String tipoEntidad;
     private String calificacionCte;
     private Character poseeTarjeta;
     private String bancoTarjeta;
     private Character poseeCuenta;
     private String bancoCuenta;
     private String referidoPor;
     private String idClienteReferido;
     private BigDecimal limiteMontoCuota;
     private String idTipoCategoria;
     private BigDecimal limiteDiasVen;
     private BigDecimal limitePorcInicial;
     private String comisionVen;
     private String razonSocial;
     private String noPasaporte;
     private Date fecha_nacimiento;
     private String descripcion_condicion;
     private String telefono;
     private String telefono_movil;
     private String direccion_email;
     private String linea1;
     private String ciudad_provincia;
     private String linea2;
     private String lugar_nac;

    public Cliente() {
    }

	
    public Cliente(String id, Empresa empresa, String estadoCliente, int idTipoCliente, int limiteCredito, String estado, Date fechaInsercion, String nombres, String idCondicion) {
        this.id = id;
        this.empresa = empresa;
        this.estadoCliente = estadoCliente;
        this.idTipoCliente = idTipoCliente;
        this.limiteCredito = limiteCredito;
        this.estado = estado;
        this.fechaInsercion = fechaInsercion;
        this.nombres = nombres;
        this.idCondicion = idCondicion;
    }
   
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getEstadoCliente() {
        return this.estadoCliente;
    }
    
    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    public int getIdTipoCliente() {
        return this.idTipoCliente;
    }
    
    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
    public int getLimiteCredito() {
        return this.limiteCredito;
    }
    
    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
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
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEdad() {
        return this.edad;
    }
    
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getDocumentoIdentidad() {
        return this.documentoIdentidad;
    }
    
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    public String getBalanceCuenta() {
        return this.balanceCuenta;
    }
    
    public void setBalanceCuenta(String balanceCuenta) {
        this.balanceCuenta = balanceCuenta;
    }
    public String getRnc() {
        return this.rnc;
    }
    
    public void setRnc(String rnc) {
        this.rnc = rnc;
    }
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getContactoPrincipal() {
        return this.contactoPrincipal;
    }
    
    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
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
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getApodo() {
        return this.apodo;
    }
    
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public String getOcupacion() {
        return this.ocupacion;
    }
    
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getNotas() {
        return this.notas;
    }
    
    public void setNotas(String notas) {
        this.notas = notas;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getValorFiscal() {
        return this.valorFiscal;
    }
    
    public void setValorFiscal(String valorFiscal) {
        this.valorFiscal = valorFiscal;
    }
    public String getIdTipoNcf() {
        return this.idTipoNcf;
    }
    
    public void setIdTipoNcf(String idTipoNcf) {
        this.idTipoNcf = idTipoNcf;
    }
    public String getCalDescDef() {
        return this.calDescDef;
    }
    
    public void setCalDescDef(String calDescDef) {
        this.calDescDef = calDescDef;
    }
    public String getIdMonedaDef() {
        return this.idMonedaDef;
    }
    
    public void setIdMonedaDef(String idMonedaDef) {
        this.idMonedaDef = idMonedaDef;
    }
    public Boolean getIdTipoIdent() {
        return this.idTipoIdent;
    }
    
    public void setIdTipoIdent(Boolean idTipoIdent) {
        this.idTipoIdent = idTipoIdent;
    }
    public String getIdCentroCosto() {
        return this.idCentroCosto;
    }
    
    public void setIdCentroCosto(String idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }
    public String getLimiteFactPendCte() {
        return this.limiteFactPendCte;
    }
    
    public void setLimiteFactPendCte(String limiteFactPendCte) {
        this.limiteFactPendCte = limiteFactPendCte;
    }
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public BigDecimal getPorcImpRetenido() {
        return this.porcImpRetenido;
    }
    
    public void setPorcImpRetenido(BigDecimal porcImpRetenido) {
        this.porcImpRetenido = porcImpRetenido;
    }
    public String getAplicaMora() {
        return this.aplicaMora;
    }
    
    public void setAplicaMora(String aplicaMora) {
        this.aplicaMora = aplicaMora;
    }
    public String getCuentaContable() {
        return this.cuentaContable;
    }
    
    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }
    public String getIdCondicionVend() {
        return this.idCondicionVend;
    }
    
    public void setIdCondicionVend(String idCondicionVend) {
        this.idCondicionVend = idCondicionVend;
    }
    public String getIdClasificacion() {
        return this.idClasificacion;
    }
    
    public void setIdClasificacion(String idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    public Boolean getClientevip() {
        return this.clientevip;
    }
    
    public void setClientevip(Boolean clientevip) {
        this.clientevip = clientevip;
    }
    public Long getLimteFactPendVenc() {
        return this.limteFactPendVenc;
    }
    
    public void setLimteFactPendVenc(Long limteFactPendVenc) {
        this.limteFactPendVenc = limteFactPendVenc;
    }
    public Short getDescFactura() {
        return this.descFactura;
    }
    
    public void setDescFactura(Short descFactura) {
        this.descFactura = descFactura;
    }
    public String getLimiteDescuento() {
        return this.limiteDescuento;
    }
    
    public void setLimiteDescuento(String limiteDescuento) {
        this.limiteDescuento = limiteDescuento;
    }
    public String getIdSubTipoCte() {
        return this.idSubTipoCte;
    }
    
    public void setIdSubTipoCte(String idSubTipoCte) {
        this.idSubTipoCte = idSubTipoCte;
    }
    public String getIdEntidad() {
        return this.idEntidad;
    }
    
    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }
    public String getTipoEntidad() {
        return this.tipoEntidad;
    }
    
    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
    public String getCalificacionCte() {
        return this.calificacionCte;
    }
    
    public void setCalificacionCte(String calificacionCte) {
        this.calificacionCte = calificacionCte;
    }
    public Character getPoseeTarjeta() {
        return this.poseeTarjeta;
    }
    
    public void setPoseeTarjeta(Character poseeTarjeta) {
        this.poseeTarjeta = poseeTarjeta;
    }
    public String getBancoTarjeta() {
        return this.bancoTarjeta;
    }
    
    public void setBancoTarjeta(String bancoTarjeta) {
        this.bancoTarjeta = bancoTarjeta;
    }
    public Character getPoseeCuenta() {
        return this.poseeCuenta;
    }
    
    public void setPoseeCuenta(Character poseeCuenta) {
        this.poseeCuenta = poseeCuenta;
    }
    public String getBancoCuenta() {
        return this.bancoCuenta;
    }
    
    public void setBancoCuenta(String bancoCuenta) {
        this.bancoCuenta = bancoCuenta;
    }
    public String getReferidoPor() {
        return this.referidoPor;
    }
    
    public void setReferidoPor(String referidoPor) {
        this.referidoPor = referidoPor;
    }
    public String getIdClienteReferido() {
        return this.idClienteReferido;
    }
    
    public void setIdClienteReferido(String idClienteReferido) {
        this.idClienteReferido = idClienteReferido;
    }
    public BigDecimal getLimiteMontoCuota() {
        return this.limiteMontoCuota;
    }
    
    public void setLimiteMontoCuota(BigDecimal limiteMontoCuota) {
        this.limiteMontoCuota = limiteMontoCuota;
    }
    public String getIdTipoCategoria() {
        return this.idTipoCategoria;
    }
    
    public void setIdTipoCategoria(String idTipoCategoria) {
        this.idTipoCategoria = idTipoCategoria;
    }
    public BigDecimal getLimiteDiasVen() {
        return this.limiteDiasVen;
    }
    
    public void setLimiteDiasVen(BigDecimal limiteDiasVen) {
        this.limiteDiasVen = limiteDiasVen;
    }
    public BigDecimal getLimitePorcInicial() {
        return this.limitePorcInicial;
    }
    
    public void setLimitePorcInicial(BigDecimal limitePorcInicial) {
        this.limitePorcInicial = limitePorcInicial;
    }
    public String getComisionVen() {
        return this.comisionVen;
    }
    
    public void setComisionVen(String comisionVen) {
        this.comisionVen = comisionVen;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getNoPasaporte() {
        return this.noPasaporte;
    }
    
    public void setNoPasaporte(String noPasaporte) {
        this.noPasaporte = noPasaporte;
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
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the descripcion_condicion
     */
    public String getDescripcion_condicion() {
        return descripcion_condicion;
    }

    /**
     * @param descripcion_condicion the descripcion_condicion to set
     */
    public void setDescripcion_condicion(String descripcion_condicion) {
        this.descripcion_condicion = descripcion_condicion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the telefono_movil
     */
    public String getTelefono_movil() {
        return telefono_movil;
    }

    /**
     * @param telefono_movil the telefono_movil to set
     */
    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    /**
     * @return the direccion_email
     */
    public String getDireccion_email() {
        return direccion_email;
    }

    /**
     * @param direccion_email the direccion_email to set
     */
    public void setDireccion_email(String direccion_email) {
        this.direccion_email = direccion_email;
    }

    /**
     * @return the linea1
     */
    public String getLinea1() {
        return linea1;
    }

    /**
     * @param linea1 the linea1 to set
     */
    public void setLinea1(String linea1) {
        this.linea1 = linea1;
    }

    /**
     * @return the ciudad_provincia
     */
    public String getCiudad_provincia() {
        return ciudad_provincia;
    }

    /**
     * @param ciudad_provincia the ciudad_provincia to set
     */
    public void setCiudad_provincia(String ciudad_provincia) {
        this.ciudad_provincia = ciudad_provincia;
    }

    /**
     * @return the linea2
     */
    public String getLinea2() {
        return linea2;
    }

    /**
     * @param linea2 the linea2 to set
     */
    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    /**
     * @return the lugar_nac
     */
    public String getLugar_nac() {
        return lugar_nac;
    }

    /**
     * @param lugar_nac the lugar_nac to set
     */
    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }




}

