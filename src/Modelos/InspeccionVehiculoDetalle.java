package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * InspeccionVehiculoDetalle generated by hbm2java
 */
public class InspeccionVehiculoDetalle  implements java.io.Serializable {


     private String id;
     private String id_empresa;
     private String idVehiculo;
     private String idTipoTrans;
     private String idElementoInspeccion;
     private String grado;
     private String puntuacion;
     private String observacion;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private Long trOrigen;
     private String idRespuesta;

    public InspeccionVehiculoDetalle() {
    }

	
    public InspeccionVehiculoDetalle(String id) {
        this.id = id;
    }
   
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getIdVehiculo() {
        return this.idVehiculo;
    }
    
    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    public String getIdTipoTrans() {
        return this.idTipoTrans;
    }
    
    public void setIdTipoTrans(String idTipoTrans) {
        this.idTipoTrans = idTipoTrans;
    }
    public String getIdElementoInspeccion() {
        return this.idElementoInspeccion;
    }
    
    public void setIdElementoInspeccion(String idElementoInspeccion) {
        this.idElementoInspeccion = idElementoInspeccion;
    }
    public String getGrado() {
        return this.grado;
    }
    
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public String getPuntuacion() {
        return this.puntuacion;
    }
    
    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public String getIdRespuesta() {
        return this.idRespuesta;
    }
    
    public void setIdRespuesta(String idRespuesta) {
        this.idRespuesta = idRespuesta;
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




}

