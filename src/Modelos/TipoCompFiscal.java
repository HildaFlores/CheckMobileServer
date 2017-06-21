package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TipoCompFiscal generated by hbm2java
 */
public class TipoCompFiscal  implements java.io.Serializable {


     private String idTipoNcf;
     private String descripcion;
     private Boolean valorFiscal;
     private String documento;
     private Date fechaInsercion;
     private Date fechaActualizacion;
     private String usuarioInsercion;
     private String usuarioActualizacion;
     private Character estado;
     private Long trOrigen;

    public TipoCompFiscal() {
    }

	
    public TipoCompFiscal(String idTipoNcf) {
        this.idTipoNcf = idTipoNcf;
    }
    public TipoCompFiscal(String idTipoNcf, String descripcion, Boolean valorFiscal, String documento, Date fechaInsercion, Date fechaActualizacion, String usuarioInsercion, String usuarioActualizacion, Character estado, Long trOrigen) {
       this.idTipoNcf = idTipoNcf;
       this.descripcion = descripcion;
       this.valorFiscal = valorFiscal;
       this.documento = documento;
       this.fechaInsercion = fechaInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioInsercion = usuarioInsercion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.estado = estado;
       this.trOrigen = trOrigen;
    }
   
    public String getIdTipoNcf() {
        return this.idTipoNcf;
    }
    
    public void setIdTipoNcf(String idTipoNcf) {
        this.idTipoNcf = idTipoNcf;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getValorFiscal() {
        return this.valorFiscal;
    }
    
    public void setValorFiscal(Boolean valorFiscal) {
        this.valorFiscal = valorFiscal;
    }
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public Date getFechaInsercion() {
        return this.fechaInsercion;
    }
    
    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getUsuarioInsercion() {
        return this.usuarioInsercion;
    }
    
    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }
    public String getUsuarioActualizacion() {
        return this.usuarioActualizacion;
    }
    
    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }




}


