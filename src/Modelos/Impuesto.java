/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Prueba
 */
public class Impuesto {

    private String id_impuesto;
    private String id_empresa;
    private String descripcion;
    private String tasa;
    private String simbolo;
    private String fecha_insercion;
    private String usuario_insercion;
    private String fecha_actualizacion;
    private String usaurio_actualizacion;
    private String estado;

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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tasa
     */
    public String getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the fecha_insercion
     */
    public String getFecha_insercion() {
        return fecha_insercion;
    }

    /**
     * @param fecha_insercion the fecha_insercion to set
     */
    public void setFecha_insercion(String fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    /**
     * @return the usuario_insercion
     */
    public String getUsuario_insercion() {
        return usuario_insercion;
    }

    /**
     * @param usuario_insercion the usuario_insercion to set
     */
    public void setUsuario_insercion(String usuario_insercion) {
        this.usuario_insercion = usuario_insercion;
    }

    /**
     * @return the fecha_actualizacion
     */
    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    /**
     * @param fecha_actualizacion the fecha_actualizacion to set
     */
    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    /**
     * @return the usaurio_actualizacion
     */
    public String getUsaurio_actualizacion() {
        return usaurio_actualizacion;
    }

    /**
     * @param usaurio_actualizacion the usaurio_actualizacion to set
     */
    public void setUsaurio_actualizacion(String usaurio_actualizacion) {
        this.usaurio_actualizacion = usaurio_actualizacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the id_impuesto
     */
    public String getId_impuesto() {
        return id_impuesto;
    }

    /**
     * @param id_impuesto the id_impuesto to set
     */
    public void setId_impuesto(String id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

}
