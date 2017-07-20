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
public class PedidoProducto implements java.io.Serializable {

    private String id_empresa;
    private String id_tipo_trans;
    private String id_documento;    
    private String id_centro_costo;
    private String id_producto;
    private String cod_barra;
    private String id_impuesto;
    private String secuencia;
    private String descripcion_producto;
    private String precio;
    private String fecha_insercion;
    private String usuario_insercion;
    private String fecha_actualizacion;
    private String usaurio_actualizacion;
    private String estado;
    private String cantidad;
    private String unidad;
    private String porc_descuento;
    private String monto_impuesto;
    private String monto_descuento;
    private String importe;
    private String importe_itbis;
    private String precio_neto;
    private String observaciones;
    private String precio_bruto;
    private String unidad_referencia;
    private String id_rep_ven;
    private String descuento;
    private String precio_final_sin_impuestos;
    private String impuestos;
    private String porc_impuesto;
    private String precio_final_con_impuestos;
    private String referencia;

    public PedidoProducto() {
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
     * @return the id_tipo_trans
     */
    public String getId_tipo_trans() {
        return id_tipo_trans;
    }

    /**
     * @param id_tipo_trans the id_tipo_trans to set
     */
    public void setId_tipo_trans(String id_tipo_trans) {
        this.id_tipo_trans = id_tipo_trans;
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
     * @return the id_centro_costo
     */
    public String getId_centro_costo() {
        return id_centro_costo;
    }

    /**
     * @param id_centro_costo the id_centro_costo to set
     */
    public void setId_centro_costo(String id_centro_costo) {
        this.id_centro_costo = id_centro_costo;
    }

    /**
     * @return the id_producto
     */
    public String getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the cod_barra
     */
    public String getCod_barra() {
        return cod_barra;
    }

    /**
     * @param cod_barra the cod_barra to set
     */
    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
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

    /**
     * @return the secuencia
     */
    public String getSecuencia() {
        return secuencia;
    }

    /**
     * @param secuencia the secuencia to set
     */
    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    /**
     * @return the descripcion_producto
     */
    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    /**
     * @param descripcion_producto the descripcion_producto to set
     */
    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
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
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the porc_descuento
     */
    public String getPorc_descuento() {
        return porc_descuento;
    }

    /**
     * @param porc_descuento the porc_descuento to set
     */
    public void setPorc_descuento(String porc_descuento) {
        this.porc_descuento = porc_descuento;
    }

    /**
     * @return the monto_impuesto
     */
    public String getMonto_impuesto() {
        return monto_impuesto;
    }

    /**
     * @param monto_impuesto the monto_impuesto to set
     */
    public void setMonto_impuesto(String monto_impuesto) {
        this.monto_impuesto = monto_impuesto;
    }

    /**
     * @return the monto_descuento
     */
    public String getMonto_descuento() {
        return monto_descuento;
    }

    /**
     * @param monto_descuento the monto_descuento to set
     */
    public void setMonto_descuento(String monto_descuento) {
        this.monto_descuento = monto_descuento;
    }

    /**
     * @return the importe
     */
    public String getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(String importe) {
        this.importe = importe;
    }

    /**
     * @return the importe_itbis
     */
    public String getImporte_itbis() {
        return importe_itbis;
    }

    /**
     * @param importe_itbis the importe_itbis to set
     */
    public void setImporte_itbis(String importe_itbis) {
        this.importe_itbis = importe_itbis;
    }

    /**
     * @return the precio_neto
     */
    public String getPrecio_neto() {
        return precio_neto;
    }

    /**
     * @param precio_neto the precio_neto to set
     */
    public void setPrecio_neto(String precio_neto) {
        this.precio_neto = precio_neto;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the precio_bruto
     */
    public String getPrecio_bruto() {
        return precio_bruto;
    }

    /**
     * @param precio_bruto the precio_bruto to set
     */
    public void setPrecio_bruto(String precio_bruto) {
        this.precio_bruto = precio_bruto;
    }

    /**
     * @return the unidad_referencia
     */
    public String getUnidad_referencia() {
        return unidad_referencia;
    }

    /**
     * @param unidad_referencia the unidad_referencia to set
     */
    public void setUnidad_referencia(String unidad_referencia) {
        this.unidad_referencia = unidad_referencia;
    }

    /**
     * @return the id_rep_ven
     */
    public String getId_rep_ven() {
        return id_rep_ven;
    }

    /**
     * @param id_rep_ven the id_rep_ven to set
     */
    public void setId_rep_ven(String id_rep_ven) {
        this.id_rep_ven = id_rep_ven;
    }

    /**
     * @return the descuento
     */
    public String getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the precio_final_sin_impuestos
     */
    public String getPrecio_final_sin_impuestos() {
        return precio_final_sin_impuestos;
    }

    /**
     * @param precio_final_sin_impuestos the precio_final_sin_impuestos to set
     */
    public void setPrecio_final_sin_impuestos(String precio_final_sin_impuestos) {
        this.precio_final_sin_impuestos = precio_final_sin_impuestos;
    }

    /**
     * @return the impuestos
     */
    public String getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the porc_impuesto
     */
    public String getPorc_impuesto() {
        return porc_impuesto;
    }

    /**
     * @param porc_impuesto the porc_impuesto to set
     */
    public void setPorc_impuesto(String porc_impuesto) {
        this.porc_impuesto = porc_impuesto;
    }

    /**
     * @return the precio_final_con_impuestos
     */
    public String getPrecio_final_con_impuestos() {
        return precio_final_con_impuestos;
    }

    /**
     * @param precio_final_con_impuestos the precio_final_con_impuestos to set
     */
    public void setPrecio_final_con_impuestos(String precio_final_con_impuestos) {
        this.precio_final_con_impuestos = precio_final_con_impuestos;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
