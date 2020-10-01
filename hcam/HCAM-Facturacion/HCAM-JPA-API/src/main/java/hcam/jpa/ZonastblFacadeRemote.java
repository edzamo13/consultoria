/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Zonastbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ZonastblFacadeRemote {

    void create(Zonastbl zonastbl);

    void edit(Zonastbl zonastbl);

    void remove(Zonastbl zonastbl);

    Zonastbl find(Object id);

    List<Zonastbl> findAll();

    List<Zonastbl> findRange(int[] range);

    int count();
    
}
