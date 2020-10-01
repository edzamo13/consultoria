/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.web.controlador;

import ec.gob.cne.web.cliente.restful.WsClienteRestful;
import ec.gob.cne.ws.dto.Producto;
import ec.gob.cne.ws.dto.ProductoRespuesta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ezamora
 */
@Named
@ViewScoped
public class DetailGovernorController1 implements Serializable {

    @Getter
    @Setter
    private Producto producto;
    @Getter
    @Setter
    private List<Producto> productos;

    WsClienteRestful cliente = new WsClienteRestful();

    @PostConstruct
    public void init() {
        setProducto(producto);
        setProductos(new ArrayList());
        setProductos(obtenerProductos());

    }

    public List<Producto> obtenerProductos() {
        ProductoRespuesta respuesta = new ProductoRespuesta();
        respuesta = cliente.invocaWs("http://localhost:8080/wanqara-ws/resources/productoServicio/obtenerProductos", null, ProductoRespuesta.class);
        return respuesta.getProductos();

    }

    public void muestraConfirmacion() {
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmacion').show();");
    }

    public void guarda() {
        setProducto(cliente.invocaWs("http://localhost:8080//wanqara-ws/resources/productoServicio/guardarProducto", getProducto(), Producto.class));
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto", "Producto guardado!..");
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }
}
