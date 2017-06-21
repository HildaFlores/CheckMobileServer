
package Modelos;

import java.util.Date;

/**
 *
 * @author Prueba
 */
public class ProductoPrecio {

    private String producto_precio;
    private String id_empresa;
    private String id_producto;
    private String cod_barra;
    private String estado;
    private String costo_compra;
    private String precio_venta;
    private Date fecha_insercion;
    private String usuario_insercion;
    private String fecha_actualizacion;
    private String usuario_actualizacion;
    private String margen_beneficio;
    private String id_moneda;
    private String modifica_manual_precio;
    
    public ProductoPrecio()
    {
        
    }

    /**
     * @return the producto_precio
     */
    public String getProducto_precio() {
        return producto_precio;
    }

    /**
     * @param producto_precio the producto_precio to set
     */
    public void setProducto_precio(String producto_precio) {
        this.producto_precio = producto_precio;
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
     * @return the costo_compra
     */
    public String getCosto_compra() {
        return costo_compra;
    }

    /**
     * @param costo_compra the costo_compra to set
     */
    public void setCosto_compra(String costo_compra) {
        this.costo_compra = costo_compra;
    }

    /**
     * @return the precio_venta
     */
    public String getPrecio_venta() {
        return precio_venta;
    }

    /**
     * @param precio_venta the precio_venta to set
     */
    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    /**
     * @return the fecha_insercion
     */
    public Date getFecha_insercion() {
        return fecha_insercion;
    }

    /**
     * @param fecha_insercion the fecha_insercion to set
     */
    public void setFecha_insercion(Date fecha_insercion) {
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
     * @return the usuario_actualizacion
     */
    public String getUsuario_actualizacion() {
        return usuario_actualizacion;
    }

    /**
     * @param usuario_actualizacion the usuario_actualizacion to set
     */
    public void setUsuario_actualizacion(String usuario_actualizacion) {
        this.usuario_actualizacion = usuario_actualizacion;
    }

    /**
     * @return the margen_beneficio
     */
    public String getMargen_beneficio() {
        return margen_beneficio;
    }

    /**
     * @param margen_beneficio the margen_beneficio to set
     */
    public void setMargen_beneficio(String margen_beneficio) {
        this.margen_beneficio = margen_beneficio;
    }

    /**
     * @return the id_moneda
     */
    public String getId_moneda() {
        return id_moneda;
    }

    /**
     * @param id_moneda the id_moneda to set
     */
    public void setId_moneda(String id_moneda) {
        this.id_moneda = id_moneda;
    }

    /**
     * @return the modifica_manual_precio
     */
    public String getModifica_manual_precio() {
        return modifica_manual_precio;
    }

    /**
     * @param modifica_manual_precio the modifica_manual_precio to set
     */
    public void setModifica_manual_precio(String modifica_manual_precio) {
        this.modifica_manual_precio = modifica_manual_precio;
    }

}
