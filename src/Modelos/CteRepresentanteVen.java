package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CteRepresentanteVen generated by hbm2java
 */
public class CteRepresentanteVen  implements java.io.Serializable {


     private String id;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private String nombres;
     private String apellidos;
     private String documentoIdentidad;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private String notas;
     private String ciudadProvincia;
     private String municipio;
     private String sector;
     private String nombreEmpresa;
     private String idCentroCosto;
     private BigDecimal porcientoComision;
     private Long trOrigen;
     private String idUbicacion;
     private String calle;
     private String edificio;
     private Character certificadoMagna;
     private Character certificadoDelta;

    public CteRepresentanteVen() {
    }

	
    public CteRepresentanteVen(String id, String estado, Date fechaInsercion, String usuarioInsercion) {
        this.id = id;
        this.estado = estado;
        this.fechaInsercion = fechaInsercion;
        this.usuarioInsercion = usuarioInsercion;
    }
    public CteRepresentanteVen(String id, String estado, Date fechaInsercion, String usuarioInsercion, String nombres, String apellidos, String documentoIdentidad, Date fechaActualizacion, String usuarioActualizacion, String notas, String ciudadProvincia, String municipio, String sector, String nombreEmpresa, String idCentroCosto, BigDecimal porcientoComision, Long trOrigen, String idUbicacion, String calle, String edificio, Character certificadoMagna, Character certificadoDelta) {
       this.id = id;
       this.estado = estado;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.documentoIdentidad = documentoIdentidad;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.notas = notas;
       this.ciudadProvincia = ciudadProvincia;
       this.municipio = municipio;
       this.sector = sector;
       this.nombreEmpresa = nombreEmpresa;
       this.idCentroCosto = idCentroCosto;
       this.porcientoComision = porcientoComision;
       this.trOrigen = trOrigen;
       this.idUbicacion = idUbicacion;
       this.calle = calle;
       this.edificio = edificio;
       this.certificadoMagna = certificadoMagna;
       this.certificadoDelta = certificadoDelta;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
    public String getDocumentoIdentidad() {
        return this.documentoIdentidad;
    }
    
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
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
    public String getNotas() {
        return this.notas;
    }
    
    public void setNotas(String notas) {
        this.notas = notas;
    }
    public String getCiudadProvincia() {
        return this.ciudadProvincia;
    }
    
    public void setCiudadProvincia(String ciudadProvincia) {
        this.ciudadProvincia = ciudadProvincia;
    }
    public String getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getIdCentroCosto() {
        return this.idCentroCosto;
    }
    
    public void setIdCentroCosto(String idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }
    public BigDecimal getPorcientoComision() {
        return this.porcientoComision;
    }
    
    public void setPorcientoComision(BigDecimal porcientoComision) {
        this.porcientoComision = porcientoComision;
    }
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public String getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getEdificio() {
        return this.edificio;
    }
    
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
    public Character getCertificadoMagna() {
        return this.certificadoMagna;
    }
    
    public void setCertificadoMagna(Character certificadoMagna) {
        this.certificadoMagna = certificadoMagna;
    }
    public Character getCertificadoDelta() {
        return this.certificadoDelta;
    }
    
    public void setCertificadoDelta(Character certificadoDelta) {
        this.certificadoDelta = certificadoDelta;
    }




}


