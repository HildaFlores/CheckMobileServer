package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CentroCostos generated by hbm2java
 */
public class CentroCostos  implements java.io.Serializable {


     private String id;
     private String id_empresa;
     private String nombreCc;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private String centroPadre;
     private String campo1;
     private String campo2;
     private Long trOrigen;
     private String canalBaseDef;
     private Set pedidoEncs = new HashSet(0);

    public CentroCostos() {
    }

	
    public CentroCostos(String id, String nombreCc, String estado, Date fechaInsercion, String usuarioInsercion) {
        this.id = id;
        this.nombreCc = nombreCc;
        this.estado = estado;
        this.fechaInsercion = fechaInsercion;
        this.usuarioInsercion = usuarioInsercion;
    }
    public CentroCostos(String id, Empresa empresa, String nombreCc, String estado, Date fechaInsercion, String usuarioInsercion, Date fechaActualizacion, String usuarioActualizacion, String centroPadre, String campo1, String campo2, Long trOrigen, String canalBaseDef, Set pedidoEncs) {
       this.id = id; 
       this.nombreCc = nombreCc;
       this.estado = estado;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.centroPadre = centroPadre;
       this.campo1 = campo1;
       this.campo2 = campo2;
       this.trOrigen = trOrigen;
       this.canalBaseDef = canalBaseDef;
       this.pedidoEncs = pedidoEncs;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCc() {
        return this.nombreCc;
    }
    
    public void setNombreCc(String nombreCc) {
        this.nombreCc = nombreCc;
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
    public String getCentroPadre() {
        return this.centroPadre;
    }
    
    public void setCentroPadre(String centroPadre) {
        this.centroPadre = centroPadre;
    }
    public String getCampo1() {
        return this.campo1;
    }
    
    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }
    public String getCampo2() {
        return this.campo2;
    }
    
    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public String getCanalBaseDef() {
        return this.canalBaseDef;
    }
    
    public void setCanalBaseDef(String canalBaseDef) {
        this.canalBaseDef = canalBaseDef;
    }
    public Set getPedidoEncs() {
        return this.pedidoEncs;
    }
    
    public void setPedidoEncs(Set pedidoEncs) {
        this.pedidoEncs = pedidoEncs;
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


