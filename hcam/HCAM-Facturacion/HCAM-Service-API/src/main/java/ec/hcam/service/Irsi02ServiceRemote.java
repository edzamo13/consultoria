/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities1.Irsi02;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface Irsi02ServiceRemote {

    public void create(Irsi02 irsi02);

    public void edit(Irsi02 irsi02);

    public void remove(Irsi02 irsi02);

    public Irsi02 find(Object id);

    public List<Irsi02> findAll();

    public List<Irsi02> findRange(int[] range);

    public int count();

}
