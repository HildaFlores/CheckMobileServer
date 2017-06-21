package Modelos;



import java.util.Date;

/**
 * VehiculoMarca generated by hbm2java
 */
public class VehiculoMarca  implements java.io.Serializable {


     private String id;
     private String id_empresa;
     private String descripcion;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private Long trOrigen;
   

    public VehiculoMarca() {
    }

	
    public VehiculoMarca(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public VehiculoMarca(String id, String descripcion, String estado, Date fechaInsercion, String usuarioInsercion, Date fechaActualizacion, String usuarioActualizacion, Long trOrigen) {
       this.id = id;
       this.descripcion = descripcion;
       this.estado = estado;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.trOrigen = trOrigen;
       
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

