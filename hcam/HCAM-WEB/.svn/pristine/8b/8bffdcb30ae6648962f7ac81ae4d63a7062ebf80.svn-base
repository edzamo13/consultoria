/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.resources;

import ec.hcam.AreatblServiceRemote;
import ec.hcam.entity.Areatbl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ezamora
 */
@ViewScoped
@ManagedBean
public class AreaView implements Serializable {

    @EJB
    private AreatblServiceRemote areatblServiceRemote;

    private List<Areatbl> areaList;

    @PostConstruct
    public void init() {
        List<Areatbl> results = new ArrayList<Areatbl>();
        //results = areatblServiceRemote.findAll();
        for (Areatbl r : results) {
            System.out.println("" + r.getUbnombre());
        }

    }

    public List<Areatbl> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Areatbl> areaList) {
        this.areaList = areaList;
    }

}
