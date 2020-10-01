/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.web;

import ec.hcam.entities.Serviciotbl;
import ec.hcam.service.ServiciotblServiceRemote;

import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author jochoa
 */
@ManagedBean
@RequestScoped
public class ServicioView {

    @EJB
    ServiciotblServiceRemote servicio;

    @PostConstruct
    private void init() {
        imprimir();
    }

    public String imprimir() {
        System.out.println("invocando imprimir.");

        Logger logger = Logger.getLogger("ManagedBean");

        List<Serviciotbl> lst = servicio.findAllServiciotbls();
        System.out.println(lst.size());
        for (Serviciotbl lst1 : lst) {
            System.out.println(lst1.getSeidpk());
        }
        return "";
    }

}
