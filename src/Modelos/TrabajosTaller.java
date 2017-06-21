/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author Prueba
 */
public class TrabajosTaller {
    
    private String idNegocio, idTipoTrans, idDocumento, idCliente, businessName, idRuta, idVendedor,
            estado, usuarioInsercion, UsuarioActualizacion;
    private Date fechaDocumento, fechaInsercion, fechaActualizacion;
    private double cantidad, balance;

    /**
     * @return the idNegocio
     */
    public String getIdNegocio() {
        return idNegocio;
    }

    /**
     * @param idNegocio the idNegocio to set
     */
    public void setIdNegocio(String idNegocio) {
        this.idNegocio = idNegocio;
    }

    /**
     * @return the idTipoTrans
     */
    public String getIdTipoTrans() {
        return idTipoTrans;
    }

    /**
     * @param idTipoTrans the idTipoTrans to set
     */
    public void setIdTipoTrans(String idTipoTrans) {
        this.idTipoTrans = idTipoTrans;
    }

    /**
     * @return the idDocumento
     */
    public String getIdDocumento() {
        return idDocumento;
    }

    /**
     * @param idDocumento the idDocumento to set
     */
    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    /**
     * @return the idCliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * @return the idRuta
     */
    public String getIdRuta() {
        return idRuta;
    }

    /**
     * @param idRuta the idRuta to set
     */
    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    /**
     * @return the idVendedor
     */
    public String getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
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
     * @return the usuarioInsercion
     */
    public String getUsuarioInsercion() {
        return usuarioInsercion;
    }

    /**
     * @param usuarioInsercion the usuarioInsercion to set
     */
    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    /**
     * @return the UsuarioActualizacion
     */
    public String getUsuarioActualizacion() {
        return UsuarioActualizacion;
    }

    /**
     * @param UsuarioActualizacion the UsuarioActualizacion to set
     */
    public void setUsuarioActualizacion(String UsuarioActualizacion) {
        this.UsuarioActualizacion = UsuarioActualizacion;
    }

    /**
     * @return the fechaDocumento
     */
    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    /**
     * @param fechaDocumento the fechaDocumento to set
     */
    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    /**
     * @return the fechaInsercion
     */
    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    /**
     * @param fechaInsercion the fechaInsercion to set
     */
    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    /**
     * @return the fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

  
}
