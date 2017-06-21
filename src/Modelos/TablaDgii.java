package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TablaDgii generated by hbm2java
 */
public class TablaDgii  implements java.io.Serializable {


     private String rncCedula;
     private String razonSocial;
     private String siglas;
     private String tipoNegocio;
     private String calle;
     private String numCalle;
     private String sector;
     private String telefono;
     private String fechaOperaciones;
     private String estado;
     private Date fecha;
     private String tipo;

    public TablaDgii() {
    }

	
    public TablaDgii(String rncCedula) {
        this.rncCedula = rncCedula;
    }
    public TablaDgii(String rncCedula, String razonSocial, String siglas, String tipoNegocio, String calle, String numCalle, String sector, String telefono, String fechaOperaciones, String estado, Date fecha, String tipo) {
       this.rncCedula = rncCedula;
       this.razonSocial = razonSocial;
       this.siglas = siglas;
       this.tipoNegocio = tipoNegocio;
       this.calle = calle;
       this.numCalle = numCalle;
       this.sector = sector;
       this.telefono = telefono;
       this.fechaOperaciones = fechaOperaciones;
       this.estado = estado;
       this.fecha = fecha;
       this.tipo = tipo;
    }
   
    public String getRncCedula() {
        return this.rncCedula;
    }
    
    public void setRncCedula(String rncCedula) {
        this.rncCedula = rncCedula;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getSiglas() {
        return this.siglas;
    }
    
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    public String getTipoNegocio() {
        return this.tipoNegocio;
    }
    
    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumCalle() {
        return this.numCalle;
    }
    
    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaOperaciones() {
        return this.fechaOperaciones;
    }
    
    public void setFechaOperaciones(String fechaOperaciones) {
        this.fechaOperaciones = fechaOperaciones;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}

